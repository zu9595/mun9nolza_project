package com.mun9.orderdetail.command;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.mun9.orderlist.service.OrderListService;
import com.mun9.orderlist.serviceImpl.OrderListServiceImpl;
import com.mun9.orderlist.vo.OrderListVO;

public class OrderResultControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		
		OrderDetailService svc = new OrderDetailServiceImpl();
		OrderListService lsvc = new OrderListServiceImpl();
		String userId = (String) session.getAttribute("logId");
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
		String orderDate = now.format(formatter);

		String orderRecipient = req.getParameter("recipient");
		String orderAddr = req.getParameter("orderAddr");
		String detailAddr = req.getParameter("detailAddr");
		String orderPhone = req.getParameter("orderPhone");
		String deliveryMemo = req.getParameter("deliveryMemo");
		int totalPrice = Integer.parseInt(req.getParameter("totalPrice"));
		int deliveryFee = Integer.parseInt(req.getParameter("deliveryFee"));
		String orderStatus = req.getParameter("orderStatus");
		
		OrderListVO vo = new OrderListVO();
		vo.setUserId(userId);
		vo.setOrderDate(orderDate);
		vo.setOrderRecipient(orderRecipient);
		vo.setOrderAddr(orderAddr);
		vo.setDetailAddr(detailAddr);
		vo.setOrderPhone(orderPhone);
		vo.setDeliveryMemo(deliveryMemo);
		vo.setTotalPrice(totalPrice);
		vo.setDeliveryFee(deliveryFee);
		vo.setOrderStatus(orderStatus);
		
		
		CartService csvc = new CartServiceImpl();
		List<CartVO> clist = csvc.selectCartList(userId);
		req.setAttribute("cartlist", clist);
		// 페이지이동
		RequestDispatcher rd = null;
		try {
		if(lsvc.addOrderList(vo) && svc.addOrderDetail(vo)) {
			rd = req.getRequestDispatcher("order/orderResult.tiles");
			rd.forward(req, resp);
			csvc.resetCartList(userId);
		}else {
			resp.sendRedirect("order/orderDetail.tiles");
		}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
