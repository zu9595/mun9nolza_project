package com.mun9.orderdetail.command;

import java.io.IOException;
import java.util.ArrayList;
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
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class OrderDetailFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		
		CartService csvc = new CartServiceImpl();
		List<CartVO> clist = csvc.selectCartList(userId);
		
		MemberService msvc = new MemberServiceImpl();
		MemberVO mlist = msvc.memInfo(userId);
		
		req.setAttribute("memberList", mlist);
		req.setAttribute("cartList", clist);

		//페이지이동
		RequestDispatcher rd = req.getRequestDispatcher("order/orderDetail.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
