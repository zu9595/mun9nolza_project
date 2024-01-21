package com.mun9.orderlist.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.orderlist.service.OrderListService;
import com.mun9.orderlist.serviceImpl.OrderListServiceImpl;
import com.mun9.orderlist.vo.OrderDetailVO;
public class MyOrderDetailControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		OrderDetailVO vo = new OrderDetailVO();
		OrderListService svc = new OrderListServiceImpl();
		
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		
		int orderNo = Integer.parseInt(req.getParameter("orderNo"));
		//List<OrderDetailVO> detail = svc.getMyOrderDetail(orderNo, userId);
		
		//req.setAttribute("orderDetail", detail);
		req.setAttribute("dvo", vo);

		
		//페이지이동
		RequestDispatcher rd = req.getRequestDispatcher("mypage/myOrderDetail.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
