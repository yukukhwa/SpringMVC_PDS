package com.test.pds;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.notice.service.NoticeRequest;
import com.test.pds.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired private NoticeService noticeService;
		
		private final static Logger logger = LoggerFactory.getLogger(NoticeController.class);
		
		@RequestMapping(value="/addNotice", method=RequestMethod.POST)
		public String addNotice(NoticeRequest noticeRequest,HttpSession session) {
			logger.debug("NoticeController addNotice Post");
			logger.debug("noticeRequest: "+noticeRequest.toString());
			// session을 만들어주는 톰캣위치를 알려줘 path에 담는다
			String path = session.getServletContext().getRealPath("\\resources\\upload");
			logger.debug("path: "+path);
			noticeService.addNotice(noticeRequest, path);
			return "redirect:/addNotice";
		}
		
		// addNotice에서 get요청을 받아 addNotice.jsp로 포워딩한다
		@RequestMapping(value="/addNotice", method=RequestMethod.GET)
		public String addNotice() {
			logger.debug("NoticeController addNotice Get");
			return "addNotice";
			
		}
}
