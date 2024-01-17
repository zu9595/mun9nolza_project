package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;

public class FindPwControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		
		MemberService svc = new MemberServiceImpl();

		String fpw = svc.findPw(userId ,userName, email);
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(fpw));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
