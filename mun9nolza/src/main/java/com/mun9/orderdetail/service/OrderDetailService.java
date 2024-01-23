package com.mun9.orderdetail.service;

import java.util.List;

import com.mun9.cart.vo.CartVO;
import com.mun9.orderdetail.vo.OrderDetailVO;

public interface OrderDetailService {
	OrderDetailVO addOrderDetail(CartVO vo);

	List<OrderDetailVO> selectOrderDetailList(String userId);
}
