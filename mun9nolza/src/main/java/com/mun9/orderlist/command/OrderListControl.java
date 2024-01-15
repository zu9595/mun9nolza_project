package com.mun9.orderlist.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.member.vo.MemberVO;
import com.mun9.orderlist.service.OrderListService;
import com.mun9.orderlist.serviceImpl.OrderListServiceImpl;
import com.mun9.orderlist.vo.OrderListVO;

public class OrderListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		OrderListService svc = new OrderListServiceImpl();
		OrderListVO vo = new OrderListVO();
		
		//id: session 담겨있고, 주문완료 내역 담겨있어야 됨?
		String userId = req.getParameter("userId");
		vo.setUserId(userId);
		svc.getMyOrderList(userId);
		
//		List<OrderListVO> list = svc.getMyOrderList(userId);
//
//		
//		resp.setContentType("text/json;charset=utf-8");
//		Gson gson = new GsonBuilder().create();
//		
//		try {
//			resp.getWriter().print(gson.toJson(list));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher("mypage/mypage.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		

	}

}
