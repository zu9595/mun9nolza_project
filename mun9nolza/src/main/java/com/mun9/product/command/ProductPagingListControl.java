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
		String category = req.getParameter("category");
		String option = req.getParameter("option");
		String page = req.getParameter("page");
		
		//페이지 값이 없으면 1
		page = page == null ? "1" : page;
		ProductVO vo = new ProductVO();
		vo.setPage(Integer.parseInt(page));
		vo.setCategory(category);
		
		if(option.equals("proName")) {
			vo.setProName("이름");
		}else if(option.equals("proPrice")) {
			vo.setProPrice(1);
		}else if(option.equals("proSell")) {
			vo.setProSell(1);
		}
		
		
		
		List<ProductVO> list = svc.productListPaging(vo);
		
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
