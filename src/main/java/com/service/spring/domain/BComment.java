package com.service.spring.domain;

import java.util.Date;

public class BComment {
	private long commentSeq;
	private String userNickname;
	private String bcommentContent;
	private Date commentDate;
	private int cDepth;
	private int cGroup;
	private long boardSeq;

	public BComment(long commentSeq, String userNickname, int cDepth, int cGroup, long boardSeq) {
		super();
		this.commentSeq = commentSeq;
		this.userNickname = userNickname;
		this.cDepth = cDepth;
		this.cGroup = cGroup;
		this.boardSeq = boardSeq;
	}
	// 댓글 
	public BComment(long boardSeq, String userNickname, String bcommentContent) {
		super();
		this.boardSeq = boardSeq;
		this.userNickname = userNickname;
		this.bcommentContent = bcommentContent;
	}
	// 대댓글
	public BComment(long boardSeq, String userNickname, String bcommentContent, int cGroup) {
		super();
		this.boardSeq = boardSeq;
		this.userNickname = userNickname;
		this.bcommentContent = bcommentContent;
		this.cGroup = cGroup;
	}

	public BComment(long commentSeq, String userNickname, String content, Date commentDate, int cDepth, int cGroup) {
		super();
		this.commentSeq = commentSeq;
		this.userNickname = userNickname;
		this.bcommentContent = content;
		this.commentDate = commentDate;
		this.cDepth = cDepth;
		this.cGroup = cGroup;
	}
	
	public BComment(long commentSeq, String userNickname, String bcommentContent, Date commentDate, int cDepth,
			int cGroup, long boardSeq) {
		super();
		this.commentSeq = commentSeq;
		this.userNickname = userNickname;
		this.bcommentContent = bcommentContent;
		this.commentDate = commentDate;
		this.cDepth = cDepth;
		this.cGroup = cGroup;
		this.boardSeq = boardSeq;
	}
	public long getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(long commentSeq) {
		this.commentSeq = commentSeq;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getBcommentContent() {
		return bcommentContent;
	}
	public void setBcommentContent(String bcommentContent) {
		this.bcommentContent = bcommentContent;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getcDepth() {
		return cDepth;
	}
	public void setcDepth(int cDepth) {
		this.cDepth = cDepth;
	}
	public int getcGroup() {
		return cGroup;
	}
	public void setcGroup(int cGroup) {
		this.cGroup = cGroup;
	}
	public long getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(long boardSeq) {
		this.boardSeq = boardSeq;
	}
	@Override
	public String toString() {
		return "BComment [commentSeq=" + commentSeq + ", userNickname=" + userNickname + ", bcommentContent="
				+ bcommentContent + ", commentDate=" + commentDate + ", cDepth=" + cDepth + ", cGroup=" + cGroup
				+ ", boardSeq=" + boardSeq + "]";
	}

	

}
