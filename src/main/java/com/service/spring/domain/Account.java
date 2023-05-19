package com.service.spring.domain;

public class Account {
	private String accountNumber;
	private String bank;
	private String accessToken;
	private String userSeqNo;
	private String generalId;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getUserSeqNo() {
		return userSeqNo;
	}
	public void setUserSeqNo(String userSeqNo) {
		this.userSeqNo = userSeqNo;
	}
	public String getGeneralId() {
		return generalId;
	}
	public void setGeneralId(String generalId) {
		this.generalId = generalId;
	}
	public Account() {
	}
	public Account(String accountNumber, String bank, String accessToken, String userSeqNo, String generalId) {
		super();
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.accessToken = accessToken;
		this.userSeqNo = userSeqNo;
		this.generalId = generalId;
	}
	
	public Account(String accountNumber, String bank, String accessToken, String userSeqNo) {
		super();
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.accessToken = accessToken;
		this.userSeqNo = userSeqNo;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", bank=" + bank + ", accessToken=" + accessToken
				+ ", userSeqNo=" + userSeqNo + ", generalId=" + generalId + "]";
	}
	
	
}
