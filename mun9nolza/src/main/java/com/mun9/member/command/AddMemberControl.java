package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class AddMemberControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String userName = req.getParameter("userName");
		String userNickName = req.getParameter("userNickName");
		String gender = req.getParameter("gender");
		String phoneNum = req.getParameter("phoneNum");
		String email = req.getParameter("email");

		
		MemberVO vo = new MemberVO();

		vo.setUserId(userId);
		vo.setUserPw(userPw);
		vo.setUserName(userName);
		vo.setUserNickName(userNickName);
		vo.setGender(gender);
		vo.setPhoneNum(phoneNum);
		vo.setEmail(email);

		
		MemberService svc = new MemberServiceImpl();
		
		
		try {
			if(svc.addMember(vo)) {				
				resp.sendRedirect("loginBody.tiles"); //로그인화면으로 이동(로그인페이지 만들어지면 다시 확인하기)			
			}else {
				resp.sendRedirect("addMemberForm.do"); //실패시 다시 회원가입폼에 머물기
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// end of execute.

}// end of class.
