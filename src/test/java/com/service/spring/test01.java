package com.service.spring;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.AccountBook;
import com.service.spring.domain.DiscountCalendar;
import com.service.spring.model.DiscountCalendarDAO;

public class test01 {

	public static void main(String[] args) throws Exception {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

		SqlSession session = factory.openSession();
		System.out.println("SqlSession Creating...");
		
		
//		DiscountCalendar discountCalendar = new DiscountCalendar("2023-05-10", "2023-05-15", "올리브영", "ㅁㄴㅇㄻㄴㅇㄹ", "www.naver.com", 200, "쇼핑");
//		session.insert("sql.tmt.mapper.cha.registerGeneralDiscountCalendar", discountCalendar);
		System.out.println("aabcd");

//	    DiscountCalendar discountCalendar4 = new DiscountCalendar(startdate, enddate, "민혁아카데미", "ㅁㄴㅇㄻㄴㅇㄹ", "www.naver.com", 200, "쇼핑");
//	    session.insert("sql.tmt.mapper.cha.registerBusinessDiscountCalender", discountCalendar4);
//	    
		DiscountCalendar discountCalendar = new DiscountCalendar(6L,"2023-05-10", "2023-05-15", "버거7킹", "ㅁㄴㅇㄻㄴㅇㄹ", "www.naver.com", 200, "음식");
		session.update("sql.tmt.mapper.cha.updateDiscountCalendar", discountCalendar);
//	    
//	    DiscountCalendar discountCalendar3 = new DiscountCalendar(startdate, enddate, "맥도날드", "ㅁㄴㅇㄻㄴㅇㄹ", "www.naver.com", 200, "음식");
//	    session.insert("sql.tmt.mapper.cha.updateBusinessDiscountCalender", discountCalendar3);
//	    
	    
		//session.delete("sql.tmt.mapper.cha.deleteDiscountCalendar", 23L);
//	    
//		session.selectList("sql.tmt.mapper.cha.getDiscountCalendar", discountCalendar);
		
		List<DiscountCalendar> list = session.selectList("sql.tmt.mapper.cha.getDiscountCalendar");
		for(DiscountCalendar cat : list) {
			System.out.println("asdfasdf==================");
			System.out.println(cat);
		}
		
		List<AccountBook> list3 = session.selectList("sql.tmt.mapper.cha.dailyAccountBook", "23/05/31");
		for (AccountBook ab : list3) {
			System.out.println("==================");
		    System.out.println(ab);
		}
//
		
		
//		AccountBook accountBook = new AccountBook("efg", "qwerqwer", "20230531 18:30", 2100L, "배불러", 33L, 1L, 2L);
//		session.insert("sql.tmt.mapper.cha.registerAccountBook", accountBook);
		session.commit();
//	
//		
////		
//		
//		session.delete("sql.tmt.mapper.cha.deleteAccountBook", 20L);
		
		List<AccountBook> list2 = session.selectList("sql.tmt.mapper.cha.getAccountBook", "efg");
		for(AccountBook ac : list2) {
			System.out.println("asdfasdf==================");
			System.out.println(ac);
		}
		
		
		session.commit();
		session.close();
	}

}
