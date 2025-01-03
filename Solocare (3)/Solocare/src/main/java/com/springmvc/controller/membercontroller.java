package com.springmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.member;
import com.springmvc.service.memberService;

@Controller
public class membercontroller {

	@Autowired
	private memberService memberservice;
	@Autowired
	MailSender sender;
	
	@GetMapping("/login")
	public String gologin(HttpServletRequest request, Model model) {
		System.out.println("membercontroller gologin()");
		// 전 페이지 URL 저장
	    String referer = request.getHeader("Referer");
	    if (referer != null) {
	        request.getSession().setAttribute("previousUrl", referer);
	    }

	    return "member/login";
	}

	// member R 로그인 했을 때 one Read
	@PostMapping("/login")
	public String loginmember(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpServletRequest request, HttpServletResponse response) {
	    System.out.println(id);
	    System.out.println(pw);

	    member mb = memberservice.loginmember(id, pw);

	    if (mb != null) {
	        System.out.println("해당 멤버 존재 : " + mb.getName());

	        // 이메일 인증 체크
	        if (mb.getEmailcheck() == 0) {
	            // 이메일 인증이 필요함
	            request.setAttribute("emailCheckError", "이메일 인증이 필요합니다.");
	            return "member/login"; // 로그인 페이지로 돌아감
	        }

	        HttpSession session = request.getSession(true);
	        session.setAttribute("mem", mb);
	        
	        // 세션에서 전 페이지 URL 가져오기
	        String previousUrl = (String) session.getAttribute("previousUrl");
	        if (previousUrl != null) {
	            // 전 페이지가 회원가입 페이지인지 확인
	            if (previousUrl.contains("/addmember")) { // 회원가입 페이지 URL을 포함하는지 확인
	                return "redirect:/home"; // 홈 페이지로 리다이렉트
	            } else {
	                return "redirect:" + previousUrl; // 전 페이지로 리다이렉트
	            }
	        } else {
	            return "redirect:/defaultPage"; // 기본 페이지로 리다이렉트
	        }
	    } else {
	        // 로그인 실패
	        String error = "1";
	        request.setAttribute("error", error);
	        return "member/login"; // 로그인 페이지로 돌아감
	    }
	}


	// member logut
	@GetMapping("/logout")
	public String logoutmember(HttpServletRequest request) {
	    HttpSession session = request.getSession(false); // 기존 세션 가져오기
	    
	    if (session != null) {
	        session.invalidate(); // 세션 무효화
	    }

	    // 항상 홈 페이지로 리다이렉트
	    return "redirect:/home";
	}




	// member C

	@GetMapping("/addmember")
	public String goaddMember() {
		return "member/addmember";
	}

	@PostMapping("/addmember")
    public String addMember(@ModelAttribute member member,
                            @RequestParam("mailDomain") String mailDomain,
                            @RequestParam("birth") String birth,
                            Model model) {
        // 이메일 주소 통합
        String fullEmail = member.getEmail() + "@" + mailDomain;
        member.setEmail(fullEmail);
        // 이메일 인증
        String host="http://localhost:8080/Solocare/emailcheck";
        String from = "rhxntrt22@gmail.com";
        String to = fullEmail;
        String text = "클릭하여 이메일 인증을 완료해 주십시요 \n"+ host +"?email="+ fullEmail;
       
        SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("전달메시지");
		message.setText(text);
		message.setFrom(from);
		sender.send(message);
		System.out.println("전송완료");

        // 데이터 처리 (예: 데이터베이스에 저장)

        // 모델에 추가하여 뷰로 전달
        model.addAttribute("member", member);

        memberservice.addmember(member);

        // 성공적으로 처리 후 리다이렉트 또는 뷰 이름 반환
        return "member/memberSuccess"; // 성공 페이지로 리다이렉트
    }
	@GetMapping("/emailcheck")
	public String emailcheck(@RequestParam String email) {
		memberservice.emailcheck(email);
		
		
		return null;
	}

	// 회원가입 중 아이디 체크
	// 아이디 체크 메서드 추가
	@PostMapping("/idcheck")
	public ResponseEntity<String> idcheck(@RequestBody Map<String, String> requestData) {
		System.out.println("membercontroller idcheck()");
	    String id = requestData.get("id");
	    boolean isExists = memberservice.isIdExists(id);
	    if (isExists) {
	        return ResponseEntity.ok("exists");
	    } else {
	        return ResponseEntity.ok("available");
	    }
	}
	// member U 내정보 보기
	@GetMapping("/infocheck")
	public String checkinfo() {
		return "member/checkinfo";
	}
	@PostMapping("/checkpw")
	public String checkinfo(@RequestParam("pw") String checkpw, HttpServletRequest request) {

		HttpSession session = request.getSession(false); // 기존 세션 가져오기
		member mem = (member) session.getAttribute("mem");
		String error;
		if(checkpw.equals(mem.getPw())) {
			return "member/myinfo";
		}else {
			error = "패스워드가 틀렸습니다";
			request.setAttribute("error", error);
			return "member/checkinfo";
		}
	}
	@GetMapping("/updatemember")
	public String goupdatemember() {

		return "member/updatemember";
	}
	@PostMapping("/updatemember")
	public String updatemember(@ModelAttribute member member,  @RequestParam("mailDomain") String mailDomain) {
		System.out.println(member.getName());

		String fullEmail = member.getEmail() + "@" + mailDomain;
        member.setEmail(fullEmail);
        System.out.println(member.getEmail());
		memberservice.updatemember(member);

		return "welcome";
	}
	@GetMapping("/deletemember")
	public String godeletemember(HttpServletRequest request) {
		HttpSession session = request.getSession(false); // 기존 세션 가져오기
		member mem = (member) session.getAttribute("mem");
		memberservice.deletemember(mem);
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
		return "redirect:/home";
	}
}
