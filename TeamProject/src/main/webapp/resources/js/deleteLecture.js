/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//클릭 이벤트
	$(document).on('click', '.deleteBtn', function() {
		var lecCode = $(this).closest('tr').find('.lecCode').text();
		var deletedTr = $(this).closest('tr');
		
		var result = confirm('정말로 삭제하시겠습니까?');
		if(result){
			deleteLec(lecCode, deletedTr);
		}else{
		    alert('취소되었습니다.');
		}
		
	});
	
	$(document).on('click', '.upadateBtn', function() {
		
	});
});

/* 함수선언 영역*/
(function($){
	deleteLec = function(lecCode, deletedTr){
		//Ajax 시작
		$.ajax({
		      url: 'deleteLec.do', //요청경로
		      type: 'post',
		      data: {'lecCode': lecCode}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  if(result == 1){
		    		  alert('삭제가 완료되었습니다.');
		    	  }else{
		    		  alert('강의를 삭제하는데 실패했습니다. \n 관리자에 문의하세요');
		    	  }
		    	  
		    	  deletedTr.remove();
		    	  
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('개설된 강의는 삭제할 수 없습니다. \n 관리자에 문의하세요')
		      }
		});
	};
	
	
	
})(jQuery);