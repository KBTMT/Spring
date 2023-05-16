package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.DiscountCalendar;
import com.service.spring.model.DiscountCalendarDAO;
import com.service.spring.model.DiscountCalendarService;



@Service
public class DiscountCalendarServiceImpl implements DiscountCalendarService {
	
	@Autowired
	private DiscountCalendarDAO discountCalendarDAO;

	@Override
	public List<DiscountCalendar> getDiscountCalendar() throws Exception {
		// TODO Auto-generated method stub
		return discountCalendarDAO.getDiscountCalendar();
	}

	@Override
	public int registerGeneralDiscountCalendar(DiscountCalendar discountcalendar) throws Exception {
		// TODO Auto-generated method stub
		return discountCalendarDAO.registerGeneralDiscountCalendar(discountcalendar);
	}

	@Override
	public int registerBusinessDiscountCalendar(DiscountCalendar discountcalendar) throws Exception {
		// TODO Auto-generated method stub
		return discountCalendarDAO.registerBusinessDiscountCalendar(discountcalendar);
	}

	@Override
	public int updateDiscountCalender(DiscountCalendar discountcalendar) throws Exception {
		// TODO Auto-generated method stub
		return discountCalendarDAO.updateDiscountCalendar(discountcalendar);
	}

	@Override
	public int updateBusinessDiscountCalendar(DiscountCalendar discountcalendar) throws Exception {
		// TODO Auto-generated method stub
		return discountCalendarDAO.updateBusinessDiscountCalendar(discountcalendar);
	}

	@Override
	public int discountCalendarWarn(Long discountSeq) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDiscountCalendar(Long discountSeq) throws Exception {
		// TODO Auto-generated method stub
		return discountCalendarDAO.deleteDiscountCalendar(discountSeq);
	}
}
