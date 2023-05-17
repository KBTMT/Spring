package com.service.spring.domain;

import java.util.Date;

public class AccountTransaction {
	private long accountSeq;
	private long money;
	private long flag;
	private String transaction_date;
	private String time;
	private String content;
	
	public AccountTransaction(long accountSeq, long money, long flag, String transaction_date, String time,
			String content) {
		super();
		this.accountSeq = accountSeq;
		this.money = money;
		this.flag = flag;
		this.transaction_date = transaction_date;
		this.time = time;
		this.content = content;
	}
	
	public AccountTransaction(long money, long flag, String transaction_date, String time,
			String content) {
		super();
		this.money = money;
		this.flag = flag;
		this.transaction_date = transaction_date;
		this.time = time;
		this.content = content;
	}
	
	public long getAccountSeq() {
		return accountSeq;
	}
	public void setAccountSeq(long accountSeq) {
		this.accountSeq = accountSeq;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public long getFlag() {
		return flag;
	}
	public void setFlag(long flag) {
		this.flag = flag;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "AccountTransaction [accountSeq=" + accountSeq + ", money=" + money + ", flag=" + flag
				+ ", transaction_date=" + transaction_date + ", time=" + time + ", content=" + content + "]";
	}

	

}
