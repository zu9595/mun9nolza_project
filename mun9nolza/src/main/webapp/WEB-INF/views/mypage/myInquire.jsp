<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- aside -->
<!-- 바뀌는 구역 -->

<div class="col-lg-9">
	<h3>나의 문의내역</h3>

	<div style="width: 720px; height: 640px; padding: 50px">
		<table class="table review">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>상품이름</th>
					<th>내용</th>
					<th>작성일시</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${inquireList}">
					<tr>
						<td>${vo.inqNo }</td>
						<td>${vo.inqTitle }</td>
						<td>${vo.prodName }</td>
						<td>${vo.inqContent }</td>
						<td><fmt:formatDate value="${vo.inqDate }"
								pattern="yyyy-MM-dd"></fmt:formatDate></td>
					</tr>
				</c:forEach>

		</tbody>
		</table>
	</div>
</div>
<!-- 바뀌는 구역 끝 -->
