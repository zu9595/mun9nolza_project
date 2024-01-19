package com.mun9.cart.service;

import java.util.List;

import com.mun9.cart.vo.CartVO;

public interface CartService {
	public List<CartVO> selectCartList(String userId);
	public boolean deleteCartList(CartVO vo);
	public boolean addCartList(CartVO vo);
	public boolean changeMyproCnt(CartVO vo);
}
