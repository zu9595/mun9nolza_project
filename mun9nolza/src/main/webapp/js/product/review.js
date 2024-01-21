/**
 * 
 */
let pageInfo = 1;
let tab1 = document.querySelector(`.tab1`);
let tab2 = document.querySelector(`.tab2`);
let tab3 = document.querySelector(`.tab3`);
let paging = document.querySelector('.pageination');
reviewList(pageInfo, proCode);
btn1();
btn2();
addReview();
function reviewList(page, proCode){
	fetch('reviewList.do?page='+ page +'&proCode='+ proCode)
		.then(str => str.json())
		.then(result => {
            let ul = ``;
            
			result.list.forEach(rev => {
				console.log(rev)
                let li = makeLis(rev);
                ul += li; 
			})
            tab3.insertAdjacentHTML('afterbegin',ul);
            tab3.insertAdjacentHTML('afterend',consts2());
            pagingList(result);
            
		})
		.catch(reject => console.log(reject));
}


function btn1(){
	const con2 = `<div class="homes" id="home" >
          <p>
            ${proDesc }
          </p>
        </div>`
	$(`.tab1`).on('click', function(e){
	$('.tab3').children().remove();
	$('.pageination').children().first().remove();
	$('.tab3').siblings().eq(1).remove();
	console.log($('.tab3').siblings().eq(2))
	tab3.insertAdjacentHTML('afterbegin',con2);
});
}

function btn2(){
	
$(`.tab2`).on('click', function(e){
	$('.tab3').children().remove();
	reviewList(pageInfo, proCode);
});
}

function makeLis(rev = {}) {
	let starssd = ``;
for(let i =1;i<=rev.reRate;i++){
	starssd += `<i class="fa fa-star ${i}s"></i>`;
}
const li = `<div class="11">
                  <div class="22">
                    <div class="33">
                      <img src="${rev.reImage}" alt="이미지없음" />
                    </div>
                    <div class="stars">
                      <h4>${rev.reTitle}</h4>
                      ${starssd}
                    </div>
                  </div>
                  <p>
                    ${rev.reContent}
                  </p>
                </div>`
return li;
}

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

function pageList(e){
        e.preventDefault();
		pageInfo = this.getAttribute("href");
       	reviewList(pageInfo,proCode);
}

function consts2(){
	const con3 = `<!-- 리뷰페이지 번호 -->
            <div class="col-lg-6">
              <div class="review_box">
                <h4>리뷰 쓰기</h4>
                <!-- 별점클릭 이벤트 -->
                <p>별점:</p>
                <ul class="listStar">
                  <li>
                    <a href="#" class="fa fa-star 1">
                    </a>
                  </li>
                  <li>
                    <a href="#" class="fa fa-star 2">
                    </a>
                  </li>
                  <li>
                    <a href="#" class="fa fa-star 3">
                    </a>
                  </li>
                  <li>
                    <a href="#" class="fa fa-star 4">
                    </a>
                  </li>
                  <li>
                    <a href="#" class="fa fa-star 5">
                    </a>
                  </li>
                </ul>
                <!-- 별점클릭 이벤트 -->
                <!-- 리뷰 등록 ajax -->
                <form class="row contact_form" action="contact_process.php" method="post" novalidate="novalidate" enctype="multipart/form-data">
                  <div class="col-md-12">
                  	<label for="reTitle">제목</label>
                	<input type="text" id="reTitle" name="reTitle">
                    <div class="form-group">
                      <textarea class="form-control" name="message" rows="1" placeholder="Review"></textarea>
                    </div>
                	<input type="file" id="reImage" name="reImage">
                  </div>
                  <div class="col-md-12 text-right">
                    <button type="submit" value="submit" class="btn_3">
                      등록
                    </button>
                  </div>
                </form>
                <!-- 리뷰 등록 -->
              </div>
            </div>`
        return con3;
}

function addReview(){
	$('.product_description_area').on('click','.btn_3',function(e){
		console.log(e.target)
		//reContent
		//reRate
		//reImage
		fetch('reviewAdd.do',{
		method: "post",
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: 'userId='+ userId +'&proCode='+ proCode + '&reContent='+ reContent + '&reRate='+ reRate + '&reImage='+ reImage
		})
		.then(str => str.json())
		.then(result => {
			console.log(result)
		})
	})
}






