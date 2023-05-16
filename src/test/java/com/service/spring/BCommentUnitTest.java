package com.service.spring;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.BComment;
import com.service.spring.domain.Board;

public class BCommentUnitTest {
	public static void main(String[] args) throws Exception {

		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		final String MAPPER = "sql.tmt.mapper.";

		
		// 일반댓글 : boardSeq, userNickname, bcommentContent
		BComment vo = new BComment(1, "testnick2", "댓글댓글댓글2");

		System.out.println("BComment Unit test\n");
		System.out.println("===============댓글 테스트 =============");
//		System.out.println("1. 댓글 작성");
//		System.out.println("insert : " + session.insert(MAPPER + "insertBComment", vo));
//		session.commit();
//		System.out.println("2. 댓글 수정");
//		vo.setBcommentContent("댓글 수정수정");
//		vo.setCommentSeq(8);
//		System.out.println("update : " + session.update(MAPPER + "updateBComment", vo));
//		session.commit();

//		System.out.println("3. 댓글 삭제");
//		System.out.println("delete : " + session.update(MAPPER + "deleteBComment", (long) 3));
//		session.commit();

		System.out.println("1-2. 대댓글 작성");
		// 대댓글 : boardSeq, userNickname, bcommentContent, cgroup
//		BComment vo2 = new BComment(4, "대댓글닉네임", "대댓글 달기", 6);
//		System.out.println("insertBCommentDepth: " + session.insert(MAPPER + "insertBCommentDepth", vo2));
//		session.commit();
		
		System.out.println("4. 게시판 별 댓글 조회");
		for(Object c : session.selectList(MAPPER+"getComments",(long) 1))
			System.out.println(c);
//		for(Object c : session.selectList(MAPPER+"getALLComment"))
//			System.out.println(c);
	}
}
