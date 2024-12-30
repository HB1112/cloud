package com.springmvc.service;

import com.springmvc.domain.Product;
import com.springmvc.domain.SearchResult;

import java.util.List;
import java.util.Map;

/**
 * ProductService 인터페이스는 상품 검색과 관련된 다양한 비즈니스 로직을 정의함.
 */
public interface ProductService {
    /**
     * 단순 검색을 수행하고 검색된 상품 목록을 반환함.
     *
     * @param searchTerms 검색어
     * @return 검색된 상품 목록
     */
    List<Product> findProducts(String searchTerms);

    /**
     * 주어진 검색어, 페이지, 정렬 옵션, 가격 범위에 따라 상품을 검색하고 결과를 반환함.
     *
     * @param searchTerms 검색어
     * @param page        검색할 페이지 번호
     * @param sort        정렬 옵션 (관련도 높은 순, 가격 낮은 순 등)
     * @param minPrice    최소 가격
     * @param maxPrice    최대 가격
     * @return 검색 결과
     */
    SearchResult searchProducts(String searchTerms, int page, String sort, int minPrice, int maxPrice);

    /**
     * 특정 카테고리에서 상위 N개의 상품을 가져옴.
     *
     * @param category 카테고리 이름
     * @param limit    가져올 상품의 개수
     * @return 상위 N개의 상품 목록
     */
    List<Product> getTopNProductsByCategory(String category, int limit);
    
    /**
     * 특정 카테고리와 검색어에 따라 상품을 검색하고 결과를 반환함.
     *
     * @param category    카테고리 이름
     * @param searchTerms 검색어
     * @param page        검색할 페이지 번호
     * @param sort        정렬 옵션
     * @return 검색 결과
     */
    SearchResult searchProductsByCategory(String category, String searchTerms, int page, String sort);

    /**
     * 모든 카테고리 정보를 가져옴.
     *
     * @return 카테고리 데이터 구조
     */
    Map<String, Map<String, List<String>>> getAllCategories();

    /**
     * 검색어를 카테고리에 맞게 조정하여 반환함.
     *
     * @param query         검색어
     * @param category1     대분류 카테고리
     * @param category2     중분류 카테고리
     * @param category3     소분류 카테고리
     * @param isDirectSearch 직접 검색 여부
     * @return 조정된 검색어
     */
    String adjustQueryForCategory(String query, String category1, String category2, String category3, boolean isDirectSearch);

    /**
     * 검색어를 카테고리에 맞게 조정하여 반환합니다.
     *
     * @param query      검색어
     * @param category1  대분류 카테고리
     * @param category2  중분류 카테고리
     * @param category3  소분류 카테고리
     * @return 조정된 검색어
     */
    String adjustQueryForCategory(String query, String category1, String category2, String category3);

	String adjustQueryForCategory(String query, String category1, String category2, String category3,
			boolean isDirectSearch, String sort);
}
