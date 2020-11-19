/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//클릭 이벤트
	
	$(document).on('click', '.aa', function() {
		var lecCode = $(this).closest('tr').find('.lecCode').text();
		
		location.href = "updateLec.do?mainNum="+9+"&sideNum="+28+"&lecCode="+lecCode;
	});
});

/* 함수선언 영역*/
(function($){
	
	
	
})(jQuery);