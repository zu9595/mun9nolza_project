<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- aside -->
<!-- 바뀌는 구역 -->

<div class="col-lg-9">
	<h3>마이리뷰</h3>

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
						<td>${vo.proCode }</td>
						<td><a href="#">${vo.reTitle }</a></td><!-- 확인하기 -->
						<%-- <td>${vo.reContent }</td> --%>
						<%-- <td>${vo.reImage }</td> --%>
						<td>${vo.reRate }</td>
						<td><fmt:formatDate value="${vo.reDate }"
								pattern="yyyy-MM-dd"></fmt:formatDate></td>
					</tr>
				</c:forEach>

		</tbody>
		</table>
	</div>
</div>
<!-- 바뀌는 구역 끝 -->

