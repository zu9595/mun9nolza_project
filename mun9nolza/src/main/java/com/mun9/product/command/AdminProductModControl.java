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
import com.mun9.product.vo.ProductVO;

public class AdminProductModControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		ProductService svc = new ProductServiceImpl();
		
		int proCode = Integer.parseInt(req.getParameter("proCode"));
		String proName = req.getParameter("proName");
		String proDesc = req.getParameter("proDesc");
		String proImage = req.getParameter("proImage");
		int proPrice = Integer.parseInt(req.getParameter("proPrice"));
		int proDiscount = Integer.parseInt(req.getParameter("proDiscount"));
		int proSell = Integer.parseInt(req.getParameter("proSell"));
		int proStock = Integer.parseInt(req.getParameter("proStock"));
		String category = req.getParameter("category");
		
		ProductVO vo = new ProductVO();
		vo.setProCode(proCode);
		vo.setProName(proName);
		vo.setProDesc(proDesc);
		vo.setProImage(proImage);
		vo.setProPrice(proPrice);
		vo.setProDiscount(proDiscount);
		vo.setProSell(proSell);
		vo.setProStock(proStock);
		vo.setCategory(category);
		
		//삭제
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(svc.modProduct(vo)) {
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
