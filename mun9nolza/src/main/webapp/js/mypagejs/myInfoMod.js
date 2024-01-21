/**
 * myInfoMod.js
 */
console.log('이거')
window.addEventListener('DOMContentLoaded', event => { 
	  
	  
	//input이벤트로 비밀번호 8자리 이하시 문구 뜨도록
    let pw = document.getElementById('pw');
    let check =  document.getElementById('check');
    pw.addEventListener('input', function() {
		if (pw.value.length < 6) {
			check.style.display = 'block';
		} else if (pw.value.length >= 6) {
			check.style.display = 'none';
		}
	});
	  

	
	
	/* 회원탈퇴 */
	
	//모달
	document.querySelector('#delinfo').addEventListener('click', function(){
		document.querySelector('.delmodal').classList.add('show');
	})

    document.querySelector('.close').addEventListener('click', function(){
		document.querySelector('.delmodal').classList.remove('show');
	})
	
	//비번----확인
	document.getElementById('clear').addEventListener('click', function(){
		let pw = document.getElementById('lastpw');
		if(pw.value == "") {
			alert("비밀번호를 입력해 주세요");
			pw.focus();
			return false;
		}
	})
	
	
	
	
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
}); //end of DOMLoaded.   