package com.mun9.orderdetail.mapper;

import java.util.List;

import com.mun9.cart.vo.CartVO;
import com.mun9.orderdetail.vo.OrderDetailVO;

public interface OrderDetailMapper {
	OrderDetailVO insertOrderDetail(CartVO vo);
	
	List<OrderDetailVO> selectOrderDetailList(String userId);
}
