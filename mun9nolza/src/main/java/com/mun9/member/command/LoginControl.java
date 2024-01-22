package com.mun9.member.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.banner.service.BannerService;
import com.mun9.banner.serviceImpl.BannerServiceImpl;
import com.mun9.banner.vo.BannerVO;
import com.mun9.common.Control;
import com.mun9.member.service.MemberService;
import com.mun9.member.serviceImpl.MemberServiceImpl;
import com.mun9.member.vo.MemberVO;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;
import com.mun9.product.vo.ProductVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");		
		
		MemberService svc = new MemberServiceImpl();
		
		MemberVO vo = svc.login(userId, userPw);
		
		if(vo != null) {
			HttpSession session = req.getSession();
			session.setAttribute("logId", vo.getUserId());
			session.setAttribute("logPw", vo.getUserPw());
			session.setAttribute("logName", vo.getUserName());
			session.setAttribute("status", vo.getStatus());
			
			ProductService psvc = new ProductServiceImpl();
			BannerService bsvc = new BannerServiceImpl();
			
			List<BannerVO>	list1 = bsvc.mainBannerList(); // 배너 리스트
			List<ProductVO> list2 = psvc.mainBestProductList(); // 판매량 순 리스트
			
			req.setAttribute("bannerList", list1);
			req.setAttribute("bestList", list2);
			
			RequestDispatcher rd = req.getRequestDispatcher("mainbody.tiles");
			try {
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			req.setAttribute("message", "아이디와 비밀번호를 확인하세요");
			//페이지 없음
			try { 
				req.getRequestDispatcher("no/login/loginForm.tiles").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
