/**
 * 
 */

$(document).ready(function(){
	productList();
	
} );
 
 
 //수정필요
function productList() {
    fetch("adminProductList.do", {
        method: "get",
        headers: { "Content-Type": "application/json" }
    })
        .then(res => res.json())
        .then(res => {
            console.log(res);
            $(res).each((idx, member) => {
				// tr생성. td생성

				let tr = $('<tr />').addClass('del').append($('<td />').attr('id','id').text(member.userId),
					$('<td />').attr('id','pw').text(member.userPw),
					$('<td />').text(member.userName),
					$('<td />').append($('<button />').addClass('delete').text('삭제'))
				);
				$('#list').append(tr);
			})
				$('.delete').on('click', function(e){
					memberDel($(e.target).parent().prevAll('#id').text(),$(e.target).parent().prevAll('#pw').text());
					console.log($(e.target).parent().prevAll('#id').text())
				});
        })
        .catch(console.error);
};