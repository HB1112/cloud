package com.springmvc.domain;

public class clubboard {
	
	private int boardnum;
	private String memberid;//
	private String subject;	//
	private String content;	//
	private String regist_date;
	private int hit;
	private int clubNum;
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(String regist_date) {
		this.regist_date = regist_date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getClubNum() {
		return clubNum;
	}
	public void setClubNum(int clubNum) {
		this.clubNum = clubNum;
	}
	
	
		
	
}