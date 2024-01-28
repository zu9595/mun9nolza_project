package com.mun9.orderlist.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.orderlist.service.OrderListService;
import com.mun9.orderlist.serviceImpl.OrderListServiceImpl;
import com.mun9.orderlist.vo.OrderListVO;

public class OrderListAdminControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		OrderListService svc = new OrderListServiceImpl();
		
		List<OrderListVO> list = svc.orderListAdmin();
		
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
