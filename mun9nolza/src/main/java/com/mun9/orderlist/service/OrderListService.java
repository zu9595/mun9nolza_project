package com.mun9.orderlist.service;

import java.util.List;

import com.mun9.orderlist.vo.OrderListVO;

public interface OrderListService {

	List<OrderListVO> getMyOrderList(String userId);
	
}
