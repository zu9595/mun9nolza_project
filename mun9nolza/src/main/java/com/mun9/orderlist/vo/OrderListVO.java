package com.mun9.orderlist.vo;

import java.util.Date;
import java.util.List;

import com.mun9.orderdetail.vo.OrderDetailVO;

import lombok.Data;

@Data
public class OrderListVO {

	private int orderNo;
	private Date orderDate;
	private String userId;
	private String orderRecipient;
	private String orderAddr;
	private String detailAddr;
	private String orderPhone;
	private int totalPrice;
	private int deliveryFee;
	private String deliveryMemo;
	private String orderStatus;
	
	private String proName;
	
	
	
	
    List<OrderDetailVO> detailList;
}

