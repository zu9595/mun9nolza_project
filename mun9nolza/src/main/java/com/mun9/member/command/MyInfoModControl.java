package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class MyInfoModControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		//String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String userName = req.getParameter("userName");
		
		String phoneNum1 = req.getParameter("phoneNum1");
		String phoneNum2 = req.getParameter("phoneNum2");
		String phoneNum3 = req.getParameter("phoneNum3");
		
//		String phoneNum = phoneNum1.concat(phoneNum2).concat(phoneNum3);
		String phoneNum = phoneNum1 + phoneNum2 + phoneNum3 ;
		System.out.println(phoneNum);
		
		
		System.out.println(phoneNum);
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String status = req.getParameter("status");
		
		MemberVO vo = new MemberVO();
		vo.setUserId(userId);
		vo.setUserPw(userPw);
		vo.setUserName(userName);
		
		vo.setPhoneNum(phoneNum);
		/*
		 * vo.setPhoneNum(phoneNum1); vo.setPhoneNum(phoneNum2);
		 * vo.setPhoneNum(phoneNum3);
		 */
		
		vo.setGender(gender);
		vo.setEmail(email);
		vo.setStatus(status);
		
		req.setAttribute("vo", vo);
		
		MemberService svc = new MemberServiceImpl();
		svc.memInfoMod(vo);
		try {
			resp.sendRedirect("myInfoMod.do"); //myInfoModForm.do?
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		
	}

}
