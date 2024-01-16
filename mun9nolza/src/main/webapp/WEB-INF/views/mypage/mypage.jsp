<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<style>
 /* .table td {
	text-align: center;
 } */

</style>

<section class="cat_product_area section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                
                    <div class="left_sidebar_area">
                        <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h4>주문내역</h4>
                                <br>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                    <li><a href="myOrderList.do">주문/배송목록</a></li>
                                    <li><a href="#">반품/교환내역</a></li>
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
                                    <li><a href="#">개인정보 수정</a></li>
                                    <li><a href="#">마이리뷰</a></li>
                                    <li><a href="#">회원탈퇴</a></li>
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
                   <div class="row align-items-center latest_product_inner productlist" style="width: 720px; height: 640px;">
                     <table class="table addOrderList">
                       <c:forEach var="vo" items="${orderList}">
                      <thead>
                       <tr>
                        <th><fmt:formatDate value="${vo.orderDate }" pattern="yyyy-MM-dd"></fmt:formatDate>(${vo.orderNo })</th>
                        <th colspan="3" style="text-align: right;"><button onclick="orderDetail()">상세보기</button></th> <!-- 확인하기 -->
                       <tr> 
                      </thead>
                      <tbody>
                       	<tr>
                       	 <td rowspan="2">
                       	  <c:if test="${!empty vo.proImage}"><img width="150px" src="img/${vo.proImage}"></c:if>
                       	 </td>
                       	 <td rowspan="2">
                       	  상품명:  ${vo.proName }
                       	  <br>수량:  ${vo.deProCnt }
                       	 </td>
                       	 <td>
                       	  ${vo.totalPrice }원
                       	 </td>
                       	 <td>
                       	</tr>
                       	<tr>
                       	 
                       	</tr>
                      </tbody>
                       </c:forEach> 
                     </table>  
                   </div>          
              </div>
               <!-- 바뀌는 구역 끝 -->
                
            </div>
        </div>
    </section>