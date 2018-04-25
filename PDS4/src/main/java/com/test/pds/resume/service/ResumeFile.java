package com.test.pds.resume.service;

public class ResumeFile {
	private int ResumeFileId;
	private int ResumeId;
	private String ResumeFileName;
	private String ResumeFileExt;
	private String ResumeFileType;
	private int ResumeFileSize;
	
	public int getResumeFileId() {
		return ResumeFileId;
	}
	public void setResumeFileId(int resumeFileId) {
		ResumeFileId = resumeFileId;
	}
	public int getResumeId() {
		return ResumeId;
	}
	public void setResumeId(int resumeId) {
		ResumeId = resumeId;
	}
	public String getResumeFileName() {
		return ResumeFileName;
	}
	public void setResumeFileName(String resumeFileName) {
		ResumeFileName = resumeFileName;
	}
	public String getResumeFileExt() {
		return ResumeFileExt;
	}
	public void setResumeFileExt(String resumeFileExt) {
		ResumeFileExt = resumeFileExt;
	}
	public String getResumeFileType() {
		return ResumeFileType;
	}
	public void setResumeFileType(String resumeFileType) {
		ResumeFileType = resumeFileType;
	}
	public int getResumeFileSize() {
		return ResumeFileSize;
	}
	public void setResumeFileSize(int resumeFileSize) {
		ResumeFileSize = resumeFileSize;
	}
	@Override
	public String toString() {
		return "ResumeFile [ResumeFileId=" + ResumeFileId + ", ResumeId=" + ResumeId + ", ResumeFileName="
				+ ResumeFileName + ", ResumeFileExt=" + ResumeFileExt + ", ResumeFileType=" + ResumeFileType
				+ ", ResumeFileSize=" + ResumeFileSize + "]";
	}
	
}
