showBestProdList();

function showBestProdList() {
	fetch('mainBest.do')
		.then(str => str.json())
		.then(res => {
			console.log(res)
			for(let i=0;i<5;i++){
				$('.owl-carousel').append(makeBestLi(res[i]));
			}
		})
		.catch(err => console.error(err));
}

function makeBestLi(product = {}) {
	let li =
		`<div class="single_product_item">
              <img src="img/${product.proImage}" alt="">
              <div class="single_product_text">
                <h4>${product.proName}</h4>
                <h3>${product.proPrice}</h3>
              </div>
            </div>`
        return li;
}