<%@page import="com.mun9.member.serviceImpl.MemberServiceImpl"%>
<%@page import="com.mun9.member.service.MemberService"%>
<%@page import="com.mun9.member.vo.MemberVO"%>
<%
request.setCharacterEncoding("UTF-8");
String userName = request.getParameter("userName");
String email = request.getParameter("email");

MemberService svc = new MemberServiceImpl();
String user_id = svc.findId(userName, email); //아이디를 디비에서 가져옴..실패시 널
%>

<form name="idsearch" method="post">
	<%
	if (user_id != null) {
	%>

	<div class="container">
		<div class="found-success">
			<h4>회원님의 아이디는</h4>
			<div class="found-id"><%=user_id%></div>
			<h4>입니다</h4>
		</div>
		<div class="found-login">
			<input type="button" id="btnLogin" value="로그인" onClick="" />
		</div>
	</div>
	<%
	} else {
	%>
	<div class="container">
		<div class="found-fail">
			<h4>등록된 정보가 없습니다</h4>
		</div>
		<div class="found-login">
			<input type="button" id="btnback" value="다시 찾기"
				onClick="" /> <input type="button" id="btnjoin"
				value="회원가입" onClick="" />
		</div>
	</div>
	<%
	}
	%>
</form>

