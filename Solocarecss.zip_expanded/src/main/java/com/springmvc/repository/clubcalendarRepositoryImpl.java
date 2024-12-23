package com.springmvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.club;
import com.springmvc.domain.clubMember;
import com.springmvc.domain.clubcalendar;
import com.springmvc.domain.member;

@Repository
public class clubcalendarRepositoryImpl implements clubcalendarRepository
{
	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 PreparedStatement pstmt2 = null;
	 ResultSet rs = null;
	 ResultSet rs2 = null;
	 
	 
	    // 내가 속한 동호회 가져오기
	  @Override
	    public List<club> getAllmyClubs(String memberId) {
	       List<club> clubs = new ArrayList<>();
	       System.out.println(memberId);
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

	    // 동호회 일정 조회
		@Override
		public List<clubcalendar> findByClubCALENDAR_clubnum(int clubNum) {
			List<clubcalendar> events = new ArrayList<>();
			String sql = "SELECT * FROM clubcalendar WHERE clubCALENDAR_clubnum = ?";
			try
			{
				conn = DBConnection.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, clubNum);
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					clubcalendar event = new clubcalendar();
					event.setCalendarNum(rs.getInt("clubCALENDAR_clubnum"));
					event.setClubname(rs.getString("clubCALENDAR_clubname"));
					event.setTitle(rs.getString("clubCALENDAR_TITLE"));
					event.setStart(rs.getString("clubCALENDAR_START"));
					event.setEnd(rs.getString("clubCALENDAR_END"));
					event.setDescription(rs.getString("clubCALENDAR_description"));
					
					events.add(event);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return events;
		}

	    // 동호회 정보 가져오기
	 @Override
		public List<club> findById(int clubNum) {
		 	String sql = "SELECT * FROM club WHERE clubNum = ?";
		 	List<club> clubs = new ArrayList<>();
		 	try
		 	{
		 		conn = DBConnection.getConnection();
		 		pstmt = conn.prepareStatement(sql);
		 		pstmt.setInt(1, clubNum);
		 		rs = pstmt.executeQuery();
		 		
		 		while (rs.next()) {
		            club club = new club(); 
		            club.setClubNum(rs.getInt("clubNum"));
		            club.setClubLeader(rs.getString("clubLeader"));
		            club.setClubName(rs.getString("clubName"));
		            club.setClubDescription(rs.getString("clubDescription"));
		            club.setClubCategory(rs.getString("clubCategory"));
		            club.setClubLocation(rs.getString("clubLocation"));
		            clubs.add(club); // 리스트에 추가
		 		
		 		}
		 	}
		 	catch(Exception e)
		 	{
		 		e.printStackTrace();
		 	}
			return clubs;
		}

		// 동호회 일정 추가
		@Override
		public void add(clubcalendar event) {
			String sql = "INSERT INTO clubcalendar (clubCALENDAR_clubnum, clubCALENDAR_clubname, clubCALENDAR_TITLE, clubCALENDAR_START, clubCALENDAR_END, clubCALENDAR_description) VALUES (?, ?, ?, ?, ?, ?)";
			try
			{
				conn = DBConnection.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, event.getCalendarNum());
				pstmt.setString(2, event.getClubname());
				pstmt.setString(3, event.getTitle());
				pstmt.setString(4, event.getStart());
				pstmt.setString(5, event.getEnd());
				pstmt.setString(6, event.getDescription());
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		// 동호회 일정 삭제
		@Override
		public void deleteclubcalendar(int clubNum, String title) {		
			String sql = "DELETE FROM clubcalendar WHERE clubCALENDAR_clubnum = ? AND clubCALENDAR_TITLE = ?";
			try
			{
				conn = DBConnection.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, clubNum);
				pstmt.setString(2, title);
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		
		// 수정폼으로 이동할때 일정 가져오기
		@Override
		public clubcalendar getEvent(int clubNum, String title) {
			System.out.println("getEvent repositoryImpl 도착");
			System.out.println(clubNum);
			System.out.println(title);
			String sql = "select * from clubcalendar where clubcalendar_clubnum = ? and clubcalendar_title = ?";
			clubcalendar event = null;
			try
			{
				conn = DBConnection.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, clubNum);
				pstmt.setString(2, title);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					event = new clubcalendar();
					event.setCalendarNum(rs.getInt("clubCALENDAR_clubnum"));
					event.setTitle(rs.getString("clubCALENDAR_TITLE"));
					event.setStart(rs.getString("clubCALENDAR_START"));
					event.setEnd(rs.getString("clubCALENDAR_END"));
					event.setDescription(rs.getString("clubCALENDAR_description"));
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return event;
		}

		@Override
		public void updateEvent(int clubNum, String oldTitle, String newTitle, String start, String end, String description) {
			  String sql = "UPDATE clubcalendar SET clubCALENDAR_TITLE = ?, clubCALENDAR_START = ?, clubCALENDAR_END = ?, clubCALENDAR_description = ? " +
		                 "WHERE clubCALENDAR_clubnum = ? AND clubCALENDAR_TITLE = ?";
			  try
			  {
				  conn = DBConnection.getConnection();
				  pstmt = conn.prepareStatement(sql);
				  pstmt.setString(1, newTitle);
			      pstmt.setString(2, start);
			      pstmt.setString(3, end);
			      pstmt.setString(4, description);
			      pstmt.setInt(5, clubNum);
			      pstmt.setString(6, oldTitle);
			      pstmt.executeUpdate();
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			  
		}
		
	   
	 
	
}
	 
	 
	
