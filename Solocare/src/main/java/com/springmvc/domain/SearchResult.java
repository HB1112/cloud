package com.springmvc.domain;

import java.util.List;

public class SearchResult {
    private List<Product> products;
    private int totalResults;
    private int currentPage;
    private int totalPages;

   
    public SearchResult(List<Product> products, int totalResults, int currentPage) {
        this.products = products;
        this.totalResults = totalResults;
        this.currentPage = currentPage;
        this.totalPages = (int) Math.ceil((double) totalResults / 10); 
    }


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


	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

    
    
}
