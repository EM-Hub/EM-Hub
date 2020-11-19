/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//수강신청
	$(document).on('click', '#enrolmentBtn', function() {
		var lecTtCode = [];
		$('.lecTtCode').each(function(index, element){
			lecTtCode[index] = $(this).text();
		});
		var isConfirm = confirm('수강신청 하시겠습니까');
		if(isConfirm){
			location.href = 'insertStuTT.do?lecTtCode=' + lecTtCode;
			alert('신청되었습니다.');
		}
		else{
			return;
		}
	});
});

/* 함수선언 영역*/
(function($){
})(jQuery);