package com.test.pds.gallery.service;

import java.util.ArrayList;
import java.util.List;

/*
 * DB : pds
 * table : gallery
 */
public class Gallery {
	/*
	 * 데이터베이스 변수명  <-> 객체 변수명
	 * gallery_id <-> galleryId
	 * gallery_title <-> galleryTitle
	 * gallery_content <-> galleryContent
	 */
	private int galleryId;
	private String galleryTitle;
	private String galleryContent;
	/*
	 * join table : gallery_file
	 */
	private List<GalleryFile> galleryFile;
	
	/**
	 * Gallery생성자 메서드
	 * 객체 생성과 동시에 GalleryFile객체 리스트 공간도 생성한다
	 */
	public Gallery() {
		this.galleryFile = new ArrayList<GalleryFile>();
	}
	
	public int getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}
	public String getGalleryTitle() {
		return galleryTitle;
	}
	public void setGalleryTitle(String galleryTitle) {
		this.galleryTitle = galleryTitle;
	}
	public String getGalleryContent() {
		return galleryContent;
	}
	public void setGalleryContent(String galleryContent) {
		this.galleryContent = galleryContent;
	}
	public List<GalleryFile> getGalleryFile() {
		return galleryFile;
	}
	public void setGalleryFile(List<GalleryFile> galleryFile) {
		this.galleryFile = galleryFile;
	}
	@Override
	public String toString() {
		return "Gallery [galleryId=" + galleryId + ", galleryTitle=" + galleryTitle + ", galleryContent="
				+ galleryContent + ", galleryFile=" + galleryFile + "]";
	}
}
