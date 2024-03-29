package com.mun9.orderdetail.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.cart.service.CartService;
import com.mun9.cart.serviceImpl.CartServiceImpl;
import com.mun9.cart.vo.CartVO;
import com.mun9.common.Control;

public class OrderDetailJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		
		CartService csvc = new CartServiceImpl();
		List<CartVO> clist = csvc.selectCartList(userId);
		
		int priceSum = 0;
		for(CartVO singleCart : clist) {
			if(singleCart.getProDiscount() == 0) {
				priceSum += (singleCart.getProPrice()*singleCart.getMyproCnt());
			} else {
				priceSum += (singleCart.getProDiscount()*singleCart.getMyproCnt());
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		
		resp.setContentType("text/json;charset=utf-8");
		map.put("list", clist);
		map.put("priceSum", priceSum);
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
