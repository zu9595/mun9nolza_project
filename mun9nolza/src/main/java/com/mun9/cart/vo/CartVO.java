package com.mun9.cart.vo;

import lombok.Data;

@Data
public class CartVO {

	private int myproNo; //장바구니상품번호
	private String userId; //
	private int proCode;
	private int myproPrice;
	private int myproCnt;
}
