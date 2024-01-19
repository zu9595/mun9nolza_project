<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<style>

 .orderHidden {
	display: none;
} 

</style>
<script src="js/mypagejs/myOrderList.js"></script>

<section class="cat_product_area section_padding">
        <div class="container">
            <div class="row" style="padding-top: 80px">
                <div class="col-lg-3">
                
                    <div class="left_sidebar_area" style="padding-top: 100px">
                        <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h4>주문내역</h4>
                                <br>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                    <li><a href="myOrderList.do">주문/배송목록</a></li>
                                </ul>
                            </div>
                        </aside>

                        <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h4>회원정보</h4>
                                <br>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                    <li><a href="myInfoModForm.do">개인정보 수정</a></li>
                                    <li><a href="myReview.do">마이리뷰</a></li>
                                </ul>
                            </div>
                        </aside>
                        
                         <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h4>고객센터</h4>
                                <br>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                    <li><a href="#">1:1문의내역</a></li>
                                </ul>
                            </div>
                        </aside>
                    </div>
                    
                </div>
                <!-- 바뀌는 구역 -->
        
                <div class="col-lg-9">
                   <h2>나의 주문내역</h2>
${orderList}
                   <div style="width: 720px; height: 640px; padding: 50px">
                     <table class="table addOrderList">
                      <thead>
                       <tr>
                         <th>주문날짜</th>
                         <th>주문번호</th>
                         <th>주문상품</th>
                         <th>주문상태</th>
                         <th>상세조회</th>
                         <td colspan="2">수령인</td>
                         <td colspan="2">연락처</td>
                         <td colspan="2">주소</td>
                       </tr>
                     </thead>
                     <tbody>  
                       <c:forEach var="vo" items="${orderList}">
                       <tr>
                      	<td>
                      	<table>
                      	   <tr>
                        <td><fmt:formatDate value="${vo.orderDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>${vo.orderNo }</td>                 
                        <td><span class="status">${vo.orderStatus }</span></td>
                        <td><button onclick="detailView()">상세조회</button></td> <!-- 확인하기 -->
                         <td colspan="2">${vo.orderRecipient }</td>
                         <td colspan="2">${vo.orderPhone }</td>
                         <td colspan="2">${vo.orderAddr }${vo.detailAddr }</td>
                                             
                                          	 <td>${vo.totalPrice }원</td>
                       	
                        <td><fmt:formatDate value="${vo.orderDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>${vo.orderNo }</td>
                
                        <td><span class="status">${vo.orderStatus }</span></td>
                        <td><button onclick="detailView()">상세조회</button></td> <!-- 확인하기 -->
                       </tr>
                       
                       <!-- 상세조회 -->
                       <tr class=" detail">
                        <td colspan="5">
                        
                       <table class="table">
                        <tr>
                         <td>상품이미지</td>
                         <td>상품명</td>
                         <td>가격</td>
                         <td colspan="2">수량</td>
                        </tr>
                        
                          <c:forEach var="dvo" items="${vo.detailList}">
                        <tr>
                       	 <td><c:if test="${!empty dvo.proImage}"><img width="150px" src="${dvo.proImage}"></c:if></td>
                       	 <td> ${dvo.proName }</td>
 						<td colspan="2">${dvo.deProCnt }개</td>
                       	 <td><button onclick="removeOrder(${vo.orderNo})">주문취소</button></td>
                        </tr>
                           </c:forEach>
                        <tr>
                         <td colspan="5" style="text-align:center">총 주문금액</td>
                         
                        </tr>
                        <tr>
                         <td colspan="5"  style="text-align:center">${vo.totalPrice }원</td>
                        </tr>
                      </table>
                       
                       </td>
                       </tr>
                       </c:forEach> 
                     </tbody>   
                      
                      
                     </table>  
                   </div>          
              </div>
               <!-- 바뀌는 구역 끝 -->
                
            </div>
        </div>
    </section>
    
<!--     <script>

    
    </script> -->