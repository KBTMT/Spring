package com.service.spring.domain;

public class Reported {
	private long targetSeq;
	private int status;
	private int reportedFlag;

	public Reported() {}

	public Reported(long targetSeq, int status, int reportedFlag) {
		super();
		this.targetSeq = targetSeq;
		this.status = status;
		this.reportedFlag = reportedFlag;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getReportedFlag() {
		return reportedFlag;
	}

	public void setReportedFlag(int reportedFlag) {
		this.reportedFlag = reportedFlag;
	}

	public long getTargetSeq() {
		return targetSeq;
	}

	public void setTargetSeq(long targetSeq) {
		this.targetSeq = targetSeq;
	}

	@Override
	public String toString() {
		return "Reported [targetSeq=" + targetSeq + ", status=" + status + ", reportedFlag=" + reportedFlag + "]";
	}


}
