<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/adminjs/product.js"></script>
<main>
	<h3>상품목록</h3>
	<table class="table">
		<thead>
			<tr>
				<th>상품코드</th>
				<th>상품명</th>
				<th>상품설명</th>
				<th>상품이미지</th>
				<th>상품가격</th>
				<th>할인가격</th>
				<th>판매수량</th>
				<th>재고수량</th>
				<th>카테고리</th>
				<th>수정버튼</th>
			</tr>
		</thead>
		<tbody id="list">
			<tr>
				<td>상품코드</td>
				<td><input type="text" value="상품명"></td>
				<td><input type="text" value="상품설명"></td>
				<td><input type="text" value="상품이미지"></td>
				<td><input type="text" value="상품가격"></td>
				<td><input type="text" value="할인가격"></td>
				<td><input type="text" value="판매수량"></td>
				<td><input type="text" value="재고수량"></td>
				<td><input type="text" value="카테고리"></td>
				<td><button>수정</button></td>
			</tr>
			
			

		</tbody>
	</table>
</main>