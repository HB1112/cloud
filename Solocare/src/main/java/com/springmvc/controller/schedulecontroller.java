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

import com.springmvc.domain.Calendar;
import com.springmvc.service.calendarService;

@Controller
public class schedulecontroller {
    @Autowired
    private calendarService CalendarService;
    
    // 일정 추가 폼
    @GetMapping("/calendar")
    public String schedule(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("loggedInUserId");
        model.addAttribute("userId", userId);
        return "/calendar/schedule";
    }
    
    // 일정 추가
    @PostMapping("/calendar")
    public String addCalendar(@ModelAttribute Calendar calendar) 
    {
    	System.out.println(calendar);
        CalendarService.addCalendar(calendar);
        return "redirect:/list";
    }
    
    // 일정 조회
    @GetMapping("/list")
    public String listCalendars(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("loggedInUserId");
        List<Calendar> calendars = CalendarService.getCalendarsByUserId(userId);
        model.addAttribute("calendars", calendars);
        return "/calendar/calendarList";
    }
    
 // 일정 수정 페이지로 이동 (calendarNum을 사용)
    @GetMapping("/edit/{calendarNum}") 
    public String editSchedule(@PathVariable int calendarNum, Model model) {
        Calendar calendar = CalendarService.getCalendarById(calendarNum); // calendarNum으로 일정 조회
        model.addAttribute("calendar", calendar);
        return "/calendar/calendarupdate"; // 수정 페이지로 이동
    }

    // 일정 수정 처리
    @PostMapping("/edit/update")
    public String updateSchedule(@ModelAttribute Calendar calendar) {
        CalendarService.updateCalendar(calendar);
        return "redirect:/list"; // 수정 후 목록으로 리다이렉트
    }

    // 일정 삭제
    @GetMapping("/delete/{calendarNum}") 
    public String deleteSchedule(@PathVariable int calendarNum) {
        CalendarService.deleteCalendar(calendarNum); // calendarNum을 사용하여 삭제
        return "redirect:/list";
    }
}