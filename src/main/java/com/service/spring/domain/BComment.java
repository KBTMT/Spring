package com.service.spring.domain;

import java.util.Date;

public class BComment implements Comparable<BComment>{
	private long commentSeq;
	private String userNickname;
	private String commentContent;
	private String commentDate;
	private int cDepth;
	private int cGroup;
	private long boardSeq;
	
	public BComment() {}

	public BComment(long commentSeq, String userNickname, int cDepth, int cGroup, long boardSeq) {
		super();
		this.commentSeq = commentSeq;
		this.userNickname = userNickname;
		this.cDepth = cDepth;
		this.cGroup = cGroup;
		this.boardSeq = boardSeq;
	}
	// 댓글 
	public BComment(long boardSeq, String userNickname, String commentContent) {
		super();
		this.boardSeq = boardSeq;
		this.userNickname = userNickname;
		this.commentContent = commentContent;
	}
	// 대댓글
	public BComment(long boardSeq, String userNickname, String commentContent, int cGroup) {
		super();
		this.boardSeq = boardSeq;
		this.userNickname = userNickname;
		this.commentContent = commentContent;
		this.cGroup = cGroup;
	}

	public BComment(long commentSeq, String userNickname, String commentContent, String commentDate, int cDepth, int cGroup) {
		super();
		this.commentSeq = commentSeq;
		this.userNickname = userNickname;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.cDepth = cDepth;
		this.cGroup = cGroup;
	}
	
	public BComment(long commentSeq, String userNickname, String commentContent, String commentDate, int cDepth,
			int cGroup, long boardSeq) {
		super();
		this.commentSeq = commentSeq;
		this.userNickname = userNickname;
		this.commentContent = commentContent;
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
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
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
		return "BComment [commentSeq=" + commentSeq + ", userNickname=" + userNickname + ", commentContent="
				+ commentContent + ", commentDate=" + commentDate + ", cDepth=" + cDepth + ", cGroup=" + cGroup
				+ ", boardSeq=" + boardSeq + "]";
	}

	@Override
	public int compareTo(BComment o) {
		return (int) (this.commentSeq - o.commentSeq);
	}

	

}
