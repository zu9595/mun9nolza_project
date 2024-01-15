package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");		
		
		MemberService svc = new MemberServiceImpl();
		
		MemberVO vo = svc.login(userId, userPw);
		
		if(vo != null) {
			HttpSession session = req.getSession();
			session.setAttribute("logId", vo.getUserId());
			session.setAttribute("logPw", vo.getUserPw());
			session.setAttribute("logName", vo.getUserName());
			RequestDispatcher rd = req.getRequestDispatcher("mainbody.tiles");
			try {
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			req.setAttribute("massage", "아이디와 비밀번호를 확인하세요");
			//페이지 없음
			try { 
				req.getRequestDispatcher("no/login/loginForm.tiles").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
