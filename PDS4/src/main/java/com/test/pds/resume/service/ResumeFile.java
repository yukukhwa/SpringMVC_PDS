package com.test.pds.resume.service;

/*
 * resume_file table
 */
public class ResumeFile {
	private int resumeFileId;
	private int resumeId;
	private String resumeFileName;
	private String resumeFileExt;
	private String resumeFileType;
	private int resumeFileSize;
	
	public int getResumeFileId() {
		return resumeFileId;
	}
	public void setResumeFileId(int resumeFileId) {
		this.resumeFileId = resumeFileId;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getResumeFileName() {
		return resumeFileName;
	}
	public void setResumeFileName(String resumeFileName) {
		this.resumeFileName = resumeFileName;
	}
	public String getResumeFileExt() {
		return resumeFileExt;
	}
	public void setResumeFileExt(String resumeFileExt) {
		this.resumeFileExt = resumeFileExt;
	}
	public String getResumeFileType() {
		return resumeFileType;
	}
	public void setResumeFileType(String resumeFileType) {
		this.resumeFileType = resumeFileType;
	}
	public int getResumeFileSize() {
		return resumeFileSize;
	}
	public void setResumeFileSize(int resumeFileSize) {
		this.resumeFileSize = resumeFileSize;
	}
	@Override
	public String toString() {
		return "ResumeFile [resumeFileId=" + resumeFileId + ", resumeId=" + resumeId + ", resumeFileName="
				+ resumeFileName + ", resumeFileExt=" + resumeFileExt + ", resumeFileType=" + resumeFileType
				+ ", resumeFileSize=" + resumeFileSize + "]";
	}	
}