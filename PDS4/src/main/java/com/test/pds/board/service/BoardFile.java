package com.test.pds.board.service;
/*
 * 데이터베이스 테이블 board_file 
 */

public class BoardFile {
	private int boardFileId; //board_file_id
	private int boardId; //board_id
	private String boardFileName; //board_file_name
	private String boardFileExt; //board_file_ext
	private String boardFileType; //board_file_type
	private int boardFileSize; //board_file_size
	public int getBoardFileId() {
		return boardFileId; 
	}
	public void setBoardFileId(int boardFileId) {
		this.boardFileId = boardFileId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardFileName() {
		return boardFileName;
	}
	public void setBoardFileName(String boardFileName) {
		this.boardFileName = boardFileName;
	}
	public String getBoardFileExt() {
		return boardFileExt;
	}
	public void setBoardFileExt(String boardFileExt) {
		this.boardFileExt = boardFileExt;
	}
	public String getBoardFileType() {
		return boardFileType;
	}
	public void setBoardFileType(String boardFileType) {
		this.boardFileType = boardFileType;
	}
	public int getBoardFileSize() {
		return boardFileSize;
	}
	public void setBoardFileSize(int boardFileSize) {
		this.boardFileSize = boardFileSize;
	}
	@Override
	public String toString() {
		return "BoardFile [boardFileId=" + boardFileId + ", boardId=" + boardId + ", boardFileName=" + boardFileName
				+ ", boardFileExt=" + boardFileExt + ", boardFileType=" + boardFileType + ", boardFileSize="
				+ boardFileSize + "]";
	}
}
