package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class AddMemberControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		MemberService svc = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		if (req.getMethod().equals("GET")) {
			
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			String userName = req.getParameter("userName");
			String gender = req.getParameter("gender");
			String phoneNum1 = req.getParameter("phoneNum1");
			String phoneNum2 = req.getParameter("phoneNum2");
			String phoneNum3 = req.getParameter("phoneNum3");
			
			String phoneNum = phoneNum1.concat(phoneNum2).concat(phoneNum3);
			
			String email = req.getParameter("email");
			vo.setStatus("user");

			vo.setUserId(userId);
			vo.setUserPw(userPw);
			vo.setUserName(userName);
			vo.setGender(gender);
			vo.setPhoneNum(phoneNum);
			vo.setEmail(email);
		
		} else if (req.getMethod().equals("POST")) {
			
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			String userName = req.getParameter("userName");
			String gender = req.getParameter("gender");
			String phoneNum1 = req.getParameter("phoneNum1");
			String phoneNum2 = req.getParameter("phoneNum2");
			String phoneNum3 = req.getParameter("phoneNum3");
			
			String phoneNum = phoneNum1.concat(phoneNum2).concat(phoneNum3);
			
			String email = req.getParameter("email");

			vo.setUserId(userId);
			vo.setUserPw(userPw);
			vo.setUserName(userName);
			vo.setGender(gender);			
			vo.setPhoneNum(phoneNum);
			vo.setEmail(email);
			vo.setStatus("user");
			
		}

		//데이터 세팅해서 넘기기
		req.setAttribute("vo", vo);
		
		//이동할 페이지
		RequestDispatcher rd = req.getRequestDispatcher("mainbody.tiles");
		try {
			if(svc.addMember(vo)) {				
				rd.forward(req, resp);
			} else {
				resp.sendRedirect("addMemberForm.do");
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		

	}// end of execute.

}// end of class.
