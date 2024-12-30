package com.springmvc.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private static final Logger logger = LoggerFactory.getLogger(SearchResult.class);

    private List<Product> products;
    private int totalResults; // 전체 결과 수
    private int currentPage;  // 현재 페이지
    private int totalPages;   // 총 페이지 수
    private final int pageSize; // 페이지당 아이템 수

    public SearchResult(List<Product> products, int totalResults, int currentPage, int totalPages, int pageSize) {
        this.products = (products != null) ? products : new ArrayList<>();
        this.totalResults = totalResults;
        this.currentPage = currentPage;
        this.totalPages = totalPages; // 총 페이지 수는 외부에서 계산
        this.pageSize = pageSize; // 페이지당 아이템 수 설정

        // 디버깅 로그 출력
        logger.debug("SearchResult 생성: 상품 개수={}, 전체 결과 수={}, 현재 페이지={}, 총 페이지 수={}, 페이지당 아이템 수={}", 
                     this.products.size(), this.totalResults, this.currentPage, this.totalPages, this.pageSize);
    }

    // 총 페이지 수 계산 메서드 (필요한 경우)
    public static int calculateTotalPages(int totalResults, int pageSize) {
        return (int) Math.ceil((double) totalResults / pageSize);
    }

    // Getters and Setters
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
        this.totalPages = calculateTotalPages(this.totalResults, this.pageSize); // totalResults 변경 시 총 페이지 수 재계산
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPageSize() {
        return pageSize; // 항상 페이지당 아이템 수 반환
    }

    // 페이지 범위를 반환 (1번부터 10번까지 등)
    public int[] getPageRange() {
        int startPage = ((currentPage - 1) / 10) * 10 + 1;
        int endPage = Math.min(startPage + 9, totalPages); // 최대 페이지 수 제한
        int[] pageRange = new int[endPage - startPage + 1];
        for (int i = 0; i < pageRange.length; i++) {
            pageRange[i] = startPage + i;
        }
        return pageRange;
    }

    public void setTotalPages(int filteredTotalPages) {
        this.totalPages = filteredTotalPages;
        logger.debug("totalPages 설정됨: {}", this.totalPages);
    }
}
