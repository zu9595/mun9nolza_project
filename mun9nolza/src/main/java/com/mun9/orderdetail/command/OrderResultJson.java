package com.mun9.orderdetail.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;
import com.mun9.orderdetail.service.OrderDetailService;
import com.mun9.orderdetail.serviceImpl.OrderDetailServiceImpl;
import com.mun9.orderdetail.vo.OrderDetailVO;

public class OrderResultJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		OrderDetailService svc = new OrderDetailServiceImpl();
		List<OrderDetailVO> vo = svc.orderResult();
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		
		MemberService msvc = new MemberServiceImpl();
		MemberVO mvo = msvc.memInfo(userId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("resultList", vo);
		map.put("buyInfo", mvo);
		
		resp.setContentType("text/json;charset=utf-8");
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
