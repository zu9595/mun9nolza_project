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
import com.mun9.inquire.command.InquireListFormControl;
import com.mun9.member.command.AddMemberControl;
import com.mun9.member.command.AddMemberFormControl;
import com.mun9.member.command.AdminFormControl;
import com.mun9.member.command.AdminMemberDelControl;
import com.mun9.member.command.AdminMemberFormControl;
import com.mun9.member.command.AdminMemberListControl;
import com.mun9.member.command.FindIdControl;
import com.mun9.member.command.FindPwControl;
import com.mun9.member.command.SocialLoginControl;
import com.mun9.member.command.AdminProductListFormControl;
import com.mun9.member.command.LoginControl;
import com.mun9.member.command.LoginFormControl;
import com.mun9.member.command.LogoutControl;
import com.mun9.product.command.ProductDetailControl;
import com.mun9.orderlist.command.ModifyOrderJsonControl;
import com.mun9.orderlist.command.OrderListControl;
import com.mun9.orderlist.command.OrderListJsonControl;
import com.mun9.product.command.AdminProductDelControl;
import com.mun9.product.command.AdminProductListControl;
import com.mun9.product.command.AdminProductModControl;
import com.mun9.product.command.ProductListFormControl;
import com.mun9.product.command.ProductPagingListControl;
import com.mun9.product.command.mainBestProductList;


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

		//메인화면
		map.put("/main.do",  new MainControl());
		map.put("/mainBest.do", new mainBestProductList());
		
		
		//회원가입
		map.put("/addMember.do", new AddMemberControl()); //가입기능
		map.put("/addMemberForm.do", new AddMemberFormControl()); //가입화면만
		//아이디 찾기
		map.put("/findId.do", new FindIdControl());
		map.put("/findPw.do", new FindPwControl());
		
		//로그인 --수정필요
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		map.put("/socialLogin.do", new SocialLoginControl());
		
		
		//마이페이지
		map.put("/myOrderList.do", new OrderListControl());//주문목록
		map.put("/myOrderModifyJson.do", new ModifyOrderJsonControl()); //orderStatus를 Json타입으로

		//장바구니 페이지
		map.put("/cartList.do", new CartListControl());
		//장바구니 목록(Json)
		map.put("/cartListJson.do", new CartListJson());
		
		
		//전체 상품목록 이동
		map.put("/productListForm.do", new ProductListFormControl()); 
		//상품 상세페이지 이동
		map.put("/productDetail.do", new ProductDetailControl());
		//전체 상품목록 분류 및 페이징(Json)
		map.put("/productPagingList.do", new ProductPagingListControl()); 
		map.put("/productDetail.do", new ProductDetailControl());
		
		//문의 페이지
		map.put("/inquireListForm.do", new InquireListFormControl());
		
		//admin 페이지
		map.put("/adminForm.do", new AdminFormControl());
		// admin 사용자 목록 이동
		map.put("/adminMemberForm.do", new AdminMemberFormControl());
		// admin 사용자 목록 list(Json)
		map.put("/memberList.do", new AdminMemberListControl());
		// admin 사용자 삭제(Json)
		map.put("/memberDel.do", new AdminMemberDelControl());
		//admin Product List 이동
		map.put("/adminProductListForm.do", new AdminProductListFormControl());
		//admin Product List(Json)
		map.put("/adminProductList.do", new AdminProductListControl());
		// admin Product 삭제(Json)
		map.put("/productDel.do", new AdminProductDelControl());
		// admin Product 수정(Json)
		map.put("/productMod.do", new AdminProductModControl());
		
		
		
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
