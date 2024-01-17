package com.mun9.orderlist.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.orderlist.service.OrderListService;
import com.mun9.orderlist.serviceImpl.OrderListServiceImpl;

public class ModifyOrderJsonControl implements Control {
	//페이지이동은 OrderListControl
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json;charset=utf-8");
		
		int orderNo = Integer.parseInt(req.getParameter("orderNo"));
		
		OrderListService svc = new OrderListServiceImpl();
		
		Map<String, Object> map = new HashMap<>();
		boolean result = svc.modifyOrder(orderNo);
		
		map.put("result", result);
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
