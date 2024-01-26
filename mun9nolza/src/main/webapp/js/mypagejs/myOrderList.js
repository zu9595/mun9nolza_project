/**
 * myOrderList.js
 */
//makeTr();
//상세조회
function detailView() {
	$(event.target).closest('tr').next().toggle('orderHidden');
}

//주문취소
function removeOrder(orderNo) {
	
	
	let status = $(event.target).closest('tr.detail').find('.status');
	if(status.text() == '배송중'){
		alert('배송중인 상품으로 주문취소 불가');
		return;
	}else if(status.text() == '배송완료'){
		alert('배송완료된 상품입니다')
		return;
	}
	
	
	fetch("myOrderModifyJson.do", {
		method: "post",
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'
		}
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
/*
function makeTr(){
	fetch("myOrderListJson.do", {
		method: "post",
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: 'userId='+userId
	})
	.then(str => str.json())
	.then(res => {
		console.log(res)
	})
	
	let tr = ``;
		tr += `<tr>
	 		     <td>`
	 	if(result.proImage != null){
			tr += `<img width="150px" src="img/${result.proImage}">`
		}  
		tr += `</td>
				<td>${result.proCode }</td>
				<td>${result.proName }</td>
				<td>${result.deProCnt }개</td>`
		if(""){
			tr += `<td>${result.deProPrice}원</td>
	 		    </tr>`
		}else{
			tr += `<td>${result.deProPrice}원</td>
	 		    </tr>`
		}
}*/