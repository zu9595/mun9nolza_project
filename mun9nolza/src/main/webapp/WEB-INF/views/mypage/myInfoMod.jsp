<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<script src="js/mypagejs/myInfoMod.js"></script>

<style>
.delmodal {
  width: 100%;
  height: 100%;
  position: fixed;
  background: rgba(0,0,0,0.5);
  z-index: 6;
  padding: 100px 50px;

  visibility: hidden; 
  opacity: 0;
}

.show { 
  visibility: visible;
  opacity: 1;
}
</style>

<!-- 회원 탈퇴 모달창 -->
<div class="delmodal" id="#deleteForm">
 <div class="modal-dialog">
  <div class="modal-content">
  <!-- Modal Header -->
  <div class="modal-header">
   <h4 class="modal-title">회원탈퇴</h4>
   <button type="button" class="close" data-dismiss="modal">&times;</button>
  </div>
  <!-- Modal body -->
  <div class="modal-body">
  <b> 탈퇴 후 복구가 불가능합니다. <br> 정말로 탈퇴하시겠습니까? <br></b>
  <br>
  <form action="myInfoDel.do" method="post">
  <input type="hidden" name="userId" value="${mem.userId }">
  <!-- 회원탈퇴 시 : 비밀번호 -->
					<table>
						<tr>
							<td>비밀번호: </td>
							<td><input type="password" name="userPw" id="lastpw" required>
							</td>
						</tr>

					</table>
					<br>
					<button type="submit" class="clear btn btn-secondary btn-sm">탈퇴하기</button>
					<!-- <button type="button" class="close">닫기</button> -->
				</form>
			</div>
	</div>
	</div>
		</div>


<section class="cat_product_area section_padding">
	<div class="container">
		<div class="row" style="padding-top: 80px">
		
			<!-- body부분 -->
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
								<li><a href="myReview.do">마이리뷰</a></li>
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
			<div class="col-lg-9">
				<h2>회원정보 수정</h2>
				<!-- <div class="row align-items-center latest_product_inner productlist"style="width: 720px; height: 640px;"> -->

				<!-- <div style="align:center"> -->
				<form action="myInfoMod.do" method="post" class="validation-form"
					novalidate>
					<!-- <div class="row"> -->
					<input type="hidden" name="userId" value="${mem.userId }">
					<!-- 화면엔 안보여줘도 되니 hidden (파라미터값 받아야되니 input사용) -->
					<div class="col-xs-12 col-md-6 mb-3" style="margin-left: 15px;">
						<br> <label for="id" style="margin-top: 5px;">아이디</label> <input
							type="text" name="userId" value="${mem.userId }"
							class="form-control" required style="width: 380px;" id="id"
							disabled> <label for="pw" style="margin-top: 5px;">비밀번호</label>
						<input type="password" name="userPw" value="${mem.userPw }"
							placeholder="비밀번호 8자리 이상" class="form-control" required
							style="width: 380px; margin-bottom: 5px;" id="pw">
						<div id="check" class="msg"
							style="display: none; color: rgb(255, 74, 74); font-size: 0.8em; width: 380px">비밀번호는
							최소 8자리 이상(대소문자,특수문자 포함)</div>
						<label for="pwCheck" style="margin-top: 5px;"></label> <input
							type="password" class="form-control" name="userPw"
							placeholder="비밀번호 재확인" required style="width: 380px;"
							id="pwCheck"> <br> <label for="name"
							style="margin-top: 5px;">이름</label> <input type="text"
							name="userName" value="${mem.userName }" class="form-control"
							required style="width: 380px;" id="name"> <label
							for="phone" required style="margin-top: 20px;">휴대전화</label> <input
							type="tel" class="form-control" id="phone" name="phoneNum"
							value="${mem.phoneNum }" style="width: 380px;"> <br>

						<label for="email">이메일</label> <input type="email"
							class="form-control" id="email" name="email"
							style="width: 380px;" id="email" value="${mem.email }">
					</div>
					<br>
					<div>
					<button type="submit" class="btn btn-secondary btn-sm">수정하기</button>
					<button type="button" id="delinfo" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
					</div>
				</form>
			</div>

		</div>


		<!-- 바뀌는 구역 끝 -->
		
	</div>
</section>

