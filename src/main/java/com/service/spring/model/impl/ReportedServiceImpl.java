package com.service.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Reported;
import com.service.spring.model.AccountBookDAO;
import com.service.spring.model.ReportedDAO;
import com.service.spring.model.ReportedService;

@Service
public class ReportedServiceImpl implements ReportedService{
	
	@Autowired
	private ReportedDAO reportedDAO;
	
	@Autowired
	private AccountBookDAO accountBookDAO;

	@Override
	public int registerReported(Reported reported) throws Exception {
		return reportedDAO.registerReported(reported);
	}

	@Override
	public int updateReported(Reported reported) throws Exception {
		return reportedDAO.updateReported(reported);
	}

	@Override
	public List<Reported> getReported() throws Exception {
		return reportedDAO.getReported();
	}

	@Override
	public int deleteReported(Reported reported) throws Exception {
		return reportedDAO.deleteReported(reported);
	}


	@Override
	public Reported getReportOne(Reported reported) throws Exception {
		return reportedDAO.getReportOne(reported);
	}

	@Override
	public List<Reported> getReportDetailUsingStatus(int status) throws Exception {
		return reportedDAO.getReportDetailUsingStatus(status);
	}

	@Override
	public List<Reported> getReportDetailUsingFlag(int reportedFlag) throws Exception {
		return reportedDAO.getReportDetailUsingFlag(reportedFlag);
	}
	
}
