package com.test.pds.resume.service;

import org.springframework.web.multipart.MultipartFile;

/*
 * addResume.jsp
 */
public class ResumeRequest {
	private String resumeTitle;
	private String resumeContent;
	private MultipartFile Multipartfile;
	public String getResumeTitle() {
		return resumeTitle;
	}
	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}
	public String getResumeContent() {
		return resumeContent;
	}
	public void setResumeContent(String resumeContent) {
		this.resumeContent = resumeContent;
	}
	public MultipartFile getMultipartfile() {
		return Multipartfile;
	}
	public void setMultipartfile(MultipartFile multipartfile) {
		Multipartfile = multipartfile;
	}
	@Override
	public String toString() {
		return "ResumeRequest [resumeTitle=" + resumeTitle + ", resumeContent=" + resumeContent + ", Multipartfile="
				+ Multipartfile + "]";
	}
	
}
