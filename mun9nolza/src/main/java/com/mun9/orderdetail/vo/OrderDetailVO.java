package com.mun9.orderdetail.vo;

import lombok.Data;

@Data
public class OrderDetailVO {

	private int orderNo;
	private int proCode;
	private int deProCnt;
	private int deProPrice;
	
	//product
	private String proName;
	private int proPrice;
	private int proDiscount;
	private String proImage;
	
}
