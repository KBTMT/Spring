package com.service.spring.domain;

public class DCMypick {
	private long  discountSeq;
	private int mypickFlag;
	private int score;
	private String review;
	private String generalId;
	
	public long getDiscountSeq() {
		return discountSeq;
	}
	public void setDiscountSeq(long discountSeq) {
		this.discountSeq = discountSeq;
	}
	public int getMypickFlag() {
		return mypickFlag;
	}
	public void setMypickFlag(int mypickFlag) {
		this.mypickFlag = mypickFlag;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getGeneralId() {
		return generalId;
	}
	public void setGeneralId(String generalId) {
		this.generalId = generalId;
	}
	
	public DCMypick() {
	}
	
	public DCMypick(long discountSeq, String generalId) {
		super();
		this.discountSeq = discountSeq;
		this.generalId = generalId;
	}
	public DCMypick(long discountSeq, int mypickFlag, int score, String review, String generalId) {
		super();
		this.discountSeq = discountSeq;
		this.mypickFlag = mypickFlag;
		this.score = score;
		this.review = review;
		this.generalId = generalId;
	}
	@Override
	public String toString() {
		return "DCMypick [discountSeq=" + discountSeq + ", mypickFlag=" + mypickFlag + ", score=" + score + ", review="
				+ review + ", generalId=" + generalId + "]";
	}
	
}
