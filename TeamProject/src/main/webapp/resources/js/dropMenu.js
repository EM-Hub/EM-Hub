/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	//메뉴바 내려오는 효과
	$(function(){
		var $firstMenu = $('nav > ul > li'),
				$header = $('#header');
				$headerHeight = $header.outerHeight();			
		$firstMenu.mouseenter(function(){
		var setMenu = $(this);
		var subHeight =	setMenu.find('ul').outerHeight();
		$header.stop().animate({height: $headerHeight + subHeight + 'px'},300);
		
		//시간설정 setTimeout ??  할일 						시간
		setTimeout(function(){setMenu.find('ul').show();},5); //시간 3초
		 
			
		})
		.mouseleave(function(){
				$header.stop().animate({height: $headerHeight +'px'},300);	
				$(this).find('ul').hide();
			
		})
	
		$(document).on('mouseenter', '.mainLi', function() {
			var mainNum = $(this).attr('data-mainNum');
			var sideUl = $(this).find('.sideUl');
			dropSideMenu(mainNum, sideUl);
			
			
		});


	});
	
});
/* 함수선언 영역*/
(function($){
	dropSideMenu = function(mainNum, sideUl){
	
	//Ajax 시작
	$.ajax({
	      url: 'selectSideMenu.do', //요청경로
	      type: 'post',
	      data: {'mainNum':mainNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
	      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
	    	  $('.sideUl').empty();
	    	  
	    	  var str = '';
	            $(result).each(function(index, element){
	               str += `<li class="drop" data-sideNum="${element.sideNum}"><a href="${element.menuUrl }?sideNum=${element.sideNum}&mainNum=${element.mainNum}">${element.sideName}</a></li>`;
	            }); 
	            
	            $('.sideUl').append(str);
	            
	      },
	      error: function(){ //ajax통신 실패 시 실행부분

	      }
	});
	};
})(jQuery);