package com.mun9.orderlist.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.orderdetail.vo.OrderDetailVO;
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
	public List<OrderListVO> orderListAdmin() {
		return mapper.selectAdminOrderList();
	}

	@Override
	public boolean modifyOrder(int orderNo) {
		return mapper.updateOrderList(orderNo) == 1;
	}

	@Override
	public boolean addOrderList(OrderListVO vo) {
		return mapper.insertOrderList(vo) > 0;
	}
	
	@Override
	public boolean orderTFReview(String userId) {
		// TODO Auto-generated method stub
		return mapper.selectOrderReview(userId) > 0;
	}

	@Override
	public List<OrderListVO> orderListsDe(String userId) {
		// TODO Auto-generated method stub
		return mapper.orderListsDe(userId);
	}

	@Override
	public List<OrderDetailVO> orderDetailBefore(OrderDetailVO vo) {
		// TODO Auto-generated method stub
		return mapper.orderDetailBefore(vo);
	}

	
}
