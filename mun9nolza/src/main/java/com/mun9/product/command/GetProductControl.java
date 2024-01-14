package com.mun9.product.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;
import com.mun9.product.vo.ProductVO;

public class GetProductControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
String pno = req.getParameter("pno");
		
		ProductService svc = new ProductServiceImpl();
		ProductVO vo = svc.getProduct(pno);
		
		req.setAttribute("vo", vo);
		
		RequestDispatcher rd = req.getRequestDispatcher("product/getProduct.tiles");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 
	}

}
