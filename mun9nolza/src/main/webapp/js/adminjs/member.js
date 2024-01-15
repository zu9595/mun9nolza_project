/**
 * 
 */
$(document).ready(memberList);



function memberList() {
    fetch("memberList.do", {
        method: "get",
        headers: { "Content-Type": "application/json" }
    })
        .then(res => res.json())
        .then(res => {
            console.log(res);
            $(res).each((idx, member) => {
				// tr생성. td생성

				let tr = $('<tr />').addClass('del').append($('<td />').text(member.userId),
					$('<td />').text(member.userPw),
					$('<td />').text(member.userName),
					$('<td />').append($('<button />').attr('id', 'delete').text('삭제'))
				);
				$('#list').append(tr);
			})
        })
        .catch(console.error);
};

function memberDel(userId, userPw) {
    const promise = fetch("memberDel.do?userId=" + userId + "&userPw="+userPw)
    const json = promise.json();
    try{
		if(json.retCode == 'OK'){
			alert('삭제됨');
			memberList();
						
		}else if(json.retCode == 'NG'){
			alert('삭제중 애러');
		}
	}catch(err){
		console.error('예외 => ',err);
	}
};

