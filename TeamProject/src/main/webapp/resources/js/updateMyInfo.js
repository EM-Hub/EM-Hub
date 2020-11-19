/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	//정보수정 버튼 클릭시
	$(document).on('click', '#updateBtn', function() {
		//inputT readonly 속성제거
		$('.inputT').removeAttr("readonly");
		$('.inputT').css('background', '#FDF0E4');
		//'정보수정' 버튼 '확인'버튼으로 변경
		$(this).val('확인');
		$(this).attr('id', 'updateMyInfo');
	});
	//개인정보 업데이트
	$(document).on('click', '#updateMyInfo', function() {
		var memId = $('.stuNum').text();
		var memEmail = $('#memEmail').val();
		var memTel = $('#memTel').val();
		var memPhone = $('#memPhone').val();
		var memZipCode = $('#memZipCode').val();
		var memAddr = $('#memAddr').val();
		
		$.ajax({
		      url: 'updateMyInfo.do', //요청경로
		      type: 'post',
		      data: {'memId':memId, 'memEmail':memEmail, 'memTel':memTel, 'memPhone':memPhone, 'memZipCode':memZipCode, 'memAddr':memAddr}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  if(result == 1){
		    		  alert('수정되었습니다.');
		    	  }
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
		});
		
		$('.inputT').attr("readonly", true);
		$('.inputT').css('background', 'white');
		$(this).val('정보수정');
		$(this).attr('id', 'updateBtn');
	});
	
	
	
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	//aaa = function(){
	
	//};
})(jQuery);