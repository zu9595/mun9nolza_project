<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- 상대경로로 이동 -> 파일위치에서 폴더에서 나가주고 폴더를 들어가야함 -->
<link rel="stylesheet" href="css/membercss/signUp.css">
<script src="js/memberjs/joinMember.js"></script>

<style>
.success_msg {
	display:none; 
	color: blue; 
	font-size: 0.8em; 
	width:380px
}

.fail_msg {
	display:none; 
	color: red; 
	font-size: 0.8em; 
	width:380px
}

.star {
 	color:red; 
 	font-weight: bold
}

.form-control {
	width: 380px;
}


</style>

</head>

<body>

  

	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-5 mx-auto">
				<div class="img-logo">
					<a href="/mun9nolza/"> <img
						src="/mun9nolza/img/logo.png" alt="logo">
					</a>
				</div>
				<!-- 서버로 정보전송 -->
				<form name="form" action="joinMember.do" method="post" class="validation-form"> <!--return signUpCheck()  -->

					<div class="col-xs-12 col-md-6 mb-3" style="margin-left: 15px;">
						<br> 
						<!-- 아이디 -->
						<label for="id" style="margin-top: 5px;">아이디<span class="star">*</span></label>
						<input type="text" id="id" name="userId" class="form-control no_input" placeholder="아이디 5자리 이상"> 
						<div id="id_ok" class="success_msg">사용 가능한 아이디</div>
						<div id="id_no" class="fail_msg">사용 불가한 아이디</div>
						<div id="id_length" class="fail_msg">아이디 최소 5자리 이상</div>
						<!-- 비밀번호 -->
						<label for="pw" style="margin-top: 5px;">비밀번호<span class="star">*</span></label>
						<input type="password"  id="pw" name="userPw" class="form-control no_input" placeholder="비밀번호 6자리 이상" >
						<div id="pwcheck" class="fail_msg">비밀번호 최소 6자리 이상</div>
						<!--<label for="pwCheck" style="margin-top: 5px;"></label>  -->
						<input type="password" id="pwCheck" class="form-control no_input" style="width: 380px; margin-top: 3px"  placeholder="비밀번호 확인"> 
						<div id="pwcheck2" class="fail_msg">비밀번호 불일치</div>
						<br>
						
						<!-- 이름 -->
						<c:choose>
						<c:when test="${!empty vo }">
						<label for="name" style="margin-top: 5px;">이름<span class="star">*</span></label>
						<input type="text" name="userName" class="form-control no_input" id="name" value="${vo.userName }" readonly>
						</c:when>
						<c:otherwise>
						<label for="name" style="margin-top: 5px;">이름<span class="star">*</span></label>
						<input type="text" name="userName" class="form-control no_input" id="name">
						</c:otherwise>
						</c:choose>
						
						<br>
						
						<c:choose>
						<c:when test="${!empty vo }">
						<label for="gender" style="margin-top: 5px;">성별</label>
						<br>
						<div class="genderBox">
						<c:choose>
						<c:when test="${vo.gender eq 'male' }">
							<label for="gender">남성</label> 
							<input type='radio' class='gender' name='gender' value='남' checked/> 
						</c:when>
						<c:otherwise>
							<label for="gender">여성</label> 
							<input type='radio' class='gender' name='gender' value='여' checked/>
						</c:otherwise>
						</c:choose>
						</div>
						</c:when>
						<c:otherwise>
						<label for="gender" style="margin-top: 5px;">성별</label>
						<br>
						<div class="genderBox">
							<label for="gender">남성</label> 
							<input type='radio' class='gender' name='gender' value='남' /> 
							<label for="gender">여성</label> 
							<input type='radio' class='gender' name='gender' value='여' />
						</div>
						</c:otherwise>
						</c:choose>
						
						<label for="phone" style="margin-top: 20px;">휴대전화<span class="star">*</span></label>
						<input type="tel" class="form-control no_input" id="phone" name="phoneNum" placeholder="010-0000-0000"> 
						<br> 
						
						<c:choose>
						<c:when test="${!empty vo }">
						<label for="email">이메일</label> 
						<input type="email" class="form-control" id="email" name="email" placeholder="you@mun9nolza.com" id="email" value="${vo.email }" readonly>
						</c:when>
						<c:otherwise>
						<label for="email">이메일</label> 
						<input type="email" class="form-control" id="email" name="email" placeholder="you@mun9nolza.com" id="email">
						</c:otherwise>
						</c:choose>
					</div>
					
					<!-- </div> -->
					<br>

					<hr class="mb-4">
					<div class="mb-4"></div>
					<button type="submit" class="btn btn-primary btn-lg btn-block">회원가입</button>
					<br>
					<p style="text-align: center">계정이 있으신가요? <a href="loginForm.do">로그인</a></p>
				</form>
			</div>
		</div>
		<footer class="my-3 text-center text-small"> </footer>
	</div>
	
	

</body>
</html>