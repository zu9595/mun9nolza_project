package com.mun9.product.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;

public class searchListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//HttpSession session = req.getSession();
		//String userId = (String)session.getAttribute("logId");
		//req.setAttribute("userId", userId);

		RequestDispatcher rd = req.getRequestDispatcher("product/searchList.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
