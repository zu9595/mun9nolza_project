package com.mun9.cart.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.cart.service.CartService;
import com.mun9.cart.serviceImpl.CartServiceImpl;
import com.mun9.cart.vo.CartVO;
import com.mun9.common.Control;

public class CartListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String userId = req.getParameter("userId");

		CartService svc = new CartServiceImpl();
		List<CartVO> list = svc.cartList(userId);

		resp.setContentType("text/json;charset=utf-8");
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
