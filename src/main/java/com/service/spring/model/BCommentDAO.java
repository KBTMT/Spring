package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.BComment;

public interface BCommentDAO {
	int insertBComment(BComment pvo) throws Exception;

	List<BComment> getBComment() throws Exception;

	List<BComment> getBComment(long boardSeq) throws Exception;

	int updateBComment(BComment pvo) throws Exception;

	int deleteBComment(long commentSeq) throws Exception;
}
