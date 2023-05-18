package com.service.spring.domain;

public class BusinessInfo {
	private String generalId;
	private String businessNum;
	private String tradeName;
	private String location;
	private int status;
	
	public BusinessInfo() {}
	
	
	
	public BusinessInfo(String generalId, String businessNum, String tradeName, String location) {
		super();
		this.generalId = generalId;
		this.businessNum = businessNum;
		this.tradeName = tradeName;
		this.location = location;
	}



	public BusinessInfo(String generalId, String businessNum, String tradeName, String location, int status) {
		super();
		this.generalId = generalId;
		this.businessNum = businessNum;
		this.tradeName = tradeName;
		this.location = location;
		this.status = status;
	}

	public String getGeneralId() {
		return generalId;
	}

	public void setGeneralId(String generalId) {
		this.generalId = generalId;
	}

	public String getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BusinessInfo [generalId=" + generalId + ", businessNum=" + businessNum + ", tradeName=" + tradeName
				+ ", location=" + location + ", status=" + status + "]";
	}
	
	
	
}
