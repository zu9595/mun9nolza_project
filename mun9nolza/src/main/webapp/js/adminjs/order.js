/**
 * 
 */
$(document).ready(function(){
list1();
EAprice();
modOrderList();
delOrderList();
})

//목록만들기
 function list1(){
	 fetch("orderListAdmin.do",{
		 	method: "post",
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'
		}
	 })
	 .then(res => res.json())
	 .then(res => {
		 console.log(res)
		 res.forEach((val,idx) => {
		 	$('#list').append(table1(val,idx));
		 	for(let i=0;i<val.detailList.length;i++){
				 $(`.lists${idx}`).append(table2(val.detailList[i]));
		 		
			 }
		 })
	 })
 }

//하단 카테고리 생성
 function table2(val){
	 let ncnt = Number(`${val.deProPrice}`) / Number(`${val.deProCnt}`);
	 let tr = `<tr>
				<td><input type="text" value="${val.proCode}" readonly></td>
				<td><input type="text" value="${val.proImage}" readonly></td>
				<td><input type="text" value="${val.proName}" readonly></td>
				<td><input type="number" value="${ncnt}" readonly></td>
				<td><input type="number" value="${val.deProCnt}" class="cnt"></td>
				<td><input type="number" value="${val.deProPrice}" class="dpp" readonly></td>
				<td><button type="button" class="modOrder">수정</button></td>
				<td><button type="button" class="delOrder">삭제</button></td>
			   </tr>`

	return tr;
 }
 
//수정
function modOrderList(){
	$(document).on("click",".modOrder",function(e){
		let proCode = $(e.target).closest('tr').find('td').eq(0).find('input').val()
		let deProCnt = $(e.target).closest('tr').find('td').eq(4).find('input').val()
		let deProPrice = $(e.target).closest('tr').find('td').eq(5).find('input').val()
		let userId = $(e.target).closest('table').closest('tr').prev().find('td').eq(0).find('input').val()
		let orderNo = $(e.target).closest('table').closest('tr').prev().find('td').eq(1).find('input').val()
		let orderRecipient = $(e.target).closest('table').closest('tr').prev().find('td').eq(2).find('input').val()
		let deliveryFee = $(e.target).closest('table').closest('tr').prev().find('td').eq(3).find('input').val()
		let orderStatus = $(e.target).closest('table').closest('tr').prev().find('td').eq(4).find('input').val()
		let orderPhone = $(e.target).closest('table').closest('tr').prev().find('td').eq(5).find('input').val()
		let orderAddr = $(e.target).closest('table').closest('tr').prev().find('td').eq(6).find('input').val()
		let detailAddr = $(e.target).closest('table').closest('tr').prev().find('td').eq(7).find('input').val()
		let totalPrice = $(e.target).closest('table').closest('tr').prev().find('td').eq(9).find('input').val()
		
		//form 양식 만들기
		let formData = new FormData();
		formData.append('userId',userId)
		formData.append('proCode',proCode)
		formData.append('orderNo',orderNo)
		formData.append('orderRecipient',orderRecipient)
		formData.append('deProCnt',deProCnt)
		formData.append('deProPrice',deProPrice)
		formData.append('totalPrice',totalPrice)
		formData.append('deliveryFee',deliveryFee)
		formData.append('orderStatus',orderStatus)
		formData.append('orderPhone',orderPhone)
		formData.append('orderAddr',orderAddr)
		formData.append('detailAddr',detailAddr)
		
		fetch("orderModAdmin.do",{
		 	method: "post",
			body: formData
			})
	 		.then(res => res.json())
	 		.then(res => {
				if(res.detailModCode == "OK" && res.listModCode == "OK"){
					alert('회원주문 수정완료');
				}else if(res.detailModCode == "NG"){
					alert('주문목록상세 수정실패');
				}else if(res.detailModCode == "NG"){
					alert('주문목록 수정실패');
				}
		 		console.log(res)
		 		$('#list').empty();
				list1();
	 		})
	})
	
}

//삭제
function delOrderList(){
	$(document).on("click",".delOrder",function(e){
		let proCode = $(e.target).closest('tr').find('td').eq(0).find('input').val()
		let orderNo = $(e.target).closest('table').closest('tr').prev().find('td').eq(1).find('input').val()
		let userId = $(e.target).closest('table').closest('tr').prev().find('td').eq(0).find('input').val()
		
		fetch('orderDelAdmin.do?proCode=' + proCode + '&orderNo=' + orderNo + '&userId=' + userId)
	 		.then(res => res.json())
	 		.then(res => {
		 		console.log(res)
				if(res.detailDelCode == "OK"){
					alert('주문목록상세 1건 삭제완료');
				}else if(res.detailDelCode == "NG"){
					alert('주문목록상세 삭제실패');
				}
				if(res.listDelCode == "OK"){
					alert('주문건이 존재하지 않아 주문목록을 삭제하였습니다.');
				}else if(res.detailDelCode == "NG"){
					alert('주문목록 삭제실패');
				}
				$('#list').empty();
				list1();
	 		})
	})
}
 
//토탈가격 자동수정
 function EAprice(){
	 $(document).on("change",".cnt",function(e){
		 //console.log($(e.target).closest('td').next().find('input').val())
		 //console.log(Number(e.target.value))
		 let ncnt = $(e.target).closest('td').prev().find('input').val()
	 	let count = Number(e.target.value);
	 	//console.log(price)
	 	$(e.target).closest('td').next().find('input').val(ncnt * count);
	 	
	 	//console.log($(e.target).closest('table').closest('tr').prev().find('td').eq(9).find('input').val())
// 주문전체가격,배송비 자동수정
	 	let trLength = $(e.target).closest('tbody').find('tr').length
	 	let totalNum = 0;
	 	for(let i =1; i < trLength;i++){
			 totalNum += Number($(e.target).closest('tbody').find('tr').eq(i).find('td').eq(5).find('input').val())
		 }
		let fee = 3000;
		if(totalNum >= 50000){
			fee = 0;
		}
		totalNum += fee
		$(e.target).closest('table').closest('tr').prev().find('td').eq(3).find('input').val(fee)
	 	$(e.target).closest('table').closest('tr').prev().find('td').eq(9).find('input').val(totalNum)
	 })
 }
 
//상단 카테고리 생성
 function table1(res,idx){
	 let day = dates(`${res.orderDate}`);
	 let tr = `<tr>
				<td><input type="text" value="${res.userId}" readonly></td>
				<td><input type="text" value="${res.orderNo}" readonly></td>
				<td><input type="text" value="${res.orderRecipient}"></td>`
		if(Number(`${res.totalPrice}`) >= 50000){
			tr += `<td><input type="text" value="0" readonly></td>`		
		}else{
			tr += `<td><input type="text" value="3000" readonly></td>`		
		}
		tr += `<td><input type="text" value="${res.orderStatus}"></td>
				<td><input type="text" value="${res.orderPhone}"></td>
				<td><input type="text" value="${res.orderAddr}"></td>
				<td><input type="text" value="${res.detailAddr}"></td>
				<td><input type="text" value="${day}" readonly></td>
				<td><input type="text" value="${res.totalPrice}" readonly></td>
				<td><button type="button" onclick="detailView()">목록</button></td>
			</tr>`
			
		tr += `<tr class="tog" style="display:none;">
				<td colspan="7">
					<table class="table lists${idx}">
						<tr>
							<td>상품번호</td>
							<td>상품이미지</td>
							<td>상품명</td>
							<td>낱개가격</td>
							<td>수량</td>
							<td>토탈가격</td>
							<td>수정</td>
							<td>삭제</td>
						</tr>
					 </table>
				 </td>
				</tr>`
	return tr;
 }
 
// 목록 토글
 function detailView() {
	$(event.target).closest('tr').next().toggle('.tog');
}

//날짜수정
 function dates(days){
	let date = new Date(days);
	let year = ('0'+date.getFullYear()).slice(-2);
    let month = ('0'+date.getMonth() + 1).slice(-2);
    let day = ('0'+date.getDate()).slice(-2);

    return `${year}/${month}/${day}`;
 }
 