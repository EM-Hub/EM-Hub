/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//대학 select -> 각 대학에 맞는 전공 select 띄우기
	$(document).on('change', '#colSel', function() {
		var collegeNum = $(this).val();
		if(collegeNum == 0){
			changeSelectBox1(collegeNum);
		}
		else{
			changeSelectBox2(collegeNum);
		}
	});
	//조회 버튼 누르면 조건에 맞게 검색
	$(document).on('click', '#selectBtn', function() {
		var collegeNum = $('#colSel').val();
		var depNo = $('#depSel').val();
		var recYear = $('#yearSel').val();
		var lecCredit = $('#lecCredit').val();
		selectLectureList(collegeNum, depNo, recYear, lecCredit);
	});
	
	//검색
	$(document).on('click', '#searchBtn', function() {
		var lecCode = $('.searchInput').val();
		searchLectureList(lecCode);
	});
	//강의 계획서
	$(document).on('click', '.attachment', function() {
		var attachment = $(this).attr('data-attachment');
		
		if (attachment == null || attachment == ''){
			alert('첨부된 강의계획서가 없습니다');
		}else{
			var attchSrc = '/upload/'+ attachment;
			
			$('#attachmentSrc').attr('src', attchSrc);
			$('#showAttchModal').modal();
		}
	});
});

/* 함수선언 영역*/
(function($){
	//대학 전체 선택 -> 과 전체
	changeSelectBox1 = function(collegeNum){
		$.ajax({
		      url: 'selectStuDep.do', //요청경로
		      type: 'post',
		      data: {}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#depSel').empty();
		    	  var str = '';
		    	  str += `<option value="0">전체</option>`;
		    		  
		    	  $(result).each(function(index, element){
		    		  str += `<option value="${element.depNo }">${element.depName }</option>`;
		    	  });
		    	  
		    	  $('#depSel').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
		});
	};
	//대학 선택 -> 각 대학에 맞는 과 list
	changeSelectBox2 = function(collegeNum){
		$.ajax({
		      url: 'selectDep.do', //요청경로
		      type: 'post',
		      data: {'collegeNum':collegeNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#depSel').empty();
		    	  var str = '';
		    	  str += `<option value="0">전체</option>`;
		    		  
		    	  $(result).each(function(index, element){
		    		  str += `<option value="${element.depNo }">${element.depName }</option>`;
		    	  });
		    	  
		    	  $('#depSel').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
			});
	};
	//강의목록 조건 조회
	selectLectureList = function(collegeNum, depNo, recYear, lecCredit){
		$.ajax({
		      url: 'lecList.do', //요청경로
		      type: 'post',
		      data: {'collegeNum':collegeNum, 'depNo':depNo, 'recYear':recYear, 'lecCredit':lecCredit}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#lecList').empty();
		    	  var str = '';
		    	  if(result.length == 0){
		    		  str += '<tr>';
		    		  str += '<td colspan="8">조회한 데이터가 없습니다.</td>';
		    		  str += '</tr>';
		    	  }
		    	  else{
		    		  $(result).each(function(index, element){
			    		  str += `<tr>`;
			    		  str += `<td>${element.lecCode }</td>`;
			    		  str += `<td>${element.collegeName }</td>`;
			    		  str += `<td>${element.depName }</td>`;
			    		  str += `<td><span class="attachment" data-attachment="${element.attachment }">${element.lectureName }</span></td>`;
			    		  str += `<td>${element.profName }</td>`;
			    		  str += `<td>${element.asstName }</td>`;
			    		  str += `<td>${element.recYear }</td>`;
			    		  str += `<td>${element.lecCredit }</td>`;
			    		  str += `</tr>`;
			    	  });
		    	  }
		    	  $('#lecList').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
			});
	};
	//강의목록 검색
	searchLectureList = function(lecCode){
		$.ajax({
		      url: 'lecList.do', //요청경로
		      type: 'post',
		      data: {'lecCode':lecCode}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#lecList').empty();
		    	  var str = '';
		    	  if(result.length == 0){
		    		  str += '<tr>';
		    		  str += '<td colspan="8">조회한 데이터가 없습니다.</td>';
		    		  str += '</tr>';
		    	  }
		    	  else{
		    		  $(result).each(function(index, element){
			    		  str += `<tr>`;
			    		  str += `<td>${element.lecCode }</td>`;
			    		  str += `<td>${element.collegeName }</td>`;
			    		  str += `<td>${element.depName }</td>`;
			    		  str += `<td><span class="attachment" data-attachment="${element.attachment }">${element.lectureName }</span></td>`;
			    		  str += `<td>${element.profName }</td>`;
			    		  str += `<td>${element.asstName }</td>`;
			    		  str += `<td>${element.recYear }</td>`;
			    		  str += `<td>${element.lecCredit }</td>`;
			    		  str += `</tr>`;
			    	  });
		    	  }
		    	  $('#lecList').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
			});
	};
})(jQuery);