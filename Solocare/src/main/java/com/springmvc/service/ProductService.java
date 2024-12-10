package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.SearchResult;
import com.springmvc.domain.Product;

public interface ProductService 
{
	List<Product> findProducts(String searchTerms);
	SearchResult searchProducts(String searchTerms, int page, String sort);
}
