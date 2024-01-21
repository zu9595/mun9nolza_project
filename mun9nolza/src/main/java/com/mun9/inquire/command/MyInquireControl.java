package com.mun9.inquire.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.inquire.service.InquireService;
import com.mun9.inquire.serviceImpl.InquireServiceImpl;
import com.mun9.inquire.vo.InquireVO;

public class MyInquireControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		InquireVO vo = new InquireVO();
		InquireService svc = new InquireServiceImpl();

		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("logId");

		List<InquireVO> list = svc.getMyInquire(userId);
		req.setAttribute("inquireList", list);
		req.setAttribute("vo", vo);

		// 페이지이동
		RequestDispatcher rd = req.getRequestDispatcher("mypage/myInquire.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
