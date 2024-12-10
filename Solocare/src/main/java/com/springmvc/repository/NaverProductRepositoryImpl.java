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
import java.util.ArrayList;
import java.util.List;


@Repository
public class NaverProductRepositoryImpl implements NaverProductRepository {

    private static final String CLIENT_ID = "DOSRPeyWB73avh0zIBmY";
    private static final String CLIENT_SECRET = "zCsRUK1YR3";
    private static final String API_URL = "https://openapi.naver.com/v1/search/shop.json";
    private static final int PAGE_SIZE = 12; // 한 페이지에 나올 상품 수 제한

    private static final Logger logger = LoggerFactory.getLogger(NaverProductRepositoryImpl.class);

    @Override
    public List<Product> searchProducts(String query) {
        return searchProducts(query, 1, "sim").getProducts(); // 기본값은 유사도순
    }

    @Override
    public SearchResult searchProducts(String query, int page, String sort) {
        logger.info("리파지토리 searchProducts 호출: query={}, page={}, sort={}", query, page, sort);
        List<Product> products = new ArrayList<>();
        int total = 0;
        final int maxResults = 500; // 최대 검색 결과 제한
        
        // 1인 가구 관련 키워드 추가
        String[] additionalKeywords = {"1인","자취"};
        StringBuilder modifiedQuery = new StringBuilder(query);

        for (String keyword : additionalKeywords) {
            modifiedQuery.append(" ").append(keyword);
        }

        try {
            RestTemplate restTemplate = new RestTemplate();

            // HTTP 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Naver-Client-Id", CLIENT_ID);
            headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

            // 요청 엔티티 생성
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // 페이지 계산
            int start = (page - 1) * PAGE_SIZE + 1;

            // API 호출
            String apiUrl = API_URL + "?query={query}&display={display}&start={start}&sort={sort}";
            String convertedSort = convertSort(sort); // 정렬 기준 변환
            logger.info("API Request: query={}, start={}, sort={}", modifiedQuery.toString(), start, convertedSort);

            ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                String.class,
                modifiedQuery.toString(), PAGE_SIZE, start, convertedSort
            );

            // JSON 응답 파싱
            JSONObject jsonResponse = new JSONObject(response.getBody());
            JSONArray items = jsonResponse.getJSONArray("items");
            logger.info("검색 결과 총 {}개 상품", items.length());

            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);

                try {
                    // 로깅 추가하여 각 상품의 정보 확인
                    logger.info("상품 정보: title={}, lprice={}", 
                        item.getString("title"), 
                        item.optString("lprice", "가격 없음")
                    );

                    // 가격 변환 시도
                    int price = Integer.parseInt(item.getString("lprice")); 
                    
                    String formattedPrice = NumberFormat.getInstance().format(price);
                    
                    Product product = new Product();
                    product.setName(item.getString("title").replaceAll("<[^>]*>", ""));
                    product.setPrice(formattedPrice + "원");
                    product.setCategory(item.optString("category", "미분류"));
                    product.setImage(item.getString("image"));
                    product.setLink(item.getString("link"));

                    products.add(product);
                } catch (NumberFormatException e) {
                    logger.warn("가격 변환 실패: {} (lprice: {})", 
                        item.getString("title"), 
                        item.optString("lprice", "N/A")
                    );
                }
            }

            total = Math.min(jsonResponse.getInt("total"), maxResults);

        } catch (Exception e) {
            logger.error("상품 검색 중 오류 발생: {}", e.getMessage(), e);
        }

        return new SearchResult(products, total, page);
    }

    private String convertSort(String sort) {
        switch (sort) {
            case "price_low":
                return "asc"; // 가격 오름차순
            case "price_high":
                return "dsc"; // 가격 내림차순
            case "date":
                return "date"; // 날짜순
            default:
                return "sim"; // 유사도순
        }
    }
}
