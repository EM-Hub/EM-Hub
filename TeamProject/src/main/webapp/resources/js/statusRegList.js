/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//체크박스 전체 체크, 해제
	$(document).on('click', '#checkAll', function() {
		if($(this).prop("checked")){
			$('.check').prop("checked", true);
		}
		else{
			$('.check').prop("checked", false);
		}
	});
	
	$(document).on('click', '#updateStatus', function() {
		if($('.check').is(':checked')){
			if($('.check:checked').parent().parent().children(':last').text() == '승인완료'){
				alert('이미 처리 된 상태입니다.');
			}
			else{
				var regNum = [];
				$('.check:checked').each(function(index, element){
					regNum[index] = $(element).val();
				});
				location.href = 'updateStatus.do?regNum=' + regNum + '&mainNum='+8+'&sideNum='+23;
				alert('승인처리 되었습니다.');
			}
		}
		else{
			alert('승인처리할 학생을 선택해주세요.');
		}
	});
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	/*check = function(){
		var regNum = '';
		$('.check:checked').each(function(index, element){
			var num = $(element).val()+',';
			regNum += num;
		});
		alert(regNum);
	};*/
})(jQuery);