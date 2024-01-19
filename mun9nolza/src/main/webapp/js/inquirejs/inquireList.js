/**
 * 
 */
$(document).ready(function() {
	inquireList();
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
						<td><a href="inquireDetail.do?inqNo=${inqNo}">${inquire.inqTitle}</a></td>
						<td>${inquire.userId}</td>
						<td>${dateFormat(date)}</td>
						<td><button type="button" class="delete" style="border: none; background:none">삭제</button></td>
					</tr>`
				} else {
					tr = `<tr class="del">
						<td>${inquire.inqNo}</td>
						<td><a href="inquireDetail.do?inqNo=${inquire.inqNo}">${inquire.inqTitle}</a></td>
						<td>${inquire.userId}</td>
						<td>${dateFormat(date)}</td>
						<td></td>
					</tr>`
				}
				$('#inquireList').append(tr);
			})

			$('.delete').on('click', function(e) {
				console.log($(e.target).parent().siblings('#inqNo').text());
				let inqNo = $(e.target).parent().siblings('#inqNo').text();
				delInq(inqNo);
			})


		}).catch(console.error);
}

async function delInq(inqNo) {
	const promise = await fetch(`inquireDel.do?inqNo=${inqNo}`)
	const json = await promise.json();
	try{
		if(json.retCode == 'OK'){
			alert('삭제됨');
			$('.del').remove();
			inquireList();
						
		}else if(json.retCode == 'NG'){
			alert('삭제중 애러');
		}
	}catch(err){
		console.error('예외 => ',err);
	}
}

function dateFormat(date) {
	let month = date.getMonth() + 1;
	let day = date.getDate();

	month = month >= 10 ? month : '0' + month;
	day = day >= 10 ? day : '0' + day;

	return date.getFullYear() + '-' + month + '-' + day;
}