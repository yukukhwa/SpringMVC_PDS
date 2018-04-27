package com.test.pds.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired private SqlSessionTemplate sqlSession;  
	
	final private String NAMESPACE = "com.test.pds.board.service.BoardMapper.";
	
	public Board selectBoardone(int boardId) {
		return sqlSession.selectOne(NAMESPACE+"selectBoardOne", boardId);
	}
	
	public List<Board> selectBoardList() {
		return sqlSession.selectList(NAMESPACE+"selectBoardList");
	}
	public int insertBoard(Board board) {
		return sqlSession.insert(NAMESPACE+"insertBoard", board);
	}
}
