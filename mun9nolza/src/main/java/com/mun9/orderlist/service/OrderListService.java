package com.mun9.orderlist.service;

import java.util.List;

import com.mun9.orderlist.vo.OrderDetailVO;
import com.mun9.orderlist.vo.OrderListVO;

public interface OrderListService {

	List<OrderListVO> getMyOrderList(String userId);
	//List<MyOrderDetailVO> getMyOrderDetail(int orderNo, String userId);
	boolean modifyOrder (int orderNo); //주문상태->주문취소로
	
}
