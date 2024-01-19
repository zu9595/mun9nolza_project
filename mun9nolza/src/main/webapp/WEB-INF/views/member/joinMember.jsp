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
</head>

<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-5 mx-auto">
				<div class="img-logo">
					<a href="http://localhost/mun9nolza/"> <img
						src="http://localhost/mun9nolza/img/logo.png" alt="logo">
					</a>
				</div>
				<!-- 서버로 정보전송 -->
				<form action="joinMember.do" method="post" class="validation-form" novalidate>

					<div class="col-xs-12 col-md-6 mb-3" style="margin-left: 15px;">
						<br> 
						<label for="id" style="margin-top: 5px;">아이디</label>
						<input type="text" name="userId" class="form-control" required
							style="width: 380px;" id="id"> 
						<label for="pw" style="margin-top: 5px;">비밀번호</label>
						<input type="password" name="userPw" class="form-control" placeholder="비밀번호 8자리 이상" required style="width: 380px;" id="pw">
						<div id="check" class="msg" style="display:none; color: rgb(255, 74, 74); font-size: 0.8em; width:380px">비밀번호는 최소 8자리 이상(대소문자,특수문자 포함)</div>
						<label for="pwCheck" style="margin-top: 5px;">비밀번호 확인</label>
						<input type="password" class="form-control" required style="width: 380px;" id="pwCheck"> 
						<br>
						
						<c:choose>
						<c:when test="${!empty vo }">
						<label for="name" style="margin-top: 5px;">이름</label>
						<input type="text" name="userName" class="form-control" required style="width: 380px;" id="name" value="${vo.userName }" readonly>
						</c:when>
						<c:otherwise>
						<label for="name" style="margin-top: 5px;">이름</label>
						<input type="text" name="userName" class="form-control" required
							style="width: 380px;" id="name">
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
						
						<label for="phone" required style="margin-top: 20px;">휴대전화</label>
						<input type="tel" class="form-control" id="phone" name="phoneNum" placeholder="010-0000-0000" style="width: 380px;"> 
						<br> 
						
						<c:choose>
						<c:when test="${!empty vo }">
						<label for="email">이메일</label> 
						<input type="email" class="form-control" id="email" name="email"
							style="width: 380px;" placeholder="you@mun9nolza.com" id="email" value="${vo.email }" readonly>
						</c:when>
						<c:otherwise>
						<label for="email">이메일</label> 
						<input type="email" class="form-control" id="email" name="email"
							style="width: 380px;" placeholder="you@mun9nolza.com" id="email">
						</c:otherwise>
						</c:choose>
					</div>
					
					<!-- </div> -->
					<br>

					<hr class="mb-4">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input" id="aggrement"
							required> <label class="custom-control-label"
							for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
					</div>
					<div class="mb-4"></div>
					<button type="submit" class="btn btn-primary btn-lg btn-block">회원가입</button>
					<br>
					<p style="text-align: center">계정이 있으신가요? <a href="loginForm.do">로그인</a></p>
				</form>
			</div>
		</div>
		<footer class="my-3 text-center text-small"> </footer>
	</div>
	
	
<!-- 	<script>
    let pw = document.getElementById('pw');
    let check =  document.getElementById('check');
    pw.addEventListener('input', function(){
        if(pw.value.length >= 8){
         check.style.display = 'none';
        }
    });
	
	</script> -->

</body>
</html>