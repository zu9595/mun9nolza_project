package com.mun9.inquire.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;
import com.mun9.inquire.service.InquireService;
import com.mun9.inquire.serviceImpl.InquireServiceImpl;
import com.mun9.inquire.vo.InquireVO;

public class InquireDetailControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String inqNo = req.getParameter("inqNo");

		InquireService svc = new InquireServiceImpl();
		InquireVO vo = svc.detailInquire(Integer.parseInt(inqNo));

		req.setAttribute("vo", vo);

		// 페이징 이동(forward)
		RequestDispatcher rd = req.getRequestDispatcher("inquire/inquireDetailForm.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
