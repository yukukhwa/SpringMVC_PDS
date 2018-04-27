package com.test.pds.gallery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
/*
 * addGallery.jsp 폼화면에서 넘어오는 값을 담는 객체
 */
public class GalleryRequest {
	private String galleryTitle;
	private String galleryContent;
	/*
	 * 이미지파일이 2개 이상 넘어올 수 있기 때문에 리스트로 받는다
	 */
	private List<MultipartFile> multipartFile;
	
	public GalleryRequest() {
		this.multipartFile = new ArrayList<MultipartFile>();
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
	public List<MultipartFile> getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(List<MultipartFile> multipartFile) {
		this.multipartFile = multipartFile;
	}
	@Override
	public String toString() {
		return "GalleryRequest [galleryTitle=" + galleryTitle + ", galleryContent=" + galleryContent
				+ ", multipartFile=" + multipartFile + "]";
	}
}
