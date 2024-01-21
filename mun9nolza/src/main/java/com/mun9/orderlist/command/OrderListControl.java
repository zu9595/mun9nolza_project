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
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;
import com.mun9.orderlist.service.OrderListService;
import com.mun9.orderlist.serviceImpl.OrderListServiceImpl;
import com.mun9.orderlist.vo.OrderListVO;

public class OrderListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		OrderListVO vo = new OrderListVO();
		OrderListService svc = new OrderListServiceImpl();
		
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		
		List<OrderListVO> list = svc.getMyOrderList(userId);
		req.setAttribute("orderList", list);
		req.setAttribute("vo", vo);

		
		resp.setContentType("text/json;charset=utf-8");
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		//페이지이동
//		RequestDispatcher rd = req.getRequestDispatcher("mypage/myOrderList.tiles");
//		try {
//			rd.forward(req, resp);
//		} catch (ServletException | IOException e) {
//			e.printStackTrace();
//		}
		

	}

}
