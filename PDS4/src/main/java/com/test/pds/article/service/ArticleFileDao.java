package com.test.pds.article.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleFileDao {	
	@Autowired private SqlSessionTemplate sqlSession;	
	private static final Logger logger = LoggerFactory.getLogger(ArticleFileDao.class);	
	final private String NAMESPACE = "com.test.pds.article.service.ArticleFileMapper.";
	
	// ArticleFile 입력
	public int insertArticleFile(ArticleFile articleFile) {
		logger.debug("ArticleFileDao insertArticleFile");
		logger.debug("articleFile : " + articleFile);
		return sqlSession.insert(NAMESPACE+"insertArticleFile", articleFile);
	}
}
