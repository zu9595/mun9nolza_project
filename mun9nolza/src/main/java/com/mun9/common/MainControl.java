package com.mun9.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.banner.service.BannerService;
import com.mun9.banner.serviceImpl.BannerServiceImpl;
import com.mun9.banner.vo.BannerVO;
import com.mun9.product.service.ProductService;
import com.mun9.product.serviceImpl.ProductServiceImpl;
import com.mun9.product.vo.ProductVO;

public class MainControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
//		if (req.getMethod().equals("POST")) {
//			String userId = req.getParameter("userId");
//			String userPw = req.getParameter("userPw");
//
//			MemberService svc = new MemberServiceImpl();
//
//			MemberVO vo = svc.login(userId, userPw);
//
//			req.setAttribute("vo", vo);
//
//			try {
//				req.getRequestDispatcher("mainbody.tiles").forward(req, resp);
//			} catch (ServletException | IOException e) {
//				e.printStackTrace();
//			}
//
//		} else {
			ProductService psvc = new ProductServiceImpl();
			BannerService bsvc = new BannerServiceImpl();
			
			List<BannerVO>	list1 = bsvc.mainBannerList(); // 배너 리스트
			List<ProductVO> list2 = psvc.mainBestProductList(); // 판매량 순 리스트
			
			req.setAttribute("bannerList", list1);
			req.setAttribute("bestList", list2);

			RequestDispatcher rd = req.getRequestDispatcher("mainbody.tiles");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
//		}
	}

}
