package com.test.pds.gallery.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.pds.Paging;
/*
 * 데이터베이스 pds내 테이블 gallery에 접근하는 Dao
 */
@Repository
public class GalleryDao {
	
	private static final Logger logger = LoggerFactory.getLogger(GalleryDao.class);
	
	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	private final String NAMESPACE = "com.test.pds.gallery.service.GalleryMapper.";
	
	/**
	 * 선택한 gallery를 수정하는 메서드
	 * @param gallery
	 * @return 수정된 행의 수
	 */
	public int updateGallery(Gallery gallery) {
		logger.debug("updateGallery dao 실행");
		return sqlSessionTemplate.update(NAMESPACE+"updateGallery", gallery);
	}
	
	/**
	 * 선택한 gallery를 삭제하는 메서드
	 * @param galleryId
	 * @return 삭제된 행의 수
	 */
	public int deleteGallery(int galleryId) {
		logger.debug("deleteGallery dao 실행");
		return sqlSessionTemplate.delete(NAMESPACE+"deleteGallery", galleryId);
	}
	
	/**
	 * 선택한 gallery의 상세내용을 보여주는 메서드
	 * @param galleryId
	 * @return 선택된 gallery의 상세내용
	 */
	public List<Gallery> selectGalleryOne(int galleryId){
		logger.debug("selectGaelleryOne dao 실행");
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
	public List<Gallery> selectGalleryList(Paging paging) {
		logger.debug("selectGalleryList dao 실행");
		return sqlSessionTemplate.selectList(NAMESPACE+"selectGalleryList",paging);
	}
	
	public int countGalleryList() {
		logger.debug("countGalleryList dao 실행");
		return sqlSessionTemplate.selectOne(NAMESPACE+"countGalleryList");
	}
	
	/**
	 * gallery를 등록하는 메서드
	 * @param gallery
	 * @return 등록된 행의 수
	 */
	public int insertGallery(Gallery gallery) {
		logger.debug("insertGallery dao 실행");
		return sqlSessionTemplate.insert(NAMESPACE+"insertGallery", gallery);
	}
}
