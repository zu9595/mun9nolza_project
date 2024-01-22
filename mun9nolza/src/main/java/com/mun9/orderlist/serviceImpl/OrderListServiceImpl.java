package com.mun9.orderlist.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.orderlist.mapper.OrderListMapper;
import com.mun9.orderlist.service.OrderListService;
import com.mun9.orderlist.vo.OrderListVO;

public class OrderListServiceImpl implements OrderListService{

	SqlSession session = DataSource.getInstance().openSession(true);
	OrderListMapper mapper = session.getMapper(OrderListMapper.class);
	
	@Override
	public List<OrderListVO> getMyOrderList(String userId) {
		return mapper.selectMyOrderList(userId);
	}

	@Override
	public boolean modifyOrder(int orderNo) {
		return mapper.updateOrderList(orderNo) == 1;
	}

	@Override
	public boolean addOrderList(OrderListVO vo) {
		return mapper.insertOrderList(vo) == 1;
	}
	
	@Override
	public boolean orderTFReview(String userId) {
		// TODO Auto-generated method stub
		return mapper.selectOrderReview(userId) > 0;
	}
	
}
