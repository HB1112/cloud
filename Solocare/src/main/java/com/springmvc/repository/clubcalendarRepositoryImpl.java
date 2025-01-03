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
	 
	 
	

