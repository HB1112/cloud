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
	PreparedStatement pstmt2 = null;
	ResultSet rs =null;
	ResultSet rs2 =null;
	
	@Override
	public club addClub(club club) {
		String sql = "INSERT INTO club (clubLeader, clubName, clubDescription, clubCategory, clubLocation, memberCount) VALUES (?, ?, ?, ?, ?, ?)";
		String sqlSelect = "SELECT * FROM club WHERE clubName = ? AND clubLeader = ?";
		int clubNum = 0;
		try {
			
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, club.getClubLeader());
			pstmt.setString(2, club.getClubName());
            pstmt.setString(3, club.getClubDescription()); 
            pstmt.setString(4, club.getClubCategory()); 
            pstmt.setString(5, club.getClubLocation());
            pstmt.setInt(6, club.getMembercount());
			
            pstmt.executeUpdate();
            System.out.println("클럽 등록 성공");
			
            pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, club.getClubName()); // 클럽 이름
            pstmt.setString(2, club.getClubLeader()); // 클럽 리더
            rs = pstmt.executeQuery();
            if (rs.next()) {
                club.setClubNum(rs.getInt("clubNum"));
                System.out.println("등록된 클럽 번호: " + club.getClubNum());
            } else {
                System.out.println("클럽 정보를 찾을 수 없습니다.");
            }
            
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("클럽 추가 중 오류 발생"+e.getMessage());
		}
		return club;
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

	@Override
	public void plusmemberCount(int clubNum) {
		String sql = "UPDATE club SET memberCount = memberCount + 1 WHERE clubNum = ?";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, clubNum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<club> getAllmyClubs(String memberId) {
	    List<club> clubs = new ArrayList<>();
	    String sqlSelectClubNum = "SELECT clubNum FROM clubmember WHERE memberId = ?";
	    String sqlSelectClub = "SELECT * FROM club WHERE clubNum = ?";	    
	    try{
	    	conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sqlSelectClubNum);
	        pstmt.setString(1, memberId);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            int clubNum = rs.getInt("clubNum");

	            // 클럽 정보 조회
	            pstmt2 = conn.prepareStatement(sqlSelectClub);
	            pstmt2.setInt(1, clubNum);
	            rs2 = pstmt2.executeQuery();
	            while(rs2.next()) {
	            	club club = new club();
                    club.setClubLeader(rs2.getString("clubLeader"));
                    club.setClubNum(rs2.getInt("clubNum"));
                    club.setClubName(rs2.getString("clubName"));
                    club.setClubDescription(rs2.getString("clubDescription"));
                    club.setClubCategory(rs2.getString("clubCategory"));
                    club.setClubLocation(rs2.getString("clubLocation"));
                    
                    clubs.add(club); // 클럽 정보를 리스트에 추가
	            }
	            
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return clubs;
	}

	@Override
	public List<clubMember> getAllClubMember(int clubNum) {
		List<clubMember> clubMembers = new ArrayList<>();
	    String sql = "SELECT * FROM clubMember WHERE clubNum = ?";
	    try (Connection conn = DBConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	           
	           // 클럽 번호 설정
	           pstmt.setInt(1, clubNum);

	           // 쿼리 실행
	           try (ResultSet rs = pstmt.executeQuery()) {
	               // 결과 처리
	               while (rs.next()) {
	                   clubMember member = new clubMember();
	                   member.setMemberId(rs.getString("memberId"));
	                   member.setClubNum(rs.getInt("clubNum"));
	                   member.setClubName(rs.getString("clubName"));
	                   member.setJoinDate(rs.getString("joinDate"));
	                   member.setMemberphone(rs.getString("memberphone"));
	                   member.setMemberemail(rs.getString("memberemail"));
	                   
	                   clubMembers.add(member); // 리스트에 추가
	               }
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return clubMembers; // 클럽 멤버 리스트 반환
	}

	
	
}
