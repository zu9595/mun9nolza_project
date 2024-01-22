package com.mun9.member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;

public class JoinIdJsonControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json;charset=utf-8");
		
		String userId = req.getParameter("userId");
		
		MemberService svc = new MemberServiceImpl();
		
		Map<String, Object> map = new HashMap<>();
		boolean result = svc.idCheck(userId);
	
		map.put("res", result);
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(map)); 
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
