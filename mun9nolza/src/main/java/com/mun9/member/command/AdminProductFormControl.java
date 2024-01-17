package com.mun9.member.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;

public class AdminProductFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//페이지 이동(forward)
			RequestDispatcher rd = req.getRequestDispatcher("admin/adminProduct.tiles");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
					e.printStackTrace();
			}

	}

}