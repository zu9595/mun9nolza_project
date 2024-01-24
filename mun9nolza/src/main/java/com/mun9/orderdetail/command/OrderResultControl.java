package com.mun9.orderdetail.command;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.orderdetail.service.OrderDetailService;
import com.mun9.orderdetail.serviceImpl.OrderDetailServiceImpl;
import com.mun9.orderdetail.vo.OrderDetailVO;
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
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
		Date orderDate = null;
		
		String orderRecipient = req.getParameter("orderRecipient");
		String orderAddr = req.getParameter("orderAddr");
		String detailAddr = req.getParameter("detailAddr");
		String orderPhone = req.getParameter("orderPhone");
		String deliveryMemo = req.getParameter("deliveryMemo");
		String totalPrice = req.getParameter("totalPrice");
		String deliveryFee = req.getParameter("deliveryFee");
		String orderStatus = req.getParameter("orderStatus");
		
		OrderListVO vo = new OrderListVO();
		vo.setUserId(userId);
		vo.setOrderDate(orderDate);
		vo.setOrderRecipient(orderRecipient);
		vo.setOrderAddr(orderAddr);
		vo.setDetailAddr(detailAddr);
		vo.setOrderPhone(orderPhone);
		vo.setDeliveryMemo(deliveryMemo);
		if(totalPrice!="") {
			vo.setTotalPrice(Integer.parseInt(totalPrice));
		}
		vo.setDeliveryFee(Integer.parseInt(deliveryFee));
		vo.setOrderStatus(orderStatus);
		
		//orderList 추가
		lsvc.addOrderList(vo);
		
		//orderList의 orderNo 목록 숫자만 뽑음 -> orderDetail 추가
		List<OrderListVO> ovo = lsvc.orderListsDe(userId);
		int w=0;
		for(int i=0;i<ovo.size();i++) {
			if(ovo.size()-1==i) {
				w = ovo.get(i).getOrderNo(); 
			}
		}
		List<OrderDetailVO> list2 = lsvc.orderDetailBefore(userId,w);
			
			for(OrderDetailVO vo2 : list2) {
				svc.addOrderDetail(vo2);
			}
		
		
		List<OrderDetailVO> odlist = svc.selectOrderDetailList(w);
		System.out.println(odlist.toString());
		req.setAttribute("orderDetailList", odlist);
		req.setAttribute("orderInfo", vo);
		
		// 페이지이동
		RequestDispatcher rd = null;
		try {
			rd = req.getRequestDispatcher("order/orderResult.tiles");
			rd.forward(req, resp);
			//csvc.resetCartList(userId);
//		}else {
//			resp.sendRedirect("order/orderDetail.tiles");
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
