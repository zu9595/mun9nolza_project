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

public class OrderListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
//		OrderListVO vo = new OrderListVO();
//		List<OrderListVO> list = svc.getMyOrderList(userId);
//		req.setAttribute("orderList", list);
//		String userId = req.getParameter("userId");
//		req.setAttribute("vo", vo);
		
		
		MemberService svc = new MemberServiceImpl();

		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		MemberVO vo = svc.login(userId, userPw);
		req.setAttribute("vo", vo);
		
		
		//페이지이동
		RequestDispatcher rd = req.getRequestDispatcher("mypage/mypage.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		

	}

}
