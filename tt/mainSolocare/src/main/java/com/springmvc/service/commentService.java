package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.comment;

public interface commentService {

	void saveComment(comment comment);

	List<comment> getCommentsByBoardNum(int boardNum);

	comment getCommentById(int commentnum);

	void updateComment(comment existingComment);

	void deleteComment(int commentnum);

}
