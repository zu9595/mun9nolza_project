package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class AddMemberFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//MemberService svc = new MemberServiceImpl();
		
		//회원가입 화면 열어주는 것만
		if (req.getMethod().equals("GET")) {
		RequestDispatcher rd = req.getRequestDispatcher("no/member/addMember.tiles"); //이동할 페이지
		
		
		//페이지 이동(forward)
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			//resp.sendRedirect("no/member/addMember.tiles");
		}else if(req.getMethod().equals("POST")) {
			MemberService svc = new MemberServiceImpl();
			
			String userName = req.getParameter("userName");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			
			MemberVO vo = new MemberVO();
			vo.setUserName(userName);
			vo.setEmail(email);
			vo.setGender(gender);
			req.setAttribute("vo", vo);
			
			RequestDispatcher rd = req.getRequestDispatcher("no/member/addMember.tiles"); //이동할 페이지
			//페이지 이동(forward)
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	}

}
