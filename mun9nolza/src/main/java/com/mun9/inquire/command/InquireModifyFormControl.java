package com.mun9.inquire.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.inquire.service.InquireService;
import com.mun9.inquire.serviceImpl.InquireServiceImpl;
import com.mun9.inquire.vo.InquireVO;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class InquireModifyFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String inqNo = req.getParameter("inqNo");

		InquireService svc = new InquireServiceImpl();
		InquireVO vo = svc.detailInquire(Integer.parseInt(inqNo));

		req.setAttribute("vo", vo);
		
		RequestDispatcher rd = req.getRequestDispatcher("inquire/inquireModifyForm.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
