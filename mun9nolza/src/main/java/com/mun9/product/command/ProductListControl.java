package com.mun9.product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;
import com.mun9.product.vo.PageDTO;
import com.mun9.product.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json;charset=utf-8");
		ProductService svc = new ProductServiceImpl();
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		List<ProductVO> list = svc.productListPaging(Integer.parseInt(page));
		
//		int totalCnt = 3;
//		PageDTO dto = new PageDTO(1, totalCnt);
//		req.setAttribute("page", dto);
		
		int cnt = list.size();
		String json = "[";
		for (int i = 0; i < cnt; i++) {
			json += "{\"proCode\":" +list.get(i).getProCode()+"\",\"proName\":\""+list.get(i).getProName()+"\",\"proImage\":\""+list.get(i).getProImage()+"\",\"proPrice\":\""+list.get(i).getProPrice()+"\",\"proDiscount\":\""+list.get(i).getProDiscount()+"\",\"category\":\""+list.get(i).getCategory()+"\"}";
			if(i != cnt-1) {
				json += ",";
			}
		}
		json += "]";
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
