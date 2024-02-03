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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class OrderModAdminControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		OrderListService osvc = new OrderListServiceImpl();
		OrderDetailService odsvc = new OrderDetailServiceImpl();
		
		String saveLoc = req.getServletContext().getRealPath("img");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mr = null;
		//만약에 파일 수정을 할수도 있어서 멀티파트 형식으로 저장
		try {
		mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		String userId = mr.getParameter("userId"); //o 수정불가
		int proCode = Integer.parseInt(mr.getParameter("proCode")); //p 수정불가
		int orderNo = Integer.parseInt(mr.getParameter("orderNo")); //o 수정불가
		String orderRecipient = mr.getParameter("orderRecipient"); //o 
		int deProCnt = Integer.parseInt(mr.getParameter("deProCnt")); //od
		int deProPrice = Integer.parseInt(mr.getParameter("deProPrice")); //od
		int totalPrice = Integer.parseInt(mr.getParameter("totalPrice")); //o
		int deliveryFee = Integer.parseInt(mr.getParameter("deliveryFee")); //o
		String orderStatus = mr.getParameter("orderStatus"); //o
		String orderPhone = mr.getParameter("orderPhone"); //o
		String orderAddr = mr.getParameter("orderAddr"); //o
		String detailAddr = mr.getParameter("detailAddr"); //o
		
		
		OrderListVO ovo = new OrderListVO();
		ovo.setUserId(userId);
		ovo.setOrderNo(orderNo);
		ovo.setOrderRecipient(orderRecipient);
		ovo.setTotalPrice(totalPrice);
		ovo.setDeliveryFee(deliveryFee);
		ovo.setOrderStatus(orderStatus);
		ovo.setOrderAddr(orderAddr);
		ovo.setDetailAddr(detailAddr);
		ovo.setOrderPhone(orderPhone);
		
		OrderDetailVO odvo = new OrderDetailVO();
		odvo.setProCode(proCode);
		odvo.setOrderNo(orderNo);
		odvo.setDeProCnt(deProCnt);
		odvo.setDeProPrice(deProPrice);
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(osvc.modOrder(ovo)) {
			map.put("listModCode", "OK");
		}else {
			map.put("listModCode", "NG");
		}
		
		if(odsvc.modOrderDetail(odvo)) {
			map.put("detailModCode", "OK");
		}else {
			map.put("detailModCode", "NG");
		}
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
