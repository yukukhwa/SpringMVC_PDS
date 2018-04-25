package com.test.pds.notice.service;

public class NoticeFile {
	private int noticeFileId; //notice_file_id;
	private int noticeId;	//notice_id
	private String noticeFileName; // notice_file_name
	private String noticeFileExt; // notice_file_ext
	private String noticeFileType; // notice_file_type
	private String noticeFileSize; // notice_file_size
	public int getNoticeFileId() {
		return noticeFileId;
	}
	public void setNoticeFileId(int noticeFileId) {
		this.noticeFileId = noticeFileId;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeFileName() {
		return noticeFileName;
	}
	public void setNoticeFileName(String noticeFileName) {
		this.noticeFileName = noticeFileName;
	}
	public String getNoticeFileExt() {
		return noticeFileExt;
	}
	public void setNoticeFileExt(String noticeFileExt) {
		this.noticeFileExt = noticeFileExt;
	}
	public String getNoticeFileType() {
		return noticeFileType;
	}
	public void setNoticeFileType(String noticeFileType) {
		this.noticeFileType = noticeFileType;
	}
	public String getNoticeFileSize() {
		return noticeFileSize;
	}
	public void setNoticeFileSize(String noticeFileSize) {
		this.noticeFileSize = noticeFileSize;
	}
	
	@Override
	public String toString() {
		return "NoticeFile [noticeFileId=" + noticeFileId + ", noticeId=" + noticeId + ", noticeFileName="
				+ noticeFileName + ", noticeFileExt=" + noticeFileExt + ", noticeFileType=" + noticeFileType
				+ ", noticeFileSize=" + noticeFileSize + "]";
	}
	
}
