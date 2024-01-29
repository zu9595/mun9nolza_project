/**
 * 
 */
let pageInfo = 1;
let tab1 = document.querySelector(`.tab1`);
let tab2 = document.querySelector(`.tab2`);
let tab3 = document.querySelector(`.tab3`);
let paging = document.querySelector('.pageination');
let star = 0;

$(document).ready(function(){
	proDescBtn1();
	//reviewList(pageInfo, proCode);
	btn1();
	btn2();
	addReview(proCode);
    tab3.insertAdjacentHTML('afterend',consts2());
    delLi();
});

//리뷰리스트 목록
function reviewList(page, proCode){
	fetch('reviewList.do?page='+ page +'&proCode='+ proCode)
		.then(str => str.json())
		.then(result => {
            let ul = ``;
			result.list.forEach(rev => {
                let li = makeLis(rev);
                ul += li; 
			})
            tab3.insertAdjacentHTML('afterbegin',ul);
            pagingList(result);
            
		})
		.catch(reject => console.log(reject));
}

//초기 페이지 상품설명 화면
function proDescBtn1(){
	const con2 = `<div class="homes" id="home" style="display: flex;align-items: center; flex-direction: column;">
          <p style="padding: 3rem 40%; max-width: 100%; margin: 0 auto; text-align: center;">
            ${proDesc }
          </p>
          <div class="imgDetail">
          </div>
        </div>`
        $('.tab3').children().remove();
		$('.pageination').children().first().remove();
		$('.tab3').siblings().eq(1).remove();
		console.log($('.tab3').siblings().eq(1))
		tab3.insertAdjacentHTML('afterbegin',con2);
		imgDetails();
}

// 상품설명 버튼 이벤트
function btn1(){
	const con2 = `<div class="homes" id="home" style="display: flex;align-items: center; flex-direction: column;">
          <p style="padding: 3rem 40%; max-width: 100%; margin: 0 auto; text-align: center;">
            ${proDesc }
          </p>
          <div class="imgDetail">
          </div>
        </div>`
	$(`.tab1`).on('click', function(e){
	$('.tab3').children().remove();
	$('.pageination').children().first().remove();
	$('.tab3').siblings().eq(1).remove();
	console.log($('.tab3').siblings().eq(1))
	tab3.insertAdjacentHTML('afterbegin',con2);
	imgDetails();
});
}

//상품설명 리스트
function imgDetails(){
	fetch('prodDetailImg2.do?proCode='+ proCode, {
		method: "get"
		})
		.then(str => str.json())
		.then(res => {
			let imgd = '';
			console.log(res)
			res.forEach(rev => {
				console.log(rev)
                let im = `<img src="img/${rev.image}" alt="이미지 없음" style="margin: 1rem 0;">`;
                imgd += im; 
			})
			let sw= document.querySelector('.tab3 .homes');
			sw.insertAdjacentHTML('beforeend',imgd);
		})	
}

// 리뷰 버튼 이벤트
function btn2(){
	
$(`.tab2`).on('click', function(e){
	$('.tab3').empty();
	$('.tab3').siblings().eq(1).remove();
	console.log(tab3)
	e.stopPropagation()
	reviewList(pageInfo, proCode);
	tab3.insertAdjacentHTML('afterend',consts2());
});
}

//리뷰 목록 html
function makeLis(rev = {}) {
	let starssd = ``;
for(let i =1;i<=rev.reRate;i++){
	starssd += `<i class="fa fa-star ${i}s"></i>`;
}
const li = `<div class="11" style="padding: 2% 18%;height: 10rem; margin-bottom: 1rem;">
                  <div class="22" style="height: 4rem;">
                    <div class="33" style="float: left;width: 10rem;margin-right: 2rem; height: 10rem;">
                      <img src="img/${rev.reImage}" alt="이미지없음" style="height: 10rem; width: 10rem;"/>
                    </div>
                    <div class="stars">
                      <h4>${rev.reTitle}</h4>
                      ${starssd}
                    </div>
                  </div>
                  <p>
                    ${rev.reContent}
                  </p>
                  <button class="delPoint btn btn-danger" style="float: right;">삭제</button>
                </div>`
return li;
}

//페이징처리
function pagingList(result){
            paging.innerHTML = ''; 
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

//페이징 버튼
function pageList(e){
        e.preventDefault();
		pageInfo = this.getAttribute("href");
		$('.tab3').empty();
       	reviewList(pageInfo,proCode);
}

//리뷰 html
function consts2(){
	const con3 = `<!-- 리뷰페이지 번호 -->
            <div class="col-lg-6" style="padding: 0px 18%; margin-top: 5rem;">
              <div class="review_box">
                <h4>리뷰 쓰기</h4>
                <!-- 별점클릭 이벤트 -->
                <form id="reData">
                <fieldset>
                <legend>별점을 선택하세요</legend>
                <div class="listStar">
                   <input type="radio" id="1" name="reRate" value="1"/>
                   <label for="star1">1</label>
                   <input type="radio" id="2" name="reRate" value="2"/>
                   <label for="star2">2</label>
                   <input type="radio" id="3" name="reRate" value="3"/>
                   <label for="star3">3</label>
                   <input type="radio" id="4" name="reRate" value="4"/>
                   <label for="star4">4</label>
                   <input type="radio" id="5" name="reRate" value="5"/>
                   <label for="star5">5</label>
                </div>
                <!-- 별점클릭 이벤트 -->
                <!-- 리뷰 등록 ajax -->
                  <div class="col-md-12">
                  	<label for="reTitle">제목</label><br>
                	<input type="text" id="reTitle" name="reTitle">
                    <div class="form-group" style="margin: 1rem 0;">
                    <label for="reContent">내용</label>
                      <textarea class="form-control" name="reContent" rows="1" placeholder="Review"></textarea>
                    </div>
                	<input type="file" id="reImage" name="reImage">
                  </div>
                  <div class="col-md-12" style="text-align:center;">
                    <button type="button" class="btn_3" style="display :inline-block;">등록</button>
                  </div>
                  </fieldset>
                  </form>
                <!-- 리뷰 등록 -->
              </div>
            </div>`
        return con3;
}

//리뷰 등록
function addReview(proCode){
	$('.product_description_area').on('click','.btn_3',function(e){
		let reTitle = $(e.target).parent().siblings('.col-md-12').find('#reTitle').val();
		let reContent = $(e.target).parent().siblings('.col-md-12').find('.form-control').val();
		let reRate = $(e.target).parent().siblings('.listStar').find('input:checked').attr('id');
		
		//file은 이미지 원본 그대로 넘겨야함
		const formData = new FormData();
		//formData.append('text', userId);
		formData.append('proCode', proCode);
		formData.append('reTitle', reTitle);
		formData.append('reContent', reContent);
		formData.append('reRate', reRate);
		const fileField = document.querySelector('input[type="file"]');
		formData.append("reImage", fileField.files[0]);
		
		fetch('reviewAdd.do', {
		method: "post",
		body:formData
		})
		.then(str => str.json())
		.then(res => {
			console.log(res)	
			if(res.retCode == "OK"){
				$(e.target).parent().siblings('.col-md-12').find('#reTitle').val('');
				$(e.target).parent().siblings('.col-md-12').find('.form-control').val('');
				$(e.target).parent().siblings('.listStar').find('input:checked').prop("checked", false);
				alert('리뷰 1건 등록하셨습니다.');	
				$('.tab3').empty();
				reviewList(pageInfo, proCode);
			}else{
				alert('회원으로 구매하신 상품이 없습니다.');
			}
		})
		
	})
}

//리뷰삭제
function delLi(){
	$(".tab3").on("click",".delPoint",function(e){
		//console.log($(e.target).parent().find('i').length)
		//let reContent = $(e.target).parent().find('p').text();
		let reRate = $(e.target).parent().find('i').length;
		let reTitle = $(e.target).parent().find('h4').text();
		console.log($(e.target).parent().find('h4').text());
		//수정필요
		fetch('reviewDel.do?proCode='+ proCode + '&reRate='+ reRate + '&reTitle='+ encodeURI(reTitle,"UTF-8"), {
		method: "get"
		})
		.then(str => str.json())
		.then(res => {
			console.log(res)	
			if(res.retCode == "OK"){
				//$(e.target).parent().remove();
				alert('리뷰를 삭제하셨습니다.');	
				$('.tab3').empty();
				reviewList(pageInfo, proCode);
			}else{
				alert('해당 회원이 작성하신 리뷰가 아닙니다.');
			}
		})
	})
}


