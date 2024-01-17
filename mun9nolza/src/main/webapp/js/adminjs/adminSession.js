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


