package com.mun9.review.command;

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
		
		String saveLoc = req.getServletContext().getRealPath("img");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mr = null;
		String userId = "";
		String reImage = "";
		String proCode = "";
		String reTitle = "";
		String reContent = "";
		String[] reRate = null;
		
		try {
			// 1.request 2.saveLoc 3.maxSize 4.인코딩 5.리네임정책
			mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());
			// 파일시스템에 바뀐이름을 가져옴
			reImage = mr.getFilesystemName("reImage");
			userId = mr.getParameter("userId");
			proCode = mr.getParameter("proCode");
			reTitle = mr.getParameter("reTitle");
			reContent = mr.getParameter("reContent");
			reRate = mr.getParameterValues("reRate");
			
			System.out.println(reRate);
			
			vo.setReImage(reImage);
			vo.setUserId(userId);
			vo.setProCode(Integer.parseInt(proCode));
			vo.setReTitle(reTitle);
			vo.setReContent(reContent);
			//vo.setReRate(Integer.parseInt(reRate));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(vo.toString());
		String ok = "";
		
		if(svc.orderTFReview(userId)) {
			svc.addReview(vo);
			ok = "OK";
		}else {
			ok="NG";
		}
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		try {
			resp.getWriter().print(gson.toJson(ok));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
