/**
 * 
 */
setPrice();
let fee = 0;

function setPrice(){
	
	fetch("orderResultJson.do", {
        method: "get",
        headers: { "Content-Type": "application/json" }
    })
        .then(res => res.json())
        .then(res => {
			console.log(res)
			let tr = ``;
			let total = 0;
			res.resultList.forEach((val, idx) => {
					tr += `<tr>
							<th><span>${val.proCode }</span></th>
							<th><span>${val.proName }</span></th>
							<th><span>${val.deProCnt }</span></th>
							<th><span>${val.deProPrice }</span></th>
						   </tr>`
					total += Number(val.deProPrice);
				})
					tr += `<tr>
							<th colspan="4"><span></span></th>
							<th><span>배송비</span></th>`
					if(total <= 50000){
						tr += `<th><span id="delifee">3000</span>원</th>
							</tr>`
						fee=3000;
					}else{
						tr += `<th><span id="delifee">0</span>원</th>
							</tr>`
						fee=0;
					}
			$('.setTr').append(tr);
			let sum = fee + total;
			$('.addFee').text(sum+"원");
			$('.buyer').text(res.buyInfo.userName);
			$('.phoneNumber').text(res.buyInfo.phoneNum);
		})
}
