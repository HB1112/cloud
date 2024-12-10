package com.springmvc.domain;

import java.util.Date;

public class ClubPost 
{
    private int postId;         
    private String clubName;     
    private String description;   
    private String category;     
    private String location;     
    private String authorId;      
    private String authorName;  
    private Date createdDate;
    
    
    public ClubPost() {}
    
	public ClubPost(int postId, String clubName, String description, String category, String location, String authorId,
			String authorName, Date createdDate) {
		
		this.postId = postId;
		this.clubName = clubName;
		this.description = description;
		this.category = category;
		this.location = location;
		this.authorId = authorId;
		this.authorName = authorName;
		this.createdDate = createdDate;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}   
    
    
    
}
