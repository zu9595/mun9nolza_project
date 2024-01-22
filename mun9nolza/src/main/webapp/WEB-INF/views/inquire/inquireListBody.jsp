<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	let userId = '${logId}'
</script>
<script src="js/inquirejs/inquireList.js"></script>

<section class="section_padding">
	<div class="container">
		<h3>문의사항</h3>
		<!-- EL(Expression Language) -->
		<table class="table">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일시</th>
				</tr>
			</thead>
			<tbody id="inquireList">
			</tbody>
		</table>
		<c:if test="${!empty logId}">
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button type="button" class="btn btn-outline-primary"
					onclick="location.href='inquireAddForm.do'">상품문의</button>
			</div>
		</c:if>
		<div class="col-lg-12" style="align-self: flex-end;">
			<div class="pageination"></div>
		</div>
	</div>
</section>