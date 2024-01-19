package com.mun9.inquire.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.inquire.service.InquireService;
import com.mun9.inquire.serviceImpl.InquireServiceImpl;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;

public class InquireDelControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		InquireService svc = new InquireServiceImpl();

		int inqNo = Integer.parseInt(req.getParameter("inqNo"));

		try {
			if (svc.delInquire(inqNo)) {
				resp.sendRedirect("inquireListForm.do");
			}else {
				resp.sendRedirect("inquireDel.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
