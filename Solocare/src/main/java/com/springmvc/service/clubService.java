package com.springmvc.service;

import java.util.List;
import java.util.Map;

import com.springmvc.domain.club;
import com.springmvc.domain.clubMember;
import com.springmvc.domain.clubboard;
import com.springmvc.domain.clubboardcomment;

public interface clubService 
{
	
	club addClub(club club);
	club getClubByNum(int clubNum);
	void updateClub(club club);
	void deleteClub(int clubNum);
	List<club> getAllClubs();
	void addClubMember(clubMember clubmember);
	void plusmemberCount(int clubNum);
	Map<String, List<club>> getAllmyClubs(String memberId);
	List<clubMember> getAllClubMember(int clubNum);
	List<club> getClubsByCategory(String category);
	List<club> searchClubs(String searchType, String query);
	List<club> getClubsByRegion(String region);
	List<club> searchClubsInCategory(String category, String searchType, String query);
	List<club> searchClubsInRegion(String region, String searchType, String query);
	boolean isMemberOfClub(String id, int clubNum);
	void addClubLeader(clubMember clubmember);
	void approveMember(String memberId, int clubNum);
	void cancelMember(String memberId, int clubNum);
	void minusmemberCount(int clubNum);
	List<clubboard> getAllclubboard(int clubNumm, int page, int pageSize );
	void writeboard(clubboard clubboard);
	clubboard getOneclubboard(int boardnum);
	void updateClubboard(clubboard clubboard);
	void deleteclubboard(int boardnum);
	void saveComment(clubboardcomment cbcommentDto);
	List<clubboardcomment> getCommentsByBoardNum(int boardnum);
	boolean updateComment(clubboardcomment commentDto);
	boolean deleteComment(int commentnum);
	void incrementhit(int boardnum);
	int getTotalClubBoardCount(int clubNum);
	int getTotalSearchBoardCount(int clubNum, String items, String text);
	List<clubboard> searchClubBoard(int clubNum, String items, String text, int page, int pageSize);
	
}
