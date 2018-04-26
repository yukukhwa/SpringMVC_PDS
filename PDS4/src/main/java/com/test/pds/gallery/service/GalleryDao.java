package com.test.pds.gallery.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 * 데이터베이스 pds내 테이블 gallery에 접근하는 Dao
 */
@Repository
public class GalleryDao {
	
	private static final Logger logger = LoggerFactory.getLogger(GalleryDao.class);
	
	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	private final String NAMESPACE = "com.test.pds.gallery.service.GalleryMapper.";
	
	public List<Gallery> selectGalleryOne(int galleryId){
		logger.debug("GalleryDao.selectGaelleryOne 메서드 호출");
		return sqlSessionTemplate.selectList(NAMESPACE+"selectGalleryOne", galleryId);
	}
	
	/*public Gallery selectGalleryOne(int galleryId){
		logger.debug("GalleryDao.selectGaelleryOne 메서드 호출");
		return sqlSessionTemplate.selectOne(NAMESPACE+"selectGalleryOne", galleryId);
	}*/
	
	/**
	 * 등록된 gallery들의 리스트르를 보여주는 메서드
	 * @return gallery리스트
	 */
	public List<Gallery> selectGalleryList() {
		logger.debug("GalleryDao.selectGalleryList 메서드 호출");
		return sqlSessionTemplate.selectList(NAMESPACE+"selectGalleryList");
	}
	
	/**
	 * gallery를 등록하는 메서드
	 * @param gallery
	 * @return 등록된 행의 수
	 */
	public int insertGallery(Gallery gallery) {
		logger.debug("GalleryDao.insertGallery 메서드 호출");
		return sqlSessionTemplate.insert(NAMESPACE+"insertGallery", gallery);
	}
}
