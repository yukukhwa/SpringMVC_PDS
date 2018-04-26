package com.test.pds.notice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/* noticeRequest addNotice폼에서 받는 값*/
public class NoticeRequest {
	private String noticeTitle; // notice_title
	private String noticeContent; // notice_content
	private List<MultipartFile> multipartFile;
	
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
	public List<MultipartFile> getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(List<MultipartFile> multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	@Override
	public String toString() {
		return "NoticeRequest [noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", multipartFile="
				+ multipartFile + "]";
	}
	
}
