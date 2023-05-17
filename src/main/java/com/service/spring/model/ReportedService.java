package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Reported;

public interface ReportedService {
	int registerReported(Reported reported) throws Exception;
	
	int updateReported(Reported reported) throws Exception; // 1:  처리 완료 (삭제 안한 글은 처리 완료 상태) (바로 삭제) 분류 구분 flag 0: 할인 달력 1 : 게시판 글 2: 댓글
	
	List<Reported> getReported() throws Exception;
	
	int deleteReported(Reported reported) throws Exception;
}
