/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//수강취소
	$(document).on('click', '#deleteTT', function() {
		var lecTtCode = $(this).parent().parent().children(':first').text();
		
		var isConfirm = confirm('선택과목을 수강취소 하시겠습니까');
		if(isConfirm){
			location.href = 'deleteStuTT.do?lecTtCode=' + lecTtCode;
		}
		else{
			return;
		}
	});
});

/* 함수선언 영역*/
(function($){
})(jQuery);