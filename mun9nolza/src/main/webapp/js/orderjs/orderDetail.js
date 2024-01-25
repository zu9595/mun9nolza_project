setPrice();
let fee = 0;

function setPrice(){
	
	fetch("orderDetailJson.do", {
        method: "get",
        headers: { "Content-Type": "application/json" }
    })
        .then(res => res.json())
        .then(res => {
			console.log(res)
			let tr = ``;
			res.list.forEach((val, idx) => {
				console.log(val)
				tr += `<tr>
					<th><span>${val.proCode }</span></th>
					<th><img src="img/${val.proImage }" alt="작은이미지" width="30px" height="30px"></th>
					<th><span>${val.proName }</span></th>`
			if(val.proDiscount != 0){
				tr += `<th><span class="proDiscount">${val.proDiscount }원</span></th>`
			}else{
				tr += `<th><span class="proPrice">${val.proPrice }원</span></th>`;
			}
				tr += `<th>${val.myproCnt }개</th>`
			if(val.proDiscount != 0){
				tr += `<th><span class="orderprice">${val.proDiscount*val.myproCnt }원</span></th>
					</tr>`
			}else{
				tr += `<th><span class="orderprice">${val.proPrice*val.myproCnt }원</span></th>
					</tr>`
			}
			})
			tr += `<tr>
				<th colspan="4"><span></span></th>
				<th><span>배송비</span></th>`
			if(res.priceSum < 50000){
				tr += `<th><span id="delifee">3000</span>원</th>
					</tr>`
				fee=3000;
			}else{
				tr += `<th><span id="delifee">0</span>원</th>
					</tr>`
				fee=0;
			}
			$('.setTr').append(tr);
			console.log(fee)
			$('.Fee').val(fee);
			let sum = fee + Number(orderSum);
			$('.addFee').text(sum+"원");
		})
}
