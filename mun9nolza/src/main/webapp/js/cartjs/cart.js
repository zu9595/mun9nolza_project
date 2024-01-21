/**
 * cart.js
 */
let pageMoveId = '';
let pageMoveCode = '';
let pageMovecnt = '';

$(document).ready(function(){
	cartList();
//	cntDecrementEvent();
//	cntIncrementEvent();
	console.log(pageMoveId)
	console.log(userId)
	});

function cartList() {
	pageMoveId = userId;
    fetch("cartListJson.do?userId=" + userId, {
        method: "get",
        headers: { "Content-Type": "application/json" }
    })
        .then(res => res.json())
        .then(res => {
            console.log(res);
            $(res).each((idx, cart) => {
				// tr생성-> 첫번째 td밑div2개 td 총5개
				console.log(cart);
				let newTr = makeTr(cart,idx);
              	let cartListTbody = document.querySelector('.cartListTbody');
				cartListTbody.insertAdjacentHTML('afterbegin', newTr);
				myproCnt = cart.myproCnt;
				
				//디폴트로 체크박스 모두 선택
				$('thead input[type="checkbox"]').prop('checked', true);
				//체크박스 모두 선택, 해제 이벤트
				
				//체크박스 수량변경 이벤트
				//console.log(cart.myproCnt);
				cntDecrementEvent(idx,cart);
				cntIncrementEvent(idx,cart);
				
				//서브토탈
				makeSubTotal(idx,cart);				
			})				
				allCheckEvent(res);
				//체크박스 선택 삭제 이벤트
				delCheckEvent(res);
				//배송비, 총금액 계산
				makeFeeTotal(res);
//			return res;
        })
//        .then(res => {
//			console.log(res)
//			$(res).each((idx, res) => {
//				fetch(`ModCartCntJson.do?cnt=${res.myproCnt}&proCode=${res.proCode}&userId=${res.userId}`, {
//        		method: "get",
//        		headers:{
//					"Content-Type": "application/json"
//        		//'Content-Type':'application/x-www-form-urlencode'
//    			}
//    			})
//				})
//    			.then(res => {
//					console.log(res);
//				})
//				})
        .catch(console.error);
};

// 모두 선택, 선택 해제
function allCheckEvent(res){
	$('thead input[type="checkbox"]').on('click', function(){
				//console.log(this.checked);				
				//console.log($('tbody input[type="checkbox"]').prop('checked'));				
				//prop로...
				$('tbody input[type="checkbox"]').prop('checked', this.checked);
				
				//makeFeeTotal(res);
			})
}

// 체크박스 1개라도 선택해제시 thead체크박스도 선택해제
 $('tbody input[type="checkbox"]').on('click', function () {
                            $('thead input[type="checkbox"]').prop('checked', false);
                        });



const checkboxes = document.querySelectorAll('tbody input[type="checkbox"]');
console.log(checkboxes);
for(const checkbox of checkboxes){
    checkbox.addEventListener('click',function(){
        
        const totalCnt = checkboxes.length;
    
        const checkedCnt = document.querySelectorAll('.chk:checked').length;
        
        if(totalCnt == checkedCnt){
            document.querySelector('#checkAll').checked = true;
        }
        else{
            document.querySelector('#checkAll').checked = false;
        }
        
    });
    
}


// 선택 삭제 이벤트
function delCheckEvent(res){
	$('#delChecked').on('click', function(){
		//console.log(res);
		//console.log($('tbody input:checked'));
		$('tbody input:checked').each((idx,cart) => {
		let userId = res[cart.className].userId;
		let proCode = res[cart.className].proCode;
		//console.log(res[cart.className].proCode);
			fetch(`delCart.do?userId=${userId}&proCode=${proCode}`, {
        	method: "get",
       		headers: { "Content-Type": "application/json" }
	    	})
	    	.catch(console.error);
		})
		
		$('tbody input:checked').parentsUntil('tbody').remove();
		
		makeFeeTotal(res);
	})
}


// 수량 변경할때마다 db에 저장하기 custom.js에 미리 걸린 이벤트 주석 처리
// 체크박스 수량 업태그
function cntDecrementEvent(idx,res){
	$(".cartListTbody").on("click",`.ininput${idx}`,function(e){
		let val = $(e.target).prev().val();
		//console.log(e.target)
		val++;
        $(e.target).prev().val(val);
        
	//e.stopPropagation();
	//console.log(res.proCode)
	
	fetch(`modCartCntJson.do?myproCnt=${val}&proCode=${res.proCode}&userId=${res.userId}`, {
        method: "get",
        headers: { "Content-Type": "application/json" }
    })
    .catch(console.error);
	
	
	makeSubTotal(idx,res);
	makeFeeTotal(res);
	})
}
// 체크박스 수량 다운태그
function cntIncrementEvent(idx,res){	
	$(".cartListTbody").on("click",`.deinput${idx}`,function(e){
		let val = $(e.target).next().val();
		//console.log(e.target)
		if(val > 1){
			val--;
		}
        $(e.target).next().val(val);
        
        //e.stopPropagation();
        
        fetch(`modCartCntJson.do?myproCnt=${val}&proCode=${res.proCode}&userId=${res.userId}`, {
        method: "get",
        headers: { "Content-Type": "application/json" }
	    })
	    .catch(console.error);
	    
		makeSubTotal(idx,res);
		makeFeeTotal(res);
		})
		
}

/*// 페이지 이동시 데이터 저장 
function orderModSet(){
	fetch("ModCartCntJson.do", {
        method: "post",
        headers:{
        'Content-Type':'application/x-www-form-urlencode'
    	},
    	body: 'cnt=' + pageMovecnt + 'proCode=' + pageMoveCode +'&userId='+pageMoveId
    	})
}*/

// 상품별 가격 합산
function makeSubTotal(idx,res){
	
	let proDiscount = $(`.proDiscount${idx}`).text();	
	let myproCnt = $(`.myproCnt${idx}`).val();
	
	//console.log(proDiscount);
	//console.log(myproCnt);
	
	$(`.subTotal${idx}`).text(proDiscount * myproCnt);	
	//makeFeeTotal(res);
}

// 배송비, 총금액 계산
function makeFeeTotal(res){
	let preTotal = 0;
	
	$('tbody input:checked').each((idx,cart) => {
		let subTotal = parseInt(document.querySelector('.subTotal'+idx).innerHTML);
		preTotal += subTotal;
		console.log(preTotal);
	})
	if(preTotal < 50000 ){
		document.querySelector('.delieveryFee').innerHTML = '+3000 원';
		document.querySelector('.total').innerHTML = preTotal + 3000;
	}else{
		document.querySelector('.delieveryFee').innerHTML = '무료';
		document.querySelector('.total').innerHTML = preTotal;
	}
}

function makeTotal(res){
	
	//$('table input[type="checkbox"]').on('change', makeFeeTotal(res));
};


// :checked 로 선택된 상품만 주문하기 페이지로 넘기기




function makeTr(cart,idx){
	let newTr = `<tr>
				<td>
					<input type="checkbox" id="f-option" name="selector" class="${idx}" checked="true">
				</td>
				
                <td>
                  <div class="media">
                    <div class="d-flex">
                      <img src="${cart.proImage}" alt="" />
                    </div>
                    <div class="media-body">
                      <a href="#">${cart.proName}</a>
                    </div>
                  </div>
                </td>
                
                <td>
                  <h5><span class="proPrice">${cart.proPrice}</span></h5>
                </td>
                
                <td>
                  <h5><span class="proDiscount proDiscount${idx}">${cart.proDiscount}</span></h5>
                </td>
                
                <td>
                  <div class="product_count">
                    <span class="input-number-decrement ti-angle-down deinput${idx}"></span>
                    <input class="input-number myproCnt${idx}" type="text" value="${cart.myproCnt}" min="0" max="10">
                    <span class="input-number-increment ti-angle-up ininput${idx}"></span>
                  </div>
                </td>
                <td>
                  <h5><span class="subTotal subTotal${idx}"></span></h5>
                </td>
              </tr>`
      return newTr;
}