package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.club;
import com.springmvc.domain.clubcalendar;
import com.springmvc.repository.clubcalendarRepository;

@Service
public class clubcalendarServiceImpl implements clubcalendarService
{
	@Autowired
	private clubcalendarRepository clubcalendarRepository;
	

	@Override
	public List<clubcalendar> getEventsByClubNum(int clubNum) {
		return clubcalendarRepository.findByClubCALENDAR_clubnum(clubNum);
	}
	

	@Override
	public void add(clubcalendar event) {
		clubcalendarRepository.add(event);
		
	}

	@Override
	public void deleteclubcalendar(int calendarNum, String title) {
		clubcalendarRepository.deleteclubcalendar(calendarNum, title);
		
	}


	@Override
	public clubcalendar getEvent(int clubNum, String title) {
		return clubcalendarRepository.getEvent(clubNum, title);
	}


	@Override
	public void updateEvent(int clubNum, String oldTitle, String newTitle, String start, String end, String description) {
		clubcalendarRepository.updateEvent(clubNum, oldTitle, newTitle, start, end, description);
	}

	
	
	
	
	
}
