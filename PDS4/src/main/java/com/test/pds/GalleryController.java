package com.test.pds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.gallery.service.GalleryRequest;

@Controller
public class GalleryController {
	
	private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);
	
	@RequestMapping(value="/addGallery", method=RequestMethod.GET)
	public String addGallery(GalleryRequest galleryRequest) {
		logger.debug("GalleryController.addGallery post호출");
		for(MultipartFile multipartFile : galleryRequest.getList()) {
			String fileType = multipartFile.getContentType();
			if(fileType.equals("image/jpeg") 
				|| fileType.equals("image/gif") 
				|| fileType.equals("image/x-icon") 
				|| fileType.equals("image/svg+xml") 
				|| fileType.equals("image/tiff") 
				|| fileType.equals("image/webp") 
				|| fileType.equals("image/png") 
				|| fileType.equals("image/bmp")) {
				
			}else {
				return "gallery/addGallery";
			}
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/addGallery", method=RequestMethod.GET)
	public String addGallery() {
		logger.debug("GalleryController.addGallery get호출");
		return "gallery/addGallery";
	}
}
