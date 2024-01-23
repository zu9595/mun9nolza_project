/**
 * joinMember.js
 */

let checkId = false; //아이디유효성
let checkPw = false; //비밀번호
let checkPw2 = false; //비밀번호확인

window.addEventListener('DOMContentLoaded', event => {


document.querySelector('form').addEventListener('submit', function(e) {
		let id = document.querySelector('#id');
		let pw = document.querySelector('#pw');
		let pwCheck = document.querySelector('#pwCheck');
		let name = document.querySelector('#name');
		let phone = document.querySelector('#phone');

		if (id.value == '') {
			alert('아이디를 입력하세요');
			e.preventDefault();
			id.focus();
			return false;
		}
		if(checkOk == false){
			alert('사용불가한 아이디입니다');
			e.preventDefault();
			id.focus();
			return false;
		}
		
		if (pw.value == '') {
			alert('비밀번호를 입력하세요');
			e.preventDefault();
			pw.focus();
			return false;
		}
		if(checkPw == false){
			alert('사용불가한 비밀번호입니다');
			e.preventDefault();
			pw.focus();
			return false;
		}
		
		if (pwCheck.value == '') {
			alert('비밀번호를 확인하세요');
			e.preventDefault();
			pwCheck.focus();
			return false;
		}
		if(checkPw2 == false){
			alert('비밀번호가 일치하지 않습니다');
			e.preventDefault();
			pwCheck.focus();
			return false;
		}
		
		if (name.value == '') {
			alert('이름을 입력하세요');
			e.preventDefault();
			name.focus();
			return false;
		}
		if (phone.value == '') {
			alert('전화번호를 입력하세요');
			e.preventDefault();
			phone.focus();
			return false;
		}
		
		
		
	})



	//id중복체크(ajax)
	let ok = document.getElementById('id_ok');
	let no = document.getElementById('id_no');
	let lenmsg = document.getElementById('id_length');

	document.querySelector('#id').addEventListener('input', function() {
		let userId = document.querySelector('#id').value
		
		checkOk = false;
		
		fetch("joinIdJson.do", {
			method: "post",
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'userId=' + userId
		})
			.then(str => str.json())
			.then(result => {
				console.log(result);

				if (userId.length < 5) {
					lenmsg.style.display = 'block';
				} else {
					lenmsg.style.display = 'none';
				}


				if (result.res != 1 && userId.length >= 5) { //사용가능
					ok.style.display = 'block';
					no.style.display = 'none';
					checkOk = true;
					
				} else if (result.res == 1 && userId.length >= 5) { //중복
					no.style.display = 'block';
					ok.style.display = 'none';
				} else if (result.res == '') {
					ok.style.display = 'none';
					no.style.display = 'none';
				}
			})
			.catch(err => alert('오류 발생'));

	})



	//비밀번호 6자리 이하시 문구
	let pw = document.getElementById('pw'); //input 비번
	let check = document.getElementById('pwcheck'); //알림문구

	pw.addEventListener('input', function() {
		if (pw.value.length >= 6) {
			check.style.display = 'none';
			checkPw = true;
		} else if (pw.value.length < 6) {
			check.style.display = 'block';

		}
	});


	/*pw.addEventListener('input', function() {
		if (pw.value.length < 6) {
			check.style.display = 'block';
		} else if (pw.value.length >= 6) {
			check.style.display = 'none';
			
			checkPw = true;
		}
	});*/

	//비밀번호 일치 확인
	let pwCheck = document.getElementById('pwCheck'); //input 비번확인 (+이벤트
	let check2 = document.getElementById('pwcheck2'); //알림문구

	pwCheck.addEventListener('input', function() {
		if (pw.value != pwCheck.value) {
			check2.style.display = 'block';
		} else {
			check2.style.display = 'none';
			
			checkPw2 = true;
		}
	})
	
	











}); //end of DOMLoaded.   