package com.springmvc.repository;

import com.springmvc.domain.Product;
import com.springmvc.domain.SearchResult;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.text.NumberFormat;
import java.util.*;

@Repository
public class NaverProductRepositoryImpl implements NaverProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(NaverProductRepositoryImpl.class);

    private static final String CLIENT_ID = "DOSRPeyWB73avh0zIBmY";
    private static final String CLIENT_SECRET = "zCsRUK1YR3";
    private static final String API_URL = "https://openapi.naver.com/v1/search/shop.json";
    private static final int PAGE_SIZE = 12;
    private static final int MAX_RESULTS = 2000; // 최대 검색 결과 제한

    // "1인" 관련 키워드 리스트 및 대상 카테고리 설정
    private static final List<String> SINGLE_PERSON_KEYWORDS = List.of("1인가구", "자취");
    private static final Set<String> ALLOWED_CATEGORIES_FOR_SINGLE_PERSON_KEYWORDS = Set.of("가구·인테리어", "식품");


    // 카테고리 데이터 구조 추가
    private final Map<String, Map<String, List<String>>> categories = getAllCategories();

    @Override
    public SearchResult searchProducts(String query, int page, String sort, int minPrice, int maxPrice) {
        logger.info("searchProducts 호출: query='{}', page={}, sort='{}', minPrice={}, maxPrice={}", query, page, sort, minPrice, maxPrice);

        List<Product> products = new ArrayList<>();
        int total = 0;
        int totalPages = 0;

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Naver-Client-Id", CLIENT_ID);
            headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

            HttpEntity<String> entity = new HttpEntity<>(headers);
            int start = (page - 1) * PAGE_SIZE + 1;

            if (start > MAX_RESULTS) {
                logger.warn("검색 시작 위치가 최대 허용 결과 수를 초과했습니다. start={}, MAX_RESULTS={}", start, MAX_RESULTS);
                int calculatedTotalPages = (int) Math.ceil((double) MAX_RESULTS / PAGE_SIZE);
                return new SearchResult(Collections.emptyList(), MAX_RESULTS, page, calculatedTotalPages, PAGE_SIZE);
            }

            logger.info("조정된 검색 쿼리: {}", query);

            String naverSort = convertSort(sort);
            if ("price_low".equals(sort) || "price_high".equals(sort)) {
                naverSort = "sim";
            }

            String apiUrl = API_URL + "?query={query}&display={display}&start={start}&sort={sort}";
            logger.info("API 호출 URL: {}", apiUrl);

            ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                String.class,
                query, PAGE_SIZE, start, naverSort
            );

            logger.debug("API 응답 상태 코드: {}", response.getStatusCode());

            if (!response.getStatusCode().is2xxSuccessful()) {
                logger.error("Naver API 호출 실패: Status Code={}", response.getStatusCode());
                return new SearchResult(Collections.emptyList(), 0, page, totalPages, PAGE_SIZE);
            }

            logger.debug("API 응답: {}", response.getBody());

            JSONObject jsonResponse = new JSONObject(response.getBody());
            JSONArray items = jsonResponse.optJSONArray("items");
            total = Math.min(jsonResponse.optInt("total", 0), MAX_RESULTS);
            totalPages = (int) Math.ceil((double) total / PAGE_SIZE);

            if (items == null || items.isEmpty()) {
                logger.warn("API 응답에서 'items'가 비어 있음: query='{}', page={}", query, page);
                return new SearchResult(Collections.emptyList(), total, page, totalPages, PAGE_SIZE);
            }

            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                Product product = parseProduct(item);
                if (product != null) {
                    products.add(product);
                    logger.debug("상품 추가: {}", product);
                }
            }

            logger.info("총 검색 결과 수: {}, 필터링 후 상품 개수: {}", total, products.size());
        } catch (Exception e) {
            logger.error("상품 검색 중 오류 발생: {}", e.getMessage(), e);
            return new SearchResult(Collections.emptyList(), 0, page, totalPages, PAGE_SIZE);
        }

        return new SearchResult(products, total, page, totalPages, PAGE_SIZE);
    }



    @Override
    public SearchResult searchProductsByCategory(String category, String searchTerms, int page, String sort) {
        logger.info("searchProductsByCategory 호출: category='{}', searchTerms='{}', page={}, sort='{}'", category, searchTerms, page, sort);

        // 카테고리와 검색어를 조합하여 쿼리를 조정
        String adjustedQuery = adjustQueryForCategory(searchTerms, category, null, null, false);
        logger.info("Adjusted Query for Category: {}", adjustedQuery);

        SearchResult searchResult = searchProducts(adjustedQuery, page, sort, 1000, 2000000);

        if (searchResult == null || searchResult.getProducts().isEmpty()) {
            logger.warn("카테고리 기반 검색 결과가 없습니다. category='{}', searchTerms='{}'", category, searchTerms);
        } else {
            logger.info("카테고리 기반 검색 성공: 상품 개수={}", searchResult.getProducts().size());
        }

        return searchResult;
    }

    @Override
    public List<Product> getTopNProductsByCategory(String category, int limit) {
        logger.info("카테고리별 상품 가져오기: category='{}', limit={}", category, limit);

        Set<String> seenImages = new HashSet<>();
        Set<String> seenNames = new HashSet<>();
        List<Product> filteredProducts = new ArrayList<>();

        // 카테고리로만 검색
        SearchResult searchResult = searchProducts(category, 1, "sim", 1000, 2000000);
        if (searchResult != null && !searchResult.getProducts().isEmpty()) {
            for (Product product : searchResult.getProducts()) {
                if (seenImages.add(product.getImage()) && seenNames.add(product.getName())) {
                    filteredProducts.add(product);
                }

                if (filteredProducts.size() >= limit) {
                    break;
                }
            }
        }

        if (filteredProducts.size() < limit) {
            List<Product> defaultProducts = getDefaultProductsForCategory(category);
            int remaining = Math.min(limit - filteredProducts.size(), defaultProducts.size());
            if (remaining > 0) {
                filteredProducts.addAll(defaultProducts.subList(0, remaining));
            }
        }

        logger.info("카테고리 '{}'의 상위 {}개 상품 반환: {}", category, limit, filteredProducts.size());
        return filteredProducts;
    }

    @Override
    public List<Product> searchProducts(String query) {
        logger.info("단순 쿼리 기반 searchProducts 호출: query='{}'", query);

        // 기본적으로 첫 페이지와 관련도 높은 순 정렬, 기본 가격 범위 적용
        SearchResult searchResult = searchProducts(query, 1, "sim", 1000, 2000000);
        return searchResult != null ? searchResult.getProducts() : Collections.emptyList();
    }

    /**
     * 카테고리와 검색어를 조합하여 쿼리를 조정하는 메서드.
     */
    @Override
    public String adjustQueryForCategory(String query, String category1, String category2, String category3, boolean isDirectSearch, String sort) {
        StringBuilder adjustedQuery = new StringBuilder();

        try {
            if (query != null && !query.trim().isEmpty()) {
                adjustedQuery.append(query.trim());
                logger.debug("기본 검색어 추가: {}", query.trim());
            } else {
                // "가구/인테리어"와 "식품" 카테고리에만 '추천 상품' 추가
                if (category1 != null && ALLOWED_CATEGORIES_FOR_SINGLE_PERSON_KEYWORDS.contains(category1.trim())) {
                    adjustedQuery.append("추천 상품");
                    logger.debug("'추천 상품' 키워드 추가됨");
                }
            }

            if (category1 != null && !category1.trim().isEmpty()) {
                if (adjustedQuery.length() > 0) {
                    adjustedQuery.append(" ");
                }
                adjustedQuery.append(category1.trim());
                logger.debug("카테고리1 추가: {}", category1.trim());
            }

            // 카테고리 계층 검증 및 추가
            if (category1 != null && categories.containsKey(category1.trim())) {
                Map<String, List<String>> subCategories = categories.get(category1.trim());

                if (category2 != null && !category2.trim().isEmpty()) {
                    if (subCategories.containsKey(category2.trim())) {
                        adjustedQuery.append(" ").append(category2.trim());
                        logger.debug("카테고리2 추가: {}", category2.trim());

                        if (category3 != null && !category3.trim().isEmpty()) {
                            List<String> subSubCategories = subCategories.get(category2.trim());
                            if (subSubCategories.contains(category3.trim())) {
                                adjustedQuery.append(" ").append(category3.trim());
                                logger.debug("카테고리3 추가: {}", category3.trim());
                            } else {
                                logger.warn("유효하지 않은 카테고리3 선택: category3='{}'는 category2='{}'의 하위 카테고리가 아닙니다.", category3, category2);
                            }
                        }
                    } else {
                        logger.warn("유효하지 않은 카테고리2 선택: category2='{}'는 category1='{}'의 하위 카테고리가 아닙니다.", category2, category1);
                    }
                }
            } else {
                if (category1 != null) {
                    logger.warn("유효하지 않은 카테고리1 선택: category1='{}'는 존재하지 않습니다.", category1);
                }
                // category2와 category3를 무시하거나 기본값 설정
            }

            // "가구/인테리어"와 "식품" 카테고리에만 "1인" 키워드 추가, 단 "욕실용품" 선택 시 제외
            if (!isDirectSearch && category1 != null && ALLOWED_CATEGORIES_FOR_SINGLE_PERSON_KEYWORDS.contains(category1.trim())) {
                // 욕실용품 제외 조건
                boolean isBathroomCategorySelected = 
                    (category2 != null && category2.trim().equals("욕실용품")) ||
                    (category3 != null && category3.trim().equals("욕실용품"));

                if (!isBathroomCategorySelected) {
                    boolean containsSinglePersonKeyword = SINGLE_PERSON_KEYWORDS.stream()
                            .anyMatch(keyword -> adjustedQuery.toString().contains(keyword));

                    if (!containsSinglePersonKeyword) {
                        // "1인" 키워드 추가
                        String keyword = "1인가구 자취";
                        adjustedQuery.append(" ").append(keyword);
                        logger.debug("'{}' 키워드 추가됨: {}", keyword, adjustedQuery.toString());
                    } else {
                        logger.debug("'1인' 키워드가 이미 포함되어 있습니다: {}", adjustedQuery.toString());
                    }
                } else {
                    logger.debug("특정상품 '1인가구' 키워드 추가 제외됨");
                }
            }

        } catch (Exception e) {
            logger.error("adjustQueryForCategory 중 오류 발생: {}", e.getMessage(), e);
            return "추천 상품"; // 기본 검색어로 설정
        }

        logger.debug("최종 조정된 검색 쿼리: {}", adjustedQuery.toString().trim());
        return adjustedQuery.toString().trim();
    }


    /**
     * JSON 응답을 Product 객체로 변환
     */
    private Product parseProduct(JSONObject item) {
        try {
            Product product = new Product();
            product.setName(item.optString("title", "알 수 없음").replaceAll("<[^>]*>", ""));
            
            int lprice = item.optInt("lprice", 0);

            String formattedPrice = NumberFormat.getInstance().format(lprice) + "원";
            
            product.setPrice(formattedPrice);
            product.setRawPrice(lprice);

            product.setCategory1(item.optString("category1", "미분류"));
            product.setCategory2(item.optString("category2", "미분류"));
            product.setCategory3(item.optString("category3", "미분류"));
            product.setImage(item.optString("image", ""));
            product.setLink(item.optString("link", ""));
            product.setMallName(item.optString("mallName", "알 수 없음"));
            product.setBrand(item.optString("brand", "알 수 없음"));
            return product;
        } catch (Exception e) {
            logger.warn("상품 정보 파싱 실패: {}", e.getMessage(), e);
            return null;
        }
    }


    /**
     * 특정 카테고리에 대한 기본 상품 목록을 반환합니다.
     */
    private List<Product> getDefaultProductsForCategory(String category) {
        List<Product> defaultProducts = new ArrayList<>();
        if ("식품".equalsIgnoreCase(category)) {
            defaultProducts.add(new Product("기본 식품 상품 1", "10,000원", "https://via.placeholder.com/150", "#", "식품", "기본", "기본", "기본몰", "무료배송", "기본"));
            defaultProducts.add(new Product("기본 식품 상품 2", "20,000원", "https://via.placeholder.com/150", "#", "식품", "기본", "기본", "기본몰", "무료배송", "기본"));
        } else if ("가구/인테리어".equalsIgnoreCase(category)) {
            defaultProducts.add(new Product("기본 가구 상품 1", "50,000원", "https://via.placeholder.com/150", "#", "가구/인테리어", "기본", "기본", "기본몰", "무료배송", "기본"));
            defaultProducts.add(new Product("기본 가구 상품 2", "70,000원", "https://via.placeholder.com/150", "#", "가구/인테리어", "기본", "기본", "기본몰", "무료배송", "기본"));
        }
        return defaultProducts;
    }

    @Override
    public Map<String, Map<String, List<String>>> getAllCategories() {
        return Map.of(
        		"가구·인테리어", Map.of(
        			    "거실가구", List.of("소파", "테이블", "TV장식장", "거실장", "러그", "리클라이너"),
        			    "침실가구", List.of("침대", "서랍장", "테이블", "화장대"),
        			    "수납가구", List.of("옷장", "책장", "신발장", "수납박스", "수납선반"),
        			    "욕실용품", List.of("욕실장·선반", "샤워커튼", "욕실매트")
        			),
        			"식품", Map.of(
        			    "냉동/간편조리식품", List.of("즉석국·즉석탕", "즉석밥", "냉동피자", "냉동만두", "스프·죽"),
        			    "신선식품", List.of("과일·채소", "샐러드", "계란류", "정육·계육", "수산물·해산물"),
        			    "밀키트", List.of("면·파스타", "찌개·국", "구이", "조림/찜", "샤브샤브", "볶음·덮밥", "스튜", "떡볶이"),
        			    "식품", List.of("라면·면류", "과자·스낵", "통조림", "양념·소스", "커피·차", "생수·음료")
        			),
        			"생활", Map.of(
        			    "생활용품", List.of("청소용품", "욕실용품", "세탁용품", "수납정리용품", "생활잡화"),
        			    "보안용품", List.of(),
        			    "주방용품", List.of("식기류", "조리도구", "냄비·프라이팬", "보관용기·밀폐용기")
        			),
        			"스포츠/레저", Map.of(
        			    "홈 트레이닝", List.of(),
        			    "캠핑장비", List.of(),
        			    "등산장비", List.of()
        			)
        );
    }

    /**
     * 정렬 옵션을 Naver API에서 요구하는 형식으로 변환합니다.
     */
    private String convertSort(String sort) {
        switch (sort) {
            case "price_low":
                return "asc"; // 오름차순
            case "price_high":
                return "dsc"; // 내림차순
            case "date":
                return "date"; // 날짜순
            default:
                return "sim"; // 관련도순
        }
    }

	@Override
	public SearchResult searchProducts(String query, int page, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String adjustQueryForCategory(String query, String category1, String category2, String category3,
			boolean isDirectSearch) {
		// TODO Auto-generated method stub
		return null;
	}
}
