package com.mun9.orderlist.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.orderdetail.service.OrderDetailService;
import com.mun9.orderdetail.serviceImpl.OrderDetailServiceImpl;
import com.mun9.orderdetail.vo.OrderDetailVO;
import com.mun9.orderlist.service.OrderListService;
import com.mun9.orderlist.serviceImpl.OrderListServiceImpl;
import com.mun9.orderlist.vo.OrderListVO;

public class OrderDelAdminControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		OrderListService osvc = new OrderListServiceImpl();
		OrderDetailService odsvc = new OrderDetailServiceImpl();
		
		String userId = req.getParameter("userId");
		int proCode = Integer.parseInt(req.getParameter("proCode"));
		int orderNo = Integer.parseInt(req.getParameter("orderNo"));
		
		OrderListVO ovo = new OrderListVO();
		ovo.setUserId(userId);
		ovo.setOrderNo(orderNo);
		
		OrderDetailVO odvo = new OrderDetailVO();
		odvo.setProCode(proCode);
		odvo.setOrderNo(orderNo);
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(odsvc.delOrderDetail(odvo)) {
			map.put("detailDelCode", "OK");
		}else {
			map.put("detailDelCode", "NG");
		}
		
		if(odsvc.selectOrderDetailList(orderNo) == null) {
			if(osvc.delOrder(ovo)) {
				map.put("listDelCode", "OK");
			}else {
				map.put("listDelCode", "NG");
			}
		}
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
