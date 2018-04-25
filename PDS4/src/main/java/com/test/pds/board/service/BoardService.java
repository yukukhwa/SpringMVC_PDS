package com.test.pds.board.service;

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
public class BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired private BoardDao boardDao;
	@Autowired private BoardFileDao boardFileDao;
	
	public void insertBoard(BoardRequest boardRequest) {
		
		MultipartFile multipartFile = boardRequest.getMultipartFile();
		
		// 파일이름
		UUID uuid = UUID.randomUUID(); // 중복되는 이름을 가질 수 없도록 자동으로 이름을 생성해주는 api
		String fileName = uuid.toString(); // 만들어진 이름값을 불러와 셋팅한다
		fileName = fileName.replace("-", "");
		logger.debug("fileName"+fileName);
		
		
		// 파일 확장자
		int dotIndex = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1);
		logger.debug("fileExt"+fileExt);
		
		
		// 파일 컨텐트 타입
		String fileType = multipartFile.getContentType();
		logger.debug("fileType"+fileType);
		
		
		// 파일 사이즈
		long fileSize = multipartFile.getSize();
		logger.debug("fileSize"+fileSize);
		
		
		// 파일 저장(매개변수 path를 이용)
		File file = new File(SystemPath.DOWNLOAD_PATH_4+"\\"+fileName+"."+fileExt);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Board board = new Board();
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardContent(boardRequest.getBoardContent());
		
		BoardFile boardFile = new BoardFile();
		boardFile.setBoardId(boardDao.insertBoard(board));
		boardFile.setBoardFileName(fileName);
		boardFile.setBoardFileExt(fileExt);
		boardFile.setBoardFileType(fileType);
		boardFile.setBoardFileSize((int)fileSize);
		
		//BoardFileDao 호출
		boardFileDao.insertBoardFile(boardFile);
		
	}
	

}
