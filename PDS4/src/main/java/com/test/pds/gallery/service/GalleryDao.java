package com.test.pds.gallery.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 * 데이터베이스 pds내 테이블 gallery에 접근하는 Dao
 */
@Repository
public class GalleryDao {
	
	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	private final String NAMESPACE = "com.test.pds.gallery.service.GalleryMapper.";
	
	/**
	 * gallery를 등록하는 메서드
	 * @param gallery
	 * @return 등록된 행의 수
	 */
	public int insertGallery(Gallery gallery) {
		return sqlSessionTemplate.insert(NAMESPACE+"insertGallery", gallery);
	}
}
