/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	addTimSelectTr();
	
	
	//클릭 이벤트
	$(document).on('click', '#viewerBtn', function() {
		var attachment = $(this).attr('data-attachment');
		
		if (attachment == null || attachment == ''){
			alert('첨부된 강의계획서가 없습니다');
		}else{
			$('#showAttchModal').modal();
		}
	});
	
	$(document).on('click', '#closeBtn', function() {
		$('#buyModal').modal('hide')
	});
	
	$(document).on('click', '#plusBtn', function() {

		addTimSelectTr();
	});
	
	$(document).on('click', '#minusBtn', function() {
		$(this).closest('tr').remove();
	});
	
	$(document).on('change', '.lecWeek', function() {
		var lecWeek = $(this).val();
	});
	$(document).on('change', '.lecWeek', function() {
		var facTd = $(this).closest('tr').find('.facTd');
		var lecWeek = $(this).val();
		var lecTT = $(this).next().val();
		
		if(lecWeek != '' && lecTT != '' && lecTT != null && lecWeek != null){
			selectFacLoc(facTd);
		}
	});
	$(document).on('change', '.lecTT', function() {
		var facTd = $(this).closest('tr').find('.facTd');
		var lecWeek = $(this).prev().val();
		var lecTT = $(this).val();
		
		if(lecWeek != '' && lecTT != '' && lecTT != null && lecWeek != null ){
			selectFacLoc(facTd);
		}
	});
	
	$(document).on('change', '.facSelect', function() {
		var facLoc = $(this).val();
		var facLocDetail = $(this).next();
		selectFacDetail(facLoc, facLocDetail);
	});
	
	$(document).on('click', '#openLecDo', function() {
		var cf = confirm($('#sem1').val() + '년도 ' + $('#sem2').val() + '학기 \n ['
				+ $('#lecName').text() + ']를 개설하시겠습니까?');
		
		if(cf){
			var lecCode = $('#lecCode').text();
			var stuMaxNum = $('#stuMaxNum').val();
			var semCode = $('#sem1').val() +'0'+ $('#sem2').val();
			
			var lecWeekArr = new Array();
			$('.lecWeek').each(function(index, element){
				var lecWeek= $(element).val();
				lecWeekArr[index] = lecWeek;
			});
			
			var ttSeqArr = new Array();
			$('.lecTT').each(function(index, element){
				var lecTT= $(element).val();
				ttSeqArr[index] = lecTT;
			});
			
			var facCodeArr = new Array();
			$('.facSelect').each(function(index, element){
				var facCode= $(element).val() + $(element).next().val();
				facCodeArr[index] = facCode;
			});
			
			location.href='openLecture.do?lecCode='+lecCode
										+ '&stuMaxNum='+stuMaxNum
										+ '&semCode='+semCode
										+ '&lecWeekArr='+lecWeekArr
										+ '&ttSeqArr='+ttSeqArr
										+ '&facCodeArr='+facCodeArr;
			
		}
		
	});
});

/* 함수선언 영역*/
(function($){
	addTimSelectTr = function(collegeNum){
		//Ajax 시작
		$.ajax({
		      url: 'selectTimetable.do', //요청경로
		      type: 'post',
		      async: false,
		      data: {}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	
		    	var str = '';
		  		str += '<tr>';
				str += 		'<td>';
				str +=		'<select class="lecWeek">';
				str += 			'<option value="" disabled selected>요일</option>';
				str += 			'<option value="2">월</option>';
				str += 			'<option value="3">화</option>';
				str += 			'<option value="4">수</option>';
				str += 			'<option value="5">목</option>';
				str += 			'<option value="6">금</option>';
				str +=		'</select>';
				str +=		'<select class="lecTT">'
				str += 			'<option value="" disabled selected>교시를 선택하세요.</option>';
				$(result).each(function(index, element){
					
					str += `<option  value = "${element.ttSeq}">`;
					str += `${element.ttSeq}교시`;
					str += `(${element.ttStartTime.substring(0, 2)}:${element.ttStartTime.substring(2, 4)} ~ ${element.ttEndTime.substring(0, 2)}:${element.ttEndTime.substring(2, 4)})`;
					str += '</option>';
				});
				
				str +=		'</select>';
				str += 		'</td>';
				str += 		'<td class="facTd">';
				str += 		'<span style="color: red ">강의일시를 먼저 선택해주세요.</span>';
				str += 		'</td>';
				str += 		'<td>';
				str += 		'<i class="icon-minus" id="minusBtn"></i>'
				str += 		'</td>';
				str += '</tr>';
				
		    	  
		    	  $('#timeTable').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분

		      }
		});
	};
	
	selectFacLoc = function(facTd){
		//Ajax 시작
		$.ajax({
			url: 'selectFacLoc.do', //요청경로
			type: 'post',
			async: false,
			data: {}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				
				$(facTd).empty();
				
				var str = '';
				str +=	'<select class="facSelect">';
				str += 	'<option value="" disabled selected>강의동 선택</option>';
				$(result).each(function(index, element){
					var tt = element.facLoc == 'OUT' ? '기타시설' : `${element.facLoc}동`;
					
					str += `<option  value = "${element.facLoc}">`;
					str += tt;
					str += '</option>';
				});
				str +=		'</select>';
				str +=		'<select class="facLocDetail">'
				str += 			'<option value="" disabled selected>-</option>';
				str +=		'</select>';
				
				$(facTd).append(str);
			},
			error: function(){ //ajax통신 실패 시 실행부분
				
			}
		});
	};
	
	selectFacDetail = function(facLoc, facLocDetail){
		//Ajax 시작
		$.ajax({
			url: 'selectFacDetail.do', //요청경로
			type: 'post',
			async: false,
			data: {'facLoc':facLoc}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				
				$(facLocDetail).empty();
				
				str =	'';
				$(result).each(function(index, element){
					var tt = element.facLoc == 'OUT' ? `${element.facName}` : `${element.facLocDetail}호`;
					
					str += `<option  value = "${element.facLocDetail}">`;
					str += tt;
					str += '</option>';
				});
				
				$(facLocDetail).append(str);
			},
			error: function(){ //ajax통신 실패 시 실행부분
				
			}
		});
	};
	
	
})(jQuery);