package com.test.pds.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired private SqlSessionTemplate sqlSession;  
	
	final private String NAMESPACE = "com.test.pds.board.service.BoardMapper.";
	
	public int deleteBoard(int boardId) {
		return sqlSession.delete(NAMESPACE+"deleteBoard", boardId);
	}
	
	public Board selectBoardOne(int boardId) {
		return sqlSession.selectOne(NAMESPACE+"selectBoardOne", boardId);
	}
	
	public Map<String, Object> selectBoardList(Map<String, Object> map) {
		List<Board> list = sqlSession.selectList(NAMESPACE+"selectBoardList", map);
		int total = sqlSession.selectOne(NAMESPACE+"totalCountBoard");
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("total", total);		
		return returnMap;
	}
	public int insertBoard(Board board) {
		return sqlSession.insert(NAMESPACE+"insertBoard", board);
	}
}
