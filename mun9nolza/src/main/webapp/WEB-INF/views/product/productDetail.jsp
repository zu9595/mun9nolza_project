<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  
    
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
            <h2><span style="text-decoration: line-through; font-size: 20px; opacity: 0.5;">${vo.proPrice }원</span>${vo.proDiscount }원</h2>
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
              <!-- 장바구니 이동 -->
              <c:choose>
              <c:when test="${!empty userId }">
              <a href="cartList.do" class="btn_3">장바구니 이동</a>
              </c:when>
              <c:otherwise>
              <a href="loginForm.do" class="btn_3">장바구니 이동</a>
              </c:otherwise>
              </c:choose>
              <!-- 로그인 세션이 존재할때 -->
              <c:choose>
              <c:when test="${!empty userId }">
              <a href="javascript:addCartList()" class="like_us fas fa-cart-plus" role = "button"></a>
              </c:when>
              <c:otherwise>
              <a href="loginForm.do" class="like_us" role = "button"> <i class="fas fa-cart-plus"></i> </a>
              </c:otherwise>
              </c:choose>
            </div>
            
          </div>
          
          
        </div>
      </div>
    </div>
  </div>
  <!--================End Single Product Area =================-->
  
  

  <!--================Product Description Area =================-->
  <section class="product_description_area">
    <div class="container">
      <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item">
          <a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home"
            aria-selected="true">상품 설명</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link active" id="review-tab" data-toggle="tab" href="#review" role="tab" aria-controls="review"
            aria-selected="false">리뷰</a>
        </li>
      </ul>
      
      <!-- 리뷰시작 -->
      <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade" id="home" role="tabpanel" aria-labelledby="home-tab">
          <p>
            ${vo.proDesc }
          </p>
          
        </div>

        <div class="tab-pane fade show active" id="review" role="tabpanel" aria-labelledby="review-tab">
          <div class="row">
            <div class="col-lg-6">
              
              <div class="review_list">
                <!-- 리뷰 페이징 목록 -->
                <!-- 리뷰 1건 리뷰 -->
                <div class="review_item">
                  <div class="media">
                    <div class="d-flex">
                      <img src="img/product/single-product/review-1.png" alt="" />
                    </div>
                    <div class="media-body">
                      <h4>Blake Ruiz</h4>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                    </div>
                  </div>
                  <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna
                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                    ullamco laboris nisi ut aliquip ex ea commodo
                  </p>
                </div>
                <!-- 리뷰 1건 리뷰 -->
                
                <div class="review_item">
                  <div class="media">
                    <div class="d-flex">
                      <img src="img/product/single-product/review-2.png" alt="" />
                    </div>
                    <div class="media-body">
                      <h4>Blake Ruiz</h4>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                    </div>
                  </div>
                  <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna
                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                    ullamco laboris nisi ut aliquip ex ea commodo
                  </p>
                </div>
                <div class="review_item">
                  <div class="media">
                    <div class="d-flex">
                      <img src="img/product/single-product/review-3.png" alt="" />
                    </div>
                    <div class="media-body">
                      <h4>Blake Ruiz</h4>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                      <i class="fa fa-star"></i>
                    </div>
                  </div>
                  <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna
                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                    ullamco laboris nisi ut aliquip ex ea commodo
                  </p>
                </div>
              </div>
            </div>
            <div class="col-lg-6">
              <div class="review_box">
                <h4>리뷰 쓰기</h4>
                <!-- 별점클릭 이벤트 -->
                <p>별점:</p>
                <ul class="list">
                  <li>
                    <a href="#">
                      <i class="fa fa-star"></i>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-star"></i>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-star"></i>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-star"></i>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-star"></i>
                    </a>
                  </li>
                </ul>
                <!-- 별점클릭 이벤트 -->
                <!-- 리뷰 등록 ajax -->
                <form class="row contact_form" action="contact_process.php" method="post" novalidate="novalidate">
                  <div class="col-md-12">
                    <div class="form-group">
                      <textarea class="form-control" name="message" rows="1" placeholder="Review"></textarea>
                    </div>
                  </div>
                  <div class="col-md-12 text-right">
                    <button type="submit" value="submit" class="btn_3">
                      등록
                    </button>
                  </div>
                </form>
                <!-- 리뷰 등록 -->
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 리뷰끝 -->
    </div>
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
</script>
<script src="js/product/productDetail.js"></script>
  <!-- product_list part end-->