package com.test.pds;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.gallery.service.Gallery;
import com.test.pds.gallery.service.GalleryRequest;
import com.test.pds.gallery.service.GalleryService;

@Controller
public class GalleryController {
	
	private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);
	
	@Autowired private GalleryService galleryService;
	
	@RequestMapping(value="/getGalleryOne", method=RequestMethod.GET)
	public String getGalleryOne(@RequestParam(value="galleryId",required=true)int galleryId,Model model) {
		logger.debug("GalleryController.getGalleryOne get호출");
		logger.debug("galleryId: "+galleryId);
		Map<String,Object> map = galleryService.getGalleryOne(galleryId);
		model.addAttribute("gallery", map.get("gallery"));
		model.addAttribute("list", map.get("list"));
		return "gallery/getGalleryOne";
	}
	
	@RequestMapping(value="/getGalleryList", method=RequestMethod.GET)
	public String getGalleryList(Model model) {
		logger.debug("GalleryController.getGalleryList get호출");
		model.addAttribute("list", galleryService.getGalleryList());
		return "gallery/getGalleryList";
	}
	
	@RequestMapping(value="/addGallery", method=RequestMethod.POST)
	public String addGallery(GalleryRequest galleryRequest, Model model) {
		logger.debug("GalleryController.addGallery post호출");
		List<MultipartFile> list = galleryRequest.getMultipartFile();
		logger.debug("list: "+list);
		/*
		 * addGallery에서 받아온 파일리스트에서 각각의 파일 데이터 타입을 분석하여 이미지 파일인지 아닌지 구분한다
		 * 만약 하나라도 이미지 파일이 아니라면 다시 addGallery화면으로 포워딩하여 재등록하도록 유도한다
		 */
		for(MultipartFile multipartFile : list) {
			String fileType = multipartFile.getContentType();
			if(!fileType.equals("image/jpeg") && !fileType.equals("image/gif") && !fileType.equals("image/x-icon") && !fileType.equals("image/svg+xml") 
					&& !fileType.equals("image/tiff") && !fileType.equals("image/webp") && !fileType.equals("image/png") && !fileType.equals("image/bmp")) {
				logger.debug("fileType: "+fileType);
				logger.info("이미지 파일만 업로드 할 수 있습니다.");
				model.addAttribute("error", "alert('이미지 파일만 업로드 할 수 있습니다.')");
				model.addAttribute("galleryTitle", galleryRequest.getGalleryTitle());
				model.addAttribute("galleryContent", galleryRequest.getGalleryContent());
				return "gallery/addGallery";
			}
		}
		String path = SystemPath.DOWNLOAD_PATH_2;
		logger.debug("path: "+path);
		galleryService.addGallery(galleryRequest, path);
		return "redirect:/getGalleryList";
	}
	
	@RequestMapping(value="/addGallery", method=RequestMethod.GET)
	public String addGallery() {
		logger.debug("GalleryController.addGallery get호출");
		return "gallery/addGallery";
	}
}
