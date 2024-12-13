package com.springmvc.domain;

public class club {

	private String clubLeader;
	private int clubNum;
	private String clubName;
	private String clubDescription;
	private String clubCategory;
	private String clubLocation;
	private int memberCount;
	// 기본 생성자
    public club() {
        this.memberCount = 1; // 기본값을 1로 설정
    }
	
	public String getClubLeader() {
		return clubLeader;
	}
	public void setClubLeader(String clubLeader) {
		this.clubLeader = clubLeader;
	}
	public int getClubNum() {
		return clubNum;
	}
	public void setClubNum(int clubNum) {
		this.clubNum = clubNum;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getClubDescription() {
		return clubDescription;
	}
	public void setClubDescription(String clubDescription) {
		this.clubDescription = clubDescription;
	}
	public String getClubCategory() {
		return clubCategory;
	}
	public void setClubCategory(String clubCategory) {
		this.clubCategory = clubCategory;
	}
	public String getClubLocation() {
		return clubLocation;
	}
	public void setClubLocation(String clubLocation) {
		this.clubLocation = clubLocation;
	}
	public int getMembercount() {
		return memberCount;
	}
	public void setMembercount(int memberCount) {
		this.memberCount = memberCount;
	}

}
