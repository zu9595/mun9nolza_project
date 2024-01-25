<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="confirmation_part padding_top">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="confirmation_tittle">
					<span style="font-size: 2.5rem; color: #86a41c;">결제 결과 페이지</span>
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
								<th scope="col">상품명</th>
								<th scope="col">수량</th>
								<th scope="col">합계</th>
							</tr>
						</thead>
						<tbody class="setTr">

							<!--<c:forEach var="order" items="${orderDetailList}">
								<tr>
									<th><span>${order.proCode }</span></th>
									<th><span>${order.orderNo }</span></th>
									<th><span>${order.deProCnt }</span></th>
									<th><span>${order.deProPrice }</span></th>
								</tr>
							</c:forEach>


							<tr>
								<th colspan="4"><span></span></th>
								<th><span>배송비</span></th>
								<th><span>$원</span></th>
							</tr>-->
							
						</tbody>
						<tfoot>
							<tr>
								<th scope="col" colspan="4"></th>
								<th scope="col">총 합계</th>
								<th scope="col" class="addFee">0 원</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
		<div class="row" style="background: floralwhite;">
			<div class="col-lg-6 col-lx-4">
				<div class="single_confirmation_details" style="background: none;">
					<h4>구매자 정보</h4>
					<ul style="height: 5rem;">
						<li style="height: 2rem;">
							<p>구매자 : <span class="buyer"></span></p>
						</li>
						<li style="height: 2rem;">
							<p>연락처 : <span class="phoneNumber"></span></p>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-lg-6 col-lx-4">
				<div class="single_confirmation_details" style="background: none;">
					<h4>받는 사람 정보</h4>
					<ul>
						<li style="padding-left: 20%;">
							<p>수령인 :</p> <span>${orderInfo.orderRecipient}</span> 
						</li>
						<li style="padding-left: 20%;">
							<p>주소 :</p> <span>${orderInfo.orderAddr}</span> 
						</li>
						<li style="padding-left: 20%;">
							<p>상세주소 :</p> <span>${orderInfo.detailAddr}</span> 
						</li>
						<li style="padding-left: 20%;">
							<p>배송메모 :</p> <span>${orderInfo.deliveryMemo}</span> 
						</li>
					</ul>
				</div>
			</div>
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
		<div class="d-grid gap-2" style="text-align: center;">
			<button type="button" class="btn btn-success" onclick="location.href='main.do'">확인</button>
		</div>
	</div>
</section>

<script src="js/orderjs/resultDetail.js"></script>