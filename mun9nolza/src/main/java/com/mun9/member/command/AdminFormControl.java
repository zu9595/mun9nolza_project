package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mun9.common.Control;

public class AdminFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String id = req.getParameter("userId");
		
		HttpSession session = req.getSession();
		session.setAttribute("userId", id);
		
		//페이지 이동(forward)
			RequestDispatcher rd = req.getRequestDispatcher("admin/adminMain.tiles");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
					e.printStackTrace();
			}
		
	}

}
