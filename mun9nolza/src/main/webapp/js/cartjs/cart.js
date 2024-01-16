/**
 * cart.js
 */
$(document).ready(cartList());

function cartList() {
    fetch("cartListJson.do?userId=user1", {
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
			})
        })
        .catch(console.error);
};


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
                      <p>${cart.proName}</p>
                    </div>
                  </div>
                </td>
                
                <td>
                  <h5>${cart.proPrice}</h5>
                </td>
                
                <td>
                  <h5>${cart.proDiscount}</h5>
                </td>
                
                <td>
                  <div class="product_count">
                    <span class="input-number-decrement"> <i class="ti-angle-down"></i></span>
                    <input class="input-number" type="text" value="${cart.myproCnt}" min="0" max="10">
                    <span class="input-number-increment"> <i class="ti-angle-up"></i></span>
                  </div>
                </td>
                <td>
                  <h5>$720.00</h5>
                </td>
              </tr>`
              return newTr;
}