package com.mun9.myproduct.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;
import com.mun9.myproduct.service.MyProductService;
import com.mun9.myproduct.serviceImpl.MyProductServiceImpl;
import com.mun9.myproduct.vo.MyProductVO;

public class MyProductListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MyProductService svc = new MyProductServiceImpl();
		List<MyProductVO> list = svc.myProductList();
		
		req.setAttribute("productList", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("product/myProductList.tiles");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 
	}

}
