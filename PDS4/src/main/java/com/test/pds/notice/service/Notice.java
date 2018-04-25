package com.test.pds.notice.service;

public class Notice {
	private int noticeId; // notice_id
	private String noticeTitle; //notice_title
	private String noticeContent; // notice_content
	private NoticeFile noticeFile; //notice_file 일단은 1대1로 
	
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public NoticeFile getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(NoticeFile noticeFile) {
		this.noticeFile = noticeFile;
	}
	
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeFile=" + noticeFile + "]";
	}
}

