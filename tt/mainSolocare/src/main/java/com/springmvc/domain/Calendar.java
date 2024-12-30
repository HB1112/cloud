package com.springmvc.domain;

import java.time.LocalDateTime;

public class Calendar {
    private int calendarNum; // INT로 변경
    private String userId; // userId 추가
    private String title;
    private String start; // LocalDateTime으로 변경
    private String end; // LocalDateTime으로 변경
    private String description;

    public Calendar() {}

    public int getCalendarNum() {
        return calendarNum;
    }
    public void setCalendarNum(int calendarNum) {
        this.calendarNum = calendarNum;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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
