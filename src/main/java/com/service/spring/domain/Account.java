package com.service.spring.domain;

public class Account {
	private long accountSeq;
	private String accountNumber;
	private String bank;
	private long balance;
	private long general_id;
	
	public Account(long accountSeq, String accountNumber, String bank, long balance, long general_id) {
		super();
		this.accountSeq = accountSeq;
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.balance = balance;
		this.general_id = general_id;
	}
	
	public Account(String accountNumber, String bank, long balance, long general_id) {
		super();
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.balance = balance;
		this.general_id = general_id;
	}
	
	public long getAccountSeq() {
		return accountSeq;
	}
	public void setAccountSeq(long accountSeq) {
		this.accountSeq = accountSeq;
	}
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
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getGeneral_id() {
		return general_id;
	}
	public void setGeneral_id(long general_id) {
		this.general_id = general_id;
	}

	@Override
	public String toString() {
		return "Account [accountSeq=" + accountSeq + ", accountNumber=" + accountNumber + ", bank=" + bank
				+ ", balance=" + balance + ", general_id=" + general_id + "]";
	}

	

}
