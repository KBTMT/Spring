package com.service.spring.model;

import java.util.Date;
import java.util.List;

import com.service.spring.domain.Board;

public interface BoardDAO {
	int insertBoard(Board pvo) throws Exception;

	Board getBoard(long boardSeq) throws Exception;

	List<Board> getBoard() throws Exception;

//	List<Board> getBoard(String userNickname) throws Exception;

	List<Board> getBoard(String generalId) throws Exception;

	List<Board> getBoard(Date startDate, Date endDate) throws Exception;

	int updateBoard(Board pvo) throws Exception;

	int deleteBoard(long boardSeq) throws Exception;
}
