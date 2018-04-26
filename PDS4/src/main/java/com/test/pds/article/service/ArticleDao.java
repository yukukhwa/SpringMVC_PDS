package com.test.pds.article.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao {	
	@Autowired private SqlSessionTemplate sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(ArticleDao.class);	
	final private String NAMESPACE = "com.test.pds.article.service.ArticleMapper.";
		
	// article 입력 메서드
	public int insertArticle(Article article) {
		logger.debug("ArticleDao.insertArticle");
		logger.debug("article : " + article);
		sqlSession.insert(NAMESPACE+"insertArticle", article);
		return article.getArticleId();
	}
}
