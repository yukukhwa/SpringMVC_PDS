package com.test.pds.resume.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.Paging;
import com.test.pds.SystemPath;
import com.test.pds.article.service.Article;
import com.test.pds.article.service.ArticleFile;

@Service
@Transactional
public class ResumeService {
	@Autowired private ResumeDao resumeDao;
	@Autowired private ResumeFileDao resumeFileDao;
	final static Logger LOGGER = LoggerFactory.getLogger(ResumeService.class);
	
	// Resume delete
		public void deleteResume(Resume resume) {
			LOGGER.debug("ResumeService.deleteResume 호출");
			ResumeFile resumeFile = new ResumeFile();
			resumeFile.setResumeId(resume.getResumeId());
			resumeDao.deleteResume(resumeFileDao.deleteResumeFile(resumeFile));
		}
	
	// Resume update
	public int updateResume(Resume resume) {
		LOGGER.debug("ResumeService.updateResume 호출");		
		return resumeDao.updateResume(resume);
	}
	
	// Resume One
	public Resume selectResumeOne(int resumeId) {
		LOGGER.debug("ResumeService.selectResumeOne 호출");
		LOGGER.debug("dao에서 받은 resume: "+resumeDao.selectResumeOne(resumeId));
		return resumeDao.selectResumeOne(resumeId);
	}
	
	// Resume 리스트
	public Map<String, Object> selectResumeList(int currentPage, int pagePerRow) {
		LOGGER.debug("ResumeService.selectResumeList 호출");
		LOGGER.debug("서비스 입력받은 현재페이지: "+currentPage + ", 페이지퍼: "+pagePerRow);
		int totalRow = resumeDao.countResumeList();
		// 페이징 메서드  Paging(totalRow, pagePerRow, currentPage)		
		Paging paging = new Paging(totalRow, pagePerRow, currentPage);
		List<Integer> pagelist = new ArrayList<Integer>();
		if(totalRow != 0) { // 레코드가 있으면
			for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { // 1~5, 6~10, ...
				pagelist.add(i);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", resumeDao.selectResumeList(paging));
		LOGGER.debug("dao 리턴값(resume객체): " + resumeDao.selectResumeList(paging));
		map.put("pageList", pagelist);
		map.put("totalPage", paging.getTotalPage());
		map.put("pagePerRow", pagePerRow);
		map.put("currentPage", currentPage);		
		return map;
	}
	
	// Resume 등록(제목, 내용, 파일)
	public void insertResume(ResumeRequest resumeRequest) {
		LOGGER.debug("ResumeService.insertResume 호출");
		
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
		LOGGER.debug("파일 경로: "+file.getPath());
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
