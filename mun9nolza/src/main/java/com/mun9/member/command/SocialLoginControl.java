package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class SocialLoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService svc = new MemberServiceImpl();
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		MemberVO vo = new MemberVO();
		vo = svc.login(userId, userPw);
		if (vo == null) {
			vo = new MemberVO();
			String userName = req.getParameter("userName");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			vo.setEmail(userName);
			vo.setEmail(email);
			vo.setGender(gender);

			HttpSession session = req.getSession();
			session.setAttribute("vo", vo);
			RequestDispatcher rd = req.getRequestDispatcher("member/addMember.tiles");
			try {
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("userId", vo.getUserId());
			session.setAttribute("userPw", vo.getUserPw());
			session.setAttribute("userName", vo.getUserName());
			session.setAttribute("email", vo.getEmail());
			session.setAttribute("gender", vo.getGender());
			session.setAttribute("phoneNum", vo.getPhoneNum());
			session.setAttribute("status", vo.getStatus());

			try {
				resp.sendRedirect("main.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
