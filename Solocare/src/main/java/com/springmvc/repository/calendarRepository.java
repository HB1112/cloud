package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Calendar;

public interface calendarRepository 
{
	//캘린더 일정 조회하기
	void addCalendar(Calendar calendar);
	List<Calendar> findCalendarsByUserId(String userId);
	Calendar findById(String id);
	void updateCalendar(Calendar calendar);
    void deleteCalendar(String id);
}
