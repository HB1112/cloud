package com.springmvc.controller;

import com.springmvc.domain.SearchResult;
import com.springmvc.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/search")
    public String searchProducts(
        @RequestParam(value = "query", required = false) String query,
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "sort", defaultValue = "sim") String sort,
        Model model
    ) {
        logger.info("컨트롤러 searchProducts 호출: query={}, page={}, sort={}", query, page, sort);

        if (query == null || query.trim().isEmpty()) {
            model.addAttribute("error", "검색어를 입력해 주세요.");
            return "search";
        }

        try {
            SearchResult searchResult = productService.searchProducts(query, page, sort);
            model.addAttribute("searchResult", searchResult);
            model.addAttribute("query", query);
            model.addAttribute("sort", sort);

            // 페이지네이션 계산
            int totalPages = (int) Math.ceil((double) searchResult.getTotalResults() / 10);
            int currentGroup = (page - 1) / 10;
            int startPage = currentGroup * 10 + 1;
            int endPage = Math.min(startPage + 9, totalPages);

            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", page);
            model.addAttribute("startPage", startPage);
            model.addAttribute("endPage", endPage);
        } catch (Exception e) {
            model.addAttribute("error", "상품 검색 중 오류가 발생했습니다.");
            logger.error("오류 발생: {}", e.getMessage(), e);
        }

        return "results";
    }

    @PostMapping("/search")
    public String searchProductsPost(
        @RequestParam("query") String query,
        @RequestParam(value = "sort", defaultValue = "sim") String sort,
        RedirectAttributes redirectAttributes
    ) {
        logger.info("컨트롤러 searchProductsPost 호출: query={}, sort={}", query, sort);

        redirectAttributes.addAttribute("query", query);
        redirectAttributes.addAttribute("page", 1);
        redirectAttributes.addAttribute("sort", sort);

        return "redirect:/search";
    }
}