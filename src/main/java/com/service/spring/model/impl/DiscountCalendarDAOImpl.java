package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.DiscountCalendar;
import com.service.spring.model.DiscountCalendarDAO;

@Repository
public class DiscountCalendarDAOImpl implements DiscountCalendarDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	public static final String MAPPER_NAME = "sql.tmt.mapper.cha.";
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<DiscountCalendar> getDiscountCalendar() throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"getDiscountCalendar");
		
	}

	@Override
	public int registerGeneralDiscountCalendar(DiscountCalendar discountcalendar) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME+"registerGeneralDiscountCalendar", discountcalendar);
		sqlSession.commit();
		return result;
	}

	@Override
	public int registerBusinessDiscountCalendar(DiscountCalendar discountcalendar) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME+"registerBusinessDiscountCalendar", discountcalendar);
		sqlSession.commit();
		return result;
	}

	@Override
	public int discountCalendarWarn(Long discountSeq) throws Exception {
		return 0;
	}

	@Override
	public int deleteDiscountCalendar(Long discountSeq) throws Exception {
		return sqlSession.delete(MAPPER_NAME+"deleteDiscountCalendar", discountSeq);
	}


	@Override
	public int updateBusinessDiscountCalendar(DiscountCalendar discountcalendar) throws Exception {
		return sqlSession.insert(MAPPER_NAME+"updateBusinessDiscountCalendar", discountcalendar);
	}

	@Override
	public int updateDiscountCalendar(DiscountCalendar discountcalendar) throws Exception {
		return 0;
	}

//	@Override
//	public List<DiscountCalendar> getAllDiscountCalenderAdmin(DiscountCalendar discountcalendar) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int getDetailDiscountCalenderAdmin(DiscountCalendar discountcalendar) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
