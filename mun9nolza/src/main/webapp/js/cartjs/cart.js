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
	});

function cartList() {
const urlParams = new URL(location.href).searchParams;
const userId = urlParams.get('userId');
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
				//모두 선택, 해제
				allCheckEvent();
				//체크박스 선택 삭제
				//체크박스 수량변경
				console.log(cart.myproCnt)
				cntDecrementEvent(idx,cart);
				cntIncrementEvent(idx,cart);
				
				//서브토탈
				makeSubTotal(idx,cart)
				
			})
				delCheckEvent(res);
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
function allCheckEvent(){
	$('thead input[type="checkbox"]').on('change', function(){
				//console.log(this.checked);				
				//console.log($('tbody input[type="checkbox"]').prop('checked'));				
				//prop로...
				$('tbody input[type="checkbox"]').prop('checked', this.checked);
			})
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
	})
}


// 수량 변경할때마다 db에 저장하기 custom.js에 미리 걸린 이벤트 주석 처리
// 체크박스 수량 업태그
function cntDecrementEvent(idx,res){
	$(".cartListTbody").on("click",`.ininput${idx}`,function(e){
		let val = $(e.target).prev().val();
		console.log(e.target)
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
	})
}
// 체크박스 수량 다운태그
function cntIncrementEvent(idx,res){	
	$(".cartListTbody").on("click",`.deinput${idx}`,function(e){
		let val = $(e.target).next().val();
		console.log(e.target)
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
}

// 배송비 계산

// 총 금액
// :checked 로 선택




function makeTr(cart,idx){
	let newTr = `<tr>
				<td>
					<input type="checkbox" id="f-option" name="selector" class="${idx}">
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