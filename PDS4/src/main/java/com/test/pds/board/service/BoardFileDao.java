package com.test.pds.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDao {
	@Autowired private SqlSessionTemplate sqlSession;
	
	final private String NAMESPACE = "com.test.pds.board.service.BoardFileMapper.";
	
	public int insertBoardFile(BoardFile boardFile) {
		return sqlSession.insert(NAMESPACE+"insertBoardFile", boardFile);
	}
}
