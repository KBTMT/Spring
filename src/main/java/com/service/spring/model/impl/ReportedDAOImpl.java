package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Reported;
import com.service.spring.model.BoardDAO;
import com.service.spring.model.ReportedDAO;

@Repository
public class ReportedDAOImpl implements ReportedDAO{
	
	public static final String MAPPER_NAME = "sql.tmt.mapper.cha.";
	
	@Autowired
	private SqlSession sqlSession;
	
	

	@Override
	public int registerReported(Reported reported) throws Exception {
		return sqlSession.insert(MAPPER_NAME+"registerReported", reported);
	}

	@Override
	public int updateReported(Reported reported) throws Exception {
		return sqlSession.update(MAPPER_NAME+"updateReported", reported);
	}

	@Override
	public List<Reported> getReported() throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"getReported");
	}
	
	@Override
	public int deleteReported(Reported reported) throws Exception {
		return sqlSession.delete(MAPPER_NAME+"deleteReported", reported);
	}

	@Override
	public Reported getReportOne(Reported reported) throws Exception {
		return sqlSession.selectOne(MAPPER_NAME+"getReportOne", reported);
	}

	@Override
	public List<Reported> getReportDetailUsingStatus(int status) throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"getReportDetailUsingStatus", status);
	}

	@Override
	public List<Reported> getReportDetailUsingFlag(int reportedFlag) throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"getReportDetailUsingFlag", reportedFlag);
	}
	
}
