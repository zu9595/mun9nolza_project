package com.mun9.cart.mapper;

import java.util.List;

import com.mun9.cart.vo.CartVO;

public interface CartMapper {
	List<CartVO> selectCartList(String userId);
	int changeCnt(CartVO vo);
	int deleteCart(CartVO vo);
}
