package com.test.pds.gallery.service;
/*
 * 데이터베이스 : pds
 * 테이블 : gallery_file
 */
public class GalleryFile {
	/*
	 * 데이터베이스 변수명  <-> 객체 변수명
	 * gallery_file_id <-> galleryFileId
	 * gallery_file_name <-> galleryFileName
	 * gallery_file_ext <-> galleryFileExt
	 * gallery_file_type <-> galleryFileType
	 * gallery_file_size <-> galleryFileSize
	 */
	private int galleryFileId;
	private String galleryFileName;
	private String galleryFileExt;
	private String galleryFileType;
	private int galleryFileSize;
	public int getGalleryFileId() {
		return galleryFileId;
	}
	public void setGalleryFileId(int galleryFileId) {
		this.galleryFileId = galleryFileId;
	}
	public String getGalleryFileName() {
		return galleryFileName;
	}
	public void setGalleryFileName(String galleryFileName) {
		this.galleryFileName = galleryFileName;
	}
	public String getGalleryFileExt() {
		return galleryFileExt;
	}
	public void setGalleryFileExt(String galleryFileExt) {
		this.galleryFileExt = galleryFileExt;
	}
	public String getGalleryFileType() {
		return galleryFileType;
	}
	public void setGalleryFileType(String galleryFileType) {
		this.galleryFileType = galleryFileType;
	}
	public int getGalleryFileSize() {
		return galleryFileSize;
	}
	public void setGalleryFileSize(int galleryFileSize) {
		this.galleryFileSize = galleryFileSize;
	}
	@Override
	public String toString() {
		return "GalleryFile [galleryFileId=" + galleryFileId + ", galleryFileName=" + galleryFileName
				+ ", galleryFileExt=" + galleryFileExt + ", galleryFileType=" + galleryFileType + ", galleryFileSize="
				+ galleryFileSize + "]";
	}
}
