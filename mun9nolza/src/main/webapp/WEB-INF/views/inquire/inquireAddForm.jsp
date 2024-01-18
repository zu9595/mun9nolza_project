<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="section_padding">
	<div class="container">
		<h3>등록화면</h3>
		<form action="inquireAdd.do" method="post"
			enctype="multipart/form-data" class="table">
			<table class="table">
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" name="inqTitle" id="inqTitle"></td>
				</tr>
				<tr>
					<th>상품종류</th>
					<td>
					<select name="proCalt">
						<optgroup label="문구">
							<option value="다이어리">다이어리</option>
							<option value="캘린더">캘린더</option>
							<option value="노트">노트</option>
							<option value="일기장">일기장</option>
							<option value="가계부">가계부</option>
						</optgroup>
						<optgroup label="꾸미기용품">
							<option value="메모지">메모지</option>
							<option value="스티커">스티커</option>
							<option value="테이프">테이프</option>
							<option value="스템프">스템프</option>
							<option value="엽서/카드">엽서/카드</option>
						</optgroup>
					</select>
					</td>
					<th>상품코드</th>
					<td>
					<select name="proCode" id="proCode">
						<optgroup label="다이어리">
							<option></option>
						</optgroup>
					</select>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea name="inqContent" id="inqContent" cols="30"
							rows="10"></textarea></td>
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
					<td colspan="6" align="center"><input type="submit" value="저장" class="btn btn-outline-primary">
						<input type="reset" value="취소" class="btn btn-outline-secondary"></td>
				</tr>
			</table>
		</form>
	</div>
</section>