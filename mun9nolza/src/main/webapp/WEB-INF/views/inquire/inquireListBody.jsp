<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script> let userId = '${logId}'</script>
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
					<th>삭제</th>
				</tr>
			</thead>
			<tbody id="inquireList">
			</tbody>
		</table>
		<button type="button" class="btn btn-primary" onclick="location.href='inquireAddForm.do'">상품문의</button>
	</div>
</section>