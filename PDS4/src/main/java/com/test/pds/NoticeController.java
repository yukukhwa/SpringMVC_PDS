package com.test.pds;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.notice.service.Notice;
import com.test.pds.notice.service.NoticeRequest;
import com.test.pds.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired private NoticeService noticeService;
		private final static Logger logger = LoggerFactory.getLogger(NoticeController.class);
		
		// getNoticeList에서 get으로 요청받아 notice/getNoticeList로 포워드한다
		@RequestMapping(value="/getNoticeList", method=RequestMethod.GET)
		public String getNoticeList(Model model) {
			logger.debug("NoticeController.getNoticeList 호출");
			List<Notice> list = noticeService.selectNoticeList();
			System.out.println("List<Notice>: "+list);
			model.addAttribute("list", list);
			return "notice/getNoticeList";
		}
		
		// addNotice에서 post요청받아 addNotice.jsp로 리다이렉트 한다
		@RequestMapping(value="/addNotice", method=RequestMethod.POST)
		public String insertNotice(NoticeRequest noticeRequest, HttpSession session) {
			logger.debug("NoticeController insertNotice Post");
			logger.debug("noticeRequest: "+noticeRequest.toString());
			// 업로드 폴더의 실제 경로를 얻어온다
			String path = session.getServletContext().getRealPath("\\resources\\upload");
			logger.debug("path: "+path);
			//noticeService의 insertNotice메서드 매개변수로noticeRequest와 path를 넘겨준다
			noticeService.insertNotice(noticeRequest, path);
			return "redirect:/getNoticeList";
		}
		
		// addNotice에서 get요청을 받아 addNotice.jsp로 포워드한다
		@RequestMapping(value="/addNotice", method=RequestMethod.GET)
		public String insertNotice() {
			logger.debug("NoticeController insertNotice Get");
			return "notice/addNotice";
			
		}
}
