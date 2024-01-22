/**
 * 
 */
let pageInfo = 1;
let paging = document.querySelector('.pageination');
let inquires = document.querySelector('.inquireList');

function showList(page) {
	fetch('inquirePagingList.do?page=' + page)
		.then(str => str.json())
		.then(result => {
			console.log("ajax 호출");
			console.log(result);
			$("#inquireList").empty(); // 페이지 번호 클래스의 형제 태그들을 지우는 구문
			$(".pageination").empty();
			result.list.forEach(inquire => {
				console.log(inquire);
				let date = new Date(inquire.inqDate);
				let tr = ``;

				tr = `<tr>
						<td id="inqNo">${inquire.inqNo}</td>
						<td><a href="inquireDetail.do?inqNo=${inquire.inqNo}">${inquire.inqTitle}</a></td>
						<td>${inquire.userId}</td>
						<td>${dateFormat(date)}</td>
					</tr>`

				$('#inquireList').append(tr);
			})
				pagingList(result);
		})
}// end of showList.

function pagingList(result) {
	console.log(result);
	let ul = document.createElement('ul');
	ul.className = 'pagination justify-content-center';
	paging.appendChild(ul);
	//이전.
	if (result.pageDTO.prev) {
		let li = document.createElement('li');
		li.className = "page-item";
		let aTag = document.createElement('a');
		aTag.className = "page-link";
		aTag.href = result.pageDTO.startPage - 1;
		let iTag = document.createElement('i');
		iTag.className = "ti-angle-double-left";
		aTag.addEventListener('click', pageList);
		ul.appendChild(li);
		li.appendChild(aTag);
		aTag.appendChild(iTag);
	}
	for (let p = result.pageDTO.startPage; p <= result.pageDTO.lastPage; p++) {
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
	if (result.pageDTO.next) {
		let li = document.createElement('li');
		li.className = "page-item";
		let aTag = document.createElement('a');
		aTag.className = "page-link";
		aTag.href = result.pageDTO.lastPage + 1;
		let iTag = document.createElement('i');
		iTag.className = "ti-angle-double-right";
		aTag.addEventListener('click', pageList);
		ul.appendChild(li);
		li.appendChild(aTag);
		aTag.appendChild(iTag);
	}
}

function pageList(e) {
	e.preventDefault();
	pageInfo = this.getAttribute("href");
	showList(pageInfo);
}

$(document).ready(function() {
	//inquireList();
	showList(pageInfo);
});

function inquireList() {
	fetch("inquireList.do", {
		method: "get",
		headers: {
			"Content-Type": "application/json"
		}
	})
		.then(res => res.json())
		.then(res => {
			console.log(res);

			$(res).each((idx, inquire) => {
				let date = new Date(inquire.inqDate);
				let tr = ``;
				console.log(inquire.userId, userId);
				if (userId == inquire.userId) {
					tr = `<tr class="del">
						<td id="inqNo">${inquire.inqNo}</td>
						<td><a href="inquireDetail.do?inqNo=${inquire.inqNo}">${inquire.inqTitle}</a></td>
						<td>${inquire.userId}</td>
						<td>${dateFormat(date)}</td>
					</tr>`
				} else {
					tr = `<tr class="del">
						<td>${inquire.inqNo}</td>
						<td><a href="inquireDetail.do?inqNo=${inquire.inqNo}">${inquire.inqTitle}</a></td>
						<td>${inquire.userId}</td>
						<td>${dateFormat(date)}</td>
					</tr>`
				}
				$('#inquireList').append(tr);
			})

		}).catch(console.error);
}

function dateFormat(date) {
	let month = date.getMonth() + 1;
	let day = date.getDate();

	month = month >= 10 ? month : '0' + month;
	day = day >= 10 ? day : '0' + day;

	return date.getFullYear() + '-' + month + '-' + day;
}