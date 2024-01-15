package com.mun9.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class MainControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
//		if (req.getMethod().equals("POST")) {
//			String userId = req.getParameter("userId");
//			String userPw = req.getParameter("userPw");
//
//			MemberService svc = new MemberServiceImpl();
//
//			MemberVO vo = svc.login(userId, userPw);
//
//			req.setAttribute("vo", vo);
//
//			try {
//				req.getRequestDispatcher("mainbody.tiles").forward(req, resp);
//			} catch (ServletException | IOException e) {
//				e.printStackTrace();
//			}
//
//		} else {

			RequestDispatcher rd = req.getRequestDispatcher("mainbody.tiles");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
//		}
	}

}
