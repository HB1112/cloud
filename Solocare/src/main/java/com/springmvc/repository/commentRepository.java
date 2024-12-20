package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.comment;

public interface commentRepository {

	void saveComment(comment comment);

	List<comment> getCommentsByBoardNum(int boardNum);

	comment getCommentById(int commentnum);

	void updateComment(comment existingComment);

	void deleteComment(int commentnum);
	
}
