/**
 * 
 */

 	let products = document.querySelector('.productlist');
	let pageInfo = 1;
    let category = categorys;
    console.log(categorys)
    let option = '';
    let paging = document.querySelector('.pageination');
    let select = document.querySelector('.otp');


    //showList(pageInfo,''); 
    showList(pageInfo,category,option);
    
    
    $(".product_top_bar .otp").on("click",".option",function(e){
        let val = e.target.dataset.value;
        console.log(e.target)
        console.log(val)
        option = '';
        //이름, 가격, 최신, 좋아요순 / 1,2,3,4
        if(val==1){
			option = 'proName'
		}else if(val==2){
			option = 'proPrice'
		}else if(val==3){
			option = 'proSell'
		}else{
			option = ''
		}
        showList(pageInfo,category,option); 
    })
    
	$('.category').on('click', function(e){            
        category = e.target.innerText;
        console.log(category);
        showList(1, category,'');
    });
    
    //Ajax호출.
    function showList(page, category,option){
        fetch('productPagingList.do?page='+ page +'&category='+ category +'&option='+ option)
		.then(str => str.json())
		.then(result => {
            let ul = ``;
            console.log("ajax 호출");
            console.log(result);
            $(".listnumber").siblings().remove(); // 페이지 번호 클래스의 형제 태그들을 지우는 구문
			result.list.forEach(product => {
                let li = makeLi(product);
                ul += li; // ul로 모아서 출력해야 제대로 나옴
			})
            // console.log(ul);
            products.insertAdjacentHTML('afterbegin',ul); // 이 구문이 ul대신 li로 들어가면 하나씩 들어가서 순번이 이상하게 나옴
            pagingList(result);
			// console.log(result);
		})
		.catch(reject => console.log(reject));
	} // end of showList.
	
function makeLi(product = {}) {
    
let li = `<div class="col-lg-4 col-sm-6 listsize">
    <div class="single_product_item">
    <img src="img/`+product.proImage+`" alt="이미지">
    <div class="single_product_text">
        <h4>`+product.proName+`</h4>
        <h3>`+product.proPrice+`원</h3>`
        if(product.proDiscount != 0){
        	li += `<h3>할인가 `+product.proDiscount+`원</h3>`;
		}
      li += `<a href="productDetail.do?pcode=`+product.proCode+`" class="add_cart">상세보기</a>
    			</div>
					</div>
						</div>`
// console.log(product.proName);
return li;
}

	function pagingList(result){
		console.log(result)
            paging.innerHTML = ''; // 페이지 번호들 지우는 구문. 원래는 지정된 페이지 번호가 선택됐다는 css가 나와야 하는데 지워져서 안나옴
            $("#totalcnt").html(result.pageDTO.totalCnt);
            // console.log(result);
            // console.log(result.totalCnt);
            let ul = document.createElement('ul');
            ul.className = 'pagination justify-content-center';
            paging.appendChild(ul);
			//이전.
			if(result.pageDTO.prev)	{
                let li = document.createElement('li');
                li.className = "page-item";
				let aTag = document.createElement('a');
                aTag.className = "page-link";
				aTag.href = result.pageDTO.startPage - 1;
				let iTag = document.createElement('i');
                iTag.className="ti-angle-double-left";
				aTag.addEventListener('click', pageList);
				ul.appendChild(li);
				li.appendChild(aTag);
				aTag.appendChild(iTag);
			}
			for (let p = result.pageDTO.startPage; p <= result.pageDTO.lastPage; p++){
                let li = document.createElement('li');
                li.className = "page-item";
				let aTag = document.createElement('a');
                aTag.className = "page-link";
				aTag.href = p;
				aTag.innerText = p;
				aTag.addEventListener('click', pageList);
				ul.appendChild(li);
				li.appendChild(aTag);
			}
			// 다음.
			if(result.pageDTO.next)	{
                let li = document.createElement('li');
                li.className = "page-item";
				let aTag = document.createElement('a');
                aTag.className = "page-link";
				aTag.href = result.pageDTO.lastPage + 1;
                let iTag = document.createElement('i');
                iTag.className="ti-angle-double-right";
				aTag.addEventListener('click', pageList);
				ul.appendChild(li);
				li.appendChild(aTag);
				aTag.appendChild(iTag);
			}
	}
    
    function pageList(e){
        e.preventDefault();
		pageInfo = this.getAttribute("href");
        // console.log(pageInfo);
       	showList(pageInfo, category, option);
	}
