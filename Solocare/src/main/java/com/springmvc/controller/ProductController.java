package com.springmvc.controller;

import com.springmvc.domain.Product;
import com.springmvc.domain.SearchResult;
import com.springmvc.service.ProductService;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/search")
    public String searchProducts(
        @RequestParam(value = "query", required = false, defaultValue = "") String query,
        @RequestParam(value = "category1", required = false) String category1,
        @RequestParam(value = "category2", required = false) String category2,
        @RequestParam(value = "category3", required = false) String category3,
        Model model
    ) {
        logger.info("searchProducts 호출: query='{}', category1='{}', category2='{}', category3='{}'", query, category1, category2, category3);

        if (query.trim().isEmpty() && category1 == null && category2 == null && category3 == null) {
            query = "추천 상품";
        }

        // 추천 상품 가져오기
        List<Product> interiorProducts = filterDuplicates(productService.getTopNProductsByCategory("가구/인테리어", 3));
        List<Product> foodProducts = filterDuplicates(productService.getTopNProductsByCategory("식품", 3));

        model.addAttribute("interiorProducts", interiorProducts);
        model.addAttribute("foodProducts", foodProducts);

        // 카테고리 데이터 전달
        model.addAttribute("categories", productService.getAllCategories());
        model.addAttribute("selectedCategory1", category1);
        model.addAttribute("selectedCategory2", category2);
        model.addAttribute("selectedCategory3", category3);

        return "search"; // 검색 페이지
    }

    @GetMapping("/results")
    public String displaySearchResults(
        @RequestParam(value = "query", required = false, defaultValue = "") String query,
        @RequestParam(value = "category1", required = false) String category1,
        @RequestParam(value = "category2", required = false) String category2,
        @RequestParam(value = "category3", required = false) String category3,
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "sort", defaultValue = "sim") String sort,
        @RequestParam(value = "minPrice", required = false, defaultValue = "1000") int minPrice, // 추가
        @RequestParam(value = "maxPrice", required = false, defaultValue = "2000000") int maxPrice, // 추가
        Model model
    ) {
        // "null" 문자열을 실제 null로 변환
        if ("null".equalsIgnoreCase(category1)) category1 = null;
        if ("null".equalsIgnoreCase(category2)) category2 = null;
        if ("null".equalsIgnoreCase(category3)) category3 = null;

        logger.info("displaySearchResults 호출: query='{}', category1='{}', category2='{}', category3='{}', page={}, sort='{}', minPrice={}, maxPrice={}", 
                    query, category1, category2, category3, page, sort, minPrice, maxPrice);

        String adjustedQuery = productService.adjustQueryForCategory(query, category1, category2, category3, false, sort);
        logger.info("Adjusted Query: {}", adjustedQuery);

        // adjustedQuery가 null이거나 비어있으면 기본 검색어 설정
        if (adjustedQuery == null || adjustedQuery.isEmpty()) {
            adjustedQuery = "추천 상품";
            logger.warn("조합된 쿼리가 null이거나 비어 있음. 기본 검색어로 설정: {}", adjustedQuery);
        }

        logger.info("최종 검색 쿼리: {}", adjustedQuery);

        // 가격 범위 전달 없이 API 쿼리에 포함하지 않음
        SearchResult searchResult = productService.searchProducts(adjustedQuery, page, sort, 1000, 2000000);

        // 가격 필터링을 애플리케이션 측에서 수행
        List<Product> filteredProducts = searchResult.getProducts().stream()
            .filter(product -> product.getPriceAsInt() >= minPrice && product.getPriceAsInt() <= maxPrice)
            .collect(Collectors.toList());

        // 정렬 수행
        if (sort.equals("price_low")) {
            filteredProducts.sort(Comparator.comparingInt(Product::getPriceAsInt));
        } else if (sort.equals("price_high")) {
            filteredProducts.sort(Comparator.comparingInt(Product::getPriceAsInt).reversed());
        }

        searchResult.setProducts(filteredProducts);

        // 페이지 정보 설정
        int pageGroupSize = 10;
        int startPage = ((page - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, searchResult.getTotalPages());

        model.addAttribute("searchResult", searchResult);
        model.addAttribute("query", query);
        model.addAttribute("category1", category1);
        model.addAttribute("category2", category2);
        model.addAttribute("category3", category3);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", searchResult.getTotalPages());
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("sort", sort);
        model.addAttribute("minPrice", minPrice); 
        model.addAttribute("maxPrice", maxPrice); 
        model.addAttribute("categories", productService.getAllCategories());
        
        logger.info("정렬 전: {}", filteredProducts);
        if (sort.equals("price_low")) {
            filteredProducts.sort(Comparator.comparingInt(Product::getPriceAsInt));
        } else if (sort.equals("price_high")) {
            filteredProducts.sort(Comparator.comparingInt(Product::getPriceAsInt).reversed());
        }
        logger.info("정렬 후: {}", filteredProducts);
        
        return "results";
    }


    private List<Product> filterDuplicates(List<Product> products) {
        Set<String> seen = new LinkedHashSet<>();
        return products.stream()
                .filter(product -> seen.add(product.getImage() + product.getName()))
                .toList();
    }
}
