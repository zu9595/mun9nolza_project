package com.mun9.inquire.vo;

import java.util.Date;

import lombok.Data;

@Data
public class InquireVO {

	private int inqNo;
	private String userId;
	private int proCode;
	private String inqTitle;
	private String inqContent;
	private Date inqDate;
	private String inqImg;
	private String answer;
	private String prodName;	
	private int page;	
}
