package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Product;
import com.springmvc.domain.SearchResult;
import com.springmvc.repository.NaverProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private NaverProductRepository naverProductRepository;

    @Override
    public List<Product> findProducts(String searchTerms) {
        return naverProductRepository.searchProducts(searchTerms);
    }

    @Override
    public SearchResult searchProducts(String searchTerms, int page, String sort) {
    	
        return naverProductRepository.searchProducts(searchTerms, page, sort);
    }
}

