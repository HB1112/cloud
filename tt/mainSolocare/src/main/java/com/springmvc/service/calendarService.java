package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Calendar;

public interface calendarService {
    // 캘린더 일정 추가
    void addCalendar(Calendar calendar);
    
    // 사용자 ID에 맞는 캘린더 일정 조회
    List<Calendar> getCalendarsByUserId(String userId);
    
    // 특정 ID에 해당하는 캘린더 일정 조회
    Calendar getCalendarById(int calendarNum);
    
    // 캘린더 일정 수정
    void updateCalendar(Calendar calendar);
    
    // 특정 ID에 해당하는 캘린더 일정 삭제
    void deleteCalendar(int calendarNum);
}