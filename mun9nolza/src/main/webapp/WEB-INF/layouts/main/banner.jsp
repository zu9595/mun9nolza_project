<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="banner_part">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-12">
                <div class="banner_slider owl-carousel bannerlist">
                
                	
                	<c:forEach var="banner" items="${bannerList}">
                    <div class="single_banner_slider">
                    	<div class="banner_img d-none d-lg-block">
                                <img src="img/${banner.bannerImg}" alt="">
                            </div>
                    </div>
               		</c:forEach>
                	
                	
                
               		<!-- 여기 -->
               		<!--<c:forEach var="banner" items="${bannerList}">
                    <div class="single_banner_slider">
                        <div class="row">
                            <div class="col-lg-5 col-md-8">
                                  <div class="banner_text">
                                    <div class="banner_text_iner">
                                        <h1>${banner.bannerName}</h1>
                                        <p>${banner.bannerDesc}</p>
                                    </div>
                                </div>
                            </div>
                            <div class="banner_img d-none d-lg-block">
                                <img src="${banner.bannerImg}" alt="">
                            </div>
                        </div>
                    </div>
               		</c:forEach>-->
                    <!-- 여기 -->
                    
                    
                    
                    <!-- <div class="single_banner_slider">
                        <div class="row">
                            <div class="col-lg-5 col-md-8">
                                <div class="banner_text">
                                    <div class="banner_text_iner">
                                        <h1>Cloth $ Wood Sofa</h1>
                                        <p>Incididunt ut labore et dolore magna aliqua quis ipsum
                                            suspendisse ultrices gravida. Risus commodo viverra</p>
                                        <a href="#" class="btn_2">buy now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="banner_img d-none d-lg-block">
                                <img src="img/banner_img.png" alt="">
                            </div>
                        </div>
                    </div> -->
                </div>
                <!-- <div class="slider-counter"></div> -->
            </div>
        </div>
    </div>
</section>