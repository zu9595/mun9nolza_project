package com.mun9.member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;

public class AdminMemberDelControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		MemberService svc = new MemberServiceImpl();
		
		String id = req.getParameter("userId");
		String pw = req.getParameter("userPw");
		
		//삭제
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(svc.delMember(id, pw)) {
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
