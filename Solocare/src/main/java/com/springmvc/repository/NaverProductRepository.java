package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import com.springmvc.domain.SearchResult;
import com.springmvc.domain.Product;

public interface NaverProductRepository {
    List<Product> searchProducts(String query);
    SearchResult searchProducts(String query, int page, String sort);
    SearchResult searchProducts(String query, int page, String sort, int minPrice, int maxPrice);
    List<Product> getTopNProductsByCategory(String category, int limit);
    Map<String, Map<String, List<String>>> getAllCategories();
    String adjustQueryForCategory(String query, String category1, String category2, String category3, boolean isDirectSearch);
    SearchResult searchProductsByCategory(String category, String searchTerms, int page, String sort);
	/**
	 * 카테고리와 검색어를 조합하여 쿼리를 조정하는 메서드.
	 */
	String adjustQueryForCategory(String query, String category1, String category2, String category3,
			boolean isDirectSearch, String sort);
}
