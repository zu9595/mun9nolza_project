package com.mun9.cart.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.cart.mapper.CartMapper;
import com.mun9.cart.service.CartService;
import com.mun9.cart.vo.CartVO;
import com.mun9.common.DataSource;

public class CartServiceImpl implements CartService{
	SqlSession session = DataSource.getInstance().openSession(true);
	CartMapper mapper = session.getMapper(CartMapper.class);
	
	@Override
	public List<CartVO> selectCartList(String userId) {
		return mapper.selectCartList(userId);
	}
	
	

}
