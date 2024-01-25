package com.mun9.cart.service;

import java.util.List;

import com.mun9.cart.vo.CartVO;

public interface CartService {
	public List<CartVO> selectCartList(String userId);
	//public List<CartVO> selectReCartList(String userId,int orderNo);
	public boolean deleteCartList(CartVO vo);
	public boolean selectOneCart(CartVO vo);
	public boolean addCartList(CartVO vo);
	public boolean addCartsList(CartVO vo);
	public boolean addCartCheck(CartVO vo);
	public boolean setCartList(CartVO vo);
	public boolean changeMyproCnt(CartVO vo);
	public boolean resetCartList(String userId);
	public List<CartVO> selectOneCart2(CartVO vo);
}
