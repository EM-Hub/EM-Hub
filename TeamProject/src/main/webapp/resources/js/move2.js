/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//top, down 버튼
	$("#upBtn").click(function() {
        $('html, body').animate({
            scrollTop : 0
        }, 400);
        return false;
    });
	
	$("#downBtn").click(function() {
        $('html, body').animate({
            scrollTop : $(document).height()
        }, 400);
        return false;
    });
	
});

/* 함수선언 영역*/
(function($){
	
})(jQuery);