<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/adminjs/order.js"></script>
<main>
	<h3>상품결제내역</h3>
	<table class="table topList">
		<thead>
			<tr>
				<th>아이디</th>
				<th>주문번호</th>
				<th>수령인</th>
				<th>배송비</th>
				<th>배송상태</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>상세주소</th>
				<th>주문날짜</th>
				<th>주문전체가격<br>(배송비포함x)</th>
				<th>목록</th>
			</tr>
		</thead>
		<tbody id="list">
			<tr>
				<td>
					<table class="table list2">
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</main>