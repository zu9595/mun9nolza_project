package com.mun9.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.member.command.AddMemberControl;
import com.mun9.member.command.AddMemberFormControl;



public class FrontController extends HttpServlet {

	//생명주기: 
	
	Map<String, Control> map;
	
	public FrontController() {
		System.out.println("생성자 호출");
		map = new HashMap<String, Control>();
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
		
		//게시판관련
		map.put("/main.do",  new MainControl());
		
		//회원가입
		map.put("/addMember.do", new AddMemberControl());
		//회원가입페이지
		map.put("/addMemberForm.do", new AddMemberFormControl());
		
		
	}
		
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //요청 정보에 한글이 있으면 알아서 인코딩해서 처리해줌
				
		System.out.println("service() 호출");
		String url = req.getRequestURI(); // /BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb
		String path = url.substring(context.length());
		System.out.println(path);
		
		Control ctrl = map.get(path);
		ctrl.execute(req, resp);
		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}
	
	
}
