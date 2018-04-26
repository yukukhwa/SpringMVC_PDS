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
	
	// resume List 메서드
		// resultMap의 결과를 List로 받아 리턴
		public List<Article> selectArticleList() {
			LOGGER.debug("ArticleDao selectArticleList");
			System.out.println("=============DAo==========");
			System.out.println(sqlSession.selectList(NAMESPACE+"selectArticleList"));
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
