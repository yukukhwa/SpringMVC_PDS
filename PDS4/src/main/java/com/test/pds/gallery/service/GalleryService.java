package com.test.pds.gallery.service;

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

@Service @Transactional
public class GalleryService {

	private static final Logger logger = LoggerFactory.getLogger(GalleryService.class);
	
	@Autowired private GalleryDao galleryDao;
	@Autowired private GalleryFileDao galleryFileDao;
	
	/**
	 * gallery(gallery-galleryFile)를 수정하는 서비스
	 * @param galleryRequest
	 * @param path
	 * @param galleryId
	 * @param deleteImg
	 */
	public void updateGallery(GalleryRequest galleryRequest,String path,int galleryId,List<String> deleteImg) {
		logger.info("updateGallery 서비스 실행");
		/*
		 * gallery 타이틀이나 컨텐츠내용을 update하는 부분
		 */
		Gallery gallery = new Gallery();
		gallery.setGalleryTitle(galleryRequest.getGalleryTitle());
		gallery.setGalleryContent(galleryRequest.getGalleryContent());
		gallery.setGalleryId(galleryId);
		galleryDao.updateGallery(gallery);
		
		List<MultipartFile> list = galleryRequest.getMultipartFile();
		/*
		 * 이미지파일 update하는 부분
		 * 만약 새로 추가되는 이미지 파일이 있다면 들록하고, 삭제되는 이미지 파일이 있다면 삭제한다
		 */
		if(list.size() != 0) {// 추가되는 이미지 파일있다면 새로 등록해주는 부분
			for(MultipartFile multipartFile : list) {
				GalleryFile galleryFile = new GalleryFile();
				/*
				 * 파일 이름 생성
				 */
				UUID uuid = UUID.randomUUID(); // 이름을 렌덤으로 생성해준다
				logger.debug("uuid: "+uuid);
				String fileName = uuid.toString().replace("-", "");
				logger.debug("fileName: "+fileName);
				galleryFile.setGalleryFileName(fileName);
				
				/*
				 * 파일 확장자
				 */
				int fileNameSize = multipartFile.getOriginalFilename().indexOf(".");
				String fileExt = multipartFile.getOriginalFilename().substring(fileNameSize+1);
				logger.debug("fileExt: "+fileExt);
				galleryFile.setGalleryFileExt(fileExt);
				
				/*
				 * 파일 데이터 타입
				 */
				String fileType = multipartFile.getContentType();
				logger.debug("fileType: "+fileType);
				galleryFile.setGalleryFileType(fileType);
				
				/*
				 * 파일 데이터 크기
				 */
				long fileSize = multipartFile.getSize();
				logger.debug("fileSize: "+String.valueOf(fileSize));
				galleryFile.setGalleryFileSize(fileNameSize);
				
				gallery.getGalleryFile().add(galleryFile);
				/*
				 * 서버내 upload폴더에 화면에서 받아온 데이터와 같은 확장자로 임시파일 생성 후 업로드하고자 하는 파일데이터를 덮어쓰기
				 */
				File file = new File(path+"\\"+fileName+"."+fileExt);
				try {
					multipartFile.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(GalleryFile file:gallery.getGalleryFile()) {
				file.setGalleryId(gallery.getGalleryId());
				galleryFileDao.insertGalleryFile(file);
			}
		}
		
		if(deleteImg != null) {// 삭제되는 이미지 파일이 있다면 삭제하는 부분
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("galleryId", galleryId);
			for(String fileNameExt : deleteImg) {
				logger.debug("파일풀네임: "+fileNameExt);
				File file = new File(path+"\\"+fileNameExt);
				logger.debug("삭제 전 파일 존재여부 확인: "+file.exists());
				file.delete();
				logger.debug("삭제 후 파일 존재여부 확인: "+file.exists());
				int fileNameSize = fileNameExt.indexOf(".");
				String fileName = fileNameExt.substring(0,fileNameSize);
				map.put("galleryFileName", fileName);
				logger.debug("galleryFileMap(작성자&삭제하고자하는 파일명): "+map.toString());
				galleryFileDao.deleteImgFile(map);
			}
		}
	}
	
	/**
	 * gallery 내용 및 이미지파일을 전체삭제해주는 서비스이다
	 * @param galleryId
	 * @param path
	 */
	public void deleteGallery(int galleryId,String path) {
		logger.debug("deleteGallery 서비스 실행");
		String fileName = null;
		String fileExt = null;
		List<GalleryFile> list = galleryFileDao.selectGalleryFileList(galleryId);
		logger.debug("DB에 저장되어있는 galleryFile목록: "+list);
		for(GalleryFile galleryFile : list) {// DB내 파일목록을 삭제하기전 파일데이터목록을 삭제한다
			fileName = galleryFile.getGalleryFileName();
			fileExt = galleryFile.getGalleryFileExt();
			logger.debug("파일명: "+fileName+"."+fileExt);
			File file = new File(path+"\\"+fileName+"."+fileExt);
			logger.debug("삭제 전 파일 존재여부 확인: "+file.exists());
			file.delete();
			logger.debug("삭제 후 파일 존재여부 확인: "+file.exists());
		}
		/*
		 * DB내 galleryFile을 삭제후 gallery를 지운다
		 * 외래키로 묶여있어 순서대로 지워야 한다, 반대로 지우면 에러발생!
		 */
		galleryFileDao.deleteGalleryFile(galleryId);
		galleryDao.deleteGallery(galleryId);
	}
	
	/**
	 * 선택한 gallery의 상세내용을 출력해주는 서비스이다
	 * @param galleryId
	 * @return 선택한 gallry의 상세내용
	 */
	public List<Gallery> getGalleryOne(int galleryId) {
		logger.debug("getGalleryOne 서비스 실행");
		List<Gallery> list = galleryDao.selectGalleryOne(galleryId);
		logger.debug("gallery목록: "+String.valueOf(list));
		return list;
	}
	
	/*public Map<String,Object> getGalleryOne(int galleryId) {
		logger.debug("GalleryService.getGalleryOne 메서드 호출");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("gallery", galleryDao.selectGalleryOne(galleryId));
		map.put("list", galleryFileDao.selectGalleryFileList(galleryId));
		return map;
	}*/
	
	/**
	 * 등록된 gallery리스트를 출력해주는 서비스
	 * @return gallery리스트
	 */
	public Map<String,Object> getGalleryList(int currentPage,int pagePerRow) {
		logger.debug("getGalleryList 서비스 실행");
		/*
		 * 총 몇개의 gallery게시글이 있는지 카운트를 샌다
		 */
		int totalRow = galleryDao.countGalleryList();
		/*
		 * 총 게시글 리스트 수, 한페이지당 보여줄 리스트 수, 현재페이지번호를 가지고 페이징 작업을 한다
		 */
		Paging paging = new Paging(totalRow, pagePerRow, currentPage);
		logger.debug("페이징상황: "+paging.toString());
		/*
		 * 만약 5줄보기+마지막페이지를 보고있던상황에서 10줄보기롤 리스트형태를 바꾸면 페이지형태가 달라지므로
		 * 10줄보기+마지막페이지가 되도록 다시 페이징작업을 해준다
		 */
		int endPage = paging.getEndPage();
		if(currentPage > endPage) {
			currentPage = endPage;
			paging = new Paging(totalRow, pagePerRow, currentPage);
			logger.debug("다시한 페이징상황: "+paging.toString());
		}
		/*
		 * 페이지 넘버를 리스트화 해주는데 만약 게시글이 없다면 만들어줄 필요가 없다
		 */
		List<Integer> pageList = new ArrayList<Integer>();
		if(totalRow != 0) {
			for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) {
				pageList.add(i);
			}
		}
		/*
		 * 완성된 페이징결과값중 beginRow와 pagePerRow값을 활용해
		 * 해당 페이지에 보여줄 게시글들을 리스트화 해준다
		 */
		List<Gallery> list = galleryDao.selectGalleryList(paging);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("totalPage", paging.getTotalPage());
		map.put("pagePerRow", pagePerRow);
		map.put("pageList", pageList);
		return map;
	}
	
	/**
	 * gallery를 등록해주는 서비스
	 * @param galleryRequest
	 * @param path
	 */
	public void addGallery(GalleryRequest galleryRequest, String path) {
		logger.debug("addGallery 서비스 실행");
		Gallery gallery = new Gallery();
		gallery.setGalleryTitle(galleryRequest.getGalleryTitle());
		gallery.setGalleryContent(galleryRequest.getGalleryContent());
		int row1 = galleryDao.insertGallery(gallery);
		
		List<MultipartFile> list = galleryRequest.getMultipartFile();
		for(MultipartFile multipartFile : list) {
			GalleryFile galleryFile = new GalleryFile();
			/*
			 * 파일 이름 생성
			 */
			UUID uuid = UUID.randomUUID(); // 이름을 렌덤으로 생성해준다
			logger.debug("uuid: "+uuid);
			String fileName = uuid.toString().replace("-", "");
			logger.debug("fileName: "+fileName);
			galleryFile.setGalleryFileName(fileName);
			
			/*
			 * 파일 확장자
			 */
			int fileNameSize = multipartFile.getOriginalFilename().indexOf(".");
			String fileExt = multipartFile.getOriginalFilename().substring(fileNameSize+1);
			logger.debug("fileExt: "+fileExt);
			galleryFile.setGalleryFileExt(fileExt);
			
			/*
			 * 파일 데이터 타입
			 */
			String fileType = multipartFile.getContentType();
			logger.debug("fileType: "+fileType);
			galleryFile.setGalleryFileType(fileType);
			
			/*
			 * 파일 데이터 크기
			 */
			long fileSize = multipartFile.getSize();
			logger.debug("fileSize: "+String.valueOf(fileSize));
			galleryFile.setGalleryFileSize(fileNameSize);
			
			gallery.getGalleryFile().add(galleryFile);
			/*
			 * 서버내 upload폴더에 화면에서 받아온 데이터와 같은 확장자로 임시파일 생성 후 업로드하고자 하는 파일데이터를 덮어쓰기
			 */
			File file = new File(path+"\\"+fileName+"."+fileExt);
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.debug("등록하고자하는 이미지파일목록: "+gallery.getGalleryFile());
		for(GalleryFile file:gallery.getGalleryFile()) {
			file.setGalleryId(gallery.getGalleryId());
			galleryFileDao.insertGalleryFile(file);
		}
	}

}