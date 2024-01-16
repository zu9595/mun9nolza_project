package com.mun9.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.cart.command.CartListControl;
import com.mun9.cart.command.CartListJson;
import com.mun9.member.command.AddMemberControl;
import com.mun9.member.command.AddMemberFormControl;
import com.mun9.member.command.AdminFormControl;
import com.mun9.member.command.AdminMemberDelControl;
import com.mun9.member.command.AdminMemberFormControl;
import com.mun9.member.command.AdminMemberListControl;
import com.mun9.member.command.FindIdControl;
import com.mun9.member.command.SocialLoginControl;
import com.mun9.member.command.AdminProductListFormControl;
import com.mun9.member.command.LoginControl;
import com.mun9.member.command.LoginFormControl;
import com.mun9.member.command.LogoutControl;

import com.mun9.product.command.ProductDetailControl;
import com.mun9.orderlist.command.OrderListControl;
import com.mun9.orderlist.command.OrderListJsonControl;

import com.mun9.product.command.AdminProductListControl;

import com.mun9.product.command.GetProductControl;
import com.mun9.product.command.ProductListControl;
import com.mun9.product.command.ProductListFormControl;
import com.mun9.product.command.ProductPagingListControl;

public class FrontController extends HttpServlet {

	// 생명주기:

	Map<String, Control> map;

	public FrontController() {
		System.out.println("생성자 호출");
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");

		//게시판관련
		map.put("/main.do",  new MainControl());
		
		
		//회원가입
		map.put("/addMember.do", new AddMemberControl()); //가입기능
		map.put("/addMemberForm.do", new AddMemberFormControl()); //가입화면만
		
		//마이페이지
    map.put("/myOrderList.do", new OrderListControl());
    //id값에 맞는 orderList 정보를 Json타입의 데이터로 묶어줌 
    map.put("/myOrderListJson.do", new OrderListJsonControl());
		
		
		//로그인 --수정필요
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		map.put("/socialLogin.do", new SocialLoginControl());

		//아이디 찾기
		map.put("/findId.do", new FindIdControl());

		//상품관련	--수정필요
		map.put("/productDetail.do", new ProductDetailControl());
		//장바구니 페이지 --수정필요(mybatis-config.xml 파일도 수정해야함)
    map.put("/cartListForm.do", new CartListFormControl());
		map.put("/cartList.do", new CartListControl());
		map.put("/cartListJson.do", new CartListJson());
		//productlist 페이지 --수정필요

		map.put("/getProduct.do", new GetProductControl());
		map.put("/productListForm.do", new ProductListFormControl()); // 상품목록페이지 이동
		map.put("/productList.do", new ProductListControl());
		map.put("/productPagingList.do", new ProductPagingListControl()); // 상품목록 및 분류
		map.put("/productDetail.do", new ProductDetailControl());
		
		//admin 페이지
		map.put("/adminForm.do", new AdminFormControl());
		// admin 사용자 목록 이동
		map.put("/adminMemberForm.do", new AdminMemberFormControl());
		// admin 사용자 목록 list
		map.put("/memberList.do", new AdminMemberListControl());
		// admin 사용자 삭제
		map.put("/memberDel.do", new AdminMemberDelControl());
		//admin Product List 이동
		map.put("/adminProductListForm.do", new AdminProductListFormControl());
		//admin Product List
		map.put("/adminProductList.do", new AdminProductListControl());

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 요청 정보에 한글이 있으면 알아서 인코딩해서 처리해줌

		System.out.println("service() 호출");
		String url = req.getRequestURI(); // /BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb
		String path = url.substring(context.length());
		System.out.println(path);

		Control ctrl = map.get(path);
		ctrl.execute(req, resp);

	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}

}
