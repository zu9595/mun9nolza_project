package com.mun9.cart.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.common.Control;

public class DelCartJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
//		String id = req.getParameter("userId");
//		String name = req.getParameter("proName");
//		
//		CartService svc = new CartServiceImpl();
//		Map<String, Object> map = new HashMap<>();
//		
//		CartVO vo = new CartVO();
//		vo.setUserId(id);
//		vo.setProName(name);;
//		
//		
//		if(svc.removeMember(id)) {
//			map.put("retCode", "OK");
//		}else {
//			map.put("retCode", "NG");
//		}
//		
//		Gson gson = new GsonBuilder().create();
//		try {
//			resp.getWriter().print(gson.toJson(map));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	}

}
