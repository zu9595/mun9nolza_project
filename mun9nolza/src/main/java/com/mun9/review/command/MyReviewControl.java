package com.mun9.review.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.review.service.ReviewService;
import com.mun9.review.serviceImpl.ReviewServiceImpl;
import com.mun9.review.vo.ReviewVO;

public class MyReviewControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		ReviewVO vo = new ReviewVO();
		ReviewService svc = new ReviewServiceImpl();

		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("logId");

		List<ReviewVO> list = svc.getMyReview(userId);
		req.setAttribute("reviewList", list);
		req.setAttribute("vo", vo);

		// 페이지이동
		RequestDispatcher rd = req.getRequestDispatcher("mypage/myReview.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
