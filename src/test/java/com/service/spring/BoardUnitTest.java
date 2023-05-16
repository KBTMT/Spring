package com.service.spring;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.BComment;
import com.service.spring.domain.Board;

import java.io.Reader;

public class BoardUnitTest {
	public static void main(String[] args) throws Exception {

		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		final String MAPPER = "sql.tmt.mapper.";

		BComment vo = new BComment(1, "닉네임4", "저도 이렇게 저축해봐야겟어요 ㅎㅎ ^^");
		System.out.println("BComment Unit test\n");
//		System.out.println("insert : " + session.insert(MAPPER + "insertBComment", vo));
//		session.commit();

//		vo.setBcommentContent("대박 저축 방법 대박 구려요");
//		System.out.println("update : " + session.update(MAPPER + "updateBComment", vo));
//		session.commit();
//		System.out.println("delete : " + session.delete(MAPPER + "deleteBComment", (long) 4));
//		session.commit();
		

//		System.out.println("select : boardSeq");
//		System.out.println("selectOne : " + session.selectOne(MAPPER+"getBoard", (long) 10));
		System.out.println("selectAll");
		for(Object b : session.selectList(MAPPER+"getAllBoard"))
			System.out.println(b);
//		System.out.println("select : generalId");
//		for(Object b : session.selectList(MAPPER+"getBoardbyGeneralId","generalid1"))
//			System.out.println(b);

	}
}
