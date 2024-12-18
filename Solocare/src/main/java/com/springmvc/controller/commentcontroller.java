package com.springmvc.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.domain.comment;
import com.springmvc.service.commentService;

@RestController
public class commentcontroller {

    @Autowired
    private commentService commentService; // 댓글 저장 서비스

    @PostMapping("/addComment")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addComment(@RequestBody comment commentDto) {
    	System.out.println("가져오는지 확인");
        Map<String, Object> response = new HashMap<>();
        try {
        	System.out.println(commentDto.getBoardnum());
        	 // 댓글 추가 로직
            commentDto.setLikes(0); // 기본값으로 좋아요 수를 0으로 설정
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm");
            String regist_date = formatter.format(new java.util.Date());
            commentDto.setCreatedDate(regist_date);

            commentService.saveComment(commentDto);
            
            // 성공적으로 추가된 경우
            response.put("success", true);
            response.put("commentnum", commentDto.getCommentnum());
            response.put("boardnum", commentDto.getBoardnum());
            response.put("authorId", commentDto.getAuthorid());
            response.put("content", commentDto.getCommentcontent());
            response.put("createdDate", commentDto.getCreatedDate().toString());
            response.put("likes", commentDto.getLikes());
            
        } catch (Exception e) {
            response.put("success", false);
        }
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/comments")
    public ResponseEntity<List<comment>> getComments(@RequestBody Map<String, Object> request) {
        
        // boardnum을 String으로 가져온 후 Integer로 변환
        String boardNumStr = (String) request.get("boardnum");
        int boardNum = Integer.parseInt(boardNumStr); // String을 Integer로 변환

        List<comment> comments = commentService.getCommentsByBoardNum(boardNum);
        return ResponseEntity.ok(comments);
    }
    
    @PostMapping("/updateComment")
    public ResponseEntity<Map<String, Object>> updateComment(@RequestBody comment commentDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 댓글 수정 로직
            comment existingComment = commentService.getCommentById(commentDto.getCommentnum());
            if (existingComment != null) {
                existingComment.setCommentcontent(commentDto.getCommentcontent());
                
                commentService.updateComment(existingComment);

                // 성공적으로 수정된 경우
                response.put("success", true);
                response.put("commentnum", existingComment.getCommentnum());
                response.put("content", existingComment.getCommentcontent());
                response.put("createdDate", existingComment.getCreatedDate());
            } else {
                response.put("success", false);
                response.put("message", "댓글을 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "댓글 수정 중 오류가 발생했습니다.");
        }
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/deleteComment")
    public ResponseEntity<Map<String, Object>> deleteComment(@RequestBody Map<String, Integer> request) {
        Map<String, Object> response = new HashMap<>();
        int commentnum = request.get("commentnum");
        
        try {
            commentService.deleteComment(commentnum); // 댓글 삭제 서비스 호출
            response.put("success", true);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "댓글 삭제 중 오류가 발생했습니다.");
        }
        
        return ResponseEntity.ok(response);
    }
}
