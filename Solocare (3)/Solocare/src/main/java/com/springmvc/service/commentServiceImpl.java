package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.comment;
import com.springmvc.repository.commentRepository;

@Service
public class commentServiceImpl implements commentService{

	@Autowired
	private commentRepository commentrepository;

	@Override
	public void saveComment(comment comment) {
		commentrepository.saveComment(comment);
	}

	@Override
	public List<comment> getCommentsByBoardNum(int boardNum) {
		
		return commentrepository.getCommentsByBoardNum(boardNum);
	}

	@Override
	public comment getCommentById(int commentnum) {
		
		return commentrepository.getCommentById(commentnum);
	}

	@Override
	public void updateComment(comment existingComment) {
		commentrepository.updateComment(existingComment);
	}

	@Override
	public void deleteComment(int commentnum) {
		commentrepository.deleteComment(commentnum);
		
	}

}
