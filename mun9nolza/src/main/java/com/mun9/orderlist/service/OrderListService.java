package com.mun9.orderlist.service;

import java.util.List;

import com.mun9.orderdetail.vo.OrderDetailVO;
import com.mun9.orderlist.vo.OrderListVO;

public interface OrderListService {

	List<OrderListVO> getMyOrderList(String userId);
	boolean modifyOrder (int orderNo); //주문상태->주문취소로

	boolean addOrderList(OrderListVO vo);

	boolean orderTFReview(String userId);
	
	List<OrderListVO> orderListsDe(String userId);

	List<OrderDetailVO> orderDetailBefore(String userId,int orderNo);
}
