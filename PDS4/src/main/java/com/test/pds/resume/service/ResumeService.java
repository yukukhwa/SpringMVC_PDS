package com.test.pds.resume.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.SystemPath;

@Service
@Transactional
public class ResumeService {
	@Autowired private ResumeDao resumeDao;
	@Autowired private ResumeFileDao resumeFileDao;
	final static Logger LOGGER = LoggerFactory.getLogger(ResumeService.class);
	
	// Resume 리스트
	public List<Resume> selectResumeList() {
		LOGGER.debug("ResumeService selectResumeList");
		return resumeDao.selectResumeList();
	}
	
	// Resume 등록(제목, 내용, 파일)
	public void insertResume(ResumeRequest resumeRequest) {
		LOGGER.debug("ResumeService insertResume");
		LOGGER.debug("resumeRequest : " + resumeRequest);
		
		// ResumeRequest에 있는 file 담을 객체(multipartFile) 생성
		MultipartFile multipartFile = resumeRequest.getMultipartfile();
		
		// 파일 이름
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString();
		fileName = fileName.replace("-", "");
		
		// 파일 컨텐트타입
		String fileType = multipartFile.getContentType();
		
		// 파일 확장자
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		
		// 파일 사이즈
		long fileSize = multipartFile.getSize();
		
		// 파일 저장(SystemPath를 이용)
		File file = new File(SystemPath.DOWNLOAD_PATH_1+"\\"+fileName+"."+fileExt);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 입력으로 쓸 Resume 객체 세팅
		Resume resume = new Resume();
		resume.setResumeTitle(resumeRequest.getResumeTitle());
		resume.setResumeContent(resumeRequest.getResumeContent());
		
		// 입력으로 쓸 ResumeFile 객체 세팅
		ResumeFile resumeFile = new ResumeFile();
		resumeFile.setResumeId(resumeDao.insertResume(resume));
		resumeFile.setResumeFileName(fileName);
		resumeFile.setResumeFileExt(fileExt);
		resumeFile.setResumeFileSize((int) fileSize);
		resumeFile.setResumeFileType(fileType);		

		resumeFileDao.insertResumeFile(resumeFile); // resumeDao 와 resumeFileDao 는 트랜젝션(@Transactional)
	}

}
