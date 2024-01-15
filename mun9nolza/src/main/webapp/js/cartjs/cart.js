/**
 * 
 */
$(document).ready(cartList());

function cartList() {
    fetch("cartList.do", {
        method: "get",
        headers: { "Content-Type": "application/json" }
    })
        .then(res => res.json())
        .then(res => {
            console.log(res);
            $(res).each((idx, cart) => {
				// tr생성. td생성

				let tr = $('<tr />').append($('<td />').text(cart.pro_image),
					$('<td />').append($('<h5 />').text(cart.pro_name)),
					$('<td />').text(cart.mypro_cnt),
					$('<td />').text(cart.mypro_price),
				);
				$('#cartListTbody').append(tr);
			})
        })
        .catch(console.error);
};
