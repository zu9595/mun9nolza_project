package com.mun9.product.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;

public class searchControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 검색단어가 포함되며 판매량이 높은 순
		ProductService svc = new ProductServiceImpl();
		resp.setContentType("text/json;charset=utf-8");
		
		String search = req.getParameter("search");
		List<String> list = new ArrayList<>();
				
		if(!search.equals("")) {
			list = svc.searchProduct("%"+search+"%");
		}
		//req.setAttribute("searchList", list);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		try {
			resp.getWriter().print(gson.toJson(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
