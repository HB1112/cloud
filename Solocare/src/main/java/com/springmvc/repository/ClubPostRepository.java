package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.ClubPost;

public interface ClubPostRepository 
{
	void save(ClubPost post);
	List<ClubPost> findAll(int page, int size);
	int count();
}
