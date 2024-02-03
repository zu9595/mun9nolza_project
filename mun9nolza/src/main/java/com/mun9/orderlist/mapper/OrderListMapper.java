package com.mun9.orderlist.mapper;

import java.util.List;

import com.mun9.orderdetail.vo.OrderDetailVO;
import com.mun9.orderlist.vo.OrderListVO;

public interface OrderListMapper {
	
	//마이페이지(주문내역조회): 로그인아이디-최근주문순
	List<OrderListVO> selectMyOrderList(String userId);
	List<OrderListVO> selectDetailMap(String userId);
	//주문상태수정
	int updateOrderList(int orderNo);

	int insertOrderList(OrderListVO vo);

	int selectOrderReview(String userId);
	
	List<OrderListVO> orderListsDe(String userId);
	List<OrderDetailVO> orderDetailBefore(OrderDetailVO vo);
	
	List<OrderListVO> selectAdminOrderList();
	
	int adminOrderMod(OrderListVO vo);
}
