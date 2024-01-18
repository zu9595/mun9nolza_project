
$('a[href="DetailTest"]').on('click',()=>{
	//let sel = 1;//event.target.proCode
	showProductDetail(sel);
})

function showProductDetail(pcode){
	
fetch('productDetail.do?pcode='+pcode)
.then(str => str.json())
.then(result => {
})
}