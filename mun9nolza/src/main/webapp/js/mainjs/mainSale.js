
showSaleList();

// Ajax
function showSaleList() {
	fetch('mainSaleList.do')
		.then(str => str.json())
		.then(result => {
			console.log("SaleList Ajax");
			let i = 1;
			result.forEach(product => {
				if (i <= 8) {
					$('.mainSalelist1').append(makeSaleLi(product));
				} else if (i > 8 && i <= 16) {
					$('.mainSalelist2').append(makeSaleLi(product));
				}
					i++;
			})
		})
		.catch(err => console.error(err));
}

function makeSaleLi(product = {}) {
	let li =
		`<div class="col-lg-3 col-sm-6">
            <div class="single_product_item">
                <img src="`+ product.proImage + `" alt="이미지">
                <div class="single_product_text">
                    <h4>`+ product.proName + `</h4>
                    <h3>`+ product.proDiscount + `원</h3>
                    <a href="productDetail.do?pcode=`+product.proCode+`" class="add_cart">상세페이지로<i class="ti-heart"></i></a>
                </div>
            </div>
        </div>`
        return li;
}