/**
 * 
 */

// Find Id Script
function resetIdInfo() {
	$('.modal-body').empty();
	$('.modal-footer').empty();
	let modal_body = `<form method = "POST" >
								<label style="margin-right: 16px;">이름</label> <input type="text" name="userName"
									class="btn-name mname" placeholder="등록한 이름" required> <br> <label>이메일</label> <input
									type="text" name="email" class="btn-email memail" placeholder="등록한 이메일 입력" required>
							</form>`;
	let modal_footer = `<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="button" class="btn btn-primary" data-toggle="modal" onclick="resultIdModal()">찾기</button>`;
	$('.modal-body').append(modal_body);
	$('.modal-footer').append(modal_footer);
}

function resultIdModal() {
	let mname = $('.mname').val();
	let memail = $('.memail').val();
	// console.log(mname);
	// console.log(memail);
	fetch("findId.do", {
		method: "post",
		headers: {
			// "Content-Type": "application/json",
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: "userName=" + mname + "&email=" + memail
	})
		.then(res => res.json())
		.then(res => {
			console.log(res);
			$('.modal-body').empty();
			$('.modal-footer').empty();
			let fid = res;
			let result_mbody = `<form name="idsearch" method="post">
								<div class="container">`;
			if (fid != null) {
				result_mbody +=
					`<div class="found-success">
									<h4>회원님의 아이디는 "${fid}" 입니다</h4>
								</div>`;
				let result_mfooter =
					`<div class="found-login">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">로그인</button>
								</div>`;
				$('.modal-body').append(result_mbody);
				$('.modal-footer').append(result_mfooter);
			} else {
				result_mbody +=
					`<div class="found-fail">
										<h4>등록된 정보가 없습니다</h4>
									</div>`;
				let result_mfooter =
					`<div class="found-login" >
										<input type="button" class="btn btn-primary" id="btnback" value="다시 찾기"
											onClick="resetIdInfo()" /> <input type="button" id="btnjoin"
											value="회원가입" class="btn btn-primary" onClick="location.href='addMemberForm.do'" />
									</div >`;
				$('.modal-body').append(result_mbody);
				$('.modal-footer').append(result_mfooter);
			}
			$('.modal-body').append(`</div></form >`);
		}).catch(console.error);
}


// Find Pw Script
function resetPwInfo() {
	$('#modal_findpw .modal-body').empty();
	$('#modal_findpw .modal-footer').empty();
	let modal_body = `<form method = "POST" >
							<label style="margin-right: 16px;">아이디</label> <input type="text" name="userId"
								class="btn-name pmid" placeholder="등록한 아이디" required> <br>
							<label style="margin-right: 16px;">이름</label> <input type="text" name="userName"
								class="btn-name pmname" placeholder="등록한 이름" required> <br> <label>이메일</label> <input
								type="text" name="email" class="btn-email pmemail" placeholder="등록한 이메일 입력" required>
						</form>`;
	let modal_footer = `<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="button" class="btn btn-primary" data-toggle="modal" onclick="resultPwModal()">찾기</button>`;
	$('#modal_findpw .modal-body').append(modal_body);
	$('#modal_findpw .modal-footer').append(modal_footer);
}

function resultPwModal() {
	let pmid = $('#modal_findpw .pmid').val();
	let pmname = $('#modal_findpw .pmname').val();
	let pmemail = $('#modal_findpw .pmemail').val();
	console.log(pmid);
	console.log(pmname);
	console.log(pmemail);
	fetch("findPw.do", {
		method: "post",
		headers: {
			// "Content-Type": "application/json",
			'Content-Type': 'application/x-www-form-urlencoded',
		},
		body: "userId=" + pmid + "&userName=" + pmname + "&email=" + pmemail
	})
		.then(res => res.json())
		.then(res => {
			console.log(res);
			$('#modal_findpw .modal-body').empty();
			$('#modal_findpw .modal-footer').empty();
			let fpw = res;
			let result_mbody = `<form name="pwsearch" method="post">
								<div class="container">`;
			if (fpw != null) {
				result_mbody +=
					`<div class="found-success">
									<h4>회원님의 비밀번호는 "${fpw}" 입니다</h4>
								</div>`;
				let result_mfooter =
					`<div class="found-login">
									<button type="button" class="btn btn-primary" data-dismiss="modal">로그인</button>
								</div>`;
				$('#modal_findpw .modal-body').append(result_mbody);
				$('#modal_findpw .modal-footer').append(result_mfooter);
			} else {
				result_mbody +=
					`<div class="found-fail">
										<h4>등록된 정보가 없습니다</h4>
									</div>`;
				let result_mfooter =
					`<div class="found-login" >
										<input type="button" id="btnback" class="btn btn-primary" value="다시 찾기"
											onClick="resetPwInfo()" />
									</div >`;
				$('#modal_findpw .modal-body').append(result_mbody);
				$('#modal_findpw .modal-footer').append(result_mfooter);
			}
			$('#modal_findpw .modal-body').append(`</div></form >`);
		}).catch(console.error);
}