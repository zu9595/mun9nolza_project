/**
 * 
 */

async function deleteFun(inqNo) {
	const promise = await fetch(`inquireDel.do?inqNo=${inqNo}`)
	const json = await promise.json();
	try{
		if(json.retCode == 'OK'){
			alert('삭제됨');	
			location.href="inquireListForm.do";				
		}else if(json.retCode == 'NG'){
			alert('삭제중 애러');
		}
	}catch(err){
		console.error('예외 => ',err);
	}
	// document.forms.myForm.action = "inquireDel.do";
	// document.forms.myForm.submit();
}