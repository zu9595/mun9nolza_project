package com.mun9.review.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.review.service.ReviewService;
import com.mun9.review.serviceImpl.ReviewServiceImpl;
import com.mun9.review.vo.ReviewVO;

public class reviewDelJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		
		String proCode = req.getParameter("proCode");
		String reTitle = req.getParameter("reTitle");
		//String reContent = req.getParameter("reContent");
		String reRate = req.getParameter("reRate");
		
		ReviewService svc = new ReviewServiceImpl();
		
		ReviewVO vo = new ReviewVO();
		vo.setUserId(userId);
		vo.setProCode(Integer.parseInt(proCode));
		vo.setReTitle(reTitle);
		//vo.setReContent(reContent);
		vo.setReRate(Integer.parseInt(reRate));
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(svc.deleteReview(vo)) {
			map.put("retCode", "OK");
		}else {
			map.put("retCode", "NG");
		}
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
