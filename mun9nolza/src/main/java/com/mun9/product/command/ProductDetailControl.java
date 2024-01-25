package com.mun9.product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.cart.service.CartService;
import com.mun9.cart.serviceImpl.CartServiceImpl;
import com.mun9.cart.vo.CartVO;
import com.mun9.common.Control;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;
import com.mun9.product.vo.ProductVO;

public class ProductDetailControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int pcode = Integer.parseInt(req.getParameter("pcode"));
		
		ProductService psvc = new ProductServiceImpl();
		ProductService svc = new ProductServiceImpl();
		CartService csvc = new CartServiceImpl();
		ProductVO vo = svc.getProductDetail(pcode);
		List<ProductVO> list2 = psvc.mainBestProductList();
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		
		
		System.out.println(userId);
		List<CartVO> list3 = null;
		CartVO ccvo = new CartVO();
		ccvo.setProCode(pcode);
		ccvo.setUserId(userId);
		
		if(userId!=null) {
			list3 = csvc.selectOneCart2(ccvo);
		}
		req.setAttribute("bestList", list2);
		req.setAttribute("cvo", list3);
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
