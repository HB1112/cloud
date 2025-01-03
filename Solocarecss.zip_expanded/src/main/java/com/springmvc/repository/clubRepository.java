package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.ClubPost;
import com.springmvc.domain.club;
import com.springmvc.domain.clubMember;

public interface clubRepository 
{
	void addClub(club club);
	club getClubByNum(int clubNum); // 클럽 번호로 개별 조회
	void updateClub(club club);
	void deleteClub(int clubNum);
	List<club> getAllClubs(); // 모든 클럽 조회
	void addClubMember(clubMember clubmember);

}
