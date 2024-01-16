package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class FindIdControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		System.out.println(userName);
		MemberService svc = new MemberServiceImpl();

		String fid = svc.findId(userName, email);
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(fid));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
