package com.mun9.orderdetail.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.cart.vo.CartVO;
import com.mun9.common.DataSource;
import com.mun9.orderdetail.mapper.OrderDetailMapper;
import com.mun9.orderdetail.service.OrderDetailService;
import com.mun9.orderdetail.vo.OrderDetailVO;

public class OrderDetailServiceImpl implements OrderDetailService {
	SqlSession session = DataSource.getInstance().openSession(true);
	OrderDetailMapper mapper = session.getMapper(OrderDetailMapper.class);
	
	@Override
	public OrderDetailVO addOrderDetail(OrderDetailVO vo) {
		return mapper.insertOrderDetail(vo);
	}

	@Override
	public List<OrderDetailVO> selectOrderDetailList(int orderNo) {
		return mapper.selectOrderDetailList(orderNo);
	}
}
