/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//logout
	$(document).on('click', '.logout', function() {
		var isConfirm = confirm('정말 로그아웃 하시겠습니까?');
		if(isConfirm){
			location.href = 'logout.do';
		}
		else{
			return;
		}
	});
});

/* 함수선언 영역*/
(function($){

})(jQuery);