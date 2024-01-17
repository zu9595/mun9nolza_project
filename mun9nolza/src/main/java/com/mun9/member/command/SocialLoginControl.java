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


		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		MemberVO vo = null;
		if (svc.kakaologin(email, userName) != null) {
			vo = svc.kakaologin(email, userName);
			
			HttpSession session = req.getSession();
			session.setAttribute("logId", vo.getUserId());
			session.setAttribute("logPw", vo.getUserPw());
			session.setAttribute("logName", vo.getUserName());
			session.setAttribute("status", vo.getStatus());
			
			RequestDispatcher rd = req.getRequestDispatcher("mainbody.tiles");
			try {
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			vo = new MemberVO();
			vo.setUserName(userName);
			vo.setEmail(email);
			vo.setGender(gender);
			req.setAttribute("vo", vo);
			
			RequestDispatcher rd = req.getRequestDispatcher("no/member/addMember.tiles");
			try {
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
