/**
 * 
 */
const urlParams = new URL(location.href).searchParams;
const userId = urlParams.get('userId');

$(document).ready(function(){
	memberList();
	
} );

function memberList() {
    fetch("memberList.do", {
        method: "get",
        headers: { "Content-Type": "application/json" }
    })
        .then(res => res.json())
        .then(res => {
            console.log(res);
            $(res).each((idx, member) => {
				console.log(member)
				// tr생성. td생성
				let tr = '';
				if(member.status == 'admin'){
					tr = $('<tr />').addClass('del').append($('<td />').attr('id','id').text(member.userId),
						$('<td />').attr('id','pw').text(member.userPw),
						$('<td />').text(member.userName),
						$('<td />')
						);
				}else{
					tr = $('<tr />').addClass('del').append($('<td />').attr('id','id').text(member.userId),
						$('<td />').attr('id','pw').text(member.userPw),
						$('<td />').text(member.userName),
						$('<td />').append($('<button />').addClass('delete').text('삭제'))
						);
				}
				
				$('#list').append(tr);
			})
				$('.delete').on('click', function(e){
					memberDel($(e.target).parent().prevAll('#id').text(),$(e.target).parent().prevAll('#pw').text());
					console.log($(e.target).parent().prevAll('#id').text())
				});
        })
        .catch(console.error);
};

async function memberDel(userId, userPw) {
    const promise = await fetch("memberDel.do?userId=" + userId + "&userPw="+userPw)
    const json = await promise.json();
    try{
		if(json.retCode == 'OK'){
			alert('삭제됨');
			$('.del').remove();
			memberList();
						
		}else if(json.retCode == 'NG'){
			alert('삭제불가');
		}
	}catch(err){
		console.error('예외 => ',err);
	}
};

