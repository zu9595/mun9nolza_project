<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<section class="section_padding">
	<div class="container">
		<h3>문의수정</h3>
		<form action="inquireModify.do" method="post" enctype="multipart/form-data">
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
						<td colspan="3"><textarea cols="30" rows="4" name="inqContent">${vo.inqContent }
						</textarea></td>
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
						<td>파일</td>
						<td colspan="3"><input type="file" name="inqImg" id="inqImg"></td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="submit"
							value="저장"> <input type="reset" value="취소" onclick="history.back()"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</section>