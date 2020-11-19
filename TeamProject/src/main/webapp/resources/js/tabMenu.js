/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$('ul.tabs li').click(function(){
	      var tab_id = $(this).attr('data-tab');

	      $('ul.tabs li').removeClass('current');
	      $('.tab-content').removeClass('current');

	      $(this).addClass('current');
	      $("#"+tab_id).addClass('current');
	   })
	
	
});

/* 함수선언 영역*/
(function($){
	
})(jQuery);