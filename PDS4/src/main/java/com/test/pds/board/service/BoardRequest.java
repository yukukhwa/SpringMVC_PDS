package com.test.pds.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
/*
 * board
 */
public class BoardRequest {
	private String boardTitle;
	private String boardContent;
	private MultipartFile multipartFile;
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	@Override
	public String toString() {
		return "BoardRequest [boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", multipartFile="
				+ multipartFile + "]";
	}
	
	
	
}
