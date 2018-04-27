package com.test.pds;
public class Paging {
	private int currentPage; //현재페이지
	private int pagePerRow; //한 페이지내에 보여줄 리스트 수  
	private int totalRow; //000객체의 전체 리스트 수 
	private int totalPage; //최종페이지(페이지총개수) 
	private int beginRow; //데이터베이스에서 첫번째로 보여 줄 000객체의 게시글시작 넘버
	private int startPage; //한 페이지 블럭 내 시작 페이지
	private int endPage; //한 페이지 블럭 내 마지막 페이지
	private int currentBlock; //현재페이지블럭
	private int lastBlock; //마지막페이지블럭
	private final int PAGEPERBLOCK = 5; //페이지묶음단위
	
	public Paging(int totalRow, int pagePerRow, int currentPage) {
		setTotalRow(totalRow);
		setPagePerRow(pagePerRow);
		setCurrentPage(currentPage);
		setTotalPage();
		setBeginRow();
		setCurrentBlock();
		setLastBlock();
		setStartPage();
		setEndPage();
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPagePerRow() {
		return pagePerRow;
	}
	public void setPagePerRow(int pagePerRow) {
		this.pagePerRow = pagePerRow;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {
		this.totalPage = totalRow/pagePerRow;
		if(totalRow%pagePerRow != 0) {
			++this.totalPage;
		}
	}
	public int getBeginRow() {
		return beginRow;
	}
	public void setBeginRow() {
		this.beginRow = (currentPage-1)*pagePerRow;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage() {
		this.startPage = currentBlock*PAGEPERBLOCK-(PAGEPERBLOCK-1);
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage() {
		this.endPage = startPage+(PAGEPERBLOCK-1);
		if(currentBlock==lastBlock) {
			endPage=totalPage;
		}
	}
	public int getCurrentBlock() {
		return currentBlock*PAGEPERBLOCK-(PAGEPERBLOCK-1);
	}
	public void setCurrentBlock() {
		this.currentBlock = currentPage/PAGEPERBLOCK;
		if(currentPage%PAGEPERBLOCK != 0) {
			++this.currentBlock;
		}
	}
	public int getLastBlock() {
		return lastBlock;
	}
	public void setLastBlock() {
		this.lastBlock = totalPage/PAGEPERBLOCK;
		if(totalPage%PAGEPERBLOCK !=0) {
			++this.lastBlock;
		}
	}
	@Override
	public String toString() {
		return "Paging [currentPage=" + currentPage + ", pagePerRow=" + pagePerRow + ", totalRow=" + totalRow
				+ ", totalPage=" + totalPage + ", beginRow=" + beginRow + ", startPage=" + startPage + ", endPage="
				+ endPage + ", currentBlock=" + currentBlock + ", lastBlock=" + lastBlock + "]";
	}
	
}
