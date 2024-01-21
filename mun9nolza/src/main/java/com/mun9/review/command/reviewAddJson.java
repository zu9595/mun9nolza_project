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
import com.mun9.review.service.ReviewService;
import com.mun9.review.serviceImpl.ReviewServiceImpl;
import com.mun9.review.vo.ReviewVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class reviewAddJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		resp.setContentType("text/json;charset=utf-8");
		ReviewService svc = new ReviewServiceImpl();
		ReviewVO vo = new ReviewVO();
		
		String userId = req.getParameter("userId");
		String proCode = req.getParameter("proCode");
		String reContent = req.getParameter("reContent");
		String reRate = req.getParameter("reRate");
		
		String saveLoc = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mr = null;

		try {
			// 1.request 2.saveLoc 3.maxSize 4.인코딩 5.리네임정책
			mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());
			// 파일시스템에 바뀐이름을 가져옴
			String reImage = mr.getParameter("reImage");
			
			vo.setUserId(userId);
			vo.setProCode(Integer.parseInt(proCode));
			vo.setReContent(reContent);
			vo.setReRate(Integer.parseInt(reRate));
			vo.setReImage(reImage);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		String orders = "";
		String clear = "";
		if(svc.orderTFReview(userId)) {
			orders = "OK";
			if(svc.addReview(vo)) {
				clear = "OK";
			}else{
				clear = "NG";
			};
		}else{
			orders = "NG";
		};
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("clear", clear);
		map.put("orderYN", orders);
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
