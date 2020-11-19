/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	var mainNum = $('#mainNum').val();
	var sideNum = $('#sideNum').val();
	var sideDetailNum = $('#sideDetailNum').val();

	var stuNum = $('#stuNum').val();
	

	// 신청한 학생의 정보
	$(document).on('click', '.empBtn', function() {
		var stuNum = $(this).attr('data-stuNum');
		var applyType = $(this).attr('data-applyType');
		var collegeNum = $(this).attr('data-majorCollegeNum');
		var depNo = $(this).attr('data-majorDepno');
		var majorStatus = $(this).attr('data-majorStatus');

		selectStudentInfo(stuNum,applyType,majorStatus);
	
	//승인하기
	$(document).on('click', '#confirmBtn', function() {		
		updateApplyStudent(stuNum,applyType);
		
	 if(applyType == 1) {
	 updateMajorStudent(stuNum,collegeNum,depNo);

	 }
	 else if(applyType == 2) {
		 updateDoubleMajorStudent(stuNum,depNo);
		
	 }	
	 
	});
	
  });

});


/* 함수선언 영역*/
(function($){
	//대학 전체 선택 -> 과 전체
	
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
			    		  str += '<td colspan="9">검색된 데이터가 없습니다.</td>';
			    		  str += '</tr>';
			    	  }
		    	  	 else{
		    	  		$(result).each(function(index, element){		    		
				    		  str += `<tr>`;
				    		  str += `<td>1</td>`;
				    		  str += `<td>${element.fromCollegeNum}</td>`;
				    		  str += `<td>${element.fromDepNo}</td>`;
				    		  str += `<td>${element.stuNum}</td>`;
				    		  str += `<td>${element.stuName}</td>`;
				    		  str += `<td>${element.stuYear}</td>`;
				    		  str += `<td>${element.memStatus}</td>`;
				    		  str += `<td>${element.collegeName2}</td>`;
				    		  str += `<td>${element.depName2}</td>`;
				    		  if(element.majorStatus == 'N')	 {
				    			  str += `<td>처리대기중</td>`;
				    		  }		 
				    		  str += `<td>${element.majorCreateDate}</td>`;
				    		  str += `</tr>`;
				    	  });
		    	  	 }			    	  			    	  	
		    	    str +=`</table>`;
		    	    if(result.length != 0) {
		    	    	str +=`<input type="button" value="취소" class="dBtn">`;			    	    	
		    	    }
		    	  $('#dmajorList').append(str);

		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
		});
	};

	updateApplyStudent = function(stuNum,applyType){
		var isConfirm = confirm('승인하시겠습니까?');
		var mainNum = $('#mainNum').val();
		var sideNum = $('#sideNum').val();
		var sideDetailNum = $('#sideDetailNum').val();
		if (isConfirm) {
			
  		  $.ajax({
  			  url: 'updateApplyStudent.do', //요청경로
  			  type: 'post',
  			  data: {'stuNum':stuNum, 'applyType':applyType}, //요청경로로 던질 파라메터. '파레메터명':파라메터
  			  success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
  				  				  
  				  	  alert('승인되었습니다.');
  					  location.href = 'applyManagement.do?mainNum=' + mainNum + '&sideNum=' + sideNum + '&sideDetailNum=' + sideDetailNum; 
  				 				  
  			  },
  			  error: function(){ //ajax통신 실패 시 실행부분
  				  alert('오류');
  			  }
  		  });
		}
		else {
			return;
		}
	};
	
	//전과신청목록에서의 학생정보조회
	selectStudentInfo = function(stuNum,applyType,majorStatus){
	  $.ajax({
		  url: 'selectStudentInfo.do', //요청경로
		  type: 'post',
		  data: {'stuNum':stuNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		  success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				
				$('.modal-content').empty();
			
				var str = '';
	    
	    	
				str += `
		
					<div style="width: 900px; height:auto; padding: 15px; position: relative; z-index= 9999; right: 30px;" align="center">
					<div style="width: 150px; height: 180px; border: 1px solid #bfbfbf; display: inline-block; z-index: 99999"> 
						<img src="resources/images/20160702.png" width="100%" height="100%" >
					</div>
					<div style="width: 600px; height: 180px; display: inline-block; float: right;" align="center">`;
	    	  		$(result).each(function(index, element){		    		
	    	  		str += `<table id="myInfo">`;
			    	  		str += `<colgroup>`;
			    			str += `		<col width="15%">`;
			    			str += `		<col width="35%">`;
			    			str += `		<col width="15%">`;
			    			str += `		<col width="35%">`;
			    			str += `	</colgroup>`;
			    			str += `	<tr>`;
			    			str += `		<td class="title">이 름</td>`;
			    			str += `		<td>${element.stuName }</td>`;
			    			str += `		<td class="title">대 학</td>`;
			    			str += `		<td>${element.collegeName }</td>`;
			    			str += `	</tr>`;
			    			str += `	<tr>`;
			    			str += `		<td class="title">학 번</td>`;
			    			str += `		<td class="stuNum">${element.stuNum }</td>`;
			    			str += `		<td class="title">전 공</td>`;
			    			str += `		<td>${element.depName }</td>`;
			    			str += `	</tr>`;
			    			str += `	<tr>`;
			    			str += `		<td class="title">학 년</td>`;
			    			str += `		<td>${element.stuYear }학년</td>`;
			    						if(element.depName2 == null) {
			    							str +=`<td class="title">부전공</td>`;
			    							str +=`<td>-</td>`;
					  		            }
					  		            else {
					  		           	str +=`<td class="title">부전공</td>`;
					  		            	str +=`<td>${element.depName2}</td>`;
					  		           }
					  						
	    	  				str += `	</tr>`;
	    	  				str += `	<tr>`;
			    			str += `	<td class="title">성 별</td>`;
			    				if(element.memGender == 'F') {
			    				str +=`<td>여</td>`;
			    				
			    				}else {
			    				str +=`<td>남</td>`;			    					
			    				}
			    			str +=`<td class="title">이메일</td>
			    					<td><input type="text" value="${element.memEmail }" class="inputT" readonly id="memEmail"></td>
			    				</tr>
	    	  				</table>
	    	  				</div>`;
	    	  		str +=	`<table id="myInfo2">
	    				<colgroup>
	    					<col width="10%">
	    					<col width="40%">
	    					<col width="10%">
	    					<col width="40%">
	    				</colgroup>
	    				<tr>
	    					<td class="title">생년월일</td>
	    					<td>${element.memBirthday }</td>
	    					<td class="title">학적상태</td>
	    					<td>${element.memStatus }</td>
	    				</tr>
	    				<tr>
	    					<td class="title">전화번호</td>
	    					<td><input type="text" value="${element.memTel }" class="inputT" readonly id="memTel"></td>
	    					<td class="title">휴대폰</td>
	    					<td><input type="text" value="${element.memPhone }" class="inputT" readonly id="memPhone"></td>
	    				</tr>
	    				<tr>
	    					<td class="title">우편번호</td>
	    					<td colspan="3"><input type="text" value="${element.memZipCode }" class="inputT" readonly id="memZipCode"></td>
	    				</tr>
	    				<tr>
	    					<td class="title">주 소</td>
	    					<td colspan="3">${element.memAddr }</td>
	    				</tr>
	    			</table>
	    	  		</div>
	    	  		</div>`;
			    	  });
	    	  		str += `<div class="modal-footer">
	    	  			<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>`;
	    	  		if(majorStatus == 'N') {
	    	  			str +=`<button type="button" class="btn btn-primary" id="confirmBtn">승인하기</button>`;	  	
	    	  		}
	    	  		else {
	    	  			str +=`<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>`;
	    	  		}
	    	  	   `</div>
	    	  	    </div>
	    	  	  </div>
	    	  	</div>`;
  
	    	 
	    	  	$('#studentInfo').modal();
	    	  	$('.modal-content').append(str);	
	      },
		  error: function(){ //ajax통신 실패 시 실행부분
			  alert('오류');
		  }
	  });
  	
	};
	
	updateMajorStudent = function(stuNum,collegeNum,depNo) {
		//Ajax 시작
		$.ajax({
			url: 'updateMajorStudent.do', //요청경로
			type: 'post',
			async: false,
			data: {'stuNum' : stuNum , 'collegeNum' :collegeNum , 'depNo':depNo}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				
				if(result == 1)	 {
					
				}
				
			},
			error: function(){ //ajax통신 실패 시 실행부분
				alert("오류ㅠㅜ11!");
			}
		});
	};
	//복수전공 업데이트
	updateDoubleMajorStudent = function(stuNum,depNo) {
		//Ajax 시작
		$.ajax({
			url: 'updateDoubleMajorStudent.do', //요청경로
			type: 'post',
			async: false,
			data: {'stuNum':stuNum,'depNo':depNo}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				
				if(result == 1)	 {
					
				}
				
			},
			error: function(){ //ajax통신 실패 시 실행부분
				alert("오류ㅠㅜ11!");
			}
		});
	};
	
	
	
})(jQuery);