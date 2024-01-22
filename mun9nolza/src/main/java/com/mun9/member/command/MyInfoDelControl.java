package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;

public class MyInfoDelControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MemberService svc = new MemberServiceImpl();
		
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("logId");
		//String logPw = (String)session.getAttribute("logPw");
		String userPw = req.getParameter("userPw"); //비밀번호 입력받은 값
		
		try {
			if(svc.delMember(userId, userPw)) {
				req.setAttribute("msg", "탈퇴되었습니다");
				req.setAttribute("url", "main.do");
				session.invalidate(); //세션무효화
				req.getRequestDispatcher("no/common/result.tiles").forward(req, resp);
			}else {
				resp.sendRedirect("myInfoModForm.do");
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		//try {
		//if(svc.delMember(userId, userPw)) {
		//	session.invalidate(); //세션무효화
		//	resp.sendRedirect("mainbody.tiles");
		//}else {
		//	resp.sendRedirect("myInfoModForm.do");
		//}
		//}catch (IOException e) {
		//	e.printStackTrace();
		//}

	}
}