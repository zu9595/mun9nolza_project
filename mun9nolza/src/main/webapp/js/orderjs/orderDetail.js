
/*console.log(orderSum);
console.log(userId);

let orderStatus = '준비중';
let deliveryFee = 3000;
let ordertel = $('#tel1').val() +'-'+ $('#tel2').val() +'-'+ $('#tel3').val();
console.log(ordertel);
	makeOrderData(userId, orderRecipient, orderAddr, detailAddr, ordertel, deliveryMemo, orderSum, deliveryFee, orderStatus);

// Ajax
function makeOrderData(userId, orderRecipient, orderAddr, detailAddr, orderPhone, deliveryMemo, totalPrice, deliveryFee, orderStatus){
	fetch('orderResult.do', {
		method: "POST",
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: 'userId=' + userId + '&orderRecipient=' + orderRecipient + '&orderAddr=' + orderAddr + '&detailAddr=' + detailAddr + '&orderPhone=' + orderPhone + '&deliveryMemo=' + deliveryMemo + '&totalPrice=' + totalPrice + '&deliveryFee=' + deliveryFee + '&orderStatus=' + orderStatus
	})
		.then(str => str.json())
		.then(result => {
			console.log(result);
		})
		.catch(err => console.error(err));
}*/



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