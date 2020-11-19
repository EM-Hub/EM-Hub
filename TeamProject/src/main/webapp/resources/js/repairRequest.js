/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//수강신청
	$(document).on('click', '#repairBtn', function() {
		var requestTitle = $('#repairTitle').val();
		var requestContent = $('.ck-content p').text();
		var isConfirm = confirm('글 등록 하시겠습니까?');
		if(isConfirm) {
			if(requestTitle == null || requestTitle == ''|| requestContent == null || requestContent ==''){
				alert('제목 또는 내용을 입력해주세요.');
				return;
			}
			else if(requestTitle != null || requestTitle != ''|| requestContent != null || requestContent !=''){
				alert('글이 등록되었습니다.');
				$('#repairForm').submit();
			}
			else {
				alert('작성이 취소되었습니다.');
				return;
			}	
			
		}
		
	});
		$(document).on('click', '#gradeE', function() {
			var isConfirm = confirm('승인완료 하시겠습니까?');
			var requestNum = $('#requestNum').val();
			if(isConfirm) {
				updateRepiarRequest(requestNum);
			}
			else {
				return;
			}
			
		});
		
});

/* 함수선언 영역*/
(function($){
	updateRepiarRequest = function(requestNum) {
		//Ajax 시작
		$.ajax({
			url: 'updateRepiarRequest.do', //요청경로
			type: 'post',
			async: false,
			data: {'requestNum' : requestNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				
				if(result == 1)	 {
					alert('승인완료 되었습니다.');
					location.href ='repairRequest2.do?mainNum=' + 11 + '&sideNum=' + 35;
				}
				
			},
			error: function(){ //ajax통신 실패 시 실행부분
				alert("오류ㅠㅜ11!");
			}
		});
	};
})(jQuery);