<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="js/inquirejs/category.js"></script>
<section class="section_padding">
	<div class="container">
		<h3>문의등록</h3>
		<form action="inquireAdd.do" method="post"
			enctype="multipart/form-data">
			<table class="table">
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" name="inqTitle"
						id="inqTitle"></td>
				</tr>
				<tr>
					<th>상품종류</th>
					<td>
					<select name="category" class="cate">
						<option value="다이어리">다이어리</option>
						<option value="캘린더">캘린더</option>
						<option value="노트">노트</option>
						<option value="필기도구">필기도구</option>
						<option value="필통/파우치">필통/파우치</option>
						<option value="메모지">메모지</option>
						<option value="스티커">스티커</option>
						<option value="테이프">테이프</option>
						<option value="스템프">스템프</option>
						<option value="엽서/카드">엽서/카드</option>
					</select>
					</td>
					<th>상품이름</th>
					<td>
					<select name="prodName" class="prodName">
						
					</select>
					<input type="hidden" name="proCode" class="proCode" > 
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea name="inqContent" id="inqContent"
							cols="30" rows="10"></textarea></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td colspan="3"><input type="text" name="userId" id="userId"
						value="${logId }"></td>
				</tr>
				<tr>
					<th>파일</th>
					<td colspan="3"><input type="file" name="inqImg" id="inqImg"></td>
				<tr>
					<td colspan="6" align="center"><input type="submit" value="저장"
						class="btn btn-outline-primary"> <input type="reset"
						value="취소" class="btn btn-outline-secondary"></td>
				</tr>
			</table>
		</form>
	</div>
</section>