package com.mun9.review.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.product.vo.PageDTO;
import com.mun9.review.service.ReviewService;
import com.mun9.review.serviceImpl.ReviewServiceImpl;
import com.mun9.review.vo.ReviewVO;

public class reviewListJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		
		resp.setContentType("text/json;charset=utf-8");
		ReviewService svc = new ReviewServiceImpl();
		
		String proCode = req.getParameter("proCode");
		String page = req.getParameter("page");
		
		System.out.println(proCode);
		page = page == null ? "1" : page;
		ReviewVO vo = new ReviewVO();
		vo.setPage(Integer.parseInt(page));
		vo.setProCode(Integer.parseInt(proCode));
		
		List<ReviewVO> list = svc.reviewListPaging(vo);
		int total = svc.getTotalReviewCnt(Integer.parseInt(proCode));
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
