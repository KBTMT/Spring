package com.service.spring.domain;

public class TmtUser {
	private String generalId;
	private String userName;
	private String userNickname;
	private String password;
	private String email;
	private String birthDate;
	private int job;
	private int consumptionCat1;
	private int consumptionCat2;
	private int consumptionCat3;
	private int financeCat;
	private int tmtUserFlag;
	private int salary;
	private int saving;
	
	public TmtUser() {}
	
	
	

	
	public TmtUser(String generalId, String userName, String userNickname, String password, String email,
			String birthDate, int job, int consumptionCat1, int financeCat) {
		super();
		this.generalId = generalId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.job = job;
		this.consumptionCat1 = consumptionCat1;
		this.consumptionCat2 = 0;
		this.consumptionCat3 = 0;
		this.financeCat = financeCat;
		this.saving = 0;
	}





	// 소비습관 2,3 없는거
	public TmtUser(String generalId, String userName, String userNickname, String password, String email,
			String birthDate, int job, int consumptionCat1, int financeCat, int salary, int saving) {
		super();
		this.generalId = generalId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.job = job;
		this.consumptionCat1 = consumptionCat1;
		this.consumptionCat2 = 0;
		this.consumptionCat3 = 0;
		this.financeCat = financeCat;
		this.tmtUserFlag = 0;
		this.salary = salary;
		this.saving = saving;
	}
	
	public TmtUser(String generalId, String userName, String userNickname, String password, String email,
			String birthDate, int job, int consumptionCat1, int financeCat, int salary, int saving, int tmtUserFlag) {
		super();
		this.generalId = generalId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.job = job;
		this.consumptionCat1 = consumptionCat1;
		this.consumptionCat2 = 0;
		this.consumptionCat3 = 0;
		this.financeCat = financeCat;
		this.salary = salary;
		this.saving = saving;
		this.tmtUserFlag = tmtUserFlag;
	}


	// 전부 다 있는거
	public TmtUser(String generalId, String userName, String userNickname, String password, String email,
			String birthDate, int job, int consumptionCat1, int consumptionCat2, int consumptionCat3, int financeCat,
			int tmtUserFlag, int salary, int saving) {
		super();
		this.generalId = generalId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.job = job;
		this.consumptionCat1 = consumptionCat1;
		this.consumptionCat2 = consumptionCat2;
		this.consumptionCat3 = consumptionCat3;
		this.financeCat = financeCat;
		this.tmtUserFlag = tmtUserFlag;
		this.salary = salary;
		this.saving = saving;
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


	public int getTmtUserFlag() {
		return tmtUserFlag;
	}
	
	
	public void setTmtUserFlag(int tmtUserFlag) {
		this.tmtUserFlag = tmtUserFlag;
	}
	
	public int getSalary() {
		return salary;
	}
	
	
	
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	public int getSaving() {
		return saving;
	}
	
	
	
	public void setSaving(int saving) {
		this.saving = saving;
	}


	@Override
	public String toString() {
		return "TmtUser [generalId=" + generalId + ", userName=" + userName + ", userNickname=" + userNickname
				+ ", password=" + password + ", email=" + email + ", birthDate=" + birthDate + ", job=" + job
				+ ", consumptionCat1=" + consumptionCat1 + ", consumptionCat2=" + consumptionCat2 + ", consumptionCat3="
				+ consumptionCat3 + ", financeCat=" + financeCat + ", tmtUserFlag=" + tmtUserFlag + ", salary=" + salary
				+ ", saving=" + saving + "]";
	}



	
	
	
}
