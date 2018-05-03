package com.test.pds;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.article.service.Article;
import com.test.pds.article.service.ArticleRequest;
import com.test.pds.article.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired private ArticleService articleService;	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	
	// delete Article GET
	@RequestMapping(value="/deleteArticle", method=RequestMethod.GET)
	public String deleteArticle(Article article,
								@RequestParam(value="articleId") int articleId) {
		LOGGER.debug("ArticleController deleteArticle GET");
		articleService.deleteArticle(article);
		return "redirect:/getArticleList";
	}
	
	// getArticleOne GET
	// 파일이 여러개일 경우 마지막 레코드만 출력되는 문제가....있음
	@RequestMapping(value="/getArticleOne", method=RequestMethod.GET)
	public String selectArticleOne(Model model, Article article, 
									@RequestParam(value="articleId") int articleId) {
		LOGGER.debug("ArticleController selectArticleOne GET");		
		LOGGER.debug("article.articleId : " + article.getArticleId());
		model.addAttribute("list", articleService.selectArticleOne(article));
		return "article/getArticle";
	}	
	
	// getArticleList.jsp 포워드
	// file이 있는 레코드만 출력
	@RequestMapping(value="/getArticleList", method=RequestMethod.GET)
	public String selectArticleList(Model model,
									@RequestParam(value="currentPage", defaultValue="1") int currentPage,
									@RequestParam(value="pagePerRow", defaultValue="3") int pagePerRow) {
		LOGGER.debug("selectArticleList GET 호출");
		Map<String, Object> map = articleService.selectArticleList(currentPage, pagePerRow);
		// model에 매핑 풀어서 넘겨주기
		model.addAttribute("list", map.get("list"));
		model.addAttribute("pageList", map.get("pageList"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("pagePerRow", map.get("pagePerRow"));
		model.addAttribute("currentPage", map.get("currentPage"));
		return "article/getArticleList";
	}	
	
	// addArticle.jsp POST
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String insertArticle(ArticleRequest articleRequest, Model model) {
		LOGGER.debug("insertArticle POST 호출");
		LOGGER.debug("articleRequest: "+articleRequest);
		List<MultipartFile> list = articleRequest.getMultipartFile();
		LOGGER.debug("filelist: "+list);
		articleService.insertArticle(articleRequest);
		return "redirect:/";
	}
	
	// addArticle.jsp GET
	@RequestMapping(value = "/addArticle", method = RequestMethod.GET)
	public String insertArticle() {
		LOGGER.debug("insertArticle GET호출");
		return "article/addArticle";
	}	
}