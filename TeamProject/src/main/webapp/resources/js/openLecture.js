/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	var mainNum = $('#mainNum').val();
	var sideNum = $('#sideNum').val();
	
	$('input:radio').eq(0).attr("checked", true);
	
	//클릭 이벤트
	$(document).on('change', '#colSelect', function() {
		
		
		var collegeNum = $('#colSelect').val();
		$('#searchBox').val('');
		
		if(collegeNum == 0){
	    	  $('#depSelect').empty();
	    	  var str = '<option>-</option>';
	    	  $('#depSelect').append(str);
	      }else{
	    	  selectDepList(collegeNum);
	      }
		
	});
	
	$(document).on('change', '#depSelect, #colSelect', function() {
		
		var depNo = $('#depSelect').val();
		var collegeNum = $('#colSelect').val();
		var lectureName = null;
		
		if(collegeNum == 0){
			depNo = 0;
			collegeNum = 0;
		}
		selectLecList(depNo, collegeNum, lectureName);
	});
	
	$(document).on('click', '#searchBtn', function() {
		
		var depNo = $('#depSelect').val();
		var collegeNum = $('#colSelect').val();
		var lectureName = $('#searchBox').val();
		
		if(collegeNum == 0){
			depNo = 0;
			collegeNum = 0;
		}
		selectLecList(depNo, collegeNum, lectureName);
		
	});
	
	//강의 개설버튼 클릭시
	$(document).on('click', '#openLecBtn', function() {
		var lecCode = $('.lecRadio:checked').closest('tr').find('.lecCode').text();
		location.href = 'openLec2.do?lecCode='+lecCode + '&mainNum=' + mainNum + '&sideNum=' + sideNum;
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
		    		  
			    		str += '<option value = "' + element.depNo+ '">';
			    		str += element.depName;
			    		str += '</option>';
			    	});
		    	  $('#depSelect').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분

		      }
		});
	};
	
	
	selectLecList = function(depNo, collegeNum, lectureName){
		
		//Ajax 시작
		$.ajax({
			url: 'selectLecList.do', //요청경로
			type: 'post',
			async: false,
			data: {'collegeNum': collegeNum
				, 'depNo' : depNo
				, 'lectureName' : lectureName}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				$('#tBody').empty();
				var str = '';
				
				if(result[0] == null){
					str += '<tr>';
					str += '<td colspan="7" style="color: red">등록된 강의가 없습니다.</td>';
					str += '<tr>';
				}else{
					$(result).each(function(index, element){
						
						str += '<tr>';
						str += '<td><input type="radio" name="lecRadioBtn" class="lecRadioBtn"></td>';
						str += `<td>${element.lecCode }</td>`;
						str += `<td>${element.lectureName }</td>`;
						str += `<td>${element.depName }</td>`;
						str += `<td>${element.profName }</td>`;
						str += `<td>${element.asstName }</td>`;
						str += `<td>${element.lecCredit }</td>`;
						str += `<td>${element.recYear }</td>`;
						str += '</tr>';
					});
				}
				
				$('#tBody').append(str);
			},
			error: function(){ //ajax통신 실패 시 실행부분
				
			}
		});
	};
	
	openModal = function(lecCode){
		//Ajax 시작
		$.ajax({
			url: 'selectLecDetail.do', //요청경로
			type: 'post',
			async: false,
			data: {'lecCode': lecCode}, //요청경로로 던질 파라메터. '파레메터명':파라메터
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
				$('#searchEmpModal').modal();
			},
			error: function(){ //ajax통신 실패 시 실행부분
				
			}
		});
	};
	
	
})(jQuery);