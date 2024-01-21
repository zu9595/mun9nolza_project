
console.log(userId);

let orderStatus = "준비중";
let deliveryFee = 3000;

function orderResult() {
	let ordertel = $('#tel1').val() + $('#tel2').val() + $('#tel3').val();
	console.log(ordertel);
	makeOrderData(userId, orderRecipient, orderAddr, detailAddr, ordertel, deliveryMemo, orderSum, deliveryFee, orderDate, orderStatus);
}

// Ajax
function makeOrderData(userId, orderRecipient, orderAddr, detailAddr, orderPhone, deliveryMemo, totalPrice, deliveryFee, orderDate, orderStatus) {
	fetch('orderDetailData.do', {
		method: "POST",
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: 'userId=' + userId + '&orderRecipient=' + orderRecipient + '&orderAddr=' + orderAddr + '&detailAddr=' + detailAddr + '&orderPhone=' + orderPhone + '&deliveryMemo=' + deliveryMemo + '&totalPrice=' + totalPrice + '&deliveryFee=' + deliveryFee + '&orderDate=' + orderDate + '&orderStatus=' + orderStatus
	})
		.then(str => str.json())
		.then(result => {
			console.log(result);
			if (result.retCode == 'OK'){
					alert('결제 완료');
				} else if(result.retCode == 'NG'){
					alert('처리중 에러');
				}
		})
		.catch(err => console.error(err));
}



/*function makeSaleLi(product = {}) {
	let li =
		`<div class="col-lg-3 col-sm-6">
			<div class="single_product_item">
				<img src="`+ product.proImage + `" alt="이미지">
				<div class="single_product_text">
					<h4>`+ product.proName + `</h4>
					<h3>`+ product.proDiscount + `원</h3>
					<a href="productDetail.do?pcode=`+product.proCode+`" class="add_cart">상세페이지로<i class="ti-heart"></i></a>
				</div>
			</div>
		</div>`
		return li;
}*/