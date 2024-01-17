package com.mun9.product.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;
import com.mun9.product.vo.ProductVO;

public class AdminProductAddControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		ProductService svc = new ProductServiceImpl();
		
		String proName = req.getParameter("proName");
		String proDesc = req.getParameter("proDesc");
		String proImage = req.getParameter("proImage");
		int proPrice = Integer.parseInt(req.getParameter("proPrice"));
		int proDiscount = Integer.parseInt(req.getParameter("proDiscount"));
		int proSell = Integer.parseInt(req.getParameter("proSell"));
		int proStock = Integer.parseInt(req.getParameter("proStock"));
		String category = req.getParameter("category");
		
		ProductVO vo = new ProductVO();
		vo.setProName(proName);
		vo.setProDesc(proDesc);
		vo.setProImage(proImage);
		vo.setProPrice(proPrice);
		vo.setProDiscount(proDiscount);
		vo.setProSell(proSell);
		vo.setProStock(proStock);
		vo.setCategory(category);
		
		req.setAttribute("vo", vo);
				
		//이동할 페이지
		RequestDispatcher rd = req.getRequestDispatcher("admin/adminProductList.tiles");
		try {
			if(svc.addProduct(vo)) {				
				rd.forward(req, resp);
			} else {
				resp.sendRedirect("adminProductAddForm.do");
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
