package com.test.pds.article.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pds.Paging;
import com.test.pds.gallery.service.Gallery;
import com.test.pds.resume.service.Resume;


@Repository
public class ArticleDao {	
	@Autowired private SqlSessionTemplate sqlSession;
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDao.class);	
	final private String NAMESPACE = "com.test.pds.article.service.ArticleMapper.";
	
	// delete Article 메서드
	public int deleteArticle(int articleId) {
		LOGGER.debug("deleteArticle 호출");
		return sqlSession.delete(NAMESPACE+"deleteArticle", articleId);
	}
	
	// article update
	public int updateArticle(Article article) {
		LOGGER.debug("ArticleDao.updateArticle 호출");
		return sqlSession.update(NAMESPACE+"updateArticle", article);
	}
	
	// selectOne 메서드
	public List<Article> selectArticleOne(int articleId){
		LOGGER.debug("selectArticleOne 호출");
		return sqlSession.selectList(NAMESPACE+"selectArticleOne", articleId);
	}
	
	// article List Count 메서드
	public int countAtricleList() {
		LOGGER.debug("countAtricleList 호출");
		return sqlSession.selectOne(NAMESPACE+"countArticleList");
	}
			
	// article List 메서드
	public List<Article> selectArticleList(Paging paging) {
		LOGGER.debug("selectArticleList 호출");
		LOGGER.debug("list: "+sqlSession.selectList(NAMESPACE+"selectArticleList", paging));
		return sqlSession.selectList(NAMESPACE+"selectArticleList", paging);
	}	
	
	// article 입력 메서드
	public int insertArticle(Article article) {
		LOGGER.debug("insertArticle 호출");
		sqlSession.insert(NAMESPACE+"insertArticle", article);
		return article.getArticleId();
	}
}
