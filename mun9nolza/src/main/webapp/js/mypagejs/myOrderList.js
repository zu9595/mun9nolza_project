/**
 * myOrderList.js
 */
aass();
//상세조회
function detailView() {
	$(event.target).closest('tr').next().toggle('orderHidden');
}





//주문취소
function removeOrder(orderNo) {
	
	let status = $(event.target).closest('tr.detail').prev().find('.status');

	if(status.text() != '배송준비중'){
		alert('배송준비 중으로 주문취소 불가');
		//alert('배송준비 중으로 주문취소 불가'); 
		return;
	}/*else if(status.text() == '배송완료'){
		alert('배송완료된 상품입니다')
	}*/
	
	fetch("myOrderModifyJson.do", {
		method: "post",
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: 'orderNo='+orderNo
	})
	.then(str => str.json())
	.then(result => {
		if(result){
			status.html('주문취소');
			
			alert('주문이 취소되었습니다.');
		}else {
			alert('오류');
		}
	})
}

function aass(){
	
	fetch("myOrderList.do", {
		method: "post",
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'
		}
	})
	.then(str => str.json())
	.then(result => {
		console.log(result);
	})
}