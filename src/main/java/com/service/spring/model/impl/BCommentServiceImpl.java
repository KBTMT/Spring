package com.service.spring.model.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.BComment;
import com.service.spring.domain.Board;
import com.service.spring.model.BCommentDAO;
import com.service.spring.model.BCommentService;
import com.service.spring.model.BoardDAO;
import com.service.spring.model.BoardService;

@Service
public class BCommentServiceImpl implements BCommentService{
 
	@Autowired
	private BCommentDAO bCommentDAO;

	@Override
	public int insertBComment(BComment pvo) throws Exception {
		return bCommentDAO.insertBComment(pvo);
	}

	@Override
	public List<BComment> getBComment() throws Exception {
		return bCommentDAO.getBComment();
	}

	@Override
	public List<BComment> getBComment(long boardSeq) throws Exception {
		return bCommentDAO.getBComment(boardSeq);
	}

	@Override
	public int updateBComment(BComment pvo) throws Exception {
		return bCommentDAO.updateBComment(pvo);
	}

	@Override
	public int deleteBComment(long commentSeq) throws Exception {
		return bCommentDAO.deleteBComment(commentSeq);
	}

	@Override
	public BComment getBCommentbySeq(long commentSeq) throws Exception {
		return bCommentDAO.getBCommentbySeq(commentSeq);
	}


	
}
