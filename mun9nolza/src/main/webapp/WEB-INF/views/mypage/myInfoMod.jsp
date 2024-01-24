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

.fail_msg {
	display:none; 
	color: red; 
	font-size: 0.8em; 
	width:380px
}

.buttons {
	padding-left: 120px;
	padding-top: 30px
}
 .all {
	border: 1px solid  rgb(190, 190, 190);
	padding-bottom: 30px;
	border-radius: 10px;
} 
/* .out {
	width: 100%;
	text-align: center;
}
.in {
	display: inline-block;
} */


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
							<td><input type="password" name="userPw" id="lastpw" required></td>
							<td><div id="pwcheck" class="fail_msg">비밀번호 불일치</div></td>
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
			<!-- 바뀌는 구역 -->
			<div class="col-lg-9 out">
			 <div class="in">
			 <br>
				<h3>회원정보 수정</h3>
				<br>
				<!-- <div class="row align-items-center latest_product_inner productlist"style="width: 720px; height: 640px;"> -->

				<div>
				<form action="myInfoMod.do" method="post" class="validation-form"
					novalidate>
					<!-- <div class="row"> -->
					<input type="hidden" name="userId" value="${mem.userId }">
					<!-- 화면엔 안보여줘도 되니 hidden (파라미터값 받아야되니 input사용) -->
					<div class="col-xs-12 col-md-6 mb-3 all" style="margin-left: 15px;">
						<br> <label for="id" style="margin-top: 5px;">아이디</label> <input
							type="text" name="userId" value="${mem.userId }"
							class="form-control" required style="width: 380px;" id="id" disabled> <label for="pw" style="margin-top: 5px;">비밀번호</label>
							
						<input type="password" name="userPw" value="${mem.userPw }"
							placeholder="비밀번호 6자리 이상" class="form-control" required
							style="width: 380px; margin-bottom: 5px;" id="pw">
						<div id="check" class="msg"
							style="display: none; color: rgb(255, 74, 74); font-size: 0.8em; width: 380px">비밀번호는
							최소 6자리 이상(대소문자,특수문자 포함)</div>
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
					<div class="buttons">
					<button type="submit" class="btn btn-secondary btn-sm">수정하기</button>
					<button type="button" id="delinfo" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
					</div>
					</div>
					<br>
				</form>
				</div><!-- all -->
			</div> <!-- in -->
			</div>




		<!-- 바뀌는 구역 끝 -->
		


