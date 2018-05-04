package com.test.pds.article.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.test.pds.Paging;
import com.test.pds.SystemPath;

@Service
@Transactional
public class ArticleService {	
	@Autowired private ArticleDao articleDao;
	@Autowired private ArticleFileDao articleFileDao;	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);
	
	// Article 삭제
	public void deleteArticle(Article article) {
		LOGGER.debug("deleteArticle 호출");
		ArticleFile articleFile = new ArticleFile();
		articleFile.setArticleId(article.getArticleId());
		articleDao.deleteArticle(articleFileDao.deleteArticleFile(articleFile));
	}
	
	// Article update
	public int updateArticle(Article article) {
		LOGGER.debug("updateArticle 호출");		
		return articleDao.updateArticle(article);
	}
	
	// Article 셀렉트원
	public List<Article> selectArticleOne(int articleId) {
		LOGGER.debug("selectArticleOne 호출");
		List<Article> list = articleDao.selectArticleOne(articleId);
		LOGGER.debug("리절트맵: "+String.valueOf(list));
		return list;
	}
	
	// Article 리스트
	public Map<String, Object> selectArticleList(int currentPage, int pagePerRow) {
		LOGGER.debug("selectArticleList 호출");
		int totalRow = articleDao.countAtricleList();
		// 페이징 메서드  Paging(totalRow, pagePerRow, currentPage)		
		Paging paging = new Paging(totalRow, pagePerRow, currentPage);

		List<Integer> pagelist = new ArrayList<Integer>();
		if(totalRow != 0) { // 레코드가 있으면
			for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { // 1~5, 6~10, ...
				pagelist.add(i);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", articleDao.selectArticleList(paging));
		map.put("pageList", pagelist);
		map.put("totalPage", paging.getTotalPage());
		map.put("pagePerRow", pagePerRow);
		map.put("currentPage", currentPage);		
		return map;
	}

	// Article 등록(제목,내용 + 파일 업로드)
	public void insertArticle(ArticleRequest articleRequest) {
		LOGGER.debug("insertArticle 호출");		
		// 입력으로 쓸 객체 article 세팅(id(auto), title, content, articlefile)
		Article article = new Article();
		article.setArticleTitle(articleRequest.getArticleTitle());
		article.setArticleContent(articleRequest.getArticleContent());		
		// article id, title, content 인서트
		int articleRow = articleDao.insertArticle(article);	
		LOGGER.debug("articleId: "+articleRow);
		// file데이터 담을 multipartFile객체를 생성
		List<MultipartFile> list = articleRequest.getMultipartFile();		
		// article_id당 여러개의 파일이 올라가야 하니까 리스트[0] 올리고, 리스트[1] 올리고, ... 리스트[N]까지.
		for(MultipartFile multipartFile : list){
			// multipartFile 에 세팅된 데이터 담을 articleFile
			ArticleFile articleFile = new ArticleFile();
			
			// 파일이름
			UUID uuid = UUID.randomUUID(); // 중복되는 이름을 가질수 없도록 자동으로 이름을 생성해주는 api
			String fileName = uuid.toString();
			fileName = fileName.replace("-", ""); // - 을 (없음)으로 리플레이스
			
			// 파일 확장자
			int dotIndex = multipartFile.getOriginalFilename().lastIndexOf("."); // 오리지널 네임의 마지막.을 찾아서 몇번째인지 담음 
			String fileExt = multipartFile.getOriginalFilename().substring(dotIndex+1); // 마지막 . 다음에 붙일 확장자명
			
			// 파일 컨텐트 타입
			String fileType = multipartFile.getContentType();
			
			// 파일 사이즈
			long fileSize = multipartFile.getSize();
			
			// 파일 저장(path를 이용)
			File file = new File(SystemPath.DOWNLOAD_PATH_1+"\\"+fileName+"."+fileExt);
			try {
				multipartFile.transferTo(file); // 쉽게 알아볼 수 있는 파일명으로 변환해줌
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			articleFile.setArticleFileName(fileName);
			articleFile.setArticleFileExt(fileExt);
			articleFile.setArticleFileType(fileType);
			articleFile.setArticleFileSize((int) fileSize);			
			
			articleFile.setArticleId(articleRow);
			LOGGER.debug("articleFile: "+articleFile);
			articleFileDao.insertArticleFile(articleFile);
		}
	}
}
