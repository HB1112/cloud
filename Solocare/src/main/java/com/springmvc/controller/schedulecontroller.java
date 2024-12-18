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

import com.springmvc.domain.Calendar;
import com.springmvc.domain.member;
import com.springmvc.service.calendarService;

@Controller
public class schedulecontroller 
{	
	@Autowired
	private calendarService CalendarService;
	
	// 일정 추가 폼
	@GetMapping("/calendar")
	public String schedule(HttpSession session, Model model)
	{
    //System.out.println("도착");
		member mem = (member)session.getAttribute("mem");
		String userId = mem.getId();
		model.addAttribute("userId", userId);
		return "calendar/schedule";
	}
	
	//일정 추가
	 @PostMapping("/calendar")
	 public String addCalendar(@ModelAttribute Calendar calendar) 
	 {
     //System.out.println("컨트롤러 addcalendar");
	     CalendarService.addCalendar(calendar);
	     return "redirect:/list";
	 }
	 
	 //일정 조회 및 추가
	 @GetMapping("/list")
	 public String listCalendars(Model model, HttpSession session) {
	     // 세션에서 로그인한 사용자 ID 가져오기
		 member mem = (member)session.getAttribute("mem");
		 String userId = mem.getId();
	     
	     // 사용자 ID에 맞는 일정 조회
	     List<Calendar> calendars = CalendarService.getCalendarsByUserId(userId);
	     model.addAttribute("calendars", calendars);
	     
	     return "calendar/calendarList"; // 일정 목록 뷰 반환
	 }
	 
	 //일정 조회 및 수정
	 @GetMapping("/edit/{id}")
	 public String updateSchedule(@PathVariable String id, Model model) 
	 {
		 System.out.println("수정 도착");
		 Calendar calendar = CalendarService.getCalendarById(id);
		 model.addAttribute("calendar", calendar);
		 return "calendar/calendarupdate"; 
	 }
	 
	 //일정 수정 처리
	 @PostMapping("/edit/update")
	 public String updateSchedule(@ModelAttribute Calendar calendar) 
	 {
		 CalendarService.updateCalendar(calendar);
		 return "redirect:/list"; // 수정 후 목록으로 리다이렉트
	 }
	 
	 //일정 삭제
	 @GetMapping("/delete/{id}")
	 public String deleteSchedule(@PathVariable String id) {
		 CalendarService.deleteCalendar(id);
		 return "redirect:/list";
	 }
}
