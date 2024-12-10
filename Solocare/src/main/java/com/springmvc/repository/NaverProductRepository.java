package com.springmvc.repository;

import java.util.List;
import com.springmvc.domain.SearchResult;
import com.springmvc.domain.Product;

public interface NaverProductRepository 
{
	List<Product> searchProducts(String query);
	SearchResult searchProducts(String query, int page, String sort);
}
