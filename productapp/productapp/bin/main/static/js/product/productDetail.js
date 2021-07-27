/**
 * 
 */
 'use strict';
 
 
 const $delBtn = document.getElementById('delBtn');
 	$delBtn.addEventListener('click',e=>{
	if(confirm("삭제하시겟습니까?")){
		location.href='/product/productList.html';
	}
	return false;
});