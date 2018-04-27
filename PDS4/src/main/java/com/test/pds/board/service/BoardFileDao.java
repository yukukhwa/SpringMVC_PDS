package com.test.pds.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDao {
	@Autowired private SqlSessionTemplate sqlSession;
	
	final private String NAMESPACE = "com.test.pds.board.service.BoardFileMapper.";
	
	public List<BoardFile> selectBoardFileList( int boardFileId) {
		return sqlSession.selectList(NAMESPACE+"selectBoardFileList", boardFileId);
	}
	
	public int insertBoardFile(BoardFile boardFile) {
		return sqlSession.insert(NAMESPACE+"insertBoardFile", boardFile);
	}
}
