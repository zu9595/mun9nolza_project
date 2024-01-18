/**
 * joinMember.js
 */
 
 window.addEventListener('DOMContentLoaded', event => {  
	 
	 
    //input이벤트로 비밀번호 8자리 이하시 문구 뜨도록
    let pw = document.getElementById('pw');
    let check =  document.getElementById('check');
    pw.addEventListener('input', function(){
        if(pw.value.length < 8){
         check.style.display = 'block';
        }else if(pw.value.length >= 8) {
			check.style.display = 'none';
		}
    });

     document.querySelector('form').addEventListener('submit', function(e){
      let id = document.querySelector('#id').value;
      let pw = document.querySelector('#pw').value;
      if(id == '' || pw == ''){
        alert('아이디/비밀번호를 입력하세요');
        e.preventDefault(); //폼전송 막기 --콜백함수에 e 파라미터 추가하고
      }else if(pw.length < 8){
        e.preventDefault();
      }
    });
  
  
    
}); //end of DOMLoaded.   