package com.mun9.orderdetail.service;

import java.util.List;

import com.mun9.orderdetail.vo.OrderDetailVO;
import com.mun9.orderlist.vo.OrderListVO;

public interface OrderDetailService {
	boolean addOrderDetail(OrderDetailVO vo);
	List<OrderDetailVO> orderResult();
	List<OrderDetailVO> selectOrderDetailList(int orderNo);
	
	boolean modOrderDetail(OrderDetailVO vo);
}
