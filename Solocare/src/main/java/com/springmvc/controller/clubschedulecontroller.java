package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Calendar;
import com.springmvc.domain.club;
import com.springmvc.domain.clubcalendar;
import com.springmvc.domain.member;
import com.springmvc.service.clubService;
import com.springmvc.service.clubcalendarService;

@Controller
@RequestMapping("/club/clubcalendar")
public class clubschedulecontroller 
{
	@Autowired
	private clubcalendarService clubcalendarservice;
	@Autowired
    private clubService clubService; 
	
	// 동호회 일정 조회
	@GetMapping("/search/{clubNum}")
	public String getCalendar(@PathVariable int clubNum, Model model) {
		System.out.println("clubcalendar에 도착");
	    List<clubcalendar> events = clubcalendarservice.getEventsByClubNum(clubNum);
	    club club = clubService.getClubByNum(clubNum);
	    System.out.println(clubNum);
	    model.addAttribute("events", events);
	    model.addAttribute("club", club);
	    model.addAttribute("clubNum", clubNum);
	    return "club/clubcalendarList";
    }
	
	// 동호회 일정 추가 폼 및 동호회 정보 가져오기
	@GetMapping("/add/{clubNum}")
	public String AddEventForm(@PathVariable int clubNum, Model model)
	{
		club club = clubService.getClubByNum(clubNum);
	
        System.out.println(club.getClubName());
        model.addAttribute("clubName", club.getClubName()); // 동호회 이름 모델에 추가
        model.addAttribute("clubNum", clubNum); // 동호회 번호 모델에 추가
	   
		return "club/clubcalandaraddform";
	}
	  
	// 동호회 일정 추가 처리
	@PostMapping("/add/{clubNum}")
	public String addEvent(@PathVariable int clubNum, @ModelAttribute clubcalendar event) {
	    event.setCalendarNum(clubNum);
	    clubcalendarservice.add(event); 
	    return "redirect:/club/clubcalendar/search/"+clubNum; 
	}
	
	// 동호회 일정 삭제
	@GetMapping("/search/{clubNum}/delete/{title}")
	public String deleteEvent(@PathVariable int clubNum, @PathVariable String title) {
		clubcalendarservice.deleteclubcalendar(clubNum, title);
		return "redirect:/club/clubcalendar/search/"+clubNum;
	}

	// 동호회 일정 수정 폼
	@GetMapping("/search/{clubNum}/edit/{title}")
	public String editEvent(@PathVariable int clubNum, @PathVariable String title, Model model) {
	    clubcalendar event = clubcalendarservice.getEvent(clubNum, title); 
	    model.addAttribute("event", event);
	    return "club/clubcalendarupdateForm";
	}
	
	// 동호회 일정 수정처리
	@PostMapping("/search/{clubNum}/edit/update")
	public String updateEvent(@PathVariable int clubNum, 
	                          @RequestParam String oldTitle, 
	                          @RequestParam String newTitle, 
	                          @RequestParam String start, 
	                          @RequestParam String end, 
	                          @RequestParam String description) {
	    // 서비스 레이어 호출하여 일정 수정
		clubcalendarservice.updateEvent(clubNum, oldTitle, newTitle, start, end, description);
	    
	    // 수정 후 클럽 캘린더 페이지로 리다이렉트
	    return "redirect:/club/clubcalendar/search/"+clubNum;
	}
}


