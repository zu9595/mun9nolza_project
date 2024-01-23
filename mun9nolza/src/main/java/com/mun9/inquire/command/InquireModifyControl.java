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

public class InquireModifyControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String saveLoc = req.getServletContext().getRealPath("img");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mr = null;
		
		InquireVO vo = new InquireVO();
		
		try {
			mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());

			String inqNo = mr.getParameter("inqNo");
			String inqContent = mr.getParameter("inqContent");
			String inqImg = mr.getFilesystemName("inqImg");
			
			vo.setInqNo(Integer.parseInt(inqNo));
			vo.setInqContent(inqContent);			
			vo.setInqImg(inqImg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		InquireService svc = new InquireServiceImpl();
		
		req.setAttribute("vo", vo);

		try {
			if (svc.modifyInquire(vo)) {
				resp.sendRedirect("inquireListForm.do");
			} else {
				resp.sendRedirect("inquireModifyForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
