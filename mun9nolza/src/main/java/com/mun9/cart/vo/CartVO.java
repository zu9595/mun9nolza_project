package com.mun9.cart.vo;

import lombok.Data;

@Data
public class CartVO {

	private String userId; 
	private int myproNo; //장바구니상품번호
	private int proCode;
	private String proImage;
	private String proName;
	private int proPrice;
	private int proDiscount;
	private int myproCnt;
	private int myproPrice;
	
}
