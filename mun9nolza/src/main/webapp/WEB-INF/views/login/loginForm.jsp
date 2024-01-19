<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jquery plugins here-->
<script src="js/jquery-1.12.1.min.js"></script>
<!-- popper js -->
<script src="js/popper.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<script src="js/loginjs/loginForm.js"></script>
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

							<li>
								<div class="mb-4"></div>
								<button type="submit" class="btn btn-primary btn-lg btn-block">로그인</button>
							</li>
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
						<a href="addMemberForm.do" style="color: black;">회원가입</a> / <a
							href="#" style="color: black;" data-toggle="modal"
							data-target="#modal_findid" onclick="resetIdInfo()">아이디찾기</a> / <a
							href="#" style="color: black;" data-toggle="modal"
							data-target="#modal_findpw" onclick="resetPwInfo()">비밀번호찾기</a>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Find Id Modal -->
	<div class="modal fade" id="modal_findid" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">아이디 찾기</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" onclick="resetIdInfo()">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" data-toggle="modal"
						onclick="resultIdModal()">찾기</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Find Pw Modal -->
	<div class="modal fade" id="modal_findpw" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">비밀번호 찾기</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" onclick="resetPwInfo()">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" data-toggle="modal"
						onclick="resultPwModal()">찾기</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 네이버 스크립트 -->
	<script
		src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js"
		charset="utf-8"></script>
	<script>
				var naverLogin = new naver.LoginWithNaverId({
					clientId: "NoqCJJA8y8apy_2fhbFi", //내 애플리케이션 정보에 cliendId를 입력해줍니다.
					callbackUrl: "http://localhost:8081/MiddleProject/naverLogin.do", // 내 애플리케이션 API설정의 Callback URL 을 입력해줍니다.
					isPopup: false,
					callbackHandle: true
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
	<script src="js/loginjs/kakao.js"></script>

</body>

</html>