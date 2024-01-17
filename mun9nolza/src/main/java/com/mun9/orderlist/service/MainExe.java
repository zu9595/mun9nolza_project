package com.mun9.orderlist.service;

import java.util.List;

import com.mun9.orderlist.serviceImpl.OrderListServiceImpl;
import com.mun9.orderlist.vo.OrderListVO;

public class MainExe {
	public static void main(String[] args) {

		OrderListService svc = new OrderListServiceImpl();
		
		OrderListVO vo = new OrderListVO();
//		MemberVO vo2 = new MemberVO();
		List<OrderListVO> list = svc.getMyOrderList(vo.getUserId());
		
		System.out.println(vo);
		
		
//		Gson gson = new GsonBuilder().create();
//		System.out.println(gson.toJson(list));
		
		
		
	}
}
