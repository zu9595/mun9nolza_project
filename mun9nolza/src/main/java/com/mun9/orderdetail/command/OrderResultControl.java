package com.mun9.orderdetail.command;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;
import com.mun9.orderlist.vo.OrderListVO;

public class OrderResultControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
//		HttpSession session = req.getSession();
//		String userId = (String)session.getAttribute("logId");
		
		// 페이지이동
		RequestDispatcher rd = req.getRequestDispatcher("order/orderResult.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
