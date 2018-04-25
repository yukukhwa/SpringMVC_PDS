package com.test.pds.resume.service;

import org.springframework.web.multipart.MultipartFile;

public class ResumeRequest {
	private String ResumeTitle;
	private String ResumeContent;
	private MultipartFile Multipartfile;
	public String getResumeTitle() {
		return ResumeTitle;
	}
	public void setResumeTitle(String resumeTitle) {
		ResumeTitle = resumeTitle;
	}
	public String getResumeContent() {
		return ResumeContent;
	}
	public void setResumeContent(String resumeContent) {
		ResumeContent = resumeContent;
	}
	public MultipartFile getMultipartfile() {
		return Multipartfile;
	}
	public void setMultipartfile(MultipartFile multipartfile) {
		Multipartfile = multipartfile;
	}
	@Override
	public String toString() {
		return "ResumeRequest [ResumeTitle=" + ResumeTitle + ", ResumeContent=" + ResumeContent + ", Multipartfile="
				+ Multipartfile + "]";
	}
	
}
