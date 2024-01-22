package com.mun9.orderlist.vo;

import java.util.List;

import lombok.Data;

@Data
public class OrderListVO {

	private int orderNo;
	private String orderDate;
	private String orderRecipient;
	private String orderAddr;
	private String detailAddr;
	private String orderPhone;
	private String userId;
	private int totalPrice;
	private int deliveryFee;
	private String deliveryMemo;
	private String orderStatus;
	
    List<OrderDetailVO> detailList;
}

