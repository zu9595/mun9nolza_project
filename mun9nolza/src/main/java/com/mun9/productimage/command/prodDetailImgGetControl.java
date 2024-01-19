package com.mun9.productimage.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.productimage.service.ProductImageService;
import com.mun9.productimage.serviceImpl.ProductImageServiceImpl;
import com.mun9.productimage.vo.ProductImageVO;

public class prodDetailImgGetControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String orderNo = req.getParameter("orderNo");
		
		//이미지 상세 목록
		ProductImageService svc = new ProductImageServiceImpl();
		List<ProductImageVO> list =  svc.getImg(Integer.parseInt(orderNo));
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
