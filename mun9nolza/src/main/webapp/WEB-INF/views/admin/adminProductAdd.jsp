<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<main>
	<h3>상품등록</h3>
	<div id="container">
		<form action="productAdd.do" method="post" id="register" name="register">
			<ul id="user-info">
				<li>
					<label for="proName" class="field">상품명</label>
					<input type="text" id="proName" name="proName">
				</li>
				<li>
                     <label>상품설명</label>
                     <textarea rows="5" cols="30" name="proDesc" placeholder="상품설명을 작성해주세요"></textarea>
                </li>
				<li>
					<label for="proImage" class="field">상품이미지</label>
					<input type="text" id="proImage" name="proImage">
				</li>
				<li>
					<label for="proPrice" class="field">상품가격</label>
					<input type="number" id="proPrice" name="proPrice">
				</li>
				<li>
					<label for="proDiscount" class="field">할인가격</label>
					<input type="number" id="proDiscount" name="proDiscount">
				</li>
				<li>
					<label for="proSell" class="field">판매수량</label>
					<input type="number" id="proSell" name="proSell">
				</li>
				<li>
					<label for="proStock" class="field">재고수량</label>
					<input type="number" id="proStock" name="proStock">
				</li>
				<li>
					<label for="category" class="field">카테고리</label>
					<input type="text" id="category" name="category">
				</li>
			</ul>
			<ul id="buttons">
				<li><button type="submit">등록하기</button></li>
				<li><button type="reset">취소</button></li>
			</ul>
		</form>
	</div>
</main>