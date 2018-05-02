package com.test.pds.notice.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeFileDao {
	@Autowired private SqlSessionTemplate sqlSession;
	private final static Logger LOGGER = LoggerFactory.getLogger(NoticeDao.class);
	private final String NAMESPACE = "com.test.pds.notice.service.NoticeFileMapper.";
	
	public int deleteNoticeFile(int noticeId) {
		LOGGER.debug("NoticeFileDao.deleteNoticeFile 호출 ");
		return sqlSession.delete(NAMESPACE+"selectNoticeFile",noticeId);
	}
	
	/*public List<NoticeFile> selectNoticeOne(){
		LOGGER.debug("%s", "noticeFileDao selectOne");
		return sqlSession.selectOne(NAMESPACE+"selectNoticeFile");
	}*/
	
	// 매개변수가 noticeFile로 insertNoticeFile메서드를 실행해 파일들의 정보들을 인서트
	public void insertNoticeFile(NoticeFile noticeFile) {
		LOGGER.debug("NoticeFile.noticeFile 호출");
		LOGGER.debug("noticeFileDao noticeFile: "+noticeFile);
		sqlSession.insert(NAMESPACE+"insertNoticeFile", noticeFile);
	}
}
