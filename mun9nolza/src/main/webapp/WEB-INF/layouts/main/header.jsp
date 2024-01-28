<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="js/adminjs/adminSession.js"></script>
<style>
	.media-body a{color:#111}
	#cartListTbody tr:last-child td:last-child ul{
		text-align:right
		}
	#cartListTbody tr td img{
		max-width:100px;
	}
	#cartListTbody td:nth-child(3) h5 span{display:inline-block; position:relative;}
	#cartListTbody td:nth-child(3) h5 span:before{content:''; display:block; position:absolute; left:0; top:50%; width:100%; height:1px; margin-top:-0.5px;}
	
</style>
<header class="main_menu home_menu">
	<!-- 로고 및 로그인 -->
	<!-- 스타일에 화면이 작아지면 display ='none' 처리 -->
	<div class="container unable">
		<div class="row align-items-center">
			<div class="col-lg-12" style="margin-top: 35px;">
				<nav class="navbar navbar-expand-lg navbar-light">
			<a class="navbar-brand able" style="visibility: hidden; margin-right: 3rem;"> <img
						src="img/logo.png" alt="logo">
					</a>
					<div class="collapse navbar-collapse main-menu-item"
						id="navbarSupportedContent">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="navbar-brand"
								href="main.do"> <img src="img/logo.png" alt="logo" style=" width: 10rem;">
							</a></li>
						</ul>
					</div>
					<div class="hearer_icon d-flex" style="font-family: 'Metropolis','Noto Sans KR',sans-serif; font-size: 1rem; font-weight: 700;">
					<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                        <c:choose>
							<c:when test="${empty logId }">
                		<li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="padding: 0;"><i class="far fa-user"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="loginForm.do">로그인&ensp;</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="joinMemberForm.do">회원가입</a></li>
                        </ul>
                        </c:when>
						<c:when test="${!empty logId and status eq 'admin'}">
							<li><span>${logName } 님</span></li>
                		<li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="padding: 0;"><i class="fas fa-user fa-fw"></i></a>
							<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="javascript:listView('${logId}')">관리자페이지&ensp;</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="myOrderList.do">마이페이지</a></li>
                        <li><hr class="dropdown-divider" /></li>
						 <li><a class="dropdown-item" href="logout.do" onclick="javascript:kakaoLogout()">로그아웃</a></li>
                        </ul>
                        </c:when>
							<c:otherwise>
							<li><span>${logName } 님</span></li>
                		<li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="padding: 0;"><i class="fas fa-user fa-fw" ></i></a>
							<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="myOrderList.do">마이페이지</a></li>
                        <li><hr class="dropdown-divider" /></li>
						 <li><a class="dropdown-item" href="logout.do" onclick="javascript:kakaoLogout()">로그아웃</a></li>
                        </ul>
							</c:otherwise>
						</c:choose>
                </li>
            </ul>
					
						<!--<c:choose>
							<c:when test="${empty logId }">
								<a href="loginForm.do">로그인</a>
								<a href="joinMemberForm.do">회원가입</a>
							</c:when>
							<c:when test="${!empty logId and status eq 'admin'}">
								<span>${logName } 님</span>
								<a href="logout.do" onclick="javascript:kakaoLogout()">로그아웃</a>
								<a href="javascript:listView('${logId}')"><i class="bi bi-clipboard"></i></a>
							</c:when>
							<c:otherwise>
								<span>${logName } 님</span>
								<a href="myOrderList.do">마이페이지</a>
								<a href="logout.do" onclick="javascript:kakaoLogout()">로그아웃</a>
							</c:otherwise>
						</c:choose>-->

						<div class="cart">
							<a href="cartList.do" role="button"> 

								<i class="fas fa-cart-plus"></i>
							</a>
						</div>
						<!-- 검색 -->
						<a id="search_1" href="javascript:void(0)"><i
							class="ti-search"></i></a>
						<!-- 검색 -->
					</div>

				</nav>
			</div>
		</div>
	</div>

	<!-- 카테고리 -->
	<div class="container" style="max-width: 100%; background: floralwhite;">
		<div class="row align-items-center">
			<div class="col-lg-12">
				<nav class="navbar navbar-expand-lg navbar-light">
					<!-- 웹페이지가 작을때 스타일에 visibility='visible' / 기본 'hidden'  처리 -->
					<a class="navbar-brand able" href="main.do"> <img
						src="img/logo.png" alt="logo">
					</a>


					<!-- 화면 줄엿을때 나오는 버튼 -->
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="menu_icon"><i class="fas fa-bars"></i></span>
					</button>

					<div class="collapse navbar-collapse main-menu-item big_width"
						id="navbarSupportedContent">
						<ul class="navbar-nav headerCategory">
							<li class="nav-item"><a class="nav-link" href="main.do">Home</a>
							</li>
							<li><a class="nav-link" href="productListForm.do">전체상품</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="blog.html"
								id="navbarDropdown_1" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> 문구 </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
									<a class="dropdown-item" href="productMenuList.do?category=다이어리"> 다이어리</a> <a
										class="dropdown-item" href="productMenuList.do?category=캘린더">캘린더</a> <a
										class="dropdown-item" href="productMenuList.do?category=노트">노트</a> <a
										class="dropdown-item" href="productMenuList.do?category=필기도구">필기도구</a> <a
										class="dropdown-item" href="productMenuList.do?category=필통/파우치">필통/파우치</a>
								</div></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="blog.html"
								id="navbarDropdown_3" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> 꾸미기용품 </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
									<a class="dropdown-item" href="productMenuList.do?category=메모지">메모지</a> <a
										class="dropdown-item" href="productMenuList.do?category=스티커"> 스티커</a> <a
										class="dropdown-item" href="productMenuList.do?category=테이프">테이프</a> <a
										class="dropdown-item" href="productMenuList.do?category=스템프">스템프</a> <a
										class="dropdown-item" href="productMenuList.do?category=엽서/카드">엽서/카드</a>
								</div></li>
							<li><a class="nav-link" href="inquireListForm.do">문의사항</a></li>
						</ul>
					</div>
					
					<!-- 웹페이지가 작을때 스타일에 visibility='visible' / 기본 'hidden'  처리 -->
					<div class="hearer_icon d-flex able">
						<c:choose>
							<c:when test="${empty logId }">
								<a href="loginForm.do">로그인&ensp;</a>
								<a href="joinMemberForm.do">회원가입</a>
							</c:when>
							<c:when test="${!empty logId and status eq 'admin'}">
								<span>${logName } 님</span>
								<a href="logout.do" onclick="javascript:kakaoLogout()"><i class="bi bi-door-open"></i></a>
								<a href="javascript:listView('${logId}')"><i class="bi bi-clipboard"></i></a>
							</c:when>
							<c:otherwise>
								<span>${logName } 님</span>
								<a href="myOrderList.do"><i class="bi bi-person-badge"></i></a>
								<a href="logout.do" onclick="javascript:kakaoLogout()"><i class="bi bi-door-open"></i></a>
							</c:otherwise>
						</c:choose>
						<div class="cart">
							<a href="cartList.do" role="button"> 
								<i class="fas fa-cart-plus"></i>
							</a>
						</div>
						<!-- 검색 -->
						<!-- <a id="search_1" href="javascript:void(0)"><i
							class="ti-search"></i></a> -->
						<!-- 검색 -->
					</div>
				</nav>
			</div>
		</div>
	</div>

	<!-- 검색 박스 -->
	<!-- 웹페이지가 작을때 스타일에 display='none' 처리 되있음 -> 클릭시 'black' 처리 / 아직 black 으로 안바뀜 수정필요 -->
	<div class="search_input" id="search_input_box">
		<div class="container ">
			<form class="d-flex justify-content-between search-inner">
				<input type="text" class="form-control" id="search_input"
					placeholder="Search Here" >
				<button type="submit" class="btn"></button>
				<span class="ti-close" id="close_search" title="Close Search"></span>
			</form>
		</div>
	</div>
	<!-- 검색 박스 -->
	
	
<!-- <script>
var a = "${logId }";
</script>
<script link="b.js"></script> -->

	
</header>