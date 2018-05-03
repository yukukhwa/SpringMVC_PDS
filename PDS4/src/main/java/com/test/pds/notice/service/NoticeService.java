package com.test.pds.notice.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.SystemPath;

@Service
@Transactional
public class NoticeService {
	@Autowired NoticeDao noticeDao;
	@Autowired NoticeFileDao noticeFileDao;
	private final static Logger LOGGER = LoggerFactory.getLogger(NoticeService.class);
		public void deleteNotice(int noticeId) {
			LOGGER.debug("NoticeService.deleteNotice 호출");
			noticeFileDao.deleteNoticeFile(noticeId);
			noticeDao.deleteNotice(noticeId);
			
		}
		
		public List<Notice> selectNoticeOne(int noticeId){
			LOGGER.debug("NoticeService.selectNoticeOne 호출");
			List<Notice> list = noticeDao.selectNoticeOne(noticeId);
			return list;
		}
	
		/* 리스트 출력 + 페이징 하기 위해 int타입의 currentPage와 pagePerRow를 매개변수로 받는다 */
		public Map<String, Object> selectNoticeList(int currentPage, int pagePerRow){
			LOGGER.debug("NoticeService.selectNoticeList 호출");
			LOGGER.debug("currentPage, pagePerRow :"+currentPage+","+pagePerRow);
			/*Map객체 생성하고 currentPage와 pagePerRow를 사용해 시작페이지를 구한다.
			 * 구한 시작페이지를 맵에다 저장하고, pagePerRow도 map에다 저장한다. 
			 * notice에 list객체를 생성해 리스트에다가 map을 매개변수로 dao에 있는 selectNoticeList메서드를 실행해
			 * 리턴받은 조회결과를 담는다*/
			Map<String, Integer> map = new HashMap<String, Integer>();
			int beginRow = (currentPage-1)*pagePerRow;
			System.out.println("NoticeService beginRow =>"+beginRow);
			map.put("beginRow", beginRow);
			map.put("pagePerRow", pagePerRow);
			/* dao에 list의 전체 갯수를 구하는 메서드를 실행한 결과를 담아 int타입의 total변수에 저장하고
			 * 전체갯수와 pagePerRow를 나눈 결과를 lastPage변수에 담는다
			 * 만약 전체갯수와 pagePerRow의 나머지가 0이 아니라면 페이지를 하나씩 더해줘야하 하므로 lastPage를 하나씩 더해준다.*/
			List<Notice> list = noticeDao.selectNoticeList(map);
			int total = noticeDao.selectNoticeCount();
			System.out.println("total => "+total);
			int lastPage = total/pagePerRow;
			if(total%pagePerRow != 0) {
				lastPage++;
			}
			System.out.println("lastPage =>"+lastPage);
			/* 새로운 맵객체를 생성해주고 그 맵객체가 있는 returnMap에 lastPage와 beginRow와 pagePerRow가 있는 
			 * list를 리턴맵에 저장하여 리턴한다*/
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("lastPage", lastPage);
			returnMap.put("list", list);
			return returnMap;
		}
	
	// 매개변수로 noticeRequest와 path를 넘겨받는다
	public void insertNotice(NoticeRequest noticeRequest, String path) {
		LOGGER.debug("NoticeService.insertNotice 호출");
		// noticeRequest의 MultipartFile을  multipartFile에 저장
		List<MultipartFile> multipartFile = noticeRequest.getMultipartFile();
		LOGGER.debug("NoticeService multipartFile list: "+multipartFile);
		
		/* notice의 객체 생성하고 Reqeust에 있는 noticeTitle과 content를 겟팅해 notice객체에 각각 셋팅한다.
		 * noticeDao에 insertNotice메서드를 매개변수 notice를 넘겨서 실행해 sql문이 실행되어 pk값인
		 * noticeId가 리턴받고 그 값을 int타입의 noticeId에 저장한다 */
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeRequest.getNoticeTitle());
		notice.setNoticeContent(noticeRequest.getNoticeContent());
		int noticeId = noticeDao.insertNotice(notice);

		/* for문: 파일이 두개이상이기 때문에
		 * noticeRequest객체의 multipartFile정보들을 겟팅해  multipartFile에 담고 
		 * 그 배열에 담긴 값들을 files변수에 대입해 반복할때마다
		 * noticeFile에 파일의 이름, 확장자, 타입, 사이즈, Id 배열을 셋팅하고 
		 * notice객체에 있는 noticeFile에 배열들을 셋팅해 주기 위해   */
		for(MultipartFile files : multipartFile) {
			/* 파일이름
			 * randomUUid:중복되지 못하도록 랜덤으로 이름 생성
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
			int dot = files.getOriginalFilename().lastIndexOf(".");
			String fileExt = files.getOriginalFilename().substring(dot+1);
			
			/* 파일 타입
			 * getContentType: 업로드된 파일의 콘텐츠 타입을 반환
			 * 반환한 타입을 fileType에 담는다*/
			String fileType = files.getContentType();

			/* 파일 사이즈
			 * 사이즈를 가져와 long타입의 filesize에 담는다*/
			long fileSize = files.getSize();
		
			/* 파일 저장
			 * pathname에 해당하는 file의 file객체를 생성한다.
			 * 파일 객체에 전송하는 메서드인 transferto를 사용 */
			File file = new File(SystemPath.DOWNLOAD_PATH_3+"\\"+fileName+"."+fileExt);
			try {
				//transferto: 파일객체에 전송,파일데이터를 지정한 파일로 저장
				files.transferTo(file);
				System.out.println("files===>"+files);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			NoticeFile noticeFile = new NoticeFile();
			noticeFile.setNoticeFileName(fileName);
			noticeFile.setNoticeFileExt(fileExt);
			noticeFile.setNoticeFileType(fileType);
			noticeFile.setNoticeFileSize((int)fileSize);
			noticeFile.setNoticeId(noticeId);
			notice.setNoticeFile(noticeFile);
			/*notice.setNoticeFile(noticeFile);*/
			/* noticeFile을 매개변수로 넘겨 insertNoticeFile메소드를 실행해
			 * noticeFile정보들을 noticeFiledb에 저장하는 sql문을 실행해 배열들을 저장한다 */
			noticeFileDao.insertNoticeFile(noticeFile);
		}	
	}
}
