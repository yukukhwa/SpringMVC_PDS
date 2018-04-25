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
	@Autowired private ArticleService articleService;	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
		
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
