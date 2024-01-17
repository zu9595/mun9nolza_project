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

				let tr = `<tr class="del">
				<td>${member.proCode}</td>
				<td><input type="text" value="${member.proName}"></td>
				<td><input type="text" value="${member.proDesc}"></td>
				<td><input type="text" value="${member.proImage}"></td>
				<td><input type="text" value="${member.proPrice}"></td>
				<td><input type="text" value="${member.proDiscount}"></td>
				<td><input type="text" value="${member.proSell}"></td>
				<td><input type="text" value="${member.proStock}"></td>
				<td><input type="text" value="${member.category}"></td>
				<td><button class="modify">수정</button></td>
				<td><button class="delete">삭제</button></td>
			</tr>`
				$('#list').append(tr);
			})
				$('.delete').on('click', function(e){
					let target = $(e.target).parent().parent();
					productDel(target.eq(0).children().eq(0).text());
					console.log(target.first().text())
				});
				
				$('.modify').on('click', function(e){
					let target = $(e.target).parent().parent();
					productMod(target.eq(0).children().eq(0).text(),target.children().eq(1).children().val(),target.children().eq(2).children().val(),target.children().eq(3).children().val(),target.children().eq(4).children().val(),target.children().eq(5).children().val(),target.children().eq(6).children().val(),target.children().eq(7).children().val(),target.children().eq(8).children().val());
					console.log(target.eq(0).children().eq(1).children().val())
					console.log(target.children())
				});
        })
        .catch(console.error);
};

async function productDel(proCode) {
    const promise = await fetch("productDel.do?proCode=" + proCode)
    const json = await promise.json();
    try{
		if(json.retCode == 'OK'){
			alert('삭제됨');
			$('.del').remove();
			productList();
						
		}else if(json.retCode == 'NG'){
			alert('삭제중 애러');
		}
	}catch(err){
		console.error('예외 => ',err);
	}
};

async function productMod(proCode,proName,proDesc,proImage,proPrice,proDiscount,proSell,proStock,category) {
    const promise = await fetch("productMod.do?proCode=" + proCode + "&proName=" + proName+ "&proDesc=" + proDesc+ "&proImage=" + proImage+ "&proPrice=" + proPrice+ "&proDiscount=" + proDiscount+ "&proSell=" + proSell+ "&proStock=" + proStock+ "&category=" + category)
    const json = await promise.json();
    try{
		if(json.retCode == 'OK'){
			alert('수정됨');
			$('.del').remove();
			productList();
						
		}else if(json.retCode == 'NG'){
			alert('수정중 애러');
		}
	}catch(err){
		console.error('예외 => ',err);
	}
};

