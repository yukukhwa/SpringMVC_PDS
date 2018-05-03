package com.test.pds.resume.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pds.article.service.ArticleFile;

@Repository
public class ResumeFileDao {
	final static Logger LOGGER = LoggerFactory.getLogger(ResumeFileDao.class);
	@Autowired private SqlSessionTemplate sqlSession;
	final private String NAMESPACE = "com.test.pds.resume.service.ResumeFileMapper.";
	
	// ResumeFile 삭제
		public int deleteResumeFile(ResumeFile resumeFile) {
			LOGGER.debug("ResumeFileDao.deleteResumeFile 호출");
			sqlSession.delete(NAMESPACE+"deleteResumeFile", resumeFile);
			return resumeFile.getResumeId();
		}
	
	// ResumeFile 입력
	public void insertResumeFile(ResumeFile resumeFile) {
		LOGGER.debug("ResumeFileDao insertResumeFile");
		LOGGER.debug("resumeFile : " + resumeFile);
		sqlSession.insert(NAMESPACE+"insertResumeFile", resumeFile);
	}
}
