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
import com.test.pds.resume.service.Resume;

@Controller
public class ArticleController {
	@Autowired private ArticleService articleService;	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	
	// updateArticle.jsp POST
	@RequestMapping(value="/updateArticle", method=RequestMethod.POST)
	public String updateArticle(Article article, Model model) {
		LOGGER.debug("updateArticle POST 호출");
		LOGGER.debug("입력받은article: "+article);
		articleService.updateArticle(article);
		model.addAttribute("articleId", article.getArticleId());
		return "redirect:/getArticleOne";
	}
		
	// updateArticle.jsp GET
	@RequestMapping(value="/updateArticle", method=RequestMethod.GET)
	public String updateArticle(Model model,
								@RequestParam(value="articleId", required=true) int articleId) {	
		LOGGER.debug("updateArticle GET 호출");
		LOGGER.debug("받은 아이디: "+articleId);
		List<Article> list = articleService.selectArticleOne(articleId);
		LOGGER.debug("list: "+list);
		model.addAttribute("articleId", list.get(0).getArticleId());
		model.addAttribute("articleTitle", list.get(0).getArticleTitle());
		model.addAttribute("articleContent", list.get(0).getArticleContent());
		model.addAttribute("articleFilelist", list.get(0).getArticleFile());	
		return "article/updateArticle";
	}
	
	// delete Article GET
	@RequestMapping(value="/deleteArticle", method=RequestMethod.GET)
	public String deleteArticle(Article article,
								@RequestParam(value="articleId") int articleId) {
		LOGGER.debug("ArticleController deleteArticle GET");
		articleService.deleteArticle(article);
		return "redirect:/getArticleList";
	}
	
	// getArticleOne GET
	@RequestMapping(value="/getArticleOne", method=RequestMethod.GET)
	public String selectArticleOne(Model model,
									@RequestParam(value="articleId", required=true) int articleId) {
		LOGGER.debug("ArticleController selectArticleOne GET");
		LOGGER.debug("받은 아이디: "+articleId);
		List<Article> list = articleService.selectArticleOne(articleId);
		model.addAttribute("articleId", list.get(0).getArticleId());
		model.addAttribute("articleTitle", list.get(0).getArticleTitle());
		model.addAttribute("articleContent", list.get(0).getArticleContent());
		model.addAttribute("articleFilelist", list.get(0).getArticleFile());		
		return "article/getArticleOne";
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