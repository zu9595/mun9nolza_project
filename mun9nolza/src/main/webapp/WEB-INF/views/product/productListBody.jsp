<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="cat_product_area section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                
                    <div class="left_sidebar_area">
                        <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h3>상품 종류</h3>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                    <li>
                                        <a href="#" class="category">다이어리</a>
                                    </li>
                                    <li>
                                        <a href="#" class="category">캘린더</a>
                                    </li>
                                    <li>
                                        <a href="#" class="category">노트</a>
                                    </li>
                                    <li>
                                        <a href="#" class="category">일기장</a>
                                    </li>
                                    <li>
                                        <a href="#" class="category">가계부</a>
                                    </li>
                                </ul>
                            </div>
                        </aside>

                        <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h3>상품 필터</h3>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                    <li>
                                        <a href="#">Apple</a>
                                    </li>
                                </ul>
                                <ul class="list">
                                    <li>
                                        <a href="#">Samsung</a>
                                    </li>
                                </ul>
                            </div>
                        </aside>

                        <aside class="left_widgets p_filter_widgets price_rangs_aside">
                            <div class="l_w_title">
                                <h3>가격 필터</h3>
                            </div>
                            <div class="widgets_inner">
                                <div class="range_item">
                                    <!-- <div id="slider-range"></div> -->
                                    <input type="text" class="js-range-slider" value="" />
                                    <div class="d-flex">
                                        <div class="price_text">
                                            <p>가격 :</p>
                                        </div>
                                        <div class="price_value d-flex justify-content-center">
                                            <input type="text" class="js-input-from" id="amount" readonly />
                                            <span>to</span>
                                            <input type="text" class="js-input-to" id="amount" readonly />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </aside>
                    </div>
                    
                </div>
                <div class="col-lg-9">
                    <div class="row">
                        <div class="col-lg-12">
                        
                            <div class="product_top_bar d-flex justify-content-between align-items-center">
                                <div class="single_product_menu">
                                    <p>총 <span id="totalcnt"></span>개의 상품</p>
                                </div>
                                <div class="single_product_menu d-flex">
                                    <h5>정렬 : </h5>
                                    <select>
                                        <option id="sorting" data-display="선택">선택</option>
                                        <option value="1">이름순</option>
                                        <option value="2">가격순</option>
                                        <option value="3">최신순</option>
                                        <option value="4">좋아요순</option>
                                    </select>
                                </div>
                                
                                <div class="single_product_menu d-flex">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="search"
                                            aria-describedby="inputGroupPrepend">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="inputGroupPrepend"><i
                                                    class="ti-search"></i></span>
                                        </div>
                                    </div>
                                </div>
                                 
                            </div>
                            
                        </div>
                    </div>
	                
                    <div class="row align-items-center latest_product_inner productlist" style="width: 720px;">
                        <!-- <div class="col-lg-4 col-sm-6">
                            <div class="single_product_item">
                                <img src="${vo.proImage }" alt="이미지">
                                <div class="single_product_text">
                                    <h4>${vo.proName }</h4>
                                    <h3>${vo.proPrice }</h3>
                                    <h3>할인가 ${vo.proDiscount }</h3>
                                    <a href="#" class="add_cart">장바구니에 담기<i class="ti-heart"></i></a>
                                </div>
                            </div>
                        </div> -->
                        
                        <div class="col-lg-12 listnumber" style="align-self: flex-end;">
                            <div class="pageination">
                                <!-- <nav aria-label="Page navigation example"> -->
                                    <!-- <ul class="pagination justify-content-center">
                                        <li class="page-item">
                                            <a class="page-link" href="#" aria-label="Previous">
                                                <i class="ti-angle-double-left"></i>
                                            </a>
                                        </li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item">
                                            <a class="page-link" href="#" aria-label="Next">
                                                <i class="ti-angle-double-right"></i>
                                            </a>
                                        </li>
                                    </ul> -->
                                <!-- </nav> -->
                            </div>
                        </div>
                            
                    </div>

                </div>
            </div>
        </div>
    </section>
<script>
 let products = document.querySelector('.productlist');
	let pageInfo = 1;
    let category = '';
    // let sort = ''; // 정렬 텍스트 기본값, .current(html로 보면 나옴)값을 넣어줄 예정
    let paging = document.querySelector('.pageination');
    showList(pageInfo,'', ''); 

    // function sorting(sort){ // 상품 정렬 기능 넣을 함수. 근데 이렇게 하는게 맞는지 모르겠음
    //     // console.log($('.current').text());
    //     switch(sort){
    //         case "이름순":
                
    //         case "가격순":

    //         default :
    //     }
    // }        

	function pageList(e){
        e.preventDefault();
		pageInfo = this.getAttribute("href");
        // console.log(pageInfo);
        showList(pageInfo, category, sort);
	}
    
    $('.category').on('click', () =>{            
        
        category = event.target.innerText;
        console.log(category);
        showList(1, category, sort);
        pagingList(result);
    });
    
    //Ajax호출.
    function showList(page, category, sort){
        fetch('productPagingList.do?page='+ page +'&category='+ category +'&sorting'+ sort)
		.then(str => str.json())
		.then(result => {
            let ul = ``;
            console.log("ajax 호출");
            $(".listnumber").siblings().remove(); // 페이지 번호 클래스의 형제 태그들을 지우는 구문
			result.list.forEach(product => {
                // sort = $('.current').text(); // 정렬 텍스트 받아오는 구문
                // sorting(sort);
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
    
const li = `<div class="col-lg-4 col-sm-6 listsize">
    <div class="single_product_item">
    <img src="`+product.proImage+`" alt="이미지">
    <div class="single_product_text">
        <h4>`+product.proName+`</h4>
        <h3>`+product.proPrice+`원</h3>
        <h3>할인가 `+product.proDiscount+`원</h3>
        <a href="#" class="add_cart">장바구니에 담기<i class="ti-heart"></i></a>
    </div>
</div>
</div>`
// console.log(product.proName);
return li;
}

	function pagingList(result){
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
	} //end of pagingList.
	// <if test="proDiscount != null and proDiscount != ''">
    // order by 
    // </if>
</script>