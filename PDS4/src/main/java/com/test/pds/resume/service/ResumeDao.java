package com.test.pds.resume.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pds.Paging;
import com.test.pds.ResumeController;

@Repository
public class ResumeDao {
	final static Logger LOGGER = LoggerFactory.getLogger(ResumeController.class);
	@Autowired private SqlSessionTemplate sqlSession;
	final private String NAMESPACE = "com.test.pds.resume.service.ResumeMapper.";
	
	// resume delete
	public int deleteResume(int resumeId) {
		LOGGER.debug("ResumeDao.deleteResume 호출");
		return sqlSession.delete(NAMESPACE+"deleteResume", resumeId);
	}
	
	// resume update
	public int updateResume(Resume resume) {
		LOGGER.debug("ResumeDao.updateResume 호출");
		return sqlSession.update(NAMESPACE+"updateResume", resume);
	}
	
	// resume selectOne
	// resultMap은 리스트로 반환하지만 resume은 1:1 관계라 객체(One)로 받아서 리턴
	public Resume selectResumeOne(int resumeId){
		LOGGER.debug("ResumeDao.selectResumeOne 호출");	
		return sqlSession.selectOne(NAMESPACE+"selectResumeOne", resumeId);
	}
	// resume count(리스트 레코드행의 갯수)
	public int countResumeList() {
		LOGGER.debug("ResumeDao.countResumeList 호출");
		return sqlSession.selectOne(NAMESPACE+"countResumeList");
	}
	
	// resume selectList
	public List<Resume> selectResumeList(Paging paging) {
		LOGGER.debug("ResumeDao.selectResumeList 호출");
		return sqlSession.selectList(NAMESPACE+"selectResumeList", paging);
	}
	
	// resume 등록 메서드
	public int insertResume(Resume resume) {
		LOGGER.debug("ResumeDao.insertResume 호출");
		sqlSession.insert(NAMESPACE+"insertResume", resume);
		return resume.getResumeId();
	}

}
