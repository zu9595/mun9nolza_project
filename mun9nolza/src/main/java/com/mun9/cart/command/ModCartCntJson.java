package com.mun9.cart.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;

public class ModCartCntJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String myproCnt = req.getParameter("myproCnt");
		String proCode = req.getParameter("proCode");
		String userId = req.getParameter("userId");
		
		
		
	}

}
