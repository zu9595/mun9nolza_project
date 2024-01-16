package com.mun9.product.command;

import java.io.IOException;
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
import com.mun9.product.vo.PageDTO;
import com.mun9.product.vo.ProductVO;

public class ProductPagingListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json;charset=utf-8");
		ProductService svc = new ProductServiceImpl();
		String page = req.getParameter("page");
		String category = req.getParameter("category");
		
		String proDiscnt = req.getParameter("proDiscount");
		
		page = page == null ? "1" : page;
		List<ProductVO> list = svc.productListPaging(Integer.parseInt(page), category, Integer.parseInt(proDiscnt));
		
		int total = svc.getTotalCnt(category);		
		PageDTO dto = new PageDTO(Integer.parseInt(page), total);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pageDTO", dto);
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
