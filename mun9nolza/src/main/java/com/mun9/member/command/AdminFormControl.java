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

public class AdminFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService svc = new MemberServiceImpl();
		
		String id = req.getParameter("id");
		
		req.setAttribute("id", id);
		
		//페이지 이동(forward)
			RequestDispatcher rd = req.getRequestDispatcher("admin/adminMain.tiles");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
					e.printStackTrace();
			}
		
	}

}
