<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- product_list part start-->
<section class="product_list best_seller section_padding">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="section_tittle text-center">
                    <h2>Best</h2>
                </div>
            </div>
        </div>
        <div class="row align-items-center justify-content-between">
            <div class="col-lg-12">
                <div class="best_product_slider owl-carousel bestlist">
                
                <!-- 메인 베스트 목록 -->
                <c:forEach var="item" items="${bestList}" begin="0" end="7" step="1">
                	<div class="single_product_item">
                		<img src="${item.proImage }" alt="이미지">
                        <div class="single_product_text">
                            <h4>${item.proName} </h4>
                            <h3>${item.proPrice}원</h3>
                        </div>
                    </div>
                </c:forEach>
                <!-- 메인 베스트 목록 end -->
                    
                    
                    
                </div>
            </div>
        </div>
    </div>
</section>
<!-- product_list part start-->

<section class="feature_part padding_top">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="section_tittle text-center">
                    <h2>카테고리별 최고 인기 상품</h2>
                </div>
            </div>
        </div>
        <div class="row align-items-center justify-content-between hotlist">
        	<!-- 메인 카테고리별 인기상품 목록 -->
            <!--<div class="col-lg-7 col-sm-6">
            	</div>
            	<div class="col-lg-5 col-sm-6">
                	<div class="single_feature_post_text">
	                    <p>종류</p>
	                    <h3>상품명</h3>
	                    <a href="#" class="feature_btn">상세페이지로 <i class="fas fa-play"></i></a>
	                    <img src="" alt="이미지">
                </div> -->
            <!-- 메인 카테고리별 인기상품 목록 end -->
        </div>
    </div>
</section>
<!-- upcoming_event part start-->

<!-- product_list start-->
<section class="product_list section_padding">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="section_tittle text-center">
                    <h2>할인상품</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="product_list_slider owl-carousel">
                	<!-- 할인상품 목록 1 -->
                    <div class="single_product_list_slider">
                        <div class="row align-items-center justify-content-between mainSalelist1">
                        	<!-- 상품 단건 1-->
                            <!-- <div class="col-lg-3 col-sm-6">
                                <div class="single_product_item">
                                    <img src="" alt="이미지">
                                    <div class="single_product_text">
                                        <h4></h4>
                                        <h3></h3>
                                        <a href="#" class="add_cart">장바구니에 담기<i class="ti-heart"></i></a>
                                    </div>
                                </div>
                            </div> -->
                            <!-- 상품 단건 1 end -->
                        </div>
                    </div>
                    <!-- 할인상품 목록 1 end -->
                    <!-- 할인상품 목록 2 -->
                    <div class="single_product_list_slider">
                        <div class="row align-items-center justify-content-between mainSalelist2">
                        	<!-- 상품 단건 2 -->
                            <!-- <div class="col-lg-3 col-sm-6">
                                <div class="single_product_item">
                                    <img src="" alt="이미지">
                                    <div class="single_product_text">
                                        <h4></h4>
                                        <h3></h3>
                                        <a href="#" class="add_cart">장바구니에 담기<i class="ti-heart"></i></a>
                                    </div>
                                </div>
                            </div> -->
                            <!-- 상품 단건 2 end -->
                        </div>
                    </div>
                    <!-- 할인상품 목록 2 end-->
                </div>
            </div>
        </div>
    </div>
</section>
<!-- product_list part start-->