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

import com.test.pds.article.service.Article;
import com.test.pds.resume.service.Resume;
import com.test.pds.resume.service.ResumeRequest;
import com.test.pds.resume.service.ResumeService;

@Controller
public class ResumeController {	
	@Autowired private ResumeService resumeService;
	final private Logger LOGGER = LoggerFactory.getLogger(ResumeController.class);	
	
	// delete Resume GET
		@RequestMapping(value="/deleteResume", method=RequestMethod.GET)
		public String deleteResume(Resume resume,
									@RequestParam(value="resumeId") int resumeId) {
			LOGGER.debug("ResumeController deleteResume GET");
			resumeService.deleteResume(resume);
			return "redirect:/getResumeList";
		}
	// updateResume.jsp POST
	@RequestMapping(value="/updateResume", method=RequestMethod.POST)
	public String updateResume(Resume resume, Model model) {
		LOGGER.debug("updateResume POST 호출");
		LOGGER.debug("입력받은resume: "+resume);
		resumeService.updateResume(resume);
		model.addAttribute("resumeId", resume.getResumeId());
		return "redirect:/getResumeOne";
	}
	
	// updateResume.jsp GET
	@RequestMapping(value="/updateResume", method=RequestMethod.GET)
	public String updateResume(Model model,
								@RequestParam(value="resumeId") int resumeId) {	
		LOGGER.debug("updateResume GET 호출");
		LOGGER.debug("받은 아이디: "+resumeId);
		model.addAttribute("resume", resumeService.selectResumeOne(resumeId));		
		return "resume/updateResume";
	}
	
	
	// getResumeOne.jsp GET
	@RequestMapping(value="/getResumeOne", method=RequestMethod.GET)
	public String selectResumeOne(Model model,
									@RequestParam(value="resumeId") int resumeId){
		LOGGER.debug("selectResumeOne GET 호출");
		LOGGER.debug("받은 아이디: "+resumeId);
		model.addAttribute("resume", resumeService.selectResumeOne(resumeId));
		return "resume/getResumeOne";
	}
	
	// getResumeList.jsp GET
	@RequestMapping(value="/getResumeList", method=RequestMethod.GET)
	public String selectResumeList(Model model,
									@RequestParam(value="currentPage", defaultValue="1") int currentPage,
									@RequestParam(value="pagePerRow", defaultValue="3") int pagePerRow) {
		LOGGER.debug("selectResumeList GET 호출");
		LOGGER.debug("커렌트 : " + currentPage, "페이지퍼 : " + pagePerRow);
		Map<String, Object> map = resumeService.selectResumeList(currentPage, pagePerRow);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("pageList", map.get("pageList"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("pagePerRow", map.get("pagePerRow"));
		model.addAttribute("currentPage", map.get("currentPage"));
		
		return "resume/getResumeList";
	}	
	
	// addResume.jsp POST
	@RequestMapping(value="/addResume", method=RequestMethod.POST)
	public String insertResume(ResumeRequest resumeRequest) {
		LOGGER.debug("insertResume POST 호출");
		// resume 과 resume_file 은 1:1 관계
		// resumeRequest에 담긴 파일의 파일타입이 조건문과 같다면 입력처리 성공 후 리턴
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
	
	// addResume.jsp GET
	@RequestMapping(value="/addResume", method=RequestMethod.GET)
	public String insertResume() {
		LOGGER.debug("insertResume GET 호출");
		return "resume/addResume";	
	}
}