package com.springmvc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Calendar;

@Repository
public class calendarRepositoryImpl implements calendarRepository {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // 캘린더 일정 추가
    @Override
    public void addCalendar(Calendar calendar) {
        System.out.println("repositoryimpl addcalendar");
        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO calendar (CALENDAR_USERID, CALENDAR_TITLE, CALENDAR_START, CALENDAR_END, CALENDAR_description) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, calendar.getUserId());
            pstmt.setString(2, calendar.getTitle());
            pstmt.setString(3, calendar.getStart());
            pstmt.setString(4, calendar.getEnd());
            pstmt.setString(5, calendar.getDescription());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 캘린더 일정 모두 불러오기
    @Override
    public List<Calendar> findCalendarsByUserId(String userId) {
        List<Calendar> calendars = new ArrayList<>();
        String sql = "SELECT * FROM calendar WHERE CALENDAR_USERID = ?";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Calendar calendar = new Calendar();
                calendar.setCalendarNum(rs.getInt("CALENDAR_NUM"));
                calendar.setUserId(rs.getString("CALENDAR_USERID"));
                calendar.setTitle(rs.getString("CALENDAR_TITLE"));
                calendar.setStart(rs.getString("CALENDAR_START"));
                calendar.setEnd(rs.getString("CALENDAR_END"));
                calendar.setDescription(rs.getString("CALENDAR_description"));
                calendars.add(calendar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return calendars;
    }

    // 캘린더 일정 조회
    @Override
    public Calendar findById(int calendarNum) {
        String sql = "SELECT * FROM calendar WHERE CALENDAR_NUM = ?";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, calendarNum);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Calendar calendar = new Calendar();
                calendar.setCalendarNum(rs.getInt("CALENDAR_NUM"));
                calendar.setUserId(rs.getString("CALENDAR_USERID"));
                calendar.setTitle(rs.getString("CALENDAR_TITLE"));
                calendar.setStart(rs.getString("CALENDAR_START"));
                calendar.setEnd(rs.getString("CALENDAR_END"));
                calendar.setDescription(rs.getString("CALENDAR_description"));
                return calendar;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 캘린더 일정 수정
    @Override
    public void updateCalendar(Calendar calendar) {
        String sql = "UPDATE calendar SET CALENDAR_USERID=?, CALENDAR_TITLE=?, CALENDAR_START=?, CALENDAR_END=?, CALENDAR_description=? WHERE CALENDAR_NUM=?";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, calendar.getUserId());
            pstmt.setString(2, calendar.getTitle());
            pstmt.setString(3, calendar.getStart());
            pstmt.setString(4, calendar.getEnd());
            pstmt.setString(5, calendar.getDescription());
            pstmt.setInt(6, calendar.getCalendarNum());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 캘린더 일정 삭제
    @Override
    public void deleteCalendar(int calendarNum)
    {
    	String sql = "DELETE FROM calendar WHERE CALENDAR_NUM = ?"; // CALENDAR_NUM 기준
        try 
        {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, calendarNum); // calendarNum을 사용
            pstmt.executeUpdate();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }
}
