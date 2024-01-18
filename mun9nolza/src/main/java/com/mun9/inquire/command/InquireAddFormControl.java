package com.mun9.inquire.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;

public class InquireAddFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher rd = req.getRequestDispatcher("inquire/inquireAddForm.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
				e.printStackTrace();
		}
	}

}
