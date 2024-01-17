/**
 * 
 */

/*$(document).ready(function(){
	productAdd();
	
} );*/
 
function productAdd(proCode,proName,proDesc,proImage,proPrice,proDiscount,proSell,proStock,category) {
    fetch("productMod.do", {
        method: "post",
        headers: { 'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: 'proCode='+proCode+'proName='+proName+'proDesc='+proDesc+'proImage='+proImage+'proPrice='+proPrice+'proDiscount='+proDiscount+'proSell='+proSell+'proStock='+proStock+'category='+category
    })
        .then(res => res.json())
        .then(res => {
            console.log(res);
            try{
				if(res.retCode == 'OK'){
				alert('수정됨');
						
			}else if(res.retCode == 'NG'){
				alert('수정중 애러');
			}
			}catch(err){
				console.error('예외 => ',err);
			}
         	})
    
    /*const json = await promise.json();
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
	}*/
};

