package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.club;
import com.springmvc.domain.clubMember;
import com.springmvc.repository.clubRepository;

@Service
public class clubServiceImpl implements clubService 
{

	@Autowired
	private clubRepository clubRepository;
	
	@Override
	public void addClub(club club) {
		clubRepository.addClub(club);
	}

	@Override
	public club getClubByNum(int clubNum) {
		return clubRepository.getClubByNum(clubNum);
	}

	@Override
	public void updateClub(club club) {
		
		clubRepository.updateClub(club);
	}

	@Override
	public void deleteClub(int clubNum) {
		
		clubRepository.deleteClub(clubNum);
		
	}

	@Override
	public List<club> getAllClubs() {
		return clubRepository.getAllClubs();
	}

	@Override
	public void addClubMember(clubMember clubmember) {
		clubRepository.addClubMember(clubmember);
		
	}

	
	
}
