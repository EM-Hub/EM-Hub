/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//자퇴신청버튼 숨김
	$('#DropBtn').hide();
	
	//자퇴신청 동의여부
	$('.checkB').click(function(){
		var check = $('.checkB').prop('checked');
		//동의함 체크시 신청버튼 나타냄
		if(check){
			$('#DropBtn').show();
		}
		//체크해제 -> 신청버튼 숨김
		else{
			$('#DropBtn').hide();
		}
	});
	
	//자퇴신청 버튼 클릭 시
	$(document).on('click', '#DropBtn', function() {
		var fromStatus = $('#fromStatus').val();
		if(fromStatus == 6){
			alert('이미 자퇴처리 된 상태입니다.');
			return;
		}
		else{
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
						var isConfirm = confirm('자퇴 신청 하시겠습니까?');
						if(isConfirm){
							$('#dropOut').submit();
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
	});
});

/* 함수선언 영역*/
(function($){

})(jQuery);