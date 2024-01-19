package com.mun9.orderdetail.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.cart.vo.CartVO;
import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class SingleOrderDetailFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		
		String proCode = req.getParameter("proCode");
		String proPrice = req.getParameter("proPrice");
		String proDiscount = req.getParameter("proDiscount");
		String myproCnt = req.getParameter("myproCnt");
		
		CartVO vo = new CartVO();
		vo.setUserId(userId);
		vo.setProCode(Integer.parseInt(proCode));
		vo.setProPrice(Integer.parseInt(proPrice));
		vo.setProDiscount(Integer.parseInt(proDiscount));
		vo.setMyproCnt(Integer.parseInt(myproCnt));
		
		List<CartVO> clist = new ArrayList<CartVO>();
		clist.add(vo);
		
		MemberService msvc = new MemberServiceImpl();
		MemberVO minfo = msvc.memInfo(userId);
		
		req.setAttribute("memberinfo", minfo);
		req.setAttribute("singleList", clist);
		
		//페이지이동
		RequestDispatcher rd = req.getRequestDispatcher("order/orderDetail.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
