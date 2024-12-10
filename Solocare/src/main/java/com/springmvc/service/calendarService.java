package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Calendar;

public interface calendarService 
{
	//캘린더 일정 조회하기
	void addCalendar(Calendar calendar);
	List<Calendar> getCalendarsByUserId(String userId);
	Calendar getCalendarById(String id);
    void updateCalendar(Calendar calendar);
    void deleteCalendar(String id);
}
