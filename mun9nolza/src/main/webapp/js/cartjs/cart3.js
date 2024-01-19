/**
 * cart.js
 */
$(document).ready(cartList());

//플러스,마이너스 버튼 이벤트 등록.
// btnEvent(){
//     $(".inc.qtybtn").on("click",function () { 

//      })
// };

//카트 전체 목록 보기
function cartList() {
    fetch("cartListJson.do?memberCode=M-00001", {
        method: "get",
        headers: { "Content-Type": "application/json" }
    })
        .then(res => res.json())
        .then(res => {
            console.log(res);
            $(res).each((idx, cart) => {
                let tr = `      <tr>
                                    <td class="shoping__cart__item">
                                        <img src="img/cart/cart-1.jpg" alt="">
                                        <h5>${cart.goodsName}</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        ${cart.price}
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                        <div class="pro-qty">
                                                <span class="dec qtybtn">-</span>
                                                <input type="text" value=${cart.quantity} class="que">
                                                <span class="inc qtybtn" >+</span>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                     
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <span class="icon_close"></span>
                                    </td>
                                </tr>`
                let cartListTbody = document.querySelector('#cartListTbody');
                cartListTbody.insertAdjacentHTML('afterend', tr);
            })//end of foreach
            //마이너스 버튼.
            $(".dec").on('click', function () {
                console.log(event.target.nextElementSibling);
                let result = event.target.nextElementSibling.value;
                if (result > 0) {
                 event.target.nextElementSibling.value = parseInt(result) - 1;
                }else{
                    return 0;
                }
                event.target.nextElementSibling.value;

            }) //end of minusBtn
            //플러스 버튼.
            $(".inc").on('click', function () {
                //console.log(event.target.nextElementSibling);
                let result = event.target.previousElementSibling.value;
                event.target.previousElementSibling.value = parseInt(result) + 1;
                //sevent.target.previousElementSibling.value(++$(cart.quantity));
            }) //end of plusBtn

            //아이템 삭제.
            $(".icon_close").on('click',function(){
                console.log(event.target);
                fetch("removeCart.do?cartCode=1")
                //응답 결과 받는 구문(controller)
                .then(result=> result.json())
                .then(result =>{
                    if(result.retCode == "OK"){
                        alert('삭제됨');
                event.target.closest("tr").remove();
//                        location.reload();
                    }else(
                        alert('삭제 중 오류 발생')
                    )
                })
            })//end of 아이템 삭제.
            //아이템 추가.
            $(".inc").on("click",function(){
                console.log(event.target);
                fetch("addCart.do?cartCode=1")
                .then(result=> result.json())
                .then(result =>{
                    if(result.retCode == "OK"){
                     event.target.   
               
//                      
                    }else(
                        alert('오류 발생');
                    )
                })
            })

            

        }) //end of click().
        .catch(console.error);
};
