/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	var category = $('#boardCategory').val();
	
	var sideDetailNum11 = $('#d1').val();
	
	var mainNum11 = $('#m1').val();
	
	var sideNum11 = $('#s1').val();
	
	$(document).on('click', '#board1', function() {
		location.href = "writeForm.do?categoryNum="+category+"&mainNum="+mainNum11+"&sideNum="+sideNum11+"&sideDetailNum="+sideDetailNum11;
	});
	
	$(document).on('click', '#board2', function() {
		location.href = "writeForm.do?categoryNum="+category+"&mainNum="+mainNum11+"&sideNum="+sideNum11+"&sideDetailNum="+sideDetailNum11;
	});
	
	$(document).on('click', '#board3', function() {
		location.href = "writeForm.do?categoryNum="+category+"&mainNum="+mainNum11+"&sideNum="+sideNum11+"&sideDetailNum="+sideDetailNum11;
	});
	
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	//aaa = function(){
	
	//};
})(jQuery);