/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$('#yBtn1').hide();
	
	var mainNum = $('#mainNum').val();
	var sideNum = $('#sideNum').val();
	var sideDetailNum = $('#sideDetailNum').val();
	
	
	var stuNum = $('#stuNum').val();	
	doubleMajorApplication(stuNum);
	//대학 select -> 각 대학에 맞는 전공 select 띄우기
	$(document).on('change', '#collegeD', function() {
		var collegeNum = $(this).val();
	
		
		if(collegeNum == 0){
			changeSelectBox1(collegeNum);
		}
		else{
			changeSelectBox2(collegeNum);
		}
	});
		
	//모두 동의
	$('.yBtn').click(function(){
		var check = $('.yBtn').prop('checked');
		//동의함 체크시 신청버튼 나타냄
		if(check){
			$('#yBtn1').show();
			$('.sBtn').hide();
		}
		//체크해제 -> 신청버튼 숨김
		else{
			$('#yBtn1').hide();
			$('.sBtn').show();
		}
	});
	
	//취소하는 버튼
	$(document).on('click', '.dmajorBtn', function() {
		var stuNum = $('#stuNum').val();
		deleteDoubleMajorApplication(stuNum);
			
	});
	
	//동의함 눌렀을 때 확인하기
	$(document).on('click', '#yBtn1', function() {
		var depNo2 = $('#depD').val();
		var collegeNum2 = $('#collegeD').val();
		var fromDepNo = $('#myDep').val();
		var fromCollegeNum = $('#myCollege').val();
		
		
		if(depNo2 == null || depNo2 == 0){
			alert('학부(과)를 선택해주세요.');
			return;		
		}
		else if(depNo2 == fromDepNo) {
			alert('신청 학부(과) 소속학부(과)를 확인해주세요.');
			return;
		}
		
			else{
			var stuNum = $('#stuNum').val();
			$.ajax({
			      url: 'majorAplicationConfirm.do', //요청경로
			      type: 'post',
			      data: {'stuNum':stuNum},
			      success: function(result) {
			    	  if(result != 0)	{
			    		  alert('다른 신청 내역이 있습니다.');			    		  
			    	  }
			    	  
			    	  else{
						var isConfirm = confirm('신청 하시겠습니까?');
						if(isConfirm){
							alert('신청되었습니다.');
							$('#dBtn').submit();
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
	//대학 전체 선택 -> 과 전체
	changeSelectBox1 = function(collegeNum){
		$.ajax({
		      url: 'selectStuDep.do', //요청경로
		      type: 'post',
		      data: {}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#depC').empty();
		    	  var str = '';
		    	  str += `<option value="0">전체</option>`;
		    		  
		    	  $(result).each(function(index, element){
		    		  str += `<option value="${element.depNo }">${element.depName }</option>`;
		    	  });
		    	  
		    	  $('#depC').append(str);
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
		    	  $('#depD').empty();
		    	  var str = '';
		    	  str += `<option value="0">전체</option>`;
		    		  
		    	  $(result).each(function(index, element){
		    		  str += `<option value="${element.depNo }">${element.depName }</option>`;
		    	  });
		    	  
		    	  $('#depD').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
		});
	};

    //신청 내역
	doubleMajorApplication = function(stuNum){
		$.ajax({
		      url: 'doubleMajorApplicationList.do', //요청경로
		      type: 'post',
		      data: {'stuNum':stuNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#dmajorList').empty(str);

		    	  var str = '';
		    	  	 str += `<table class="ttt11">
		    	  		 <col width="5%">
		    	  		 <col width="10%">
		    	  		 <col width="10%">
		    	  		 <col width="10%">
		    	  		 <col width="10%">
		    	  		 <col width="5%">
		    	  		 <col width="10%">
		    	  		 <col width="10%">
		    	  		 <col width="10%">
		    	  		 <col width="10%">
		    	  		 <col width="*">`;
		    	  	 if(result.length == 0){
			    		  str += '<tr>';
			    		  str += '<td colspan="9">신청 내역이 없습니다.</td>';
			    		  str += '</tr>';
			    	  }		
		    	  	 else{
		    	  		$(result).each(function(index, element){	
		    	  		
		    	  			  if (element.applyType == 2) {
		    	  				  str += `<tr>`;
					    		  str += `<td>1</td>`;
					    		  str += `<td>${element.collegeName}</td>`;
					    		  str += `<td>${element.depName}</td>`;
					    		  str += `<td>${element.stuNum}</td>`;
					    		  str += `<td>${element.stuName}</td>`;
					    		  str += `<td>${element.stuYear}</td>`;
					    		  str += `<td>${element.memStatus}</td>`;
					    		  str += `<td>${element.collegeName21}</td>`;
					    		  str += `<td>${element.depName21}</td>`;
			    	  			
					    		  if(element.majorStatus == 'N')	 {
					    			  str += `<td>처리대기중</td>`;
					    		  }		 
					    		  else {
					    			  str += `<td>승인완료</td>`;
					    		  }
					    		  str += `<td>${element.majorCreateDate}</td>`;
					    		  str += `</tr>`;
		    	  			  }
			    	  		
			    	  			});			 
		    	  		}			    	  			    	  	
		    	    str +=`</table>`;
		    	    $(result).each(function(index, element){
		    	    if(element.majorStatus == 'N' && element.applyType == 2 ) {
		    	    	str +=`<input type="button" value="취소" class="dmajorBtn">`;			    	    	
		    	    }
		    	    else if(element.majorStatus == 'Y' && element.applyType == 2) {
		    	    	str +=`<td>승인완료 되었습니다.</td>`		    	    	
		    	    }
	    	  	});

		    	  $('#dmajorList').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
		});
	};
	
	deleteDoubleMajorApplication = function(stuNum){
		var isConfirm = confirm('취소하시겠습니까?');
		var mainNum = $('#mainNum').val();
		var sideNum = $('#sideNum').val();
		var sideDetailNum = $('#sideDetailNum').val();
  	  if(isConfirm)	{
  		  
  		  $.ajax({
  			  url: 'deleteDoubleMajorList.do', //요청경로
  			  type: 'post',
  			  data: {'stuNum':stuNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
  			  success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
  				  				  
  					  location.href = 'doubleMajorApplication.do?mainNum=' + mainNum + '&sideNum=' + sideNum + '&sideDetailNum=' + sideDetailNum; 
  					  alert('취소되었습니다.');
  				 				  
  			  },
  			  error: function(){ //ajax통신 실패 시 실행부분
  				  alert('오류');
  			  }
  		  });
  	  }
  	
	};

	
	
	
})(jQuery);