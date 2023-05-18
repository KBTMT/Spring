package com.service.spring.domain;

public class Reported {
	private long reportedSeq;
	private long status;
	private long reportedFlag;

	public Reported() {
		super();
	}

	public Reported(long status, long reportedFlag) {
		super();
		this.status = status;
		this.reportedFlag = reportedFlag;
	}

	public Reported(long reportedSeq, long status, long reportedFlag) {
		super();
		this.reportedSeq = reportedSeq;
		this.status = status;
		this.reportedFlag = reportedFlag;
	}

	public long getReportedSeq() {
		return reportedSeq;
	}

	public long getStatus() {
		return status;
	}

	public void setReportedSeq(long reportedSeq) {
		this.reportedSeq = reportedSeq;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getReportedFlag() {
		return reportedFlag;
	}

	public void setReportedFlag(long reportedFlag) {
		this.reportedFlag = reportedFlag;
	}

	@Override
	public String toString() {
		return "Reported [reportedSeq=" + reportedSeq + ", status=" + status + ", reportedFlag=" + reportedFlag + "]";
	}

}
