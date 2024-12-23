package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.club;
import com.springmvc.domain.clubMember;
import com.springmvc.domain.clubboard;
import com.springmvc.repository.clubRepository;

@Service
public class clubServiceImpl implements clubService 
{

	@Autowired
	private clubRepository clubRepository;
	
	@Override
	public club addClub(club club) {
		club = clubRepository.addClub(club);
		return club;
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

	@Override
	public void plusmemberCount(int clubNum) {
		clubRepository.plusmemberCount(clubNum);
	}

	@Override
	public List<club> getAllmyClubs(String memberId) {
		return clubRepository.getAllmyClubs(memberId);
	}

	@Override
	public List<clubMember> getAllClubMember(int clubNum) {
		
		return clubRepository.getAllClubMember(clubNum);
	}

	@Override
	public List<club> getClubsByCategory(String category) {
		
		return clubRepository.getClubsByCategory(category);
	}

	@Override
	public List<club> searchClubs(String searchType, String query) {
		
		return clubRepository.searchClubs(searchType, query);
	}

	@Override
	public List<club> getClubsByRegion(String region) {
		
		return clubRepository.getClubsByRegion(region);
	}

	@Override
	public List<club> searchClubsInCategory(String category, String searchType, String query) {
		
		return  clubRepository.searchClubsInCategory(category,searchType,query);
	}

	@Override
	public List<club> searchClubsInRegion(String region, String searchType, String query) {
		
		return clubRepository.searchClubsInRegion(region,searchType,query);
	}

	@Override
	public boolean isMemberOfClub(String id, int clubNum) {
		
		return clubRepository.isMemberOfClub(id,clubNum);
	}

	@Override
	public void addClubLeader(clubMember clubmember) {
		clubRepository.addClubLeader(clubmember);
	}

	@Override
	public void approveMember(String memberId, int clubNum) {
		clubRepository.approveMember(memberId, clubNum);
		
	}

	@Override
	public void cancelMember(String memberId, int clubNum) {
		clubRepository.cancelMember(memberId, clubNum);
		
	}

	@Override
	public void minusmemberCount(int clubNum) {
		clubRepository.minusmemberCount(clubNum);
		
	}

	@Override
	public List<clubboard> getAllclubboard(int clubNum) {
		
		return clubRepository.getAllclubboard(clubNum);
	}

	@Override
	public void writeboard(clubboard clubboard) {
		clubRepository.writeboard(clubboard);
		
	}

	@Override
	public clubboard getOneclubboard(int boardnum) {
		
		return clubRepository.getOneclubboard(boardnum);
	}

	@Override
	public void updateClubboard(clubboard clubboard) {
		clubRepository.updateClubboard(clubboard);
		
	}

	@Override
	public void deleteclubboard(int boardnum) {
		clubRepository.deleteclubboard(boardnum);
	}


	
}
