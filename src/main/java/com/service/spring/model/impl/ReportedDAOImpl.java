package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Reported;
import com.service.spring.model.ReportedDAO;

@Repository
public class ReportedDAOImpl implements ReportedDAO{
	
	@Autowired
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "tmt_query_cha.";
	
	@Autowired
	private BoardDAO boardDAO;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int registerReported(Reported reported) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(MAPPER_NAME+"registerReported", reported);
	}

	@Override
	public int updateReported(Reported reported) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(MAPPER_NAME+"updateReported", reported);
	}

	@Override
	public List<Reported> getReported() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(MAPPER_NAME+"getReported");
	}
	
	@Override
	public int deleteReported(Reported reported) throws Exception {
		if(reported.getFlag() == 1) {
			boardDAO.deleteBoard(reported.getReportedSeq());
			return 1;
		}
	}
	
}
