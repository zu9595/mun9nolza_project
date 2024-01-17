package com.mun9.orderlist.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
//		MemberService svc = new MemberServiceImpl();
//		String userId = req.getParameter("userId");
//		String userPw = req.getParameter("userPw");
//		MemberVO vo = svc.login(userId, userPw);
//		req.setAttribute("vo", vo);
		
		OrderListVO vo = new OrderListVO();
		OrderListService svc = new OrderListServiceImpl();

		String userId = req.getParameter("userId");
		List<OrderListVO> list = svc.getMyOrderList(userId);
		req.setAttribute("orderList", list);
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
