package com.mun9.review.command;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.orderlist.service.OrderListService;
import com.mun9.orderlist.serviceImpl.OrderListServiceImpl;
import com.mun9.review.service.ReviewService;
import com.mun9.review.serviceImpl.ReviewServiceImpl;
import com.mun9.review.vo.ReviewVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class reviewAddJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String saveLoc = req.getServletContext().getRealPath("img");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mr = null;
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		System.out.println(userId);
		try {
			// 1.request 2.saveLoc 3.maxSize 4.인코딩 5.리네임정책
			mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());
			String proCode = mr.getParameter("proCode");
			String reTitle = mr.getParameter("reTitle");
			String reContent = mr.getParameter("reContent");
			String reRate = mr.getParameter("reRate");
			String reImage = mr.getFilesystemName("reImage");
			// 파일시스템에 바뀐이름을 가져옴
			
			ReviewService svc = new ReviewServiceImpl();
			OrderListService osvc = new OrderListServiceImpl();
			ReviewVO vo = new ReviewVO();
			vo.setReImage(reImage);
			vo.setUserId(userId);
			vo.setProCode(Integer.parseInt(proCode));
			vo.setReTitle(reTitle);
			vo.setReContent(reContent);
			vo.setReRate(Integer.parseInt(reRate));
			
			
			System.out.println(vo.toString());
			
			Map<String,Object> map = new HashMap<String,Object>();
			
			if(osvc.orderTFReview(userId)) {
				svc.addReview(vo);
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
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
