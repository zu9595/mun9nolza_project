

showCategoryHotList();

function showCategoryHotList() {
	fetch('mainCategoryHotList.do')
		.then(str => str.json())
		.then(result => {
			console.log("CategoryHotList Ajax")
			result.forEach(product => {
				$('.hotlist').append(makeCategoryHotList(product));
			})
		})
		.catch(err => console.error(err));
}


function makeCategoryHotList(product = {}) {
	let li =
		`<div class="col-lg-5 col-sm-6">
		<div class="single_feature_post_text">
                    <p>`+product.category+`</p>
                    <h3>`+product.proName+`</h3>
                    <a href="productDetail.do?pcode=`+product.proCode+`" class="feature_btn">상세페이지로 <i class="fas fa-play"></i></a>
                    <img src="img/`+product.proImage+`" alt="이미지">
                </div>`
	return li;
}