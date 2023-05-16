package com.service.spring.domain;

import java.util.Date;

public class AccountBook {
	private long accountBookSeq;
	private String generalId;
	private String content;
	private String time;
	private long price;
	private String memo;
	private long discountSeq;
	private long emoji;
	private long consumptionCat;
	
	
	public AccountBook(long accountBookSeq, String generalId, String content, String time, long price, String memo,
			long discountSeq, long emoji, long consumptionCat) {
		super();
		this.accountBookSeq = accountBookSeq;
		this.generalId = generalId;
		this.content = content;
		this.time = time;
		this.price = price;
		this.memo = memo;
		this.discountSeq = discountSeq;
		this.emoji = emoji;
		this.consumptionCat = consumptionCat;
	}
	
	
	public AccountBook(String generalId, String content, String time, long price, String memo, long discountSeq,
			long emoji, long consumptionCat) {
		super();
		this.generalId = generalId;
		this.content = content;
		this.time = time;
		this.price = price;
		this.memo = memo;
		this.discountSeq = discountSeq;
		this.emoji = emoji;
		this.consumptionCat = consumptionCat;
	}


	public long getAccountBookSeq() {
		return accountBookSeq;
	}
	public void setAccountBookSeq(long accountBookSeq) {
		this.accountBookSeq = accountBookSeq;
	}
	public String getGeneralId() {
		return generalId;
	}
	public void setGeneralId(String generalId) {
		this.generalId = generalId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public long getDiscountSeq() {
		return discountSeq;
	}
	public void setDiscountSeq(long discountSeq) {
		this.discountSeq = discountSeq;
	}
	public long getEmoji() {
		return emoji;
	}
	public void setEmoji(long emoji) {
		this.emoji = emoji;
	}
	public long getConsumptionCat() {
		return consumptionCat;
	}
	public void setConsumptionCat(long consumptionCat) {
		this.consumptionCat = consumptionCat;
	}
	public AccountBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AccountBook [accountBookSeq=" + accountBookSeq + ", generalId=" + generalId + ", content=" + content
				+ ", time=" + time + ", price=" + price + ", memo=" + memo + ", discountSeq=" + discountSeq + ", emoji="
				+ emoji + ", consumptionCat=" + consumptionCat + "]";
	}

	

	

}
