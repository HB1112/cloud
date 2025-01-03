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
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Calendar;
import com.springmvc.domain.club;
import com.springmvc.domain.clubcalendar;
import com.springmvc.domain.member;
import com.springmvc.service.clubcalendarService;

@Controller
public class clubschedulecontroller 
{
	@Autowired
	private clubcalendarService clubcalendarservice;
	
	// 내가 속한 동호회 리스트
	@GetMapping("/club/myclublist")
	public String getAllmyClubs(HttpSession session, Model model)
	{
		String memberId = (String) session.getAttribute("loggedInUserId");
		System.out.println(memberId);
		List<club> club = clubcalendarservice.getAllmyClubs(memberId);
		model.addAttribute("club", club);
		return "club/myclublist";
	}
	
	// 동호회 일정 조회
	@GetMapping("/club/{clubNum}/clubcalendar")
	public String getCalendar(@PathVariable int clubNum, Model model) {
		System.out.println("clubcalendar에 도착");
	    List<clubcalendar> events = clubcalendarservice.getEventsByClubNum(clubNum);
	    System.out.println(clubNum);
	    model.addAttribute("events", events);
	    model.addAttribute("clubNum", clubNum);
    return "club/clubcalendarList";
    }
	
	// 동호회 일정 추가 폼 및 동호회 정보 가져오기
	@GetMapping("/club/{clubNum}/clubcalendar/add")
	public String AddEventForm(@PathVariable int clubNum, Model model)
	{
		List<club> clubs = clubcalendarservice.findById(clubNum);
		
		if (!clubs.isEmpty()) {
	        club club = clubs.get(0); // 첫 번째 동호회 가져오기
	        System.out.println(club.getClubName());
	        model.addAttribute("clubName", club.getClubName()); // 동호회 이름 모델에 추가
	        model.addAttribute("clubNum", clubNum); // 동호회 번호 모델에 추가
	    } else {
	        return "error"; // 동호회가 존재하지 않는 경우의 처리
	    }
		return "club/clubaddform";
	}
	  
	// 동호회 일정 추가 처리
	@PostMapping("/club/{clubNum}/clubcalendar/add")
	public String addEvent(@PathVariable int clubNum, @ModelAttribute clubcalendar event) {
	    event.setCalendarNum(clubNum);
	    clubcalendarservice.add(event); 
	    return "redirect:/club/" + clubNum + "/clubcalendar"; 
	}
	
	// 동호회 일정 삭제
	@GetMapping("/club/{clubNum}/delete/{title}")
	public String deleteEvent(@PathVariable int clubNum, @PathVariable String title) {
		clubcalendarservice.deleteclubcalendar(clubNum, title);
		return "redirect:/club/" + clubNum + "/clubcalendar";
	}

	// 동호회 일정 수정 폼
	@GetMapping("/club/{clubNum}/edit/{title}")
	public String editEvent(@PathVariable int clubNum, @PathVariable String title, Model model) {
	    clubcalendar event = clubcalendarservice.getEvent(clubNum, title); 
	    model.addAttribute("event", event);
	    return "club/clubcalendarupdateForm";
	}
	
	// 동호회 일정 수정처리
	@PostMapping("/club/{clubNum}/edit/update")
	public String updateEvent(@PathVariable int clubNum, 
	                          @RequestParam String oldTitle, 
	                          @RequestParam String newTitle, 
	                          @RequestParam String start, 
	                          @RequestParam String end, 
	                          @RequestParam String description) {
	    // 서비스 레이어 호출하여 일정 수정
		clubcalendarservice.updateEvent(clubNum, oldTitle, newTitle, start, end, description);
	    
	    // 수정 후 클럽 캘린더 페이지로 리다이렉트
	    return "redirect:/club/" + clubNum + "/clubcalendar";
	}
}


