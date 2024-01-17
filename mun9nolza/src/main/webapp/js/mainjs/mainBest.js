


showBestList();

function showBestList() {
	fetch('mainBest.do')
		.then(str => str.json())
		.then(result => {
			console.log(result);
			i = 0;
			result.forEach(product => {
				if (i < 6) {
					$('.bestlist .owl-stage .owl-item').children().eq(i).append(makeBestLi(product));
					i++;
				}
			})
		})
}


function makeBestLi(product) {

	let li = `
                        <img src="`+ product.proImage + `" alt="">
                        <div class="single_product_text">
                            <h4>`+ product.proName + `</h4>
                            <h3>`+ product.proPrice + `원</h3>
                        </div>
                    `;
	return li;
}