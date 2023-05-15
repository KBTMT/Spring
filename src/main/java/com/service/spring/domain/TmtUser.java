package com.service.spring.domain;

public class TmtUser {
	private String generalId;
	private String userName;
	private String userNickname;
	private String password;
	private String email;
	private String certType;
	private String birthDate;
	private int job;
	private int consumptionCat1;
	private int consumptionCat2;
	private int consumptionCat3;
	private int financeCat;
	private int flag;
	
	public TmtUser() {}
	
	
	

	public TmtUser(String generalId, String userName, String userNickname, String password, String email, String certType,
			String birthDate, int job, int flag) {
		super();
		this.generalId = generalId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.password = password;
		this.email = email;
		this.certType = certType;
		this.birthDate = birthDate;
		this.job = job;
		this.consumptionCat1 = 0;
		this.consumptionCat2 = 0;
		this.consumptionCat3 = 0;
		this.financeCat = 0;
		
		this.flag = flag;
	}




	public TmtUser(String generalId, String userName, String userNickname, String password, String email, String certType,
			String birthDate, int job, int consumptionCat1, int consumptionCat2, int consumptionCat3, int financeCat,
			int flag) {
		super();
		this.generalId = generalId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.password = password;
		this.email = email;
		this.certType = certType;
		this.birthDate = birthDate;
		this.job = job;
		this.consumptionCat1 = consumptionCat1;
		this.consumptionCat2 = consumptionCat2;
		this.consumptionCat3 = consumptionCat3;
		this.financeCat = financeCat;
		this.flag = flag;
	}


	public String getGeneralId() {
		return generalId;
	}


	public void setGeneralId(String generalId) {
		this.generalId = generalId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserNickname() {
		return userNickname;
	}


	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCertType() {
		return certType;
	}


	public void setCertType(String certType) {
		this.certType = certType;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public int getJob() {
		return job;
	}


	public void setJob(int job) {
		this.job = job;
	}


	public int getConsumptionCat1() {
		return consumptionCat1;
	}


	public void setConsumptionCat1(int consumptionCat1) {
		this.consumptionCat1 = consumptionCat1;
	}


	public int getConsumptionCat2() {
		return consumptionCat2;
	}


	public void setConsumptionCat2(int consumptionCat2) {
		this.consumptionCat2 = consumptionCat2;
	}


	public int getConsumptionCat3() {
		return consumptionCat3;
	}


	public void setConsumptionCat3(int consumptionCat3) {
		this.consumptionCat3 = consumptionCat3;
	}


	public int getFinanceCat() {
		return financeCat;
	}


	public void setFinanceCat(int financeCat) {
		this.financeCat = financeCat;
	}


	public int getFlag() {
		return flag;
	}


	public void setFlag(int flag) {
		this.flag = flag;
	}


	@Override
	public String toString() {
		return "TmtUser [generalId=" + generalId + ", userName=" + userName + ", userNickname=" + userNickname
				+ ", password=" + password + ", email=" + email + ", certType=" + certType + ", birthDate=" + birthDate
				+ ", job=" + job + ", consumptionCat1=" + consumptionCat1 + ", consumptionCat2=" + consumptionCat2
				+ ", consumptionCat3=" + consumptionCat3 + ", financeCat=" + financeCat + ", flag=" + flag + "]";
	}
	
	
	
}
