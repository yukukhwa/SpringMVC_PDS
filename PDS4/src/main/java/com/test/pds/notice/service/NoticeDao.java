package com.test.pds.notice.service;

import java.util.List;
import java.util.Map;

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
	
	// 해당 notice를 삭제하는 메서드 
	public int deleteNotice(int noticeId) {
		LOGGER.debug("NoticeDao.deleteNotice 메서드 호출");
		return sqlSession.delete(NAMESPACE+"deleteNotice",noticeId);
	}
	
	// notice의 카운트 조회하는 메서드
	public int selectNoticeCount() {
		LOGGER.debug("NoticeDao.selectNoticeCount 호출");
		System.out.println("카운트 갯수 몇개임? ==>"+sqlSession.selectOne(NAMESPACE+"selectNoticeCount"));
		return sqlSession.selectOne(NAMESPACE+"selectNoticeCount");
	}
	
	// pagePerRow와 beginRow가 저장되어있는 map을 매개변수로 받아 리스트를 출력하는 메서드
	public List<Notice> selectNoticeList(Map<String, Integer> map) {
		LOGGER.debug("NoticeDao.selectNoticeList 호출");
		System.out.println("noticeDao 리스트: "+sqlSession.selectList(NAMESPACE+"selectNoticeList", map));
		return sqlSession.selectList(NAMESPACE+"selectNoticeList", map);
	}
	
	/* insertNotice */
	public int insertNotice(Notice notice) {
		LOGGER.debug("NoticeDao.insertNotice 호출");
		sqlSession.insert(NAMESPACE+"insertNotice",notice);
		return notice.getNoticeId();
	}

	
}
