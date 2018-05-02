package com.test.pds.article.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleFileDao {	
	@Autowired private SqlSessionTemplate sqlSession;	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleFileDao.class);	
	final private String NAMESPACE = "com.test.pds.article.service.ArticleFileMapper.";
	
	// ArticleFile 삭제
	public int deleteArticleFile(ArticleFile articleFile) {
		LOGGER.debug("deleteArticleFile 호출");
		sqlSession.delete(NAMESPACE+"deleteArticleFile", articleFile);
		return articleFile.getArticleId();
	}
	
	// ArticleFile 입력
	public int insertArticleFile(ArticleFile articleFile) {
		LOGGER.debug("insertArticleFile 호출");
		return sqlSession.insert(NAMESPACE+"insertArticleFile", articleFile);
	}
}
