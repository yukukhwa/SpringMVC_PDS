package com.test.pds.gallery.service;

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

@Service @Transactional
public class GalleryService {

	private static final Logger logger = LoggerFactory.getLogger(GalleryService.class);
	
	@Autowired private GalleryDao galleryDao;
	@Autowired private GalleryFileDao galleryFileDao;
	
	public void updateGallery(GalleryRequest galleryRequest,String path) {
		logger.debug("GalleryService.updateGallery 메서드 호출");
		
	}
	
	/**
	 * gallery 내용 및 이미지파일을 삭제해주는 서비스이다
	 * @param galleryId
	 * @param path
	 */
	public void deleteGallery(int galleryId,String path) {
		logger.debug("GalleryService.deleteGallery 메서드 호출");
		String fileName = null;
		String fileExt = null;
		List<GalleryFile> list = galleryFileDao.selectGalleryFileList(galleryId);
		logger.debug("list: "+list);
		for(GalleryFile galleryFile : list) {
			fileName = galleryFile.getGalleryFileName();
			fileExt = galleryFile.getGalleryFileExt();
			logger.debug("파일명: "+fileName+"."+fileExt);
			File file = new File(path+"\\"+fileName+"."+fileExt);
			logger.debug("삭제 전 파일 존재여부 확인"+file.exists());
			file.delete();
			logger.debug("삭제 후 파일 존재여부 확인"+file.exists());
		}
		galleryFileDao.deleteGalleryFile(galleryId);
		galleryDao.deleteGallery(galleryId);
	}
	
	/**
	 * 선택한 gallery의 상세내용을 출력해주는 서비스이다
	 * @param galleryId
	 * @return 선택한 gallry의 상세내용
	 */
	public List<Gallery> getGalleryOne(int galleryId) {
		logger.debug("GalleryService.getGalleryOne 메서드 호출");
		List<Gallery> list = galleryDao.selectGalleryOne(galleryId);
		logger.debug("list: "+String.valueOf(list));
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
	public List<Gallery> getGalleryList() {
		logger.debug("GalleryService.getGalleryList 메서드 호출");
		logger.debug("list: "+ galleryDao.selectGalleryList());
		return galleryDao.selectGalleryList();
	}
	
	/**
	 * gallery를 등록해주는 서비스
	 * @param galleryRequest
	 * @param path
	 */
	public void addGallery(GalleryRequest galleryRequest, String path) {
		logger.debug("GalleryService.addGallery 메서드 호출");
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
		logger.debug("gallertyFileList: "+gallery.getGalleryFile());
		for(GalleryFile file:gallery.getGalleryFile()) {
			file.setGalleryId(gallery.getGalleryId());
			galleryFileDao.insertGalleryFile(file);
		}
	}

}