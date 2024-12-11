package com.springmvc.controller;

import java.util.List;

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
import com.springmvc.service.clubService;

@Controller
@RequestMapping("/club")
public class clubcontroller { 

    @Autowired
    private clubService clubService; 

    @GetMapping("/board")
    public String clubPage() {
        return "club/clubBoard";
    }

    @GetMapping("/regist") 
    public String registClub() {
        return "club/clubregist";
    }

    @PostMapping("/regist")
    public String addClub(@ModelAttribute club club) { 
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

    @PostMapping("/delete")
    public String deleteClub(@RequestParam int clubNum) {
        clubService.deleteClub(clubNum);
        return "redirect:/club/list";
    }
}
