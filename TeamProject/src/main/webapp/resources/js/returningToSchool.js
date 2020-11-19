/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//복학신청 버튼
	$(document).on('click', '#RtsBtn', function() {
		var fromStatus = $('#fromStatus').val();
		if(fromStatus == 1){
			alert('이미 재학중입니다.');
			return;
		}
		else if(fromStatus == 2){
			var stuNum = $('#stuNum').val();
			$.ajax({
			      url: 'checkComfirm.do', //요청경로
			      type: 'post',
			      data: {'stuNum':stuNum},
			      success: function(result) { 
			    	  if(result != ''){
			    		  alert('이미 신청하셨습니다.');
			    	  }
			    	  else{
						var isConfirm = confirm('복학 신청 하시겠습니까?');
						if(isConfirm){
							$('#Rts').submit();
							alert('신청되었습니다.');
						}
						else{
							return;
						}
			    	  }
			      },
			      error: function(){
			    	  alert('오류');
			      }
			});
			
		}
		else{
			alert('조건이 맞지 않습니다.');
			return;
		}
	});
});

/* 함수선언 영역*/
(function($){

})(jQuery);