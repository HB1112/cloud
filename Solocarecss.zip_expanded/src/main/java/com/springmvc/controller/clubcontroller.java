package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.springmvc.domain.club;
import com.springmvc.domain.clubMember;
import com.springmvc.service.clubService;
import com.springmvc.service.memberService;

@Controller
@RequestMapping("/club")
public class clubcontroller { 

    @Autowired
    private clubService clubService; 
    @Autowired
    private memberService memberservice;

    @GetMapping("/board")
    public String clubPage() {
        return "club/clubBoard";
    }

    @GetMapping("/regist") 
    public String registClub() {
        return "club/clubregist";
    }

    @PostMapping("/regist")
    public String addClub(@ModelAttribute club club, HttpServletRequest request, HttpServletResponse response) {
    	HttpSession session = request.getSession(true);
    	session.setAttribute("loggedInclubname", club.getClubName());
        clubService.addClub(club);
        
        return "redirect:/club/board";
    }
    
    // 전부 다 read
    @GetMapping("/list")
    public String listClubs(Model model) {
        List<club> clubs = clubService.getAllClubs(); 
        model.addAttribute("clubs", clubs);
        return "club/clubList";
    }

    // 하나씩 read
    @GetMapping("/detail/{clubNum}")
    public String clubDetail(@PathVariable int clubNum, Model model) {
        System.out.println("전달받은 클럽 번호: " + clubNum); 
        club club = clubService.getClubByNum(clubNum); 
        System.out.println("조회한 클럽: " + club); 
        
        if (club == null) {
            System.out.println("클럽 정보가 null입니다. 클럽 번호: " + clubNum);
            return "error"; 
        }
        
        model.addAttribute("club", club); 
        return "club/clubDetail"; 
    }
    // Club U
    @GetMapping("/update/{clubNum}")
    public String showUpdateForm(@PathVariable int clubNum, Model model) {
        club club = clubService.getClubByNum(clubNum); // 클럽 정보 조회
        if (club == null) {
            return "error"; // 클럽 정보가 없으면 에러 페이지로 이동
        }
        model.addAttribute("club", club); // 모델에 클럽 정보 추가
        return "club/clubUpdate"; // 클럽 수정 페이지 반환
    }
    
    @PostMapping("/update/submit")
    public String updateClub(@ModelAttribute club club) {
        clubService.updateClub(club); // 클럽 정보 업데이트
        return "redirect:/club/detail/" + club.getClubNum(); // 업데이트 후 상세 페이지로 리다이렉트
    }
    // Club D
    @PostMapping("/delete")
    public String deleteClub(@RequestParam int clubNum) {
        clubService.deleteClub(clubNum);
        return "redirect:/club/list";
    }
    // Club member join
    @GetMapping("join")
    public String gomemberjoin(@RequestParam int clubNum, Model model) {
    	club club = clubService.getClubByNum(clubNum);
    	if (club == null) {
            System.out.println("클럽 정보가 null입니다. 클럽 번호: " + clubNum);
            return "error"; 
        }
    	model.addAttribute("club",club);
    	
    	return "club/clubjoin";
    }
	 // Club member join
    @PostMapping("join")
    public String memberjoin(@ModelAttribute clubMember clubmember) {
    	
    	 // 현재 날짜 및 시간 포맷 설정
	    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm");
	    String join_date = formatter.format(new java.util.Date());
	    
	    clubmember.setJoinDate(join_date);
	    
	    clubService.addClubMember(clubmember);
	    memberservice.joinClub(clubmember.getMemberId(),clubmember.getClubNum());
    	return "redirect:/club/list";
    }
}

