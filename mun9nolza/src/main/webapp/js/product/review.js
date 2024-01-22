/**
 * 
 */
let pageInfo = 1;
let tab1 = document.querySelector(`.tab1`);
let tab2 = document.querySelector(`.tab2`);
let tab3 = document.querySelector(`.tab3`);
let paging = document.querySelector('.pageination');
let star = 0;

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
            console.log(result)
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
                <form method="post" enctype="multipart/form-data">
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
                  	<label for="reTitle">제목</label>
                	<input type="text" id="reTitle" name="reTitle">
                    <div class="form-group">
                      <textarea class="form-control" name="reContent" rows="1" placeholder="Review"></textarea>
                    </div>
                	<input type="file" id="reImage" name="reImage">
                  </div>
                  <div class="col-md-12" style="text-align:center;">
                    <button class="btn_3" style="display :inline-block;">등록</button>
                  </div>
                  </fieldset>
                <!-- 리뷰 등록 -->
                </form>
              </div>
            </div>`
        return con3;
}

function addReview(){
	$('.product_description_area').on('change','.btn_3',function(e){
		let imageN = $(e.target).parent().siblings('.col-md-12').find('#reImage').val().split("\\")
		console.log(imageN[imageN.length-1])
		
		let reTitle = $(e.target).parent().siblings('.col-md-12').find('#reTitle').val();
		let reContent = $(e.target).parent().siblings('.col-md-12').find('.form-control').val();
		let reRate = $(e.target).parent().siblings('.listStar').find('input:checked').attr('id');
		let reImage = imageN[imageN.length-1];
		
		const formData = new FormData();
		formData.append("userId", userId);
		formData.append("proCode", proCode);
		formData.append("reTitle", reTitle);
		formData.append("reContent", reContent);
		formData.append("reRate", reRate);
		formData.append("reImage", reImage);
		
		fetch('reviewAdd.do', {
		method: "POST",
		headers: {
			'Content-Type': 'multipart/form-data'
		},
		body: formData
	})
		.then(str => str.json())
		.then(result => {
			console.log(result);
		})
	})
}






