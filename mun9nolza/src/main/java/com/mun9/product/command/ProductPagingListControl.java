package com.mun9.product.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;
import com.mun9.product.vo.PageDTO;

public class ProductPagingListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String page = req.getParameter("page");

		ProductService svc = new ProductServiceImpl();
		int total = svc.getTotalCnt();

		PageDTO dto = new PageDTO(Integer.parseInt(page), total);
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(dto));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
