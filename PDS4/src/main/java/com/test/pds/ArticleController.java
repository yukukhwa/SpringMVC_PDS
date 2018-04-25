package com.test.pds;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.article.service.ArticleRequest;
import com.test.pds.article.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@RequestMapping(value = "/getArticleList", method = RequestMethod.GET)
	public String selectArticleList(Model model, HttpSession session) {
		String path = session.getServletContext().getRealPath("/resources/upload");
		model.addAttribute("list", articleService.selectArticleList());
		model.addAttribute("path", path);
		return "article/getArticleList";
	}
	/*
	 * insertArticle 매핑
	 * get방식으로 입력창을 foward하고
	 * post방식으로 service에 insert를 호출한 후 redirect한다.
	 */
	@RequestMapping(value = "/addArticle", method = RequestMethod.GET)
	public String insertArticle() {
		return "article/addArticle";
	}
	
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String insertArticle(ArticleRequest articleRequest) {
		articleService.insertArticle(articleRequest);
		return "redirect:/";
	}
}
