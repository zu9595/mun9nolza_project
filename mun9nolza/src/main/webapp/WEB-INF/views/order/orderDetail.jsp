<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="confirmation_part padding_top">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="confirmation_tittle">
					<span>결제 페이지</span>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="order_details_iner">
					<!-- style 적용부분 -->
					<h3>주문 상품 정보</h3>
					<table class="table table-borderless">
						<thead>
							<tr>
								<th scope="col">상품코드</th>
								<th scope="col" colspan="2">상품정보</th>
								<!-- 이미지 상품명 -->
								<th scope="col">가격</th>
								<th scope="col">수량</th>
								<th scope="col">합계</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="order" items="${cartList }">
							<tr>
								<th><span>${order.proCode }</span></th>
								<th><img src="${order.proImage }" alt="작은이미지" width="30px" height="30px"></th>
								<th><span>${order.proName }</span></th>
								<th><span>${order.proPrice }</span></th>
								<th>${order.myproCnt }</th>
								<th><span class="orderprice">${order.proPrice*order.myproCnt }</span></th>
							</tr>
							</c:forEach>


							<tr>
								<th colspan="4"><span></span></th>
								<th><span>배송비</span></th>
								<th><span>$원</span></th>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<th scope="col" colspan="4"></th>
								<th scope="col">합계</th>
								<th scope="col">원</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-lx-4">
				<div class="single_confirmation_details">
					<h4>구매자 정보</h4>
					<ul>
						<li>
							<p>구매자 :</p> <span>${memberinfo.userName}</span>
						</li>
						<li>
							<p>연락처 :</p> <span>${memberinfo.phoneNum}</span>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-lg-6 col-lx-4">
				<div class="single_confirmation_details">
					<h4>받는 사람 정보</h4>
					<ul>
						<li>
							<p>수령인</p> <span>:<input type="text"></span>
						</li>
						<li>
							<p>주소</p> <span>:<input type="text"></span>
						</li>
						<li>
							<p>상세주소</p> <span>:<input type="text"></span>
						</li>
						<li>
							<p>배송메모</p> <span>:<input type="text"></span>
						</li>
					</ul>
				</div>
			</div>
			<span><a class="btn_1" href="#">결제하기</a></span>
			<!-- <div class="col-lg-6 col-lx-4">
				<div class="single_confirmation_details">
					<h4>결제 수단</h4>
					<ul>
						<li>
							<p>Street</p> <span>: 56/8</span>
						</li>
						<li>
							<p>city</p> <span>: Los Angeles</span>
						</li>
						<li>
							<p>country</p> <span>: United States</span>
						</li>
						<li>
							<p>postcode</p> <span>: 36952</span>
						</li>
					</ul>
				</div>
			</div>
		</div> -->
		</div>
	</div>
</section>