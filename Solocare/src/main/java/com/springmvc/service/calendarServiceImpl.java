package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Calendar;
import com.springmvc.repository.calendarRepository;

@Service
public class calendarServiceImpl implements calendarService
{
	@Autowired
	private calendarRepository calendarRepository;

	@Override
	public void addCalendar(Calendar calendar) 
	{
		System.out.println("calendarservice addcalendar");
		calendarRepository.addCalendar(calendar);	
	}

	@Override
	public List<Calendar> getCalendarsByUserId(String userId) {
        return calendarRepository.findCalendarsByUserId(userId);
	}

	@Override
	public Calendar getCalendarById(String id) {
		return calendarRepository.findById(id);
	}

	@Override
	public void updateCalendar(Calendar calendar) {
		calendarRepository.updateCalendar(calendar);
	}

	@Override
	public void deleteCalendar(String id) {
		calendarRepository.deleteCalendar(id);
	}	
}
