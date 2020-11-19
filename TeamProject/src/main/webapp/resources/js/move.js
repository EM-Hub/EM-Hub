/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//화면 이동 시 애니메이션
	$("body").css("display", "none");
	$("body").fadeIn(300);
	$("a.transition").click(function(event){
		event.preventDefault();
		linkLocation = this.href;
		$("body").fadeOut(300, redirectPage);
	});
	
	function redirectPage() {
	window.location = linkLocation;
	}
	//화면 이동시 슬라이드div
	$('#mainE').css('height',$(scroll).height());
	$('#mainE').css("margin-left","0");
	$('#mainE').animate({'opacity':'0.9','margin-left':'0px'}, 500);
	$(function(){
		setTimeout(function(){
			$('#mainE').animate({
				'left':'110%'
			}, 500);
		});
	});
	//슬라이드 밑 div
	$('#mainF').css('height',$(scroll).height());
	$('#mainF').animate({'opacity':'0.9','margin-left':'0px'},500);
	$(function(){
		setTimeout(function(){
			$('#mainF').animate({
				'right':'110%'
			}, 500);
		});
	});
	
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
	
	//숨은 div 나타내기
	$(window).scroll( function(){
        $('.fadeinleft').each( function(i){
            
            var bottom_of_element = $(this).offset().top + $(this).outerHeight();
            var bottom_of_window = $(window).scrollTop() + $(window).height();
            
            if( bottom_of_window > bottom_of_element ){
                $(this).animate({'opacity':'1','margin-left':'0px'},1000);
            }
            
        }); 
    });
	
});

/* 함수선언 영역*/
(function($){
	
})(jQuery);