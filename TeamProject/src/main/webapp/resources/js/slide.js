/* 페이지 로딩 후 실행 */
$(document).ready(function(){
		
		slide();

});

/* 함수선언 영역 */
(function($){
	slide = function(){
		var i = 1;
		setInterval(function() {
			$('input[type="radio"]:checked').prop('checked', 'false');
			
			var a = i % 3; 
			$('#slide' + a).prop('checked', 'true');
			i++;
		}, 3000);
		/*setInterval(function() {
			$('#slide' + a).prop('checked', 'true');
		}, 6000);
		setInterval(function() {
			$('#slide' + a).prop('checked', 'true');
		}, 9000);*/
	};
})(jQuery);