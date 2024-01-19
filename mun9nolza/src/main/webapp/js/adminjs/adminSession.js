/**
 * 
 */
function listView(userId){
    let f = document.createElement('form');
    
    let obj;
    obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'userId');
    obj.setAttribute('value', userId);
    
    f.appendChild(obj);
    f.setAttribute('method', 'post');
    f.setAttribute('action', 'adminForm.do');
    document.body.appendChild(f);
    f.submit();
}

function cartNumbering(userId){
	//$(`.main_menu .cart i:after`)
	
	fetch("myOrderList.do", {
		method: "post",
		headers: { 'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: "userId=" + userId
	})
	.then(str => str.json())
	.then(res => {
		if(res){
			console.log(res)
			//$(`.main_menu .cart i:after`).css("content")
		}
	})
}


