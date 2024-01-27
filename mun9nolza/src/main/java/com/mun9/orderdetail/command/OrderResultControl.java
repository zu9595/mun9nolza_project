package com.mun9.orderdetail.command;

import java.io.IOException;
import java.text.*;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

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

public class OrderResultControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		
		OrderDetailService svc = new OrderDetailServiceImpl();
		OrderListService lsvc = new OrderListServiceImpl();
		String userId = (String) session.getAttribute("logId");
		System.out.println(userId);
		
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
		vo.setOrderRecipient(orderRecipient);
		vo.setOrderAddr(orderAddr);
		vo.setDetailAddr(detailAddr);
		vo.setOrderPhone(orderPhone);
		vo.setDeliveryMemo(deliveryMemo);
		vo.setOrderDate(new Date());
		if(totalPrice!="") {
			vo.setTotalPrice(Integer.parseInt(totalPrice));
		}
		vo.setDeliveryFee(Integer.parseInt(deliveryFee));
		vo.setOrderStatus(orderStatus);
		System.out.println(totalPrice);
		
		if(totalPrice != "") {
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
		System.out.println(w);
		OrderDetailVO vo3 = new OrderDetailVO();
		vo3.setUserId(userId);
		vo3.setOrderNo(w);
		
		List<OrderDetailVO> list2 = lsvc.orderDetailBefore(vo3);
			System.out.println(list2);
			for(OrderDetailVO vo2 : list2) {
				int Sum = 0;
				if(vo2.getDeProPrice() == 0) {
					Sum = ((vo2.getMyproPrice()) * (vo2.getMyproCnt()));
				}else {
					Sum = ((vo2.getDeProPrice()) * (vo2.getMyproCnt()));
				}
				vo2.setDeProPrice(Sum);
				svc.addOrderDetail(vo2);
			}
		
		List<OrderDetailVO> odlist = svc.selectOrderDetailList(w);
		System.out.println(odlist.toString());
		
		//장바구니 삭제
		CartService csvc = new CartServiceImpl();
		csvc.resetCartList(userId);
		
		//req.setAttribute("orderDetailList", odlist);
		req.setAttribute("orderInfo", vo);
		//req.setAttribute("orderNo", w);
		
		// 페이지이동
		RequestDispatcher rd = null;
		try {
			rd = req.getRequestDispatcher("order/orderResult.tiles");
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		}else {
			// 페이지이동
			try {
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter w = resp.getWriter();
				w.write("<script>alert(`등록된 상품이 없습니다.`);location.href='main.do';</script>");
				w.flush();
				w.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
