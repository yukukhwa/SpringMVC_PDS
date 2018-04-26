package com.test.pds.resume.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pds.ResumeController;

@Repository
public class ResumeDao {
	final static Logger LOGGER = LoggerFactory.getLogger(ResumeController.class);
	@Autowired private SqlSessionTemplate sqlSession;
	final private String NAMESPACE = "com.test.pds.resume.service.ResumeMapper.";
	
	// resume List 메서드
	// resultMap의 결과를 List로 받아 리턴
	public List<Resume> selectResumeList() {
		LOGGER.debug("ResumeDao selectResumeList");
		return sqlSession.selectList(NAMESPACE+"selectResumeList");
	}
	
	// resume 등록 메서드
	public int insertResume(Resume resume) {
		LOGGER.debug("ResumeDao insertResume");
		LOGGER.debug("resume : " + resume);
		sqlSession.insert(NAMESPACE+"insertResume", resume);
		return resume.getResumeId();
	}

}
