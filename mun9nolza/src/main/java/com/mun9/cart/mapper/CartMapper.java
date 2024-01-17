package com.mun9.cart.mapper;

import java.util.List;

import com.mun9.cart.vo.CartVO;
import com.yedam.board.vo.BoardVO;

public interface CartMapper {
	List<CartVO> selectCartList(String userId);
	int changeCnt(CartVO vo);
	int deleteCart(int cartNo);
}
