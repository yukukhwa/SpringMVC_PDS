package com.test.pds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pds.article.service.ArticleRequest;
import com.test.pds.article.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired private ArticleService articleService;	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

	// addArticle.jsp 에서 보낸 articleRequest 받아 입력처리 후 home으로 리다이렉트
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String insertArticle(ArticleRequest articleRequest) {
		LOGGER.debug("ArticleController insertArticle POST");
		LOGGER.debug("articleRequest : " + articleRequest);
		articleService.insertArticle(articleRequest);
		return "redirect:/";
	}
	
	// addArticle.jsp로 포워드
	@RequestMapping(value = "/addArticle", method = RequestMethod.GET)
	public String insertArticle() {
		LOGGER.debug("ArticleController insertArticle GET");
		return "article/addArticle";
	}	
}