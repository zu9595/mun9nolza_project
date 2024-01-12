package com.mun9.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		RequestDispatcher rd =  req.getRequestDispatcher("mainbody.tiles");
		try {
			rd.forward(req,  resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
