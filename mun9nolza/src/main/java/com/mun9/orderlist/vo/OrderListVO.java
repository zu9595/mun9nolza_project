package com.mun9.orderlist.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderListVO {

	private int orderNo;
	private Date orderDate;
	private String userId;
	private int procode;
	private String orderRecipient;
	private String orderAddr;
	private String detailAddr;
	private String orderPhone;
	private int totalPrice;
	private int deliveryFee;
	private String deliveryMemo;
	private String orderStatus;
	
	private String proImage;
	private String proName;
	private int deProCnt;
}

