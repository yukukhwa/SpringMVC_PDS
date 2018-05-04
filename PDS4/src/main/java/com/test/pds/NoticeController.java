package com.test.pds;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.pds.notice.service.Notice;
import com.test.pds.notice.service.NoticeFile;
import com.test.pds.notice.service.NoticeRequest;
import com.test.pds.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired private NoticeService noticeService;
		private final static Logger LOGGER = LoggerFactory.getLogger(NoticeController.class);
		
		@RequestMapping(value="updateNotice", method=RequestMethod.POST)
		public String updateNotice() {
			LOGGER.debug("NoticeController.updateNotice POST 호출");
			return "redirect:/getNoticeList";
		}
		
		// 수정화면폼으로 가서 수정화면에 해당 notice정보들을 가져오기
		@RequestMapping(value="/updateNotice", method=RequestMethod.GET)
		public String updateNotice(int noticeId, Model model) {
			LOGGER.debug("NoticeController.updateNotice GET 호출");
			List<Notice> list = noticeService.selectNoticeOne(noticeId);
			System.out.println("무엇이 들어있을까요?LIST ===>"+list);
			model.addAttribute("noticeTitle", list.get(0).getNoticeTitle());
			model.addAttribute("noticeContent", list.get(0).getNoticeContent());
			model.addAttribute("noticeFile", list.get(0).getNoticeFile());
			model.addAttribute("noticeId", list.get(0).getNoticeId());
			return "notice/updateNotice";
		}
		
		// 삭제
		@RequestMapping(value="/deleteNotice", method=RequestMethod.GET)
		public String deleteNotice(@RequestParam(value="noticeId") int noticeId) {
			
			System.out.println("NoticeController notice===>"+noticeId);
			LOGGER.debug("noticeController.deleteNotice 호출");
			noticeService.deleteNotice(noticeId);
			return "redirect:/getNoticeList";
		}
		  
		//상세보기
		@RequestMapping(value="/getNoticeOne", method=RequestMethod.GET)
		public String getNoticeOne(int noticeId, Model model) {
			LOGGER.debug("NoticeContent.getNoticeOne 호출");
			System.out.println("selectNoticeOne 컨트롤러 매개변수 noticeId==>"+noticeId);
			List<Notice> list = noticeService.selectNoticeOne(noticeId);
			System.out.println("NoticeController의 list===>"+list);
			model.addAttribute("noticeFile",list.get(0).getNoticeFile());
			model.addAttribute("noticeTitle",list.get(0).getNoticeTitle());
			model.addAttribute("noticeContent",list.get(0).getNoticeContent());
			model.addAttribute("noticeId",list.get(0).getNoticeId());
			return "notice/getNoticeOne";
		}
		
		/* getNoticeList에서 get으로 요청받아 notice/getNoticeList로 포워드한다
		 * 페이징하기 위해 currentPage와 pagePerRow를 받아 Service에 넘겨 서비스에서 페이징처리한다.*/
		@RequestMapping(value="/getNoticeList", method=RequestMethod.GET)
		public String getNoticeList(Model model
									,@RequestParam(value="currentPage", defaultValue="1") int currentPage
									,@RequestParam(value="pagePerRow", defaultValue="10") int pagePerRow) {
			LOGGER.debug("NoticeController.getNoticeList 호출");
			Map<String, Object> map = noticeService.selectNoticeList(currentPage, pagePerRow);
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("pagePerRow",pagePerRow);
			model.addAttribute("list", map.get("list"));
			System.out.println("컨트롤러 맵: "+map.get("list"));
			model.addAttribute("lastPage",map.get("lastPage"));
			return "notice/getNoticeList";
		}
		
		// addNotice에서 post요청받아 addNotice.jsp로 리다이렉트 한다
		@RequestMapping(value="/addNotice", method=RequestMethod.POST)
		public String insertNotice(NoticeRequest noticeRequest, HttpSession session) {
			LOGGER.debug("NoticeController insertNotice Post");
			LOGGER.debug("noticeRequest: "+noticeRequest.toString());
			// 업로드 폴더의 실제 경로를 얻어온다
			String path = session.getServletContext().getRealPath("\\resources\\upload");
			LOGGER.debug("path: "+path);
			//noticeService의 insertNotice메서드 매개변수로noticeRequest와 path를 넘겨준다
			noticeService.insertNotice(noticeRequest, path);
			return "redirect:/getNoticeList";
		}
		
		// addNotice에서 get요청을 받아 addNotice.jsp로 포워드한다
		@RequestMapping(value="/addNotice", method=RequestMethod.GET)
		public String insertNotice() {
			LOGGER.debug("NoticeController insertNotice Get");
			return "notice/addNotice";
			
		}
}
