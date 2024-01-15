<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- 상대경로로 이동 -> 파일위치에서 폴더에서 나가주고 폴더를 들어가야함 -->
<link rel="stylesheet" href="css/membercss/login.css">
</head>
<body>
	<section>
		<div class="container">
			<div class="input-form-backgroud row">
				<div class="input-form col-md-5 mx-auto">
					<div class="img-logo">
						<a href="http://localhost/mun9nolza/"> <img
							src="http://localhost/mun9nolza/img/logo.png" alt="logo">
						</a>
					</div>
					<form action="login.do" method="post">
						<ul class="ul-form">
							<li><span style="margin-top: 5px; margin-right: 17px">아이디</span>
								<input type="text" name="userId" placeholder="아이디를 입력하세요" /></li>
							<li><span style="margin-top: 5px;">비밀번호</span> <input
								type="password" name="userPw" placeholder="비밀번호를 입력하세요" /></li>

							<li><div class="mb-4"></div>
								<button type="submit" class="btn btn-primary btn-lg btn-block">로그인</button></li>
						</ul>
					</form>
					<div class="sns-box">
						<a id="naverIdLogin_loginButton" href="#" role="button"> <img
							src="https://mall.hanssem.com/resources/images/common/easy-log-1.png"
							width=50 height=50>
						</a> <a href="javascript:kakaoLogin()"> <img
							src="https://mall.hanssem.com/resources/images/common/easy-log-4.png"
							width=50 height=50 alt="카카오 로그인 버튼" /></a>
					</div>
					<div class="link-tag">
						<a href="addMemberForm.do">회원가입</a> / <a href="#">아이디찾기</a> / <a
							href="#">비밀번호찾기</a>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>