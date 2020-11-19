/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//대학 select -> 각 대학에 맞는 전공 select 띄우기
	$(document).on('change', '#colSel', function() {
		var collegeNum = $(this).val();
		if(collegeNum == 0){
			changeSelectBox1(collegeNum);
			selectStudentList(collegeNum);
		}
		else{
			changeSelectBox2(collegeNum);
			selectStudentList(collegeNum);
		}
	});
	//조회 버튼 누르면 조건에 맞게 검색
	$(document).on('click', '#selectBtn', function() {
		var collegeNum = $('#colSel').val();
		var depNo = $('#depSel').val();
		var stuYear = $('#yearSel').val();
		var statusNum = $('#statusSel').val();
		selectStudentList(collegeNum, depNo, stuYear, statusNum);
	});
	
	//검색
	$(document).on('click', '#searchBtn', function() {
		var searchValue = $('#searchInput').val();
		searchStudent(searchValue);
		
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
	selectStudentList = function(collegeNum, depNo, stuYear, statusNum){
		$.ajax({
		      url: 'stuList.do', //요청경로
		      type: 'post',
		      data: {'collegeNum':collegeNum, 'depNo':depNo, 'stuYear':stuYear, 'statusNum':statusNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#stuList').empty();
		    	  var str = '';
		    	  if(result.length == 0){
		    		  str += '<tr>';
		    		  str += '<td colspan="6">해당 학생이 없습니다.</td>';
		    		  str += '</tr>';
		    	  }
		    	  else{
		    		  $(result).each(function(index, element){
			    		  str += `<tr>`;
			    		  str += `<td>${element.stuNum }</td>`;
			    		  str += `<td>${element.stuYear }</td>`;
			    		  str += `<td><a href="studentInfo.do?stuNum=${element.stuNum }&mainNum=8&sideNum=21">${element.stuName }</a></td>`;
			    		  str += `<td>${element.collegeName }</td>`;
			    		  str += `<td>${element.depName }</td>`;
			    		  str += `<td>${element.memStatus }</td>`;
			    		  str += `</tr>`;
			    	  });
		    	  }
		    	  $('#stuList').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
			});
	};
	searchStudent = function(searchValue){
		$.ajax({
		      url: 'searchStudent.do', //요청경로
		      type: 'post',
		      data: {'searchValue':searchValue}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#stuList').empty();
		    	  var str = '';
		    	  
		    	  if(result.length == 0){
		    		  str += '<tr>';
		    		  str += '<td colspan="6">해당 학생이 없습니다.</td>';
		    		  str += '</tr>';
		    	  }
		    	  else{
			    	  $(result).each(function(index, element){
			    		  str += `<tr>`;
			    		  str += `<td>${element.stuNum }</td>`;
			    		  str += `<td>${element.stuYear }</td>`;
			    		  str += `<td><a href="studentInfo.do?stuNum=${element.stuNum }&mainNum=8&sideNum=21">${element.stuName }</a></td>`;
			    		  str += `<td>${element.collegeName }</td>`;
			    		  str += `<td>${element.depName }</td>`;
			    		  str += `<td>${element.memStatus }</td>`;
			    		  str += `</tr>`;
			    	  });
		    	  }
		    	  $('#stuList').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
			});
	};
})(jQuery);