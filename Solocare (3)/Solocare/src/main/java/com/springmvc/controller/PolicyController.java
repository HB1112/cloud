package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import java.nio.charset.StandardCharsets;

@Controller
public class PolicyController {
    @GetMapping("/policy")
    public String policyPage() {
        return "policy";
    }
    
    @GetMapping(value = "/policy/search", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String searchPolicy(
            @RequestParam("query") String query,
            @RequestParam(value = "srchPolyBizSecd", required = false) String regions,
            @RequestParam(value = "bizTycdSel", required = false) String bizTypes, // 정책 분야 추가
            @RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex) {
        
        String apiUrl = "https://www.youthcenter.go.kr/opi/youthPlcyList.do";
        String apiKey = "9569a7f6c9d70e44cb6199da"; // 실제 API 키로 변경
        int display = 10; // 페이지당 항목 수
        
        StringBuilder urlBuilder = new StringBuilder(apiUrl)
            .append("?openApiVlak=").append(apiKey)
            .append("&display=").append(display)
            .append("&pageIndex=").append(pageIndex)
            .append("&query=").append(query);
        
        if (regions != null && !regions.isEmpty()) {
            urlBuilder.append("&srchPolyBizSecd=").append(regions);
        }
        
        if (bizTypes != null && !bizTypes.isEmpty()) {
            urlBuilder.append("&bizTycdSel=").append(bizTypes); // 분야 추가
        }

        // Log the final API URL for debugging
        System.out.println("API 호출 URL: " + urlBuilder.toString());
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setAcceptCharset(java.util.Arrays.asList(StandardCharsets.UTF_8));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
            .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        
        try {
            String xmlResponse = restTemplate.exchange(
                urlBuilder.toString(), 
                HttpMethod.GET, 
                entity, 
                String.class
            ).getBody();
            
            // Check if the response is null or empty
            if (xmlResponse == null || xmlResponse.isEmpty()) {
                return "{\"error\": \"API 응답이 비어 있습니다.\"}";
            }
            
            JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
            return jsonResponse.toString();
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            return "{\"error\": \"API 호출 중 문제가 발생했습니다: " + e.getMessage() + "\"}";
        }
    }
}
