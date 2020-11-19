/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//클릭 이벤트
	$(document).on('click Keyup', '#loginBtn', function() {
		var memId = $('#memId').val();
		var memPassword = $('#memPassword').val();
		memberLogin(memId, memPassword);
	});
});

/* 함수선언 영역*/
(function($){
	memberLogin = function(memId, memPassword){
		//Ajax 시작
		$.ajax({
		      url: 'loginMember.do', //요청경로
		      type: 'post',
		      async:false,
		      data: {'memId':memId
		    	  ,'memPassword':memPassword}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  if(result == 'fail'){
		    		  alert('아이디와 비밀번호가 맞지않습니다.')
		    	  }else{
		    		  location.href = 'mainPage.do';
		    	  }
		      },
		      error: function(request, error){ //ajax통신 실패 시 실행부분
		    		alert("아이디는 학번(숫자)만 입력 가능합니다.");
		      }
		});
	};
})(jQuery);