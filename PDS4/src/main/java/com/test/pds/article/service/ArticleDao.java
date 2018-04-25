package com.test.pds.article.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleDao.class);
	
	final String NS = "com.test.pds.article.service.ArticleMapper.";
	
	public List<Article> selectArticle() {
		return sqlSession.selectList(NS+"selectArticleList");
	}
	/*
	 * article 매개변수로 받아 article 입력처리 후 id값을 리턴받는다
	 */
	public int insertArticle(Article article) {
		sqlSession.insert(NS+"insertArticle", article);
		return article.getArticleId();
	}
}
