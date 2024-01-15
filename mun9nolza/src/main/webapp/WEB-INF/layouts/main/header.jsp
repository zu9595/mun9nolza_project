<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<header class="main_menu home_menu">
	<!-- 로고 및 로그인 -->
	<!-- 스타일에 화면이 작아지면 display ='none' 처리 -->
	<div class="container unable">
		<div class="row align-items-center">
			<div class="col-lg-12">
				<nav class="navbar navbar-expand-lg navbar-light">
					<div class="collapse navbar-collapse main-menu-item" id="navbarSupportedContent">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="navbar-brand" href="index.html"> <img src="img/logo.png" alt="logo"> </a>
                            </li>
                        </ul>
                    </div>
                    
                    <div class="hearer_icon d-flex">
                        <a href="admin">로그인</a>
                        <a href="addMemberForm.do">회원가입</a>
                        <div class="dropdown cart">
                            <a class="dropdown-toggle" href="myProductList.do" id="navbarDropdown3" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-cart-plus"></i>
                            </a>
                        </div>
                        <!-- 검색 -->
                        <a id="search_1" href="javascript:void(0)"><i class="ti-search"></i></a>
                        <!-- 검색 -->
                    </div>
                    
				</nav>
			</div>
		</div>
	</div>
	
	<!-- 카테고리 -->
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg navbar-light">
                	<!-- 웹페이지가 작을때 스타일에 visibility='visible' / 기본 'hidden'  처리 -->
                    <a class="navbar-brand able" href="index.html"> <img src="img/logo.png" alt="logo"> </a>
                    
                    <!-- 화면 줄엿을때 나오는 버튼 -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="menu_icon"><i class="fas fa-bars"></i></span>
                    </button>

                    <div class="collapse navbar-collapse main-menu-item" id="navbarSupportedContent">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="index.html">Home</a>
                            </li>
                            <li>
                                <a class="nav-link" href="ProductListForm.do">전체상품</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown_1"
                                    role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    문구
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                    <a class="dropdown-item" href="category.html"> 다이어리</a>
                                    <a class="dropdown-item" href="single-product.html">캘린더</a>
                                    <a class="dropdown-item" href="single-product.html">노트</a>
                                    <a class="dropdown-item" href="single-product.html">일기장</a>
                                    <a class="dropdown-item" href="single-product.html">가계부</a>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown_3"
                                    role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    꾸미기용품
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
                                    <a class="dropdown-item" href="checkout.html">메모지</a>
                                    <a class="dropdown-item" href="login.html"> 스티커</a>
                                    <a class="dropdown-item" href="tracking.html">테이프</a>
                                    <a class="dropdown-item" href="cart.html">스템프</a>
                                    <a class="dropdown-item" href="confirmation.html">엽서/카드</a>
                                </div>
                            </li>
                           <li>
                                <a class="nav-link" href="index.html">공지사항</a>
                            </li>
                        </ul>
                    </div>
                    <!-- 웹페이지가 작을때 스타일에 visibility='visible' / 기본 'hidden'  처리 -->
                    <div class="hearer_icon d-flex able">
                        <a href="admin">로그인</a>
                        <a href="addMemberForm.do">회원가입</a>
                        <div class="dropdown cart">
                            <a class="dropdown-toggle" href="myProductList.do" id="navbarDropdown3" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-cart-plus"></i>
                            </a>
                        </div>
                        <!-- 검색 -->
                        <a id="search_1" href="javascript:void(0)"><i class="ti-search"></i></a>
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
                <input type="text" class="form-control" id="search_input" placeholder="Search Here">
                <button type="submit" class="btn"></button>
                <span class="ti-close" id="close_search" title="Close Search"></span>
            </form>
        </div>
    </div>
    <!-- 검색 박스 -->
</header>