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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InquireAddControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String saveLoc = req.getServletContext().getRealPath("img");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mr = null;

		InquireVO vo = new InquireVO();

		try {
			mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());

			String userId = mr.getParameter("userId");
			String proCode = mr.getParameter("proCode");
			String inqTitle = mr.getParameter("inqTitle");
			String inqContent = mr.getParameter("inqContent");
			String inqImg = mr.getParameter("inqImg");
			String prodName = mr.getParameter("prodName");

			vo.setUserId(userId);
			vo.setProCode(Integer.parseInt(proCode));
			vo.setInqTitle(inqTitle);
			vo.setInqContent(inqContent);
			vo.setInqImg(inqImg);
			vo.setProdName(prodName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		InquireService svc = new InquireServiceImpl();

		req.setAttribute("vo", vo);

		RequestDispatcher rd = req.getRequestDispatcher("inquire/inquireListBody.tiles");

		try {
			if (svc.addInquire(vo)) {
				rd.forward(req, resp);
			} else {
				resp.sendRedirect("inquireAddForm.do");
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
