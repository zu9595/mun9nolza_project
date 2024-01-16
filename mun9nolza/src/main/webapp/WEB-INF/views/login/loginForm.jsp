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
	<!-- 네이버 스크립트 -->
	<script
		src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js"
		charset="utf-8"></script>
	<script>
		var naverLogin = new naver.LoginWithNaverId({
			clientId : "NoqCJJA8y8apy_2fhbFi", //내 애플리케이션 정보에 cliendId를 입력해줍니다.
			callbackUrl : "http://localhost:8081/MiddleProject/naverLogin.do", // 내 애플리케이션 API설정의 Callback URL 을 입력해줍니다.
			isPopup : false,
			callbackHandle : true
		});
		naverLogin.init();

		var testPopUp;
		function openPopUp() {
			testPopUp = window
					.open("https://nid.naver.com/nidlogin.logout", "_blank",
							"toolbar=yes,scrollbars=yes,resizable=yes,width=1000,height=1000");
		}
		function closePopUp() {
			testPopUp.close();
		}

		function naverLogout() {
			openPopUp();
			closePopUp();
		}
	</script>


	<!-- 카카오톡 스크립트 -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script>
		Kakao.init('3417f296b9ba3b697980f5786262df50'); //발급받은 키 중 javascript키를 사용해준다.
		console.log(Kakao.isInitialized()); // sdk초기화여부판단

		//카카오로그인	
		function kakaoLogin() {
			Kakao.Auth
					.login({
						success : function(response) {
							Kakao.API
									.request({
										url : '/v2/user/me',
										success : function(response) {
											console.log(response);
											console
													.log(response.kakao_account.profile.nickname);
											location.href = "socialLogin.do?userName="
													+ response.kakao_account.profile.nickname
													+ "&email="
													+ response.kakao_account.email
													+ "&gender="//male,female
													+ response.kakao_account.gender;
										},
										fail : function(error) {
											console.log(error)
										},
									})
						},
						fail : function(error) {
							console.log(error)
						},
					})
		}

		//카카오로그아웃  
		function kakaoLogout() {
			if (Kakao.Auth.getAccessToken()) {
				Kakao.API.request({
					url : '/v1/user/unlink',
					success : function(response) {
						console.log(response);
						Kakao.Auth.logout(function(obj) {
							if (obj == true) {
							} else {
							}
							location.href = 'main.do';
						});
						deleteCookie();
					},
					fail : function(error) {
						console.log(error)
					},
				})
				Kakao.Auth.setAccessToken(undefined);
			}
		}
		function deleteCookie() {
			document.cookie = 'authorize-access-token=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
		}
	</script>
</body>
</html>