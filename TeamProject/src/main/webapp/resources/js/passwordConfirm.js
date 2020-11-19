/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	//클릭 이벤트
	$(document).on('click', '#passwordBtn', function() {
		 var memPassword = $('#memPassword').val();
		 var memId = $('#memId').val();
		 passwordConfirm(memId,memPassword);
	});
});

/* 함수선언 영역*/
(function($){
	passwordConfirm = function(memId, memPassword){
		var mainNum = $('#mainNum').val();	
		var sideNum = $('#sideNum').val();
		var sideDetailNum = $('#sideDetailNum').val();
		//Ajax 시작
		$.ajax({
		      url: 'passwordConfirm.do', //요청경로
		      type: 'post',
		      async:false,
		      data: {'memId':memId
		    	  ,'memPassword':memPassword}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  if(result){
		    		  
		    		  location.href = 'passwordChangePage.do?&mainNum=' + mainNum + '&sideNum=' + sideNum + '&sideDetailNum=' +sideDetailNum;
		    	  }else{
		    		  alert('아이디와 비밀번호가 맞지않습니다.')
		    	  }
		      },
		      
		      error: function(request, error){ //ajax통신 실패 시 실행부분
		    		alert("아이디는 학번(숫자)만 입력 가능합니다.");
		      }
		});
	};
})(jQuery);