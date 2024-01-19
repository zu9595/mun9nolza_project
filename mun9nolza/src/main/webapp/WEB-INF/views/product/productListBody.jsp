<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="cat_product_area section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                
                    <div class="left_sidebar_area">
                        <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h3>상품 종류</h3>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                    <li>
                                        <a href="#" class="category">다이어리</a>
                                    </li>
                                    <li>
                                        <a href="#" class="category">캘린더</a>
                                    </li>
                                    <li>
                                        <a href="#" class="category">노트</a>
                                    </li>
                                    <li>
                                        <a href="#" class="category">일기장</a>
                                    </li>
                                    <li>
                                        <a href="#" class="category">가계부</a>
                                    </li>
                                </ul>
                            </div>
                        </aside>

                        <!-- <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h3>상품 필터</h3>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                    <li>
                                        <a href="#">Apple</a>
                                    </li>
                                </ul>
                                <ul class="list">
                                    <li>
                                        <a href="#">Samsung</a>
                                    </li>
                                </ul>
                            </div>
                        </aside>

                        <aside class="left_widgets p_filter_widgets price_rangs_aside">
                            <div class="l_w_title">
                                <h3>가격 필터</h3>
                            </div>
                            <div class="widgets_inner">
                                <div class="range_item">
                                    <!-- <div id="slider-range"></div> 
                                    <input type="text" class="js-range-slider" value="" />
                                    <div class="d-flex">
                                        <div class="price_text">
                                            <p>가격 :</p>
                                        </div>
                                        <div class="price_value d-flex justify-content-center">
                                            <input type="text" class="js-input-from" id="amount" readonly />
                                            <span>to</span>
                                            <input type="text" class="js-input-to" id="amount" readonly />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </aside> -->
                    </div>
                    
                </div>
                <div class="col-lg-9">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="product_top_bar d-flex justify-content-between align-items-center">
                                <div class="single_product_menu">
                                    <p>총 <span id="totalcnt"></span>개의 상품</p>
                                </div>
                                <div class="single_product_menu d-flex" style="visibility: hidden;">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="search"
                                            aria-describedby="inputGroupPrepend">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="inputGroupPrepend"><i
                                                    class="ti-search"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="single_product_menu d-flex otp">
                                    <h5>정렬 : </h5>
                                    <select class="">
                                        <option id="sorting" data-display="선택">선택</option>
                                        <option value="1">이름순</option>
                                        <option value="2">가격순</option>
                                        <option value="3">인기순</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
	                
                    <div class="row align-items-center latest_product_inner productlist" style="width: 720px;">
                        <!-- <div class="col-lg-4 col-sm-6">
                            <div class="single_product_item">
                                <img src="${vo.proImage }" alt="이미지">
                                <div class="single_product_text">
                                    <h4>${vo.proName }</h4>
                                    <h3>${vo.proPrice }</h3>
                                    <h3>할인가 ${vo.proDiscount }</h3>
                                    <a href="#" class="add_cart">장바구니에 담기<i class="ti-heart"></i></a>
                                </div>
                            </div>
                        </div> -->
                        
                        <div class="col-lg-12 listnumber" style="align-self: flex-end;">
                            <div class="pageination">
                                <!-- <nav aria-label="Page navigation example"> -->
                                    <!-- <ul class="pagination justify-content-center">
                                        <li class="page-item">
                                            <a class="page-link" href="#" aria-label="Previous">
                                                <i class="ti-angle-double-left"></i>
                                            </a>
                                        </li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item">
                                            <a class="page-link" href="#" aria-label="Next">
                                                <i class="ti-angle-double-right"></i>
                                            </a>
                                        </li>
                                    </ul> -->
                                <!-- </nav> -->
                            </div>
                        </div>
                            
                    </div>

                </div>
            </div>
        </div>
    </section>
<script src="js/product/productList.js"></script>