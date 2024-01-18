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

public class MyInfoModFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
	
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId"); 
		//String userId = req.getParameter("userId");
		
		MemberService svc = new MemberServiceImpl();
		MemberVO mem = svc.memInfo(userId);

		req.setAttribute("mem", mem);
		
		RequestDispatcher rd = req.getRequestDispatcher("mypage/myInfoMod.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
