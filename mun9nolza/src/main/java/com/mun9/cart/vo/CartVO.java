package com.mun9.cart.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	private int orderNo;
}

//