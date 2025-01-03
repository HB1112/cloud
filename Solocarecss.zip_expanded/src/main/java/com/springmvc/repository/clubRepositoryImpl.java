package com.springmvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.ClubPost;
import com.springmvc.domain.club;
import com.springmvc.domain.clubMember;

@Repository
public class clubRepositoryImpl implements clubRepository 
{

	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	
	@Override
	public void addClub(club club) {
		String sql = "INSERT INTO club (clubLeader, clubNum, clubName, clubDescription, clubCategory, clubLocation) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, club.getClubLeader());
			pstmt.setInt(2, club.getClubNum());
			pstmt.setString(3, club.getClubName());
            pstmt.setString(4, club.getClubDescription()); 
            pstmt.setString(5, club.getClubCategory()); 
            pstmt.setString(6, club.getClubLocation());
			
            pstmt.executeUpdate();
            System.out.println("클럽 등록 성공");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("클럽 추가 중 오류 발생"+e.getMessage());
		}
		
	}

	@Override
	public club getClubByNum(int clubNum) {
		
		club club = null;
		String sql = "SELECT * FROM club WHERE clubNum = ?";
		
		try {
			System.out.print("DB 연결중");
			conn = DBConnection.getConnection();
			System.out.println("DB 연결 성공" + (conn!=null));
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clubNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				club = new club();
				club.setClubNum(rs.getInt("clubNum"));
		        club.setClubLeader(rs.getString("clubLeader"));
		        club.setClubName(rs.getString("clubName"));
		        club.setClubDescription(rs.getString("clubDescription"));
		        club.setClubCategory(rs.getString("clubCategory"));
		        club.setClubLocation(rs.getString("clubLocation"));
			} else {
				System.out.println("클럽 번호에 해당하는 데이터가 없음" + clubNum);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return club;
	}

	@Override
	public void updateClub(club club) {
		String sql = "UPDATE club SET clubLeader = ?, clubName = ?, clubDescription = ?, clubCategory = ?, clubLocation = ? WHERE clubNum = ?";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
	        pstmt.setString(1, club.getClubLeader());
	        pstmt.setString(2, club.getClubName());
	        pstmt.setString(3, club.getClubDescription());
	        pstmt.setString(4, club.getClubCategory());
	        pstmt.setString(5, club.getClubLocation());
	        pstmt.setInt(6, club.getClubNum());
			
	        pstmt.executeUpdate();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteClub(int clubNum) {
		String sql = "DELETE FROM club WHERE clubNum =?";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, clubNum);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<club> getAllClubs() {
		List<club> clubList = new ArrayList<club>();
		String sql = "SELECT * FROM club";
		
		try {
			
	        conn = DBConnection.getConnection(); // DB 연결
	        pstmt = conn.prepareStatement(sql); // PreparedStatement 생성
	        rs = pstmt.executeQuery(); // 쿼리 실행 및 ResultSet 초기화
			
			while(rs.next()) {
				club club = new club();
				club.setClubLeader(rs.getString("clubLeader"));
				club.setClubNum(rs.getInt("clubNum"));
				club.setClubName(rs.getString("clubName"));
	            club.setClubDescription(rs.getString("clubDescription"));
	            club.setClubCategory(rs.getString("clubCategory"));
	            club.setClubLocation(rs.getString("clubLocation"));
	            clubList.add(club);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return clubList;
	}
	// ClubMember C
	@Override
	public void addClubMember(clubMember clubmember) {
		String sql = "INSERT INTO clubMember VALUES (?, ?, ?, ?, ?, ?)";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clubmember.getMemberId());
	        pstmt.setInt(2, clubmember.getClubNum());
	        pstmt.setString(3, clubmember.getClubName());
	        pstmt.setString(4, clubmember.getJoinDate());
	        pstmt.setString(5, clubmember.getMemberphone());
	        pstmt.setString(6, clubmember.getMemberemail());
	        pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
