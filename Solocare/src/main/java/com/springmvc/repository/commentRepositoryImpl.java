package com.springmvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.comment;

@Repository
public class commentRepositoryImpl implements commentRepository{
	
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	
	// 댓글 C
	@Override
	public void saveComment(comment comment) {
		System.out.println("CommentRepositoryImpl addComment()");
	    System.out.println("댓글 내용: " + comment.getCommentcontent());
	    try {
			conn=DBConnection.getConnection();
			String sql = "INSERT INTO comments (boardnum, commentcontent, authorid, createDate, likes) VALUES (?, ?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, comment.getBoardnum());
	        pstmt.setString(2, comment.getCommentcontent());
	        pstmt.setString(3, comment.getAuthorid());
	        pstmt.setString(4, comment.getCreatedDate()); // String을 직접 설정
	        pstmt.setInt(5, comment.getLikes());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	   
	}

	@Override
	public List<comment> getCommentsByBoardNum(int boardNum) {
		 List<comment> comments = new ArrayList<>();
		try {
			conn=DBConnection.getConnection();
			String sql = "SELECT * FROM comments WHERE boardnum = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNum);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                comment c = new comment();
                c.setCommentnum(rs.getInt("commentnum"));
                c.setBoardnum(rs.getInt("boardnum"));
                c.setAuthorid(rs.getString("authorid"));
                c.setCommentcontent(rs.getString("commentcontent"));
                c.setCreatedDate(rs.getString("createDate"));
                c.setLikes(rs.getInt("likes"));
                
                comments.add(c);
            }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return comments;
	}

	@Override
	public comment getCommentById(int commentnum) {
		comment c = null;
		try {
	        conn = DBConnection.getConnection(); // 데이터베이스 연결
	        String sql = "SELECT * FROM comments WHERE commentnum = ?"; // 댓글 번호로 조회하는 SQL 쿼리
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, commentnum); // 댓글 번호를 쿼리에 설정
	        rs = pstmt.executeQuery(); // 쿼리 실행
	        
	        if (rs.next()) { // 결과가 존재하는 경우
	            c = new comment(); // 댓글 객체 생성
	            c.setCommentnum(rs.getInt("commentnum"));
	            c.setBoardnum(rs.getInt("boardnum"));
	            c.setAuthorid(rs.getString("authorid"));
	            c.setCommentcontent(rs.getString("commentcontent"));
	            c.setCreatedDate(rs.getString("createDate"));
	            c.setLikes(rs.getInt("likes"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 처리
	    } finally {
	        // 자원 해제
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return c; // 조회 결과 반환
	}

	@Override
	public void updateComment(comment existingComment) {
		try {
	        conn = DBConnection.getConnection(); // 데이터베이스 연결
	        String sql = "UPDATE comments SET commentcontent = ?, createDate = ? WHERE commentnum = ?"; // 댓글 수정 쿼리
	        pstmt = conn.prepareStatement(sql);
	        
	        // 댓글 내용과 수정 날짜 설정
	        pstmt.setString(1, existingComment.getCommentcontent());
	        pstmt.setString(2, existingComment.getCreatedDate()); // 수정된 날짜
	        pstmt.setInt(3, existingComment.getCommentnum()); // 수정할 댓글 번호
	        
	        pstmt.executeUpdate(); // 쿼리 실행
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 처리
	    } finally {
	        // 자원 해제
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
	}

	@Override
	public void deleteComment(int commentnum) {
		try {
	        conn = DBConnection.getConnection(); // 데이터베이스 연결
	        String sql = "DELETE FROM comments WHERE commentnum = ?"; // 삭제 쿼리
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, commentnum); // 댓글 번호 설정
	        pstmt.executeUpdate(); // 쿼리 실행
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 처리
	    } finally {
	        // 자원 해제
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
	}
	
}
