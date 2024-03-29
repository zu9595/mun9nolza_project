package com.mun9.orderlist.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderListVO {

	private int orderNo;
	private Date orderDate;
	private String orderRecipient;
	private String orderAddr;
	private String detailAddr;
	private String orderPhone;
	private String userId;
	private int totalPrice;
	private int deliveryFee;
	private String deliveryMemo;
	private String orderStatus;
	private int myproCnt;
	private int proCode;
	
	

	
    List<OrderDetailVO> detailList;
}

