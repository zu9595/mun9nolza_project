package com.mun9.orderdetail.vo;

import lombok.Data;

@Data
public class OrderDetailVO {

	private int proCode;
	private int orderNo;
	private int deProCnt;
	private int deProPrice;
	private String userId;
	private int myproCnt;
	private int myproPrice;
	private String proName;
}
