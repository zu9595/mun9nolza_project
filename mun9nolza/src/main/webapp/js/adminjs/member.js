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

				let tr = $('<tr />').append($('<td />').text(member.userId),
					$('<td />').text(member.userPw),
					$('<td />').text(member.userName)
				);
				$('#list').append(tr);
			})
        })
        .catch(console.error);
};
