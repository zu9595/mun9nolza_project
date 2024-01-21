package com.mun9.orderdetail.command;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mun9.common.Control;
import com.mun9.orderdetail.service.OrderDetailService;
import com.mun9.orderdetail.serviceImpl.OrderDetailServiceImpl;
import com.mun9.orderlist.vo.OrderListVO;

public class OrderDetailJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		
		OrderDetailService svc = new OrderDetailServiceImpl();
		OrderListVO vo = new OrderListVO();
		String userId = (String) session.getAttribute("logId");
		
		Date orderDate = null; // 임시

		String orderRecipient = req.getParameter("recipient");
		String orderAddr = req.getParameter("orderAddr");
		String detailAddr = req.getParameter("detailAddr");
		String orderPhone = req.getParameter("orderPhone");
		String deliveryMemo = req.getParameter("deliveryMemo");
		int totalPrice = Integer.parseInt(req.getParameter("totalPrice"));
		int deliveryFee = Integer.parseInt(req.getParameter("deliveryFee"));
		String orderStatus = req.getParameter("orderStatus");

		vo.setUserId(userId);
		vo.setOrderDate(orderDate);
		vo.setOrderRecipient(orderRecipient);
		vo.setOrderAddr(orderAddr);
		vo.setDetailAddr(detailAddr);
		vo.setOrderPhone(orderPhone);
		vo.setDeliveryMemo(deliveryMemo);
		vo.setTotalPrice(totalPrice);
		vo.setDeliveryFee(deliveryFee);
		vo.setOrderStatus(orderStatus);

		Gson gson = new GsonBuilder().create();

		Map<String, Object>	map = new HashMap<>();
		try {

			if (svc.addOrder(vo)) {
				map.put("retCode", "OK");
				map.put("vo", vo);
				resp.getWriter().print(gson.toJson(map));
			} else {
				map.put("retCode", "NG");
				resp.getWriter().print(gson.toJson(map));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
