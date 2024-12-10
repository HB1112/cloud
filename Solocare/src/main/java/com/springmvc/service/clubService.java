package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.club;

public interface clubService 
{
	
	void addClub(club club);
	club getClubByNum(int clubNum);
	void updateClub(club club);
	void deleteClub(int clubNum);
	List<club> getAllClubs();
}
