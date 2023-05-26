package com.service.spring.model.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.model.AnalysisDAO;

@Repository
public class AnalysisDAOImpl implements AnalysisDAO {
	@Autowired
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "sql.tmt.mapper.analysis.";

	@Override
	public List<Map<String, Object>> getAnalysisByCat(String generaId) throws Exception {
		return sqlSession.selectList(MAPPER_NAME + "getAnalysisByCat", generaId);
	}

	@Override
	public List<Map<String, Object>> getMaxCat(String generaId) throws Exception {
		return sqlSession.selectList(MAPPER_NAME + "getMaxCat", generaId);
	}

	@Override
	public List<Map<String, Object>> getAnalysisByHour(String generaId) throws Exception {
		return sqlSession.selectList(MAPPER_NAME + "getAnalysisByHour", generaId);
	}

	@Override
	public List<Map<String, Object>> sumConsumption(String generaId) throws Exception {
		return sqlSession.selectList(MAPPER_NAME + "sumConsumption", generaId);
	}

	@Override
	public List<Map<String, Object>> sumIncome(String month) throws Exception {
		return sqlSession.selectList(MAPPER_NAME + "sumIncome", month);
	}

}
