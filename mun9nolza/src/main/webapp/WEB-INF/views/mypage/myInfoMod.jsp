<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<script src="js/mypagejs/myInfoMod.js"></script>

<section class="cat_product_area section_padding">
	<div class="container">
		<div class="row" style="padding-top: 80px"> <!-- body부분 -->
			<div class="col-lg-3">

				<div class="left_sidebar_area" style="padding-top: 100px">
					<aside class="left_widgets p_filter_widgets">
						<div class="l_w_title">
							<h4>주문내역</h4>
							<br>
						</div>
						<div class="widgets_inner">
							<ul class="list">
								<li><a href="myOrderList.do">주문/배송목록</a></li>
							</ul>
						</div>
					</aside>

					<aside class="left_widgets p_filter_widgets">
						<div class="l_w_title">
							<h4>회원정보</h4>
							<br>
						</div>
						<div class="widgets_inner">
							<ul class="list">
								<li><a href="myInfoModForm.do">개인정보 수정</a></li>
								<li><a href="#">마이리뷰</a></li>
								<li><a href="#">회원탈퇴</a></li>
							</ul>
						</div>
					</aside>

					<aside class="left_widgets p_filter_widgets">
						<div class="l_w_title">
							<h4>고객센터</h4>
							<br>
						</div>
						<div class="widgets_inner">
							<ul class="list">
								<li><a href="#">1:1문의내역</a></li>
							</ul>
						</div>
					</aside>
				</div>

			</div>

			<!-- 바뀌는 구역 -->
			<div class="col-lg-9" > 
				<h2>회원정보 수정</h2>
				<!-- <div class="row align-items-center latest_product_inner productlist"style="width: 720px; height: 640px;"> -->
					
					<!-- <div style="align:center"> -->
					<form action="myInfoMod.do" method="post" class="validation-form" novalidate>
					<!-- <div class="row"> -->
						<input type="hidden" name="userId" value="${mem.userId }"> <!-- 화면엔 안보여줘도 되니 hidden (파라미터값 받아야되니 input사용) -->
					<div class="col-xs-12 col-md-6 mb-3" style="margin-left: 15px;">
						<br> 
						<label for="id" style="margin-top: 5px;">아이디</label>
						<input type="text" name="userId" value="${mem.userId }"class="form-control" required style="width: 380px;" id="id" disabled> 
						<label for="pw" style="margin-top: 5px;">비밀번호</label>
						<input type="password" name="userPw" value="${mem.userPw }" class="form-control" required style="width: 380px; margin-bottom: 5px;" id="pw">
						<label for="pwCheck" style="margin-top: 5px;"></label>
						<input type="password" class="form-control" name="userPw" placeholder="비밀번호 재확인" required style="width: 380px;" id="pwCheck">
						
						<br>
						
						<label for="name" style="margin-top: 5px;">이름</label>
						<input type="text" name="userName" value="${mem.userName }" class="form-control" required
							style="width: 380px;" id="name">

						<label for="phone" required style="margin-top: 20px;">휴대전화</label>
						<input type="tel" class="form-control" id="phone" name="phoneNum" value="${mem.phoneNum }" style="width: 380px;"> 
						<br> 
						
						<label for="email">이메일</label> 
						<input type="email" class="form-control" id="email" name="email"
							style="width: 380px;" id="email" value="${mem.email }">						
					</div>
					<br>

					<button type="submit" class="modify">수정하기</button>
				</form>
				</div>
				
			</div>

			<!-- 바뀌는 구역 끝 -->
		</div>
	</div>
</section>

<!--     <script>

    
    </script> -->