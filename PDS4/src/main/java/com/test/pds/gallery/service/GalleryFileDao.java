package com.test.pds.gallery.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 * 데이터베이스 pds내 테이블 gallery_file에 접근하는 Dao
 */
@Repository
public class GalleryFileDao {
	
	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	private final String NAMESPACE = "com.test.pds.gallery.service.GalleryFileMapper.";
	
	/*public List<GalleryFile> selectGalleryFileList(int galleryId) {
		return sqlSessionTemplate.selectList(NAMESPACE+"selectGalleryFileList", galleryId);
	}*/
	
	/**
	 * galleryFile를 등록하는 메서드
	 * @param gallery
	 * @return 등록된 행의 수
	 */
	public int insertGalleryFile(GalleryFile galleryFile) {
		return sqlSessionTemplate.insert("insertGalleryFile", galleryFile);
	}
}
