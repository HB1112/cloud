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
		calendarRepository.addCalendar(calendar);	
	}

	@Override
	public List<Calendar> getCalendarsByUserId(String userId) 
	{
        return calendarRepository.findCalendarsByUserId(userId);
	}

	@Override
	public Calendar getCalendarById(int calendarNum) 
	{
		return calendarRepository.findById(calendarNum);
	}

	@Override
	public void updateCalendar(Calendar calendar)
	{
		calendarRepository.updateCalendar(calendar);
	}

	@Override
	public void deleteCalendar(int calendarNum) 
	{
		calendarRepository.deleteCalendar(calendarNum);
	}	
}
