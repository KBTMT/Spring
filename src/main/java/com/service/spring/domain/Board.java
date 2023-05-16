package com.service.spring.domain;

import java.util.Date;
import java.util.List;

public class Board {
	private long boardSeq;
	private String userNickname;
	private String title;
	private String boardContent;
	private Date boardDate;
	private int boardLike;
	private String generalId;
	private List<BComment> bcomment;
	public Board() {
		super();
	}
	
	public Board(String userNickname, String title, String boardContent, String generalId) {
		super();
		this.userNickname = userNickname;
		this.title = title;
		this.boardContent = boardContent;
		this.generalId = generalId;
	}

	public Board(String userNickname, String title, String content, Date boardDate, int boardLike, String generalId) {
		super();
		this.userNickname = userNickname;
		this.title = title;
		this.boardContent = content;
		this.boardDate = boardDate;
		this.boardLike = boardLike;
		this.generalId = generalId;
	}
	public Board(long boardSeq, String userNickname, String title, String content, Date boardDate, int boardLike,
			String generalId) {
		super();
		this.boardSeq = boardSeq;
		this.userNickname = userNickname;
		this.title = title;
		this.boardContent = content;
		this.boardDate = boardDate;
		this.boardLike = boardLike;
		this.generalId = generalId;
	}

	public long getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(long boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}

	public String getGeneralId() {
		return generalId;
	}

	public void setGeneralId(String generalId) {
		this.generalId = generalId;
	}

	public List<BComment> getBcomment() {
		return bcomment;
	}

	public void setBcomment(List<BComment> bcomment) {
		this.bcomment = bcomment;
	}

	@Override
	public String toString() {
		return "Board [boardSeq=" + boardSeq + ", userNickname=" + userNickname + ", title=" + title + ", boardContent="
				+ boardContent + ", boardDate=" + boardDate + ", boardLike=" + boardLike + ", generalId=" + generalId
				+ ", bcomment=" + bcomment + "]";
	}

	
	
	
}
