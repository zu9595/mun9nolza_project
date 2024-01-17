/**
 * myOrderList.js
 */

$(document).ready(function(){
	myOrderList();
});

function myOrderList() {
	
	/*let userId = '${logId}'
	fetch('myOrderListJson.do?userId='+userId,*/
	
	fetch('myOrderListJson.do?userId=user1', {
		method: 'get',
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
	})
		.then(str => str.json())
		.then(result => {
			console.log(result);



			$(result).each((idx, order) => {
				let info = makeTr(order);
				let tbody = document.querySelector('#tbody');
				tbody.insertAdjacentHTML('beforeend', info);
			})
		})
		
			/*result.forEach((order,idx) => {
				let info = makeTr(order);
				let tbody = document.querySelector('#tbody');
				tbody.insertAdjacentHTML(info, 'beforeend');
			})
		})*/
		.catch(console.error);
};


function makeTr(order) { //주문상태 바꿔야 됨
	let info = `<tr>
                        <td>${order.orderDate}</td>
                        <td>${order.orderNo}</td>
                        <td>${order.proName}</td>
                        <td>${order.deProCnt}</td>
                        <td><button class='orderDetail'>상세조회</button></td>
                       </tr>`           
  return info;                     
}

//상세
/*document.querySelector('.orderDetail').onclick = function(){
	
}*/



















