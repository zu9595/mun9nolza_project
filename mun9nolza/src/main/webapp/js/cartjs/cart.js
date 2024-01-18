/**
 * cart.js
 */
let myproCnt = 0;
$(document).ready(cartList());

function cartList() {
const urlParams = new URL(location.href).searchParams;
const userId = urlParams.get('userId');
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
				//선택삭제
				delCheckEvent();
				//체크박스 수량변경
				cntDecrementEvent(cart,idx,myproCnt);
				cntIncrementEvent(cart,idx,myproCnt);
				
				
				
			})
        })
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
function delCheckEvent(){
	$('#delChecked').on('click', function(){
					$('tbody input:checked').parentsUntil('tbody').remove();
	})
}

function cntDecrementEvent(cart,idx,myproCnt){
	//업태그
	$(".cartListTbody").on("click",`.increment${idx}`,function(e){
		console.log(e.target)
		--myproCnt;
		console.log(myproCnt)
		let proCode = cart.proCode;
		let userId = cart.userId;
        $(".cartListTbody").find(`.input${idx}`).val(myproCnt);
	})
	
	}


// 수량 변경할때마다 db에 저장하기 custom.js에 미리 걸린 이벤트 주석 처리
function cntIncrementEvent(cart,idx,myproCnt){
	// <input class="input-number" type="text" value="${cart.myproCnt}" min="0" max="10">
	//다운태그
	
	$(".cartListTbody").on("click",`.decrement${idx}`,function(e){
		console.log(e.target)
		console.log(cart)
		if(myproCnt < 2){
			++myproCnt;
		}else{
		}
		console.log(myproCnt)
		let proCode = cart.proCode;
		let userId = cart.userId;
        $(".cartListTbody").find(`.input${idx}`).prop("value",`${myproCnt}`);
		
		/*fetch("cartListJson.do", {
        method: "post",
        headers:{
        'Content-Type':'application/x-www-form-urlencode'
    	},
    	body: 'myproCnt=' + myproCnt + 'proCode=' + proCode +'&userId='+userId
    	})*/
		
		//아이디/이름/수량
	})
	
	
	
	/*$("input-number-decrement").on("click", function(){
		let cnt = $('.input-number').val();
		console.log(event.target);
		let result = event.target.previousElementSibling.value;
		console.log(result);
		
	})*/
}
/*function cntIncrementEvent(){
	$(".input-number-increment").on("click", ".increment" ,function(){
		console.log(event.target);
	})
}*/






// 상품별 가격 합산
function makeSubTotal(discountP, cnt){
	let subTotal = discountP * cnt;
	
	return subTotal; 
}

// 배송비 계산

// 총 금액
// :checked 로 선택




function makeTr(cart,idx){
	let newTr = `<tr>
				<td>
					<input type="checkbox" id="f-option" name="selector">
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
                  <h5><span class="proDiscount">${cart.proDiscount}</span></h5>
                </td>
                
                <td>
                  <div class="product_count">
                    <span class="input-number-decrement decrement${idx}"> <i class="ti-angle-down"></i></span>
                    <input class="input-number input${idx}" type="text" value="${cart.myproCnt}" min="0" max="10">
                    <span class="input-number-increment increment${idx}"> <i class="ti-angle-up"></i></span>
                  </div>
                </td>
                <td>
                  <h5><span class="subTotal">서브토탈</span></h5>
                </td>
              </tr>`
              return newTr;
}