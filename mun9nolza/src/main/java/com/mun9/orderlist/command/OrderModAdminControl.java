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

public class OrderModAdminControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		OrderListService osvc = new OrderListServiceImpl();
		OrderDetailService odsvc = new OrderDetailServiceImpl();
		
		String userId = req.getParameter("userId"); //o 수정불가
		int orderNo = Integer.parseInt(req.getParameter("orderNo")); //o 수정불가
		int proCode = Integer.parseInt(req.getParameter("proCode")); //p 수정불가
		String proName = req.getParameter("proName"); //p 수정불가
		String orderDate = req.getParameter("orderDate"); //o 수정불가
		String orderRecipient = req.getParameter("orderRecipient"); //o 
		String deProCnt = req.getParameter("deProCnt"); //od
		String proImage = req.getParameter("proImage"); //p
		String deProPrice = req.getParameter("deProPrice"); //od
		String totalPrice = req.getParameter("totalPrice"); //o
		String deliveryFee = req.getParameter("deliveryFee"); //o
		String orderStatus = req.getParameter("orderStatus"); //o
		String orderPhone = req.getParameter("orderPhone"); //o
		String orderAddr = req.getParameter("orderAddr"); //o
		String detailAddr = req.getParameter("detailAddr"); //o
		
		
		OrderListVO ovo = new OrderListVO();
		OrderDetailVO odvo = new OrderDetailVO();
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		
//			if(osvc.modOrder(ovo)) {
//				map.put("retCode", "OK");
//			}else {
//				map.put("retCode", "NG");
//		
//			if(odsvc.modOrderDetail(odvo)) {
//				map.put("retCode", "OK");
//			}else {
//				map.put("retCode", "NG");
//			}
		
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
