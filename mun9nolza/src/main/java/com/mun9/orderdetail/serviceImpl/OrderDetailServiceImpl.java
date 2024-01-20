package com.mun9.orderdetail.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.orderdetail.mapper.OrderDetailMapper;
import com.mun9.orderdetail.service.OrderDetailService;
import com.mun9.orderlist.vo.OrderListVO;

public class OrderDetailServiceImpl implements OrderDetailService {
	SqlSession session = DataSource.getInstance().openSession(true);
	OrderDetailMapper mapper = session.getMapper(OrderDetailMapper.class);
	
	@Override
	public boolean addOrder(OrderListVO vo) {
		return mapper.insertOrder(vo) == 1;
	}

}
