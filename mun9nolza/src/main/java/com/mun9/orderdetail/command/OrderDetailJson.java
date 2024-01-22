package com.mun9.orderdetail.command;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.cart.service.CartService;
import com.mun9.cart.serviceImpl.CartServiceImpl;
import com.mun9.cart.vo.CartVO;
import com.mun9.common.Control;
import com.mun9.orderdetail.service.OrderDetailService;
import com.mun9.orderdetail.serviceImpl.OrderDetailServiceImpl;
import com.mun9.orderdetail.vo.OrderDetailVO;
import com.mun9.orderlist.service.OrderListService;
import com.mun9.orderlist.serviceImpl.OrderListServiceImpl;
import com.mun9.orderlist.vo.OrderListVO;

public class OrderDetailJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
//		HttpSession session = req.getSession();
//		
//		OrderDetailService svc = new OrderDetailServiceImpl();
//		OrderListService lsvc = new OrderListServiceImpl();
//		OrderListVO vo = new OrderListVO();
//		OrderDetailVO dvo = new OrderDetailVO();
//		String userId = (String) session.getAttribute("logId");
//		
//		Date orderDate = null; // 임시
//
//		String orderRecipient = req.getParameter("recipient");
//		String orderAddr = req.getParameter("orderAddr");
//		String detailAddr = req.getParameter("detailAddr");
//		String orderPhone = req.getParameter("orderPhone");
//		String deliveryMemo = req.getParameter("deliveryMemo");
//		int totalPrice = Integer.parseInt(req.getParameter("totalPrice"));
//		int deliveryFee = Integer.parseInt(req.getParameter("deliveryFee"));
//		String orderStatus = req.getParameter("orderStatus");
//		
//		vo.setUserId(userId);
//		vo.setOrderDate(orderDate);
//		vo.setOrderRecipient(orderRecipient);
//		vo.setOrderAddr(orderAddr);
//		vo.setDetailAddr(detailAddr);
//		vo.setOrderPhone(orderPhone);
//		vo.setDeliveryMemo(deliveryMemo);
//		vo.setTotalPrice(totalPrice);
//		vo.setDeliveryFee(deliveryFee);
//		vo.setOrderStatus(orderStatus);
//		
//		CartService csvc = new CartServiceImpl();
//		List<CartVO> clist = csvc.selectCartList(userId);
//		RequestDispatcher rd = null;
//		if(lsvc.addOrderList(vo) && svc.addOrderDetail(dvo)) {
//			csvc.deleteCartList(userId);
//			rd = req.getRequestDispatcher("order/orderResult.tiles");
//		}else {
//			rd = req.getRequestDispatcher("order/orderResult.tiles");
//		}
//		
//		
//		
//		try {
//			
//			rd.forward(req, resp);
//		} catch (ServletException | IOException e) {
//			e.printStackTrace();
//		}
	}

}
