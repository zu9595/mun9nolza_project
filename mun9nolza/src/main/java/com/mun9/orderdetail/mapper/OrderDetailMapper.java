package com.mun9.orderdetail.mapper;

import java.util.List;

import com.mun9.orderdetail.vo.OrderDetailVO;

public interface OrderDetailMapper {
	int insertOrderDetail(OrderDetailVO vo);
	List<OrderDetailVO> selectOrderResult();
	List<OrderDetailVO> selectOrderDetailList(int orderNo);
	
	int adminOrderDetailMod(OrderDetailVO vo);
	int adminOrderDetailDel(OrderDetailVO vo);
}
