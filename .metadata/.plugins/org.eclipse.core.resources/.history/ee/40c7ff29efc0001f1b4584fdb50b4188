package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Calendar;
import com.springmvc.domain.club;
import com.springmvc.domain.clubcalendar;

public interface clubcalendarService 
{
	// 내가 속한 동호회 리스트
	List<club> getAllmyClubs(String memberId);
	// 동호회 일정 불러오기
	List<clubcalendar> getEventsByClubNum(int clubNum);
	// 동호회 정보 가져오기
	List<club> findById(int clubNum);
	// 동호회 일정 추가
	void add(clubcalendar event);
	// 동호회 일정 삭제
	void deleteclubcalendar(int calendarNum, String title);
	// 수정페이지 이동할때 일정 가져오기
	clubcalendar getEvent(int clubNum, String title);
	// 동호회 일정 수정처리 
	void updateEvent(int clubNum, String oldTitle, String newTitle, String start, String end, String description);
}
