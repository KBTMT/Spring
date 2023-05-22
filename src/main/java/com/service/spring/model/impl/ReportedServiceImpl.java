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
//		if(reported.getFlag() == 1) {
//			boardDAO.deleteBoard(reported.getReportedSeq());
//			return 1;
//		}
		return 1;
	}

	@Override
	public Reported getReportDetail(Reported reported) throws Exception {
		return reportedDAO.getReportDetail(reported);
	}
	
}
