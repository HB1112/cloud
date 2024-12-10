package com.springmvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Calendar;

@Repository
public class calendarRepositoryImpl implements calendarRepository
{
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	
	// 캘린더 일정 추가
	@Override
	public void addCalendar(Calendar calendar)
	{
		System.out.println("repositoryimpl addcalendar");
		try 
		{
			conn = DBConnection.getConnection();
			String sql = "INSERT INTO calendar VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, calendar.getId());
			pstmt.setString(2, calendar.gettitle());
			pstmt.setString(3, calendar.getStart());
			pstmt.setString(4, calendar.getEnd());
			pstmt.setString(5, calendar.getDescription());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt != null) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	// 캘린더 일정 모두 불러오기
	@Override
	 public List<Calendar> findCalendarsByUserId(String userId)
	{
		List<Calendar> calendars = new ArrayList<>();
		String sql = "SELECT * FROM calendar WHERE calendar_clubid = ?";
		try
		{
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Calendar calendar = new Calendar();
				calendar.setId(rs.getString("calendar_clubid"));
				calendar.settitle(rs.getString("calendar_title"));
				calendar.setStart(rs.getString("calendar_start"));
				calendar.setEnd(rs.getString("calendar_end"));
				calendar.setDescription(rs.getString("calendar_description"));
				calendars.add(calendar);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return calendars;
	}

	// 캘린더 일정 및 수정 폼
	@Override
	public Calendar findById(String id) 
	{
		String sql = "select calendar_clubid, calendar_title, calendar_start, calendar_end, calendar_description from calendar where calendar_clubid = ?";
		try
		{
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				Calendar calendar = new Calendar();
				calendar.setId(rs.getString("calendar_clubid"));
				calendar.settitle(rs.getString("calendar_title"));
				calendar.setStart(rs.getString("calendar_start"));
				calendar.setEnd(rs.getString("calendar_end"));
				calendar.setDescription(rs.getString("calendar_description"));
				return calendar;
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	// 캘린더 일정 수정
	@Override
	public void updateCalendar(Calendar calendar) 
	{
		String sql = "update calendar set calendar_title=?, calendar_start=?, calendar_end=?, calendar_description=?, where calendar_clubid=?";
		try 
		{
			conn = DBConnection.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, calendar.gettitle());
			pstmt.setString(2, calendar.getStart());
			pstmt.setString(3, calendar.getEnd());
			pstmt.setString(4, calendar.getId());
			pstmt.setString(5, calendar.getDescription());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	// 캘린더 일정 삭제
	@Override
	public void deleteCalendar(String id) 
	{
		String sql = "delete from calendar where calendar_clubid = ?";
		try 
		{
			conn=DBConnection.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
}
