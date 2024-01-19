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
						<td>${inquire.inqNo}</td>
						<td>${inquire.inqTitle}</td>
						<td>${inquire.userId}</td>
						<td>${dateFormat(date)}</td>
						<td><a class="delete">삭제</a></td>
					</tr>`
				} else {
					tr = `<tr class="del">
						<td>${inquire.inqNo}</td>
						<td>${inquire.inqTitle}</td>
						<td>${inquire.userId}</td>
						<td>${dateFormat(date)}</td>
						<td></td>
					</tr>`
				}

				$('#inquireList').append(tr);
			})
			$('.delete').on('click', function() {
				delInq();
			})

		}).catch(console.error);
}

function delInq(){
	console.log(this);
}

function dateFormat(date) {
	let month = date.getMonth() + 1;
	let day = date.getDate();

	month = month >= 10 ? month : '0' + month;
	day = day >= 10 ? day : '0' + day;

	return date.getFullYear() + '-' + month + '-' + day;
}