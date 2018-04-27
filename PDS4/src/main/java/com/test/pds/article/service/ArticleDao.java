package com.test.pds.article.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ArticleDao {	
	@Autowired private SqlSessionTemplate sqlSession;
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDao.class);	
	final private String NAMESPACE = "com.test.pds.article.service.ArticleMapper.";
	
	// delete Article 메서드
	public int deleteArticle(int articleId) {
		LOGGER.debug("ArticleDao deleteArticle");
		return sqlSession.delete(NAMESPACE+"deleteArticle", articleId);
	}
	
	// selectOne 메서드
	public List<Article> selectArticleOne(Article article) {
		LOGGER.debug("ArticleDao selectArticleOne");	
		return sqlSession.selectList(NAMESPACE+"selectArticleOne", article);		
	}
	
	// article List 메서드
	// resultMap의 결과를 List로 받아 리턴
	public List<Article> selectArticleList() {
		LOGGER.debug("ArticleDao selectArticleList");
		//beginRow, perPage 입력받아야함
		return sqlSession.selectList(NAMESPACE+"selectArticleList");
	}
	
	
	// article 입력 메서드
	public int insertArticle(Article article) {
		LOGGER.debug("ArticleDao.insertArticle");
		LOGGER.debug("article : " + article);
		sqlSession.insert(NAMESPACE+"insertArticle", article);
		return article.getArticleId();
	}
}
