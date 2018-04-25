package com.test.pds.article.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleFileDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleFileDao.class);
	
	final String NS = "com.test.pds.article.service.ArticleFileMapper.";
	
	/*
	 * articleFile을 매개변수로 받아 insert시킨후 row를 리턴
	 */
	public int insertArticleFile(ArticleFile articleFile) {
		int row = sqlSession.insert(NS+"insertArticleFile", articleFile);
		return row;
	}
}
