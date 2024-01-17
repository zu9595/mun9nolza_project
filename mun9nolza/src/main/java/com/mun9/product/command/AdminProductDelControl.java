package com.mun9.product.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;

public class AdminProductDelControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		ProductService svc = new ProductServiceImpl();
		
		int proCode = Integer.parseInt(req.getParameter("proCode"));
		
		//삭제
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(svc.delProduct(proCode)) {
			map.put("retCode", "OK");
		}else {
			map.put("retCode", "NG");
		}
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
