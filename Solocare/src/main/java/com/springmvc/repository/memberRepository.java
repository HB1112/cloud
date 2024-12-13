package com.springmvc.repository;

import com.springmvc.domain.member;

public interface memberRepository {
	
	void addmember(member member);
	member getmemberById(String id);
	member loginmember(String id, String pw);
	void updatemember(member member);
	void deletemember(member mem);
	boolean isIdExists(String id);
	void joinClub(String memberId, int clubNum);
	
}
