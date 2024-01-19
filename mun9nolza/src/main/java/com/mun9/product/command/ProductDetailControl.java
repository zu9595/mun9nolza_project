package com.mun9.product.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;
import com.mun9.product.vo.ProductVO;

public class ProductDetailControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int pcode = Integer.parseInt(req.getParameter("pcode"));
		
		ProductService svc = new ProductServiceImpl();
		ProductVO vo = svc.getProductDetail(pcode);
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		
		req.setAttribute("vo", vo);
		req.setAttribute("userId", userId);
		
		RequestDispatcher rd = req.getRequestDispatcher("product/productDetail.tiles");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			} 

	}

}
