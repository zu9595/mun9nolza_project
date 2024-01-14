package com.mun9.product.vo;

import lombok.Data;

@Data
public class PageDTO {
	private int currPage;
	private int totalCnt;
	private boolean prev, next;
	private int startPage, lastPage;
	
	public PageDTO(int page, int totalCnt) {
		this.currPage = page;
		this.totalCnt = totalCnt;

		// 이전페이지 여부, 첫 페이지, 마지막페이지, 이후페이지 여부
		int realLast = (int) Math.ceil(totalCnt / 5.0);
		this.lastPage = (int) Math.ceil(page / 5.0) * 5;
		this.startPage = this.lastPage - 4;
		this.lastPage = this.lastPage > realLast ? realLast : this.lastPage;
		
		this.prev = this.startPage > 1;
		this.next = this.lastPage < realLast;
	}
}
