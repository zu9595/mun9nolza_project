package com.mun9.product.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;

public class ProductMainListAjax implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.getRequestDispatcher("mainbody.tiles").forward(req,resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
		
	}

	
}
