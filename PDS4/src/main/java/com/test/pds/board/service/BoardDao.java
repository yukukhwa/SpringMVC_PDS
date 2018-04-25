package com.test.pds.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired private SqlSessionTemplate sqlSession;  
	
	final private String NAMESPACE = "com.test.pds.board.service.BoardMapper.";
	
	public int insertBoard(Board board) {
		return sqlSession.insert(NAMESPACE+"insertBoard", board);
	}
}
