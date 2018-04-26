package com.test.pds.notice.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao {
	@Autowired private SqlSessionTemplate sqlSession;
	private final static Logger LOGGER = LoggerFactory.getLogger(NoticeDao.class);
	private final String NAMESPACE = "com.test.pds.notice.service.NoticeMapper.";

	// selectNoticeList메서드를 실행해 sql문 실행
	public List<Notice> selectNoticeList() {
		LOGGER.debug("NoticeDao.selectNoticeList 호출");
		return sqlSession.selectList(NAMESPACE+"selectNoticeList");
	}
	
	/* insertNotice */
	public int insertNotice(Notice notice) {
		LOGGER.debug("NoticeDao.insertNotice 호출");
		sqlSession.insert(NAMESPACE+"insertNotice",notice);
		return notice.getNoticeId();
	}
}
