package com.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.board;
import com.springmvc.domain.club;
import com.springmvc.domain.clubMember;
import com.springmvc.domain.clubboard;
import com.springmvc.domain.clubboardcomment;
import com.springmvc.domain.member;
import com.springmvc.service.clubService;
import com.springmvc.service.memberService;

@Controller
@RequestMapping("/club")
public class clubcontroller { 

    @Autowired
    private clubService clubService; 
    
    @GetMapping("/board")
    public String clubPage() {
        return "club/clubBoard";
    }
    
    //클럽 등록
    @GetMapping("/regist") 
    public String registClub() {
        return "club/clubregist";
    }
    // 클럽 등록
    @PostMapping("/regist")
    public String addClub(@ModelAttribute club club, HttpSession session) { 
       club = clubService.addClub(club);
        
       System.out.println(club.getClubNum());
       member mem = (member) session.getAttribute("mem");
       
       clubMember clubmember = new clubMember();
       clubmember.setMemberId(club.getClubLeader());
       clubmember.setClubNum(club.getClubNum());
       clubmember.setClubName(club.getClubName());
       // 현재 날짜 및 시간 포맷 설정
	   java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm");
	   String join_date = formatter.format(new java.util.Date());
       clubmember.setJoinDate(join_date);
       
       clubmember.setMemberphone(mem.getPhone());
       clubmember.setMemberemail(mem.getEmail());
       
       clubService.addClubLeader(clubmember);
        
       return "redirect:/club/list";
    }
    
    // 전부 다 read
    @GetMapping("/list")
    public String listClubs(@RequestParam(value = "category", required = false) String category,
                            @RequestParam(value = "region", required = false) String region,
                            @RequestParam(value = "searchType", required = false) String searchType,
                            @RequestParam(value = "query", required = false) String query,
                            Model model) {
        List<club> clubs = clubService.getAllClubs(); // 전체 클럽 리스트 초기화

        // 카테고리 필터링
        if (category != null && !category.isEmpty()) {
            clubs = clubService.getClubsByCategory(category);
            model.addAttribute("selectedCategory", category); // 선택한 카테고리 모델에 추가
        }

        // 지역 필터링
        if (region != null && !region.isEmpty()) {
            clubs = clubService.getClubsByRegion(region); // 지역에 따른 클럽 목록 가져오기
        }

        // 검색 기능
        if (searchType != null && query != null && !query.isEmpty()) {
            if (category != null && !category.isEmpty()) {
                // 카테고리 내에서 검색
                clubs = clubService.searchClubsInCategory(category, searchType, query);
            } else if (region != null && !region.isEmpty()) {
                // 지역 내에서 검색
                clubs = clubService.searchClubsInRegion(region, searchType, query);
            } else {
                // 전체에서 검색
                clubs = clubService.searchClubs(searchType, query);
            }
        }

        model.addAttribute("region", region);
        model.addAttribute("clubs", clubs);
        return "club/clubList"; // 클럽 리스트 페이지 반환
    }


    // 내 클럽
    @PostMapping("/myclub")
    public String myClublists(@RequestParam("id") String memberId, Model model) {
        System.out.println("동호회 관리 요청, 멤버 ID: " + memberId);
        List<club> clubs = clubService.getAllmyClubs(memberId);
        model.addAttribute("clubs", clubs);
        return "club/myclub"; // 클럽 리스트 페이지로 이동
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
    // 하나씩 read
    @GetMapping("/myclubdetail/{clubNum}")
    public String myclubDetail(@PathVariable int clubNum, Model model) {
        System.out.println("전달받은 클럽 번호: " + clubNum); 
        club club = clubService.getClubByNum(clubNum); 
        System.out.println("조회한 클럽: " + club); 
        
        if (club == null) {
            System.out.println("클럽 정보가 null입니다. 클럽 번호: " + clubNum);
            return "error"; 
        }
        
        model.addAttribute("club", club); 
        return "club/myclubDetail"; 
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
    // clubmember join check
    @GetMapping("/checkMembership")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkMembership(@RequestParam int clubNum, HttpSession session) {
        member mem = (member) session.getAttribute("mem"); // 세션에서 멤버 정보 가져오기
        Map<String, Object> response = new HashMap<>();
        
        if (mem == null) {
            response.put("isMember", false);
            return ResponseEntity.ok(response);
        }

        // DB에서 멤버가 해당 클럽에 가입되어 있는지 확인
        boolean isMember = clubService.isMemberOfClub(mem.getId(), clubNum); // 서비스 메서드 호출
        response.put("isMember", isMember);
        
        return ResponseEntity.ok(response);
    }
	 // Club member join
    @PostMapping("join")
    public String memberjoin(@ModelAttribute clubMember clubmember) {
    	
    	 // 현재 날짜 및 시간 포맷 설정
	    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm");
	    String join_date = formatter.format(new java.util.Date());
	    
	    clubmember.setJoinDate(join_date);
	    
	    clubService.addClubMember(clubmember);
	    
    	return "redirect:/club/list";
    }
    @GetMapping("/membercheck")
    public String membercheck(@RequestParam int clubNum, Model model) {
    	
    	System.out.println("멤버체크 클럽넘버 : "+clubNum);
    	List<clubMember> clubmembers = clubService.getAllClubMember(clubNum);
    	model.addAttribute("clubmembers",clubmembers);
    	return "club/membercheck";
    }
    @PostMapping("/approveMember")
    public String approveMember(@RequestParam("memberId") String memberId, 
                                @RequestParam("clubNum") int clubNum) {
        // 클럽 멤버 승인 처리
        clubService.approveMember(memberId, clubNum); // 승인을 위한 서비스 호출

        // 승인된 멤버 수 증가
        clubService.plusmemberCount(clubNum);

        return "redirect:/club/membercheck?clubNum=" + clubNum;  // 승인 후 리다이렉트할 페이지
    }
    @PostMapping("/cancelMember")
    public String cancelMember(@RequestParam("memberId") String memberId, 
                                @RequestParam("clubNum") int clubNum) {
        // 클럽 멤버 승인 처리
        clubService.cancelMember(memberId, clubNum); // 승인을 위한 서비스 호출

        // 승인된 멤버 수 증가
        clubService.minusmemberCount(clubNum);

        return "redirect:/club/membercheck?clubNum=" + clubNum;  // 승인 후 리다이렉트할 페이지
    }
    @PostMapping("/selfcancelMember")
    public String selfcancelMember(@RequestParam("memberId") String memberId, 
                                @RequestParam("clubNum") int clubNum) {
        // 클럽 멤버 승인 처리
        clubService.cancelMember(memberId, clubNum); // 승인을 위한 서비스 호출

        // 승인된 멤버 수 증가
        clubService.minusmemberCount(clubNum);

        return "redirect:/club/board";  // 승인 후 리다이렉트할 페이지
    }
    
   
    
    // 클럽 보드 write로 이동 C
    @GetMapping("/writeclub")
    public String gowriteboard(@RequestParam("clubNum") int clubNum,Model model) {
    	
    	model.addAttribute("clubNum",clubNum);
    	
    	return "club/clubWrite";
    }
    // 클럽 게시판 작성 C
    @PostMapping("/writeclub")
    public String writeboard(@ModelAttribute clubboard clubboard) {
    	 System.out.println("clubcontroller writeboard()");
    	// 현재 날짜 및 시간 포맷 설정
	    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm");
	    String regist_date = formatter.format(new java.util.Date());
	    clubboard.setHit(0);
	    clubboard.setRegist_date(regist_date);
	    
	    clubService.writeboard(clubboard);
    	
    	return "redirect:/club/community?clubNum="+clubboard.getClubNum();
    }
    
    
    // 클럽 별 게시판  all Read
    @GetMapping("/community")
    public String goCommunityList(@RequestParam("clubNum") int clubNum, @RequestParam(defaultValue = "1") int page, Model model) {
        System.out.println("클럽 번호: " + clubNum);

        int pageSize = 10; // 페이지당 게시글 수
        int totalBoards = clubService.getTotalClubBoardCount(clubNum); // 클럽 게시글 총 수
        int totalPages = (int) Math.ceil((double) totalBoards / pageSize); // 총 페이지 수

        List<clubboard> boards = clubService.getAllclubboard(clubNum, page, pageSize);
        model.addAttribute("clubboards", boards);
        model.addAttribute("clubNum", clubNum);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        
        // 시작 번호
        int startNumber = totalBoards - (page - 1) * pageSize; // 현재 페이지의 시작 번호
        model.addAttribute("startNumber", startNumber);
        // 클럽 커뮤니티 페이지로 이동
        return "club/clubcommunity"; 
    }
    // 클럽 게시판 검색 기능
    @GetMapping("/searchclubboard")
    public String searchClubBoard(
            @RequestParam("clubNum") int clubNum,
            @RequestParam("items") String items,
            @RequestParam("text") String text,
            @RequestParam(defaultValue = "1") int page,
            Model model) {
        
        System.out.println("ClubBoardController searchClubBoard()");
        // 로그 확인용
        System.out.println("검색 조건: " + items);
        System.out.println("검색어: " + text);
        System.out.println("페이지: " + page);
        
        int pageSize = 10; // 페이지당 게시글 수
        int totalBoards = clubService.getTotalSearchBoardCount(clubNum, items, text); // 검색 게시글 수
        int totalPages = (int) Math.ceil((double) totalBoards / pageSize); // 총 페이지 수
        
        List<clubboard> searchResult = clubService.searchClubBoard(clubNum, items, text, page, pageSize);
        model.addAttribute("clubboards", searchResult);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("items", items);
        model.addAttribute("text", text);
        model.addAttribute("clubNum", clubNum);

        // 시작 번호 계산 (최신 게시물부터 시작)
        int startNumber = totalBoards - (page - 1) * pageSize; // 현재 페이지의 시작 번호
        model.addAttribute("startNumber", startNumber);

        // 검색 결과 페이지로 이동
        return "club/clubcommunity"; // JSP 페이지 이름
    }

    // 클럽 게사핀 one read
    @GetMapping("/detailboard")
    public String godetail(@RequestParam("boardnum") int boardnum, Model model) {
    	System.out.println("클럽 게시물 번호: " + boardnum);
    	clubboard clubboard = clubService.getOneclubboard(boardnum);
    	
    	clubService.incrementhit(boardnum);
    	
    	model.addAttribute("clubboard",clubboard);
    	
    	
    	return "club/clubcommunitydetail";
    }
    // 클럽 게시판 update
    @GetMapping("/updateclubboard")
    public String goupdateclubboard(@RequestParam("boardnum") int boardnum, Model model) {
    	System.out.println("updateclubboard");
    	clubboard clubboard = clubService.getOneclubboard(boardnum);
    	model.addAttribute("clubboard",clubboard);
    	
    	return "club/clubboardupdate"; 
    }
    @PostMapping("/updateclubboard")
    public String updateclubboard(@ModelAttribute clubboard clubboard) {
    	System.out.println("updateclubboard post");
    	
    	clubService.updateClubboard(clubboard);
    	
    	return "redirect:/club/detailboard?boardnum="+clubboard.getBoardnum(); 
    }
    @GetMapping("/deleteclubboard")
    public String deleteclubboard(@RequestParam("boardnum") int boardnum,@RequestParam("clubNum") int clubNum, Model model) {
    	System.out.println("deleteclubboard");
    	clubService.deleteclubboard(boardnum);
    	
    	return "redirect:/club/community?clubNum="+clubNum; 
    }
    // 클럽 게시판 댓글 C
    @PostMapping("/addComment")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addComment(@RequestBody clubboardcomment cbcommentDto) {
        System.out.println("가져오는지 확인");

        Map<String, Object> response = new HashMap<>();
        try {
            System.out.println(cbcommentDto.getBoardnum());
            // 댓글 추가 로직
            cbcommentDto.setLikes(0); // 기본값으로 좋아요 수를 0으로 설정
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm");
            String regist_date = formatter.format(new java.util.Date());
            cbcommentDto.setCreatedDate(regist_date);

            // 댓글 추가 서비스 호출
            clubService.saveComment(cbcommentDto);
            
            // 성공적으로 추가된 경우
            response.put("success", true);
            response.put("commentnum", cbcommentDto.getCommentnum());
            response.put("boardnum", cbcommentDto.getBoardnum());
            response.put("authorId", cbcommentDto.getAuthorid());
            response.put("content", cbcommentDto.getCommentcontent());
            response.put("createdDate", cbcommentDto.getCreatedDate());
            response.put("likes", cbcommentDto.getLikes());
            
        } catch (Exception e) {
            response.put("success", false);
            e.printStackTrace(); // 예외 로그 출력
        }
        return ResponseEntity.ok(response);
    }
    // 클럽 게시판 댓글 R
    @PostMapping("/comments")
    public ResponseEntity<List<clubboardcomment>> getComments(@RequestBody Map<String, Integer> request) {
        int boardnum = request.get("boardnum");
        List<clubboardcomment> comments = clubService.getCommentsByBoardNum(boardnum);
        return ResponseEntity.ok(comments);
    }
    // 댓글 수정 메소드
    @PostMapping("/updateComment")
    public ResponseEntity<Map<String, Object>> updateComment(@RequestBody clubboardcomment commentDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 댓글 수정 로직
            boolean isUpdated = clubService.updateComment(commentDto);

            if (isUpdated) {
                response.put("success", true);
                response.put("message", "댓글이 성공적으로 수정되었습니다.");
            } else {
                response.put("success", false);
                response.put("message", "댓글 수정에 실패했습니다.");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "댓글 수정 중 오류가 발생했습니다.");
            e.printStackTrace(); // 오류 로그 출력
        }
        return ResponseEntity.ok(response); // JSON 형태로 응답 반환
    }
    
    // 댓글 삭제 메서드
    @PostMapping("/deleteComment")
    public ResponseEntity<Map<String, Object>> deleteComment(@RequestBody Map<String, Integer> request) {
        Map<String, Object> response = new HashMap<>();
        int commentnum = request.get("commentnum"); // 요청 본문에서 댓글 번호 가져오기

        try {
            boolean isDeleted = clubService.deleteComment(commentnum); // 댓글 삭제 서비스 호출
            if (isDeleted) {
                response.put("success", true);
                response.put("message", "댓글이 성공적으로 삭제되었습니다.");
            } else {
                response.put("success", false);
                response.put("message", "댓글 삭제에 실패했습니다.");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "댓글 삭제 중 오류가 발생했습니다.");
            e.printStackTrace(); // 오류 로그 출력
        }
        return ResponseEntity.ok(response); // JSON 형태로 응답 반환
    }

}

