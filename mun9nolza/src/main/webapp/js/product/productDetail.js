
/*$('a[href="Detail"]').on('click',(e)=>{
	e.preventDefault();
	console.log(e.target)
	//showProductDetail(e.target.proCode);
})

function showProductDetail(pcode){
	
fetch('productDetail.do?pcode='+pcode)
.then(str => str.json())
.then(result => {
})
}*/

//상세이미지 들고오는 부분
function detDetailImg(orderNo){
	
	
	fetch('prodDetailImg.do',{
        method: "post",
        headers:{
        'Content-Type':'application/x-www-form-urlencode'
    	},
    	body: 'orderNo=' + orderNo
    	})
		.then(str => str.json())
		.then(res => {
			console.log(res)
			res.each(function(idx,val){
				
			})
			imgdiv(res);
		})
}

function imgdiv(res){
	let div = `<div data-thumb="img/logo.png">
                <img src="${res.image}" alt="상세이미지"/>
              </div>`;
    
    return div;
}

