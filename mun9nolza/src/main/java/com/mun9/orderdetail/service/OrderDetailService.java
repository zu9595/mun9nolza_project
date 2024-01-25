package com.mun9.orderdetail.service;

import java.util.List;

import com.mun9.orderdetail.vo.OrderDetailVO;

public interface OrderDetailService {
	boolean addOrderDetail(OrderDetailVO vo);
	List<OrderDetailVO> orderResult();
	List<OrderDetailVO> selectOrderDetailList(int orderNo);
}
