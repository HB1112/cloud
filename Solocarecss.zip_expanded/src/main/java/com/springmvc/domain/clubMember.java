package com.springmvc.domain;


public class clubMember 
{
	private String memberId;
	private int clubNum;
	private String clubName;
	private String joinDate;
	private String memberphone;
	private String memberemail;
	

	public clubMember() {}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
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


	public String getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}


	public String getMemberphone() {
		return memberphone;
	}


	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}


	public String getMemberemail() {
		return memberemail;
	}


	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}
	
		
}