/* 페이지 로딩 후 실행 */
$(document).ready(function(){
		var collegeNum = $('#colSelect').val();
		selectDepList(collegeNum);
	
	//클릭 이벤트
	$(document).on('change', '#colSelect', function() {
		var collegeNum = $('#colSelect').val();
		selectDepList(collegeNum);
	});
	
	//교수 검색버튼 클릭시
	$(document).on('click', '#profBtn', function() {
		$('#hiddenEmpJob').val('교수');
		var empName = '';
		selectEmpList(empName);
		
	});
	
	//조교 검색버튼 클릭시
	$(document).on('click', '#asstBtn', function() {
		var empName = '';
		$('#hiddenEmpJob').val('학사조교');
		
		selectEmpList(empName);
	});
	
	//모달 검색버튼 클릭시
	$(document).on('click', '#modalsearchBtn', function() {
		var empName= $('#searchValue').val();
		selectEmpList(empName);
	});
	
	//모달 등록 버튼 클릭시
	$(document).on('click', '#confirmBtn', function() {
		var empNo = $('input:radio:checked').val();
		
		if($('#hiddenEmpJob').val() == '교수'){
			$('#profNum').val(empNo);
		}else{
			$('#asstNum').val(empNo);
		}
		$('#buyModal').modal('hide');
	});
	
	//모달 취소하기 버튼 클릭시
	$(document).on('click', '#modalCancelBtn', function() {
		$('#buyModal').modal('hide');
	});
	
	//모달 취소하기 버튼 클릭시
	$(document).on('click', '#profNum, #asstNum', function() {
		alert('검색을 이용하세요.');
	});
	
	//모달 취소하기 버튼 클릭시
	$(document).on('click', '#regFormBtn', function() {
		if($('.required').val() == null || $('.required').val() == ''){
			alert('필수항목을 입력해주세요');
		}else{
			$('#regForm').submit();
		}
	});
});

/* 함수선언 영역*/
(function($){
	selectDepList = function(collegeNum){
		//Ajax 시작
		$.ajax({
		      url: 'selectDepList.do', //요청경로
		      type: 'post',
		      async: false,
		      data: {'collegeNum': collegeNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  
		    	  
		    	  $('#depSelect').empty();
		    	  var str = '';
		    	  $(result).each(function(index, element){
			    		str += `<option  value = "${element.depNo}">`;
			    		str += `${element.depName}`;
			    		str += '</option>';
			    	});
		    	  
		    	  $('#depSelect').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분

		      }
		});
	};
	
	selectEmpList = function(empName){
		var empJob = $('#hiddenEmpJob').val();
		//Ajax 시작
		$.ajax({
			url: 'selectEmpList.do', //요청경로
			type: 'post',
			async: false,
			data: {'empJob': empJob
				, 'empName': empName}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				
				
				$('#modalTbody').empty();
				var str = '';
				$(result).each(function(index, element){
					str += '<tr>';
					str += `<td><input type="radio" class="empNo" value="${element.empNo}"></td>`;
					str += `<td>${element.empNo}</td>`;
					str += `<td>${element.empName}</td>`;
					str += `<td>${element.depName}</td>`;
					str += `<td>${element.empJob}</td>`;
					str += '</tr>';
				});
				
				$('#modalTbody').append(str);
				$('#selectEmpModal').modal();
			},
			error: function(){ //ajax통신 실패 시 실행부분
				
			}
		});
	};
	
})(jQuery);