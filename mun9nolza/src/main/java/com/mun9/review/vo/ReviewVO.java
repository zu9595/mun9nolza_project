package com.mun9.review.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {

	private int reNo;
	private int orderNo;
	private int proCode;
	private String userId;
	private String reTitle;
	private Date reDate;
	private String reContent;
	private String reImage;
	private int reRate;
	private int page;
}
