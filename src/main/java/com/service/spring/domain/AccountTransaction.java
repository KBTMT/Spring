package com.service.spring.domain;

public class AccountTransaction {
	
	private String accountNumber;
	private long money;
	private long accountTransactionFlag;
	private String transactionDate;
	private String accountTransactionContent;
	
	public AccountTransaction() {}

	public AccountTransaction(String accountNumber, long money, long accountTransactionFlag, String transactionDate,
			String accountTransactionContent) {
		super();
		this.accountNumber = accountNumber;
		this.money = money;
		this.accountTransactionFlag = accountTransactionFlag;
		this.transactionDate = transactionDate;
		this.accountTransactionContent = accountTransactionContent;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public long getAccountTransactionFlag() {
		return accountTransactionFlag;
	}

	public void setAccountTransactionFlag(long accountTransactionFlag) {
		this.accountTransactionFlag = accountTransactionFlag;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getAccountTransactionContent() {
		return accountTransactionContent;
	}

	public void setAccountTransactionContent(String accountTransactionContent) {
		this.accountTransactionContent = accountTransactionContent;
	}

	@Override
	public String toString() {
		return "AccountTransaction [accountNumber=" + accountNumber + ", money=" + money + ", accountTransactionFlag="
				+ accountTransactionFlag + ", transactionDate=" + transactionDate + ", accountTransactionContent="
				+ accountTransactionContent + "]";
	}
	
}



