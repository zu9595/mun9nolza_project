/**
 * 
 */
let detailImg = document.querySelector('#vertical');

detDetailImg(proCode);
cntDecrementEvent();
cntIncrementEvent();

//상세이미지 들고오는 부분
function detDetailImg(proCode){
	fetch(`prodDetailImg.do?proCode=${proCode}`,{
        method: "get",
		headers: {
			"Content-Type": "application/json"
			}
		})
		.then(str => str.json())
		.then(res => {
			let ul = ``;
			console.log(res)
			$(res).each((idx,val) =>{
			 	let div = imgdiv(val);
                ul += div;
			})
			detailImg.insertAdjacentHTML('beforeend',ul);
		})
}

function imgdiv(res){
	const div = `<div data-thumb="img/logo.png">
                <img src="img/${res.image}" alt="상세이미지"/>
              </div>`;
    
    return div;
}

function addCartList(){
	let myproCnt = document.querySelector('.prodCnt').value;
	console.log(myproCnt)
	fetch(`addCartJson.do?userId=${userId}&proCode=${proCode}&proPrice=${proPrice}&proDiscount=${proDiscount}&myproCnt=${myproCnt}`,{
        method: "get",
		headers: {
			"Content-Type": "application/json"
			}
		})
		.then(str => str.json())
		.then(res => {
			console.log(res)
			if(res.retCode = "OK"){
				alert('장바구니에 추가 되었습니다.');
				alert('장바구니에 추가된 목록은 장바구니 페이지에서 결제해주세요.');
			}
		})
		.catch(res => console.log(res));
}

// 체크박스 수량 업태그
function cntDecrementEvent(){
	$(".product_count").on("click",`.ininput`,function(e){
		let val = $(e.target).prev().val();
		val++;
        $(e.target).prev().val(val);
	})
}
// 체크박스 수량 다운태그
function cntIncrementEvent(){	
	$(".product_count").on("click",`.deinput`,function(e){
		let val = $(e.target).next().val();
		if(val > 1){
			val--;
		}
        $(e.target).next().val(val);
	})
}

// 단건 주문이동
function singlePayForm(){
	let myproCnt = document.querySelector('.prodCnt').value;
		
	let f = document.createElement('form');
    
    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'userId');
    obj.setAttribute('value', userId);
    f.appendChild(obj);
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'proCode');
    obj.setAttribute('value', proCode);
    f.appendChild(obj);
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'proPrice');
    obj.setAttribute('value', proPrice);
    f.appendChild(obj);
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'proDiscount');
    obj.setAttribute('value', proDiscount);
    f.appendChild(obj);
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'myproCnt');
    obj.setAttribute('value', myproCnt);
    f.appendChild(obj);
    
    f.setAttribute('method', 'post');
    f.setAttribute('action', 'singleOrderDetailForm.do');
    document.body.appendChild(f);
    f.submit();
}
