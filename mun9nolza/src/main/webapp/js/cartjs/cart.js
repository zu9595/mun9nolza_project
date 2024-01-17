/**
 * cart.js
 */
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
				let newTr = makeTr(cart);
              	let cartListTbody = document.querySelector('.cartListTbody');
				cartListTbody.insertAdjacentHTML('afterbegin', newTr);
				
				//모두 선택, 해제
				allCheckEvent();
				//선택삭제
				delChecked();
				
				
				
				changeCnt2();
				
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
function delChecked(){	
	$('#delChecked').on('click', function(){
					$('tbody input:checked').parentsUntil('tbody').remove();
	})
}




// 수량 변경할때마다 db에 저장하기
function changeCnt() {
	// <input class="input-number" type="text" value="${cart.myproCnt}" min="0" max="10">
	$('.input-number-decrement').on("click", function(){
		let cnt = $('.input-number').val();
		cnt++;
		console.log(cnt);
	})
}

function changeCnt2() {
	$(".input-number-increment").on("click", function () {
		//let proDiscount = document.querySelector(".proDiscount").innerHTML = "";
		let proDiscount = $(this).parent("tr");
		//let proDiscount = $(this).closest("tr").find(".proDiscount").find("span").text();
		let price = $(this).closest("tr").find(".subTotal").text();
		let quantity = $(this).parent("div").find(".input-number").val();
		quantity ++;
		price = proDiscount * quantity;
		console.log(proDiscount);
		
		// makePoint();
	});

	$(".minusBtn").on("click", function () {
		let price = $(this).closest("td").prev().find("span").text();
		let quantity = $(this).parent("div").parent("div").find("input").val();
		if (quantity > 1) {
			$(this).parent("div").parent("div").find("input").val(--quantity);
		}
		$(this).closest("td").next("td").find("span").text(price * quantity);
		// makePoint();
	});
}




// 상품별 가격 합산
function makeSubTotal(discountP, cnt){
	let subTotal = discountP * cnt;
	
	return subTotal; 
}

// 배송비 계산

// 총 금액
// :checked 로 선택




function makeTr(cart){
	let newTr = `<tr>
				<td>
					<input type="checkbox" id="f-option" name="selector">
				</td>
				
                <td>
                  <div class="media">
                    <div class="d-flex">
                      <img src="img/${cart.proImage}" alt="" />
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
                    <span class="input-number-decrement"> <i class="ti-angle-down"></i></span>
                    <input class="input-number" type="text" value="${cart.myproCnt}" min="0" max="10">
                    <span class="input-number-increment"> <i class="ti-angle-up"></i></span>
                  </div>
                </td>
                <td>
                  <h5><span class="subTotal">서브토탈</span></h5>
                </td>
              </tr>`
              return newTr;
}