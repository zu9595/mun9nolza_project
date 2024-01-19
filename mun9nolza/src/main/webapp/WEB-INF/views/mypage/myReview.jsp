<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>




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
                   <h2>마이리뷰</h2>
                   
                   <div style="width: 720px; height: 640px; padding: 50px">
                     <table class="table review">
                      <thead>
                       <tr>
                         <th>주문번호</th>
                         <th>상품코드</th>
                         <th>제목</th>
                         <!-- <th>내용</th> -->
                         <!-- <th>이미지</th> -->
                         <th>별점</th>
                         <th>등록일</th>
                       </tr>
                     </thead>
                     <tbody>  
                       <c:forEach var="vo" items="${reviewList}">
                       <tr>
                        <td>${vo.orderNo }</td>
                        <td> ${vo.proCode }</td>
                        <td>${vo.reTitle }</td>
                        <%-- <td>${vo.reContent }</td> --%>
                        <%-- <td>${vo.reImage }</td> --%>
                        <td>${vo.reRate }</td>
                        <td><fmt:formatDate value="${vo.reDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                       </tr>
                       </c:forEach> 
                       
                       <!-- 상세조회 -->
                       <tr class="orderHidden detail">
                        <td colspan="5">
                        
                       <!-- <table class="table">
                        <tr>
                         <td>상품이미지</td>
                         <td>상품명</td>
                         <td>가격</td>
                         <td colspan="2">수량</td>
                        </tr>
                        <tr> -->
                       	 <%-- <td><c:if test="${!empty vo.proImage}"><img width="150px" src="img/${vo.proImage}"></c:if></td>
                       	 <td> ${vo.proName }</td>
                       	 <td>${vo.totalPrice }원</td>
                       	 <td colspan="2">${vo.deProCnt }개</td>
                       	 <td><button onclick="removeOrder(${vo.orderNo})">주문취소</button></td>
                        </tr>
                        <tr>
                         <td colspan="2">수령인</td>
                         <td colspan="2">연락처</td>
                         <td colspan="2">주소</td>
                        </tr>
                        <tr>
                         <td colspan="2">${vo.orderRecipient }</td>
                         <td colspan="2">${vo.orderPhone }</td>
                         <td colspan="2">${vo.orderAddr }${vo.detailAddr }</td>
                         <td></td>                       
                        </tr> 
                        <tr>
                         <td colspan="5" style="text-align:center">총 주문금액</td>
                        </tr>
                        <tr>
                         <td colspan="5"  style="text-align:center">${vo.totalPrice }원</td>
                        </tr>
 --%>                      </table>
                       
                       </td>
                       </tr>
                       <%-- </c:forEach>  --%>
                     </tbody>   
                      
                      
                     </table>  
                   </div>          
              </div>
               <!-- 바뀌는 구역 끝 -->
                
            </div>
        </div>
    </section>
