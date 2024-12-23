package com.springmvc.domain;

import java.time.LocalDateTime;

public class clubcalendar {
    private int calendarNum;
    private String clubname;
    private String title;
    private String start;
    private String end;
    private String description;

    public clubcalendar() {}

    public int getCalendarNum() {
        return calendarNum;
    }
    public void setCalendarNum(int calendarNum) {
        this.calendarNum = calendarNum;
    }
    public String getClubname() {
		return clubname;
	}

	public void setClubname(String clubname) {
		this.clubname = clubname;
	}

	public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
