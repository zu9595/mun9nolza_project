<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="js/mypagejs/myOrderList.js"></script>

<style>
.orderHidden {
	display: none;
}
.table {
	text-align: center;
}

</style>


<!-- 바뀌는 구역 -->
<div class="col-lg-9">

	<h3>나의 주문내역</h3>
	<br>
	 <table class="table addOrderList">
	 	<thead>
	 		<tr>
	 		 <th>주문번호</th>
	 		 <th>주문날짜</th>
	 		 <th>주문상태</th>
	 		 <th>수령인</th>
	 		 <th>주소</th>
	 		 <th>상세조회</th>
	 		 <th>주문취소</th>
	 		</tr>
	 	</thead>
	 	
	 	<tbody>
	 		<c:forEach var="vo" items="${orderList }">
	 		 <tr class="detail">
	 		  		 <td>${vo.orderNo }</td>
	 		  		 <td><fmt:formatDate value="${vo.orderDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	 		  		 <td><span class="status">${vo.orderStatus }</span></td>
	 		  		 <td>${vo.orderRecipient }</td>
	 		  		 <td>${vo.orderAddr } ${vo.detailAddr }</td>
	 		  		 <td><button type="button" class="btn btn-default btn-sm btn-outline-info" onclick="detailView()">상세조회</button></td>
	 		  		 <td><button type="button" class="btn btn-default btn-sm btn-outline-secondary" onclick="removeOrder(${vo.orderNo})">주문취소</button></td>
	 		  		
	 		 </tr>
	 		
	 		<!-- 상세조회 -->
	 		<tr class="orderHidden">
	 		 <td colspan="7">
	 		  <table class="table">
	 		   <tr>
	 		     <td>상품이미지</td>
	 		   	 <td>상품코드</td>
	 		     <td>상품명</td>
	 		     <td>수량</td>
	 		     <td>가격</td>
	 		   </tr>
	 		   <c:forEach var="dvo" items="${vo.detailList }">
	 		    <tr>
	 		     <td>
	 		       <c:if test="${!empty dvo.proImage}">
	 		        <img width="150px" src="img/${dvo.proImage}">
				   </c:if>
				</td>
				<td>${dvo.proCode }</td>
				<td>${dvo.proName }</td>
				<td>${dvo.deProCnt }개</td>
				<td>${dvo.deProPrice}원</td>
	 		    </tr>
	 		   </c:forEach>
	 		   
	 		   <tr>
	 		    <td colspan="7">상품금액 + 배송비 = 총 주문금액</td>
	 		   </tr>
	 		   <tr>
	 		    <td colspan="7">${vo.totalPrice }원 + ${vo.deliveryFee}원 = ${vo.totalPrice+vo.deliveryFee}원</td>
	 		   </tr>
	 		  </table>
	 		 </td>
	 		</tr> <!-- 상세조회끝tr --> 
	 		</c:forEach>

	 	 </tbody>
	  </table>
	
</div>
	
<!-- 바뀌는 구역 끝 -->