package com.test.pds.article.service;

import java.util.ArrayList;
import java.util.List;

/*
 * article table
 */
public class Article {
	private int articleId;
	private String articleTitle;
	private String articleContent;
	/*
	 * join article_file table
	 */
	private List<ArticleFile> articleFile;
	
	/*
	 * List<ArticleFile> 생성자 메서드
	 * Article객체 생성하면서 ArticleFile list담을 객체도 생성한다.
	 */
	public Article() {
		this.articleFile = new ArrayList<ArticleFile>();
	}
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public List<ArticleFile> getArticleFile() {
		return articleFile;
	}
	public void setArticleFile(List<ArticleFile> articleFile) {
		this.articleFile = articleFile;
	}
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle=" + articleTitle + ", articleContent="
				+ articleContent + "]";
	}	
}