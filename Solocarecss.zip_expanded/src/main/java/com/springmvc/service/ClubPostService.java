package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.ClubPost;

public interface ClubPostService 
{
	void createPost(ClubPost post);
	List<ClubPost> getAllPosts(int page, int size);
	int getTotalPostCount();
}
