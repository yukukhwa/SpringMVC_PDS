package com.test.pds;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.gallery.service.GalleryRequest;
import com.test.pds.gallery.service.GalleryService;

@Controller
public class GalleryController {
	
	private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);
	
	@Autowired private GalleryService galleryService;
	
	@RequestMapping(value="/addGallery", method=RequestMethod.POST)
	public String addGallery(GalleryRequest galleryRequest, Model model) {
		logger.debug("GalleryController.addGallery post호출");
		List<MultipartFile> list = galleryRequest.getMultipartFile();
		logger.debug("list: "+list);
		for(MultipartFile multipartFile : list) {
			String fileType = multipartFile.getContentType();
			if(!fileType.equals("image/jpeg") && !fileType.equals("image/gif") && !fileType.equals("image/x-icon") && !fileType.equals("image/svg+xml") 
					&& !fileType.equals("image/tiff") && !fileType.equals("image/webp") && !fileType.equals("image/png") && !fileType.equals("image/bmp")) {
				logger.debug("fileType: "+fileType);
				logger.info("이미지 파일만 업로드 할 수 있습니다.");
				model.addAttribute("error", "이미지 파일만 업로드 할 수 있습니다.");
				return "gallery/addGallery";
			}
		}
		String path = SystemPath.DOWNLOAD_PATH_2;
		logger.debug("path: "+path);
		galleryService.addGallery(galleryRequest, path);
		return "redirect:/";
	}
	
	@RequestMapping(value="/addGallery", method=RequestMethod.GET)
	public String addGallery() {
		logger.debug("GalleryController.addGallery get호출");
		return "gallery/addGallery";
	}
}
