package com.test.pds.notice.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao {
	@Autowired private SqlSessionTemplate sqlSession;
	private final static Logger logger = LoggerFactory.getLogger(NoticeDao.class);
	private final String NS = "com.test.pds.notice.service.NoticeMapper.";
	
	public int addNotice(Notice notice) {
		logger.debug("NoticeDao.addNotice 호출");
		return sqlSession.insert(NS+"insertNotice",notice);
	}
}
