package com.mun9.cart.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.cart.service.CartService;
import com.mun9.cart.serviceImpl.CartServiceImpl;
import com.mun9.cart.vo.CartVO;
import com.mun9.common.Control;

public class AddCartJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		
		int proCode = Integer.parseInt(req.getParameter("proCode"));
		int proPrice = Integer.parseInt(req.getParameter("proPrice"));
		int proDiscount = Integer.parseInt(req.getParameter("proDiscount"));
		int myproCnt = Integer.parseInt(req.getParameter("myproCnt"));
		
		CartService svc = new CartServiceImpl();
		
		CartVO vo = new CartVO();
		vo.setUserId(userId);
		vo.setProCode(proCode);
		vo.setProPrice(proPrice);
		vo.setProDiscount(proDiscount);
		vo.setMyproCnt(myproCnt);
		
		Map<String,Object> map = new HashMap<String,Object>();

		if(svc.addCartCheck(vo)) {
			if(svc.setCartList(vo)) {
				map.put("retCode", "OK");
			}else {
				map.put("retCode", "NG");
			}
     }else {
			if(svc.addCartList(vo)) {
				map.put("retCode", "OK");
			}else {
				map.put("retCode", "NG");
			}
		}

			Gson gson = new GsonBuilder().create();
			try {
				resp.getWriter().print(gson.toJson(map));
			} catch (IOException e) {
				e.printStackTrace();
			}

		
	}

}
