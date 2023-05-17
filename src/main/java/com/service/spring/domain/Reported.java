package com.service.spring.domain;

public class Reported {
	private long reportedSeq;
	private long status;
	private long flag;

	public Reported() {
		super();
	}

	public Reported(long status, long flag) {
		super();
		this.status = status;
		this.flag = flag;
	}

	public Reported(long reportedSeq, long status, long flag) {
		super();
		this.reportedSeq = reportedSeq;
		this.status = status;
		this.flag = flag;
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

	public long getFlag() {
		return flag;
	}

	public void setFlag(long flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Reported [reportedSeq=" + reportedSeq + ", status=" + status + ", flag=" + flag + "]";
	}

}
