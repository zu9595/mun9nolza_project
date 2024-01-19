/**
 * 
 */
$(document).ready(function() {
	categorySelect();
})

function categorySelect() {
	$('.cate').on('click', 'LI', function(e) {
		console.log(e.target.dataset.value);
		let category = e.target.dataset.value;
		fetch(`prodCodeList.do?category=${category}`, {
			method: "get",
			headers: {
				"Content-Type": "application/json"
			}
		})
			.then(res => res.json())
			.then(res => {
				console.log(res);
				$('.prodName').empty();
				$(res).each((idx, prod) => {
					let option = `<option value="${prod.proName}">${prod.proName}</option>`;
					$('.prodName').append(option);
				})
				$('.prodName').niceSelect('update');
				
				$('.prodName').on('click', 'LI', function(e) {
					$(res).each((idx, prod)=>{
						if(e.target.dataset.value == prod.proName){
							let proCode = prod.proCode;
							$('.proCode').prop('value', proCode);
						}
					})
				})

			}).catch(console.error);

	})
}