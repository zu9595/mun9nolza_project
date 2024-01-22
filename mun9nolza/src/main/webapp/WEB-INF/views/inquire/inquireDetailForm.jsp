<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="js/inquirejs/inquireDetail.js"></script>
<section class="section_padding">
	<div class="container">
		<h3>문의상세</h3>
		<form name="myForm" action="inquireModifyForm.do">
			<input type="hidden" name="inqNo" value="${vo.inqNo }">
			<table class="table">
				<tbody>
					<tr>
						<td>글번호</td>
						<td colspan="3">${vo.inqNo }</td>
					</tr>
					<tr>
						<td>상품이름</td>
						<td colspan="3">${vo.prodName }</td>
					</tr>
					<tr>
						<td>제목</td>
						<td colspan="3">${vo.inqTitle }</td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3">${vo.inqContent }</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="3">${vo.userId }</td>
					</tr>
					<tr>
						<td>작성일</td>
						<td><fmt:formatDate value="${vo.inqDate }"
								pattern="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<td>이미지</td>
						<td colspan="3"><c:if test="${!empty vo.inqImg }">
								<img width="300px" src="img/${vo.inqImg }">
							</c:if></td>
					</tr>
					<tr>
						<td colspan="4" align="center"><c:choose>
								<c:when test="${logId eq vo.userId }">
									<input type="submit" value="수정">
									<input type="button" onclick="deleteFun(${vo.inqNo})"
										value="삭제">
								</c:when>
								<c:when test="${status eq 'admin' }">
									<input type="submit" value="수정">
									<input type="button" onclick="deleteFun(${vo.inqNo})"
										value="삭제">
								</c:when>
								<c:otherwise>
									<input type="submit" disabled value="수정">
									<input type="button" disabled onclick="deleteFun(${vo.inqNo})"
										value="삭제">
								</c:otherwise>
							</c:choose></td>
					</tr>

				</tbody>
			</table>
		</form>
	</div>
</section>
