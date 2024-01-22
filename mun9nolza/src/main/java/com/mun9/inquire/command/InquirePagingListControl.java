package com.mun9.inquire.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.inquire.service.InquireService;
import com.mun9.inquire.serviceImpl.InquireServiceImpl;
import com.mun9.inquire.vo.InquireVO;
import com.mun9.product.vo.PageDTO;

public class InquirePagingListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json;charset=utf-8");
		InquireService svc = new InquireServiceImpl();
		
		String page = req.getParameter("page");
		
		page = page == null ? "1" : page;
		InquireVO vo = new InquireVO();
		vo.setPage(Integer.parseInt(page));
		
		List<InquireVO> list = svc.inquireListPaging(vo);
		
		int total = svc.getTotalCnt();
		PageDTO dto = new PageDTO(Integer.parseInt(page), total);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pageDTO", dto);
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
