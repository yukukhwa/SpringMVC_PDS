package com.test.pds;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.resume.service.ResumeRequest;
import com.test.pds.resume.service.ResumeService;

@Controller
public class ResumeController {	
	@Autowired private ResumeService resumeService;
	final private Logger LOGGER = LoggerFactory.getLogger(ResumeController.class);
	
	// getResumeList.jsp 포워드
	@RequestMapping(value="/getResumeList", method=RequestMethod.GET)
	public String selectResumeList(Model model,
									@RequestParam(value="currentPage", defaultValue="1") int currentPage,
									@RequestParam(value="pagePerRow", defaultValue="3") int pagePerRow) {
		LOGGER.debug("selectResumeList GET 호출");
		Map<String, Object> map = resumeService.selectResumeList(currentPage, pagePerRow);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("pageList", map.get("pageList"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("pagePerRow", map.get("pagePerRow"));
		model.addAttribute("currentPage", map.get("currentPage"));
		LOGGER.debug("리스트 : " + map.get("list"));
		return "resume/getResumeList";
	}	
	
	// addResume에서 입력받은 resumeRequest 세팅해서 서비스 호출하고 home으로 리다이렉트	
	@RequestMapping(value="/addResume", method=RequestMethod.POST)
	public String insertResume(ResumeRequest resumeRequest) {
		LOGGER.debug("insertResume POST 호출");
		// resume 과 resume_file 은 1:1 관계
		// resumeRequest에 담긴 파일의 파일타입이 마임타입과 같다면 입력처리 성공 후 리턴
		// 아니면 입력화면으로 리다이렉트	
		String fileType = resumeRequest.getMultipartfile().getContentType();
		if(fileType.equals("image/jpeg") 
			|| fileType.equals("image/gif") 
			|| fileType.equals("image/x-icon") 
			|| fileType.equals("image/svg+xml") 
			|| fileType.equals("image/tiff") 
			|| fileType.equals("image/webp") 
			|| fileType.equals("image/png") 
			|| fileType.equals("image/bmp")) {				
		} else {
			LOGGER.info("업로드한 파일 타입이 이미지가 아닙니다.");
			return "resume/addResume";
		}								
		resumeService.insertResume(resumeRequest);
		return "redirect:/";	
	}	
	
	// addResume.jsp 포워드
	@RequestMapping(value="/addResume", method=RequestMethod.GET)
	public String insertResume() {
		LOGGER.debug("insertResume GET 호출");
		return "resume/addResume";	
	}
}