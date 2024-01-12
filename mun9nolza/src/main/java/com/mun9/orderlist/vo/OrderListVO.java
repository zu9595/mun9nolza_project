package com.mun9.orderlist.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderListVO {

	private int orderNo;
	private String orderAddr;
	private Date orderDate;
	private int deliveryFee;
	private String userId;
	private int totalPrice;
	private String orderRecipient;
	private String orderPhone;
	private String detailAddr;
	private String deliveryMemo;
}
