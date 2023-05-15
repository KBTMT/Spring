package com.service.spring.model.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Board;
import com.service.spring.model.BoardDAO;
import com.service.spring.model.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
 
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public int insertBoard(Board pvo) throws Exception {
		return boardDAO.insertBoard(pvo);
	}

	@Override
	public Board getBoard(long boardSeq) throws Exception {
		return boardDAO.getBoard(boardSeq);
	}

	@Override
	public List<Board> getBoard() throws Exception {
		return boardDAO.getBoard();
	}

	@Override
	public List<Board> getBoard(String generalId) throws Exception {
		return boardDAO.getBoard(generalId);
	}

	@Override
	public List<Board> getBoard(Date startDate, Date endDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(Board pvo) throws Exception {
		return boardDAO.updateBoard(pvo);
	}

	@Override
	public int deleteBoard(long boardSeq) throws Exception {
		return boardDAO.deleteBoard(boardSeq);
	}


}
