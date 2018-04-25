package com.test.pds.notice.service;

import java.io.File;
import java.io.IOException;
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
public class NoticeService {
	@Autowired NoticeDao noticeDao;
	@Autowired NoticeFileDao noticeFileDao;
	private final static Logger LOGGER = LoggerFactory.getLogger(NoticeService.class);
	
	// 매개변수로 noticeRequest와 path를 넘겨받는다
	public void insertNotice(NoticeRequest noticeRequest, String path) {
		LOGGER.debug("NoticeService.insertNotice 호출");
		// noticeRequest의 MultipartFile을  multipartFile에 저장
		MultipartFile multipartFile = noticeRequest.getMultipartFile();
		
		/* 파일이름
		 * randaomUUid:중복되지 못하도록 랜덤으로 이름 생성
		 * 생성후 uuid에 담는다
		 * 생성한 문자열을 가져와 변수 fileName에 셋팅한다 
		 * replace:일부 문자와 일부 문자를 교체하거나 함께 문자열에서 정규 표현식과 
		 * 일치하는 문자열을 대체하는 데 사용한다 그 후  fileName에 담는다*/
		UUID uuid = UUID.randomUUID(); 
		String fileName = uuid.toString(); 
		fileName = fileName.replace("-", ""); 

		/* 파일 확장자
		 * getOriginalFilename:파일의 실제이름을 가져옴
		 * lastIndexOf: 문자열안에 조건이 되는 문자열이 뒤에서 몇번째 위치에 존재하는지 확인하는 함수*/
		int dot = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileExt = multipartFile.getOriginalFilename().substring(dot+1);

		/* 파일 타입
		 * getContentType: 업로드된 파일의 콘텐츠 타입을 반환
		 * 반환한 타입을 fileType에 담는다*/
		String fileType = multipartFile.getContentType();

		/* 파일 사이즈
		 * 사이즈를 가져와 long타입의 filesize에 담고
		 * noticeFile에 셋팅한다*/
		long fileSize = multipartFile.getSize();
		
		/* 파일 저장
		 * 매개변수 path를 사용
		 * pathname에 해당하는 file의 file객체를 생성한다.
		 * 파일 객체에 전송하는 메서드인 transferto를 사용 */
		File file = new File(SystemPath.DOWNLOAD_PATH_3+"\\"+fileName+"."+fileExt);
		try {
			//transferto: 파일객체에 전송
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// notice의 객체 생성하고 Reqeust에 있는 noticeTitle과 content를 notice객체에 셋팅한다.
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeRequest.getNoticeTitle());
		notice.setNoticeContent(noticeRequest.getNoticeContent());
				
		//noticeFile의 객체 생성후 담은 정보들을 셋팅
		NoticeFile noticeFile = new NoticeFile();
		noticeFile.setNoticeFileName(fileName);
		noticeFile.setNoticeFileExt(fileExt);
		noticeFile.setNoticeFileType(fileType);
		noticeFile.setNoticeFileSize((int)fileSize);
		
		// notice의 noticeFile정보를 셋팅한다
		notice.setNoticeFile(noticeFile);
		// noticeDao의 insertNotice메서드에서 리턴받은 id값을 int타입의 noticeId에 담는다 
		int noticeId = noticeDao.insertNotice(notice);
		LOGGER.debug("noticeId ==>"+noticeId);
		/*noticeFile에 린턴받은 데이터가 들어있는 noticeId를 셋팅한다*/
		noticeFile.setNoticeId(noticeId);
		noticeFileDao.insertNoticeFile(noticeFile);
	}
}
