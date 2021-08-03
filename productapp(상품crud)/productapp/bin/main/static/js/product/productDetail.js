/**
 * 
 */
 'use strict';
 
 
 const $delBtn = document.getElementById('delBtn');
 	$delBtn.addEventListener('click',e=>{
	if(confirm("삭제하시겟습니까?")){
	const pid = e.target.dataset.pid;
		location.href=`/product/${pid}/del`;
	}
	return false;
});