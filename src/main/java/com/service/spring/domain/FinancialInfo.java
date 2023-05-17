package com.service.spring.domain;

public class FinancialInfo {
	private long financialSeq;
	private String financeCat;
	private String financialUrl;
	private String financialSummary;
	private String financialKeyword;
	private String financialDate;
	public long getFinancialSeq() {
		return financialSeq;
	}
	public void setFinancialSeq(long financialSeq) {
		this.financialSeq = financialSeq;
	}
	public String getFinanceCat() {
		return financeCat;
	}
	public void setFinanceCat(String financeCat) {
		this.financeCat = financeCat;
	}
	public String getFinancialUrl() {
		return financialUrl;
	}
	public void setFinancialUrl(String financialUrl) {
		this.financialUrl = financialUrl;
	}
	public String getFinancialSummary() {
		return financialSummary;
	}
	public void setFinancialSummary(String financialSummary) {
		this.financialSummary = financialSummary;
	}
	public String getFinancialKeyword() {
		return financialKeyword;
	}
	public void setFinancialKeyword(String financialKeyword) {
		this.financialKeyword = financialKeyword;
	}
	public String getFinancialDate() {
		return financialDate;
	}
	public void setFinancialDate(String financialDate) {
		this.financialDate = financialDate;
	}
	public FinancialInfo() {
		super();
	}
	public FinancialInfo(long financialSeq, String financeCat, String financialUrl, String financialSummary,
			String financialKeyword, String financialDate) {
		super();
		this.financialSeq = financialSeq;
		this.financeCat = financeCat;
		this.financialUrl = financialUrl;
		this.financialSummary = financialSummary;
		this.financialKeyword = financialKeyword;
		this.financialDate = financialDate;
	}
	@Override
	public String toString() {
		return "FinancialInfo [financialSeq=" + financialSeq + ", financeCat=" + financeCat + ", financialUrl="
				+ financialUrl + ", financialSummary=" + financialSummary + ", financialKeyword=" + financialKeyword
				+ ", financialDate=" + financialDate + "]";
	}
	
	
}
