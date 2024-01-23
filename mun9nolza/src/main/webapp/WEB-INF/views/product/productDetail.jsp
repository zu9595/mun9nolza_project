<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="css/review.css">
    
  <!--================Single Product Area =================-->
  <div class="product_image_area section_padding">
    <div class="container">
      <div class="row s_product_inner justify-content-between">
        <div class="col-lg-7 col-xl-7 w">
          <div class="product_slider_img">
            <div id="vertical">
              <div data-thumb="img/logo.png">
                <img src="${vo.proImage }" alt="메인이미지"/>
              </div>
				<!-- 상세페이지 3개 가져옴(2,3,4) -->
              
            </div>
          </div>
        </div>
        <div class="col-lg-5 col-xl-4">
        
          <div class="s_product_text">
            <h5></h5>
            <h3>${vo.proName }</h3>
            <c:choose>
            <c:when test="${!empty vo.proDiscount }">
            <h2><span style="text-decoration: line-through; font-size: 20px; opacity: 0.5;">${vo.proPrice }원</span><span>${vo.proDiscount }원</span></h2>
            </c:when>
            <c:otherwise>
            <h2>${vo.proPrice }원</h2>
            </c:otherwise>
            </c:choose>
            <ul class="list">
              <li>
                <p>${vo.proDesc }상품 내용</p>
              </li>              
            </ul>
            <div class="buy">
            	<p>배송비 | 3000원 <br><span style="font-size: 16px; opacity: 0.5;">5만원이상 구매시 무료배송</span> </p>
            </div>
            <div class="card_area d-flex justify-content-between align-items-center">
              <div class="product_count">
                <span class="inumber-decrement ti-minus deinput"></span>
                <input class="input-number prodCnt" type="text" value="1" min="0" max="10">
                <span class="number-increment ti-plus ininput"></span>
              </div>
              
              <c:choose>
              <c:when test="${!empty userId }">
              <a href="javascript:singlePayForm()" class="btn_3">상품구매</a>
              </c:when>
              <c:otherwise>
              <a href="loginForm.do" class="btn_3">상품구매</a>
              </c:otherwise>
              </c:choose>
              
              <!-- 로그인 세션이 존재할때 -->
              <c:choose>
              <c:when test="${!empty userId }">
              <a href="javascript:addCartList()" class="btn_3" role = "button" style="padding: 4px 19px;">장바구니 추가</a>
              </c:when>
              <c:otherwise>
              <a href="addCartJson.do?userId=${userId}&proCode=${proCode}&proPrice=${proPrice}&proDiscount=${proDiscount}&myproCnt=${myproCnt}" class="btn_3" role = "button" style="padding: 4px 19px;">장바구니<br>추가</a>
              </c:otherwise>
              </c:choose>
            </div>
            
          </div>
          
          
        </div>
      </div>
    </div>
  </div>
  <!--================End Single Product Area =================-->
  <!-- 장바구니 이동 -->
              <!--<c:choose>
              <c:when test="${!empty userId }">
              <a href="cartList.do" class="btn_3">장바구니</a>
              </c:when>
              <c:otherwise>
              <a href="loginForm.do" class="btn_3">장바구니</a>
              </c:otherwise>
              </c:choose>-->
  

  <!--================Product Description Area =================-->



  <section class="product_description_area">
	<div class="container">
		<ul class="btns" >
        <li class="btn1">
          <a class="tab1" href="#">상품 설명</a>
        </li>
        <li class="btn2">
          <a class="tab2" href="#">리뷰</a>
        </li>
      </ul>
	</div>
    <div class=" tab3"></div>
    <div class=" pageination"></div>
  </section>

  <!--================End Product Description Area =================-->

  <!-- product_list part start-->
  <section class="product_list best_seller">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-12">
          <div class="section_tittle text-center">
            <h2>인기상품<span>shop</span></h2>
          </div>
        </div>
      </div>
      <div class="row align-items-center justify-content-between">
        <div class="col-lg-12">
          <div class="best_product_slider owl-carousel">
            <div class="single_product_item">
              <img src="img/logo.png" alt="">
              <div class="single_product_text">
                <h4>Quartz Belt Watch</h4>
                <h3>$150.00</h3>
              </div>
            </div>
            <div class="single_product_item">
              <img src="img/logo.png" alt="">
              <div class="single_product_text">
                <h4>Quartz Belt Watch</h4>
                <h3>$150.00</h3>
              </div>
            </div>
            <div class="single_product_item">
              <img src="img/logo.png" alt="">
              <div class="single_product_text">
                <h4>Quartz Belt Watch</h4>
                <h3>$150.00</h3>
              </div>
            </div>
            <div class="single_product_item">
              <img src="img/logo.png" alt="">
              <div class="single_product_text">
                <h4>Quartz Belt Watch</h4>
                <h3>$150.00</h3>
              </div>
            </div>
            <div class="single_product_item">
              <img src="img/logo.png" alt="">
              <div class="single_product_text">
                <h4>Quartz Belt Watch</h4>
                <h3>$150.00</h3>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  
<script>
	let proCode = `${vo.proCode }`;
	let userId = `${userId}`;
	let proPrice = `${vo.proPrice}`;
	let proDiscount = `${vo.proDiscount}`;
	let proDesc = `${vo.proDesc}`;
</script>
<script src="js/product/productDetail.js"></script>
<script src="js/product/review.js"></script>
  <!-- product_list part end-->