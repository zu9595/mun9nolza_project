/**
 * 
 */
$(document).ready(function(){
list1();
EAprice();
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
				<td><input type="number" value="${val.deProPrice}" readonly></td>
				<td><button type="button" class="modOrder">수정</button></td>
				<td><button type="button" class="delOrder">삭제</button></td>
			   </tr>`

	return tr;
 }
 
//수정
function modOrderList(){
	//데이터 찾아줘야함
	let formData = new FormData();
	
	fetch("orderModAdmin.do",{
		 	method: "post",
			headers: { 'Content-Type': 'application/x-www-form-urlencoded'
			},
			body:{
				formData
			}
	 })
	 .then(res => res.json())
	 .then(res => {
		 
	 })
}

//삭제
function delOrderList(){
	
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