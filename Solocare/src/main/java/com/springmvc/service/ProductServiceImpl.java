package com.springmvc.service;

import com.springmvc.domain.Product;
import com.springmvc.domain.SearchResult;
import com.springmvc.repository.NaverProductRepository;

import java.util.List;
import java.util.Map;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private NaverProductRepository naverProductRepository;

    @Override
    public List<Product> findProducts(String searchTerms) {
        logger.info("findProducts 호출: searchTerms='{}'", searchTerms);

        // 카테고리 정보를 포함하지 않는 단순 검색
        SearchResult searchResult = naverProductRepository.searchProducts(searchTerms, 1, "sim", 1000, 2000000);
        return searchResult != null ? searchResult.getProducts() : Collections.emptyList();
    }

    @Override
    public SearchResult searchProducts(String searchTerms, int page, String sort, int minPrice, int maxPrice) {
        logger.info("searchProducts 호출: searchTerms='{}', page={}, sort='{}', minPrice={}, maxPrice={}", searchTerms, page, sort, minPrice, maxPrice);

        // 검색어 조정은 컨트롤러에서 처리했으므로, 단순히 전달
        SearchResult searchResult = naverProductRepository.searchProducts(searchTerms, page, sort, minPrice, maxPrice);

        if (searchResult == null || searchResult.getProducts().isEmpty()) {
            logger.warn("검색된 상품이 없습니다: searchTerms='{}', page={}, sort='{}', minPrice={}, maxPrice={}", searchTerms, page, sort, minPrice, maxPrice);
        } else {
            logger.info("searchProducts 성공: 상품 개수={}", searchResult.getProducts().size());
        }

        return searchResult;
    }


    @Override
    public List<Product> getTopNProductsByCategory(String category, int limit) {
        logger.info("getTopNProductsByCategory 호출: category='{}', limit={}", category, limit);

        List<Product> products = naverProductRepository.getTopNProductsByCategory(category, limit);
        if (products == null || products.isEmpty()) {
            logger.warn("카테고리 '{}'의 상품이 없습니다.", category);
        } else {
            logger.info("카테고리 '{}'의 상위 상품 개수: {}", category, products.size());
        }
        return products;
    }

    @Override
    public SearchResult searchProductsByCategory(String category, String searchTerms, int page, String sort) {
        logger.info("searchProductsByCategory 호출: category='{}', searchTerms='{}', page={}, sort='{}'", category, searchTerms, page, sort);

        // 카테고리와 검색어를 조합하여 쿼리를 조정
        String adjustedQuery = adjustQueryForCategory(searchTerms, category, null, null, false);
        logger.info("Adjusted Query for Category: {}", adjustedQuery);

        SearchResult searchResult = naverProductRepository.searchProducts(adjustedQuery, page, sort, 1000, 2000000);

        if (searchResult == null || searchResult.getProducts().isEmpty()) {
            logger.warn("카테고리 기반 검색 결과가 없습니다. category='{}', searchTerms='{}'", category, searchTerms);
        } else {
            logger.info("카테고리 기반 검색 성공: 상품 개수={}", searchResult.getProducts().size());
        }

        return searchResult;
    }

    @Override
    public Map<String, Map<String, List<String>>> getAllCategories() {
        logger.info("getAllCategories 호출");

        Map<String, Map<String, List<String>>> categories = naverProductRepository.getAllCategories();

        if (categories == null || categories.isEmpty()) {
            logger.warn("카테고리 데이터가 없습니다.");
        } else {
            logger.info("카테고리 데이터 로드 성공: 카테고리 수={}", categories.size());
        }

        return categories;
    }

    @Override
    public String adjustQueryForCategory(String query, String category1, String category2, String category3, boolean isDirectSearch, String sort) {
        return naverProductRepository.adjustQueryForCategory(query, category1, category2, category3, isDirectSearch, sort);
    }


	@Override
	public String adjustQueryForCategory(String query, String category1, String category2, String category3) {
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
