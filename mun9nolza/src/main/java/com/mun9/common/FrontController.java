package com.mun9.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mun9.cart.command.AddCartJson;
import com.mun9.cart.command.CartListControl;
import com.mun9.cart.command.CartListJson;
import com.mun9.cart.command.DelCartControl;
import com.mun9.cart.command.ModCartCntJson;
import com.mun9.inquire.command.InquireAddControl;
import com.mun9.inquire.command.InquireAddFormControl;
import com.mun9.inquire.command.InquireDelControl;
import com.mun9.inquire.command.InquireDetailControl;
import com.mun9.inquire.command.InquireListControl;
import com.mun9.inquire.command.InquireListFormControl;

import com.mun9.inquire.command.MyInquireControl;

import com.mun9.inquire.command.InquireModifyControl;
import com.mun9.inquire.command.InquireModifyFormControl;
import com.mun9.inquire.command.InquirePagingListControl;

import com.mun9.inquire.command.ProdCodeListControl;
import com.mun9.member.command.AdminFormControl;
import com.mun9.member.command.AdminMemberDelControl;
import com.mun9.member.command.AdminMemberFormControl;
import com.mun9.member.command.AdminMemberListControl;
import com.mun9.member.command.AdminProductListFormControl;
import com.mun9.member.command.FindIdControl;
import com.mun9.member.command.FindPwControl;
import com.mun9.member.command.JoinIdJsonControl;
import com.mun9.member.command.JoinMemberControl;
import com.mun9.member.command.JoinMemberFormControl;
import com.mun9.member.command.LoginControl;
import com.mun9.member.command.LoginFormControl;
import com.mun9.member.command.LogoutControl;
import com.mun9.member.command.MyInfoDelControl;
import com.mun9.member.command.MyInfoModControl;
import com.mun9.member.command.MyInfoModFormControl;
import com.mun9.member.command.SocialLoginControl;
import com.mun9.orderdetail.command.OrderDetailFormControl;
import com.mun9.orderdetail.command.OrderDetailJson;
import com.mun9.orderdetail.command.OrderResultControl;
import com.mun9.orderdetail.command.SingleOrderDetailFormControl;
import com.mun9.orderlist.command.ModifyOrderJsonControl;
import com.mun9.orderlist.command.OrderListControl;
import com.mun9.orderlist.command.OrderListJsonControl;
import com.mun9.product.command.AdminProductAddControl;
import com.mun9.product.command.AdminProductAddFormControl;
import com.mun9.product.command.AdminProductDelControl;
import com.mun9.product.command.AdminProductListControl;
import com.mun9.product.command.AdminProductModControl;
import com.mun9.product.command.MainCategoryHotListJson;
import com.mun9.product.command.MainSaleListJson;
import com.mun9.product.command.ProductDetailControl;
import com.mun9.product.command.ProductListFormControl;
import com.mun9.product.command.ProductMenuListControl;
import com.mun9.product.command.ProductPagingListControl;
import com.mun9.product.command.mainBestProductList;
import com.mun9.product.command.searchControl;
import com.mun9.product.command.searchListControl;
import com.mun9.productimage.command.prodDetailImg2GetControl;
import com.mun9.productimage.command.prodDetailImgGetControl;
import com.mun9.review.command.MyReviewControl;
import com.mun9.review.command.reviewAddJson;
import com.mun9.review.command.reviewDelJson;
import com.mun9.review.command.reviewListJson;

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

		// 메인화면
		map.put("/main.do", new MainControl());
		map.put("/mainSaleList.do", new MainSaleListJson());
		map.put("/mainCategoryHotList.do", new MainCategoryHotListJson());
		map.put("/myOrderListJson.do", new OrderListJsonControl());//주문갯수
		
		//상품 검색

		map.put("/search.do",  new searchControl());//상품 검색해서 json생성
		map.put("/searchList.do",  new searchListControl());//검색 결과 페이지로 이동
		
		//map.put("/mainBest.do", new mainBestProductList()); // 미사용

		
		//회원가입
		map.put("/joinMemberForm.do", new JoinMemberFormControl()); //가입화면만
		map.put("/joinMember.do", new JoinMemberControl()); //가입기능
		map.put("/joinIdJson.do", new JoinIdJsonControl()); //아이디중복체크

		// 상품 검색
		map.put("/search.do", new searchControl());
		// map.put("/mainBest.do", new mainBestProductList()); // 미사용


		// 아이디,비밀번호 찾기
		map.put("/findId.do", new FindIdControl());
		map.put("/findPw.do", new FindPwControl());

		// 로그인 --소셜로그인 수정필요
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		map.put("/socialLogin.do", new SocialLoginControl());

		// 마이페이지
		map.put("/myOrderList.do", new OrderListControl());// 주문목록
		map.put("/myOrderModifyJson.do", new ModifyOrderJsonControl()); // orderStatus를 Json타입으로
		map.put("/myInfoModForm.do", new MyInfoModFormControl());// 수정화면만
		map.put("/myInfoMod.do", new MyInfoModControl()); // 수정기능
		map.put("/myInfoDel.do", new MyInfoDelControl()); // 삭제기능
		map.put("/myReview.do", new MyReviewControl());
		map.put("/myInquire.do", new MyInquireControl());

		// 장바구니 페이지
		map.put("/cartList.do", new CartListControl());
		// 장바구니 목록(Json)
		map.put("/cartListJson.do", new CartListJson());
		// 장바구니 상품 삭제
		map.put("/delCart.do", new DelCartControl());
		// 장바구니 상품 추가
		map.put("/addCartJson.do", new AddCartJson());
		// 장바구니 상품 숫자 변경
		map.put("/modCartCntJson.do", new ModCartCntJson());
		// 결제화면으로 이동
		map.put("/orderDetailForm.do", new OrderDetailFormControl());
		// 단건결제화면으로 이동
		map.put("/singleOrderDetailForm.do", new SingleOrderDetailFormControl());

		//map.put("/orderDetailData.do", new OrderDetailJson()); // 미사용
		//결제 후 내역 페이지

		// 결제 시 데이터 관련

		//map.put("/orderDetailData.do", new OrderDetailJson());
		// 결제 후 내역 페이지
		map.put("/orderResult.do", new OrderResultControl());

		// 전체 상품목록 이동
		map.put("/productListForm.do", new ProductListFormControl());
		// 상품 상세페이지 이동
		map.put("/productDetail.do", new ProductDetailControl());
		// 상품 리뷰 목록Json
		map.put("/reviewList.do", new reviewListJson());
		// 상품 리뷰 추가Json
		map.put("/reviewAdd.do", new reviewAddJson());
		// 상품 리뷰 삭제Json
		map.put("/reviewDel.do", new reviewDelJson());
		// 전체 상품목록 분류 및 페이징(Json)
		map.put("/productPagingList.do", new ProductPagingListControl());
		// 상품목록 메뉴
		map.put("/productMenuList.do", new ProductMenuListControl());

		// 문의 페이지 이동
		map.put("/inquireListForm.do", new InquireListFormControl());
		// 문의 목록 list(Json)
		map.put("/inquireList.do", new InquireListControl());
		// 문의 등록 페이지 이동
		map.put("/inquireAddForm.do", new InquireAddFormControl());
		// 상품 코드 list(Json)
		map.put("/prodCodeList.do", new ProdCodeListControl());
		// 문의 등록
		map.put("/inquireAdd.do", new InquireAddControl());
		// 문의 삭제
		map.put("/inquireDel.do", new InquireDelControl());
		// 문의 상세
		map.put("/inquireDetail.do", new InquireDetailControl());
		// 문의 수정 페이지 이동
		map.put("/inquireModifyForm.do", new InquireModifyFormControl());
		// 문의 수정
		map.put("/inquireModify.do", new InquireModifyControl());
		// 문의 페이징 -- 수정 필요
		map.put("/inquirePagingList.do", new InquirePagingListControl());

		// 상품 상세
		map.put("/prodDetailImg.do", new prodDetailImgGetControl());
		map.put("/prodDetailImg2.do", new prodDetailImg2GetControl());

		// admin 페이지
		map.put("/adminForm.do", new AdminFormControl());
		// admin 사용자 목록 이동
		map.put("/adminMemberForm.do", new AdminMemberFormControl());
		// admin 사용자 목록 list(Json)
		map.put("/memberList.do", new AdminMemberListControl());
		// admin 사용자 삭제(Json)
		map.put("/memberDel.do", new AdminMemberDelControl());
		// admin Product List 이동
		map.put("/adminProductListForm.do", new AdminProductListFormControl());
		// admin Product AddForm 이동
		map.put("/adminProductAddForm.do", new AdminProductAddFormControl());
		// admin Product List(Json)
		map.put("/adminProductList.do", new AdminProductListControl());
		// admin Product 삭제(Json)
		map.put("/productDel.do", new AdminProductDelControl());
		// admin Product 수정(Json)
		map.put("/productMod.do", new AdminProductModControl());
		// admin Product 추가
		map.put("/productAdd.do", new AdminProductAddControl());

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
