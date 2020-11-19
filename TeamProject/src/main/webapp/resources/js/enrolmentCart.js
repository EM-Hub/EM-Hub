/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//약도 숨기기
	$('#mapDiv').hide();
	
	//건물코드 클릭 시 약도 나타내기
	$(document).on('click', '.facCode', function() {
		$('.icon-commerical-building').css('color', 'black');
		var facCode = $(this).text().substr(1,1);
		if(facCode == 'A'){
			$('#fA').css('color', 'red');
			$('#mapDiv').show(400);
		}
		if(facCode == 'B'){
			$('#fB').css('color', 'red');
			$('#mapDiv').show(400);
		}
		if(facCode == 'C'){
			$('#fC').css('color', 'red');
			$('#mapDiv').show(400);
		}
		if(facCode == 'D'){
			$('#fD').css('color', 'red');
			$('#mapDiv').show(400);
		}
		if(facCode == 'E'){
			$('#fE').css('color', 'red');
			$('#mapDiv').show(400);
		}
		if(facCode == 'F'){
			$('#fF').css('color', 'red');
			$('#mapDiv').show(400);
		}
	});
	$(document).on('click', '#closeBtn', function() {
		$('.icon-commerical-building').css('color', 'black');
		$('#mapDiv').hide(400);
	});
	
	//총 학점 구하기
	sumCredit();
	
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
		lectureTTList(collegeNum, depNo, recYear, lecCredit);
	});
	//검색
	$(document).on('click', '#searchBtn', function() {
		var lecTtCode = $('.searchInput').val();
		searchTTList(lecTtCode);
	});
	
	//과목바구니 담기 (예비수강신청)
	$(document).on('click', '#cartBtn', function(){
		var stuNum = $('#stuNum').val();
		var lecTtCode = $(this).parent().parent().children(':first').text();
		var booleanVar = true;
		var booleanTime = true;
		var codeArr = new Array();
		//중복 과목 검사
		$('.lecTtCode').each(function(index, element){
			codeArr[index] = $(this).text();
			if(codeArr[index] == lecTtCode){
				booleanVar = false;
			}
		});
		
		//시간 중복 검사
		var time = $(this).parent().prev().text().replace(/(\s*)/g, "");
		var items = time.split(')');
		var result = [];
		
		for(var i = 0 ; i < items.length ; i++){
			if(items[i].substr(0, 2) != ''){
				result[i] = items[i].substr(0, 2);
			}
		}
		
		var cartTime = $('.cartTime').text().replace(/(\s*)/g, "");
		var cartI = cartTime.split(')');
		var cartTimeArr = [];
		for(var i = 0; i < cartI.length; i++){
			if(cartI[i].substr(0, 2) != ''){
				cartTimeArr[i] = cartI[i].substr(0, 2);
			}
		}
		for(var i = 0; i < cartTimeArr.length; i++){
			for(var j = 0; j < result.length; j++){
				if(cartTimeArr[i] == result[j]){
					booleanTime = false;
				}
			}
		}
		
		
		if($('#sum').text() == 20 || parseInt($('#sum').text()) + parseInt($(this).parent().prev().prev().prev().prev().prev().text()) > 20){
			alert('학기당 들을 수 있는 학점은 최대 20점입니다.');
		}
		else if(booleanVar == false){
			alert('이미 추가한 과목입니다.');
		}
		else if(booleanTime == false){
			alert('시간이 중복되었습니다.');
		}
		else{
			
			location.href = 'insertStuTTCart.do?stuNum=' + stuNum + '&lecTtCode=' + lecTtCode;
		}
	});
	
	//과목바구니에서 과목 빼기
	$(document).on('click', '#delCart', function(){
		var stuNum = $('#stuNum').val();
		var lecTtCode = $(this).parent().parent().children(':first').text();
		location.href = 'deleteStuTTCart.do?stuNum=' + stuNum + '&lecTtCode=' + lecTtCode;
	});
	
});

/* 함수선언 영역*/
(function($){
	//학점 구하기
	sumCredit = function(){
		var sum = 0;
		$('.credit').each(function(){
			sum += parseInt($(this).html());
		});
		
		$('#sum').text(sum);
	};
	
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
	lectureTTList = function(collegeNum, depNo, recYear, lecCredit){
		$.ajax({
		      url: 'selectLecTT.do', //요청경로
		      type: 'post',
		      data: {'collegeNum':collegeNum, 'depNo':depNo, 'recYear':recYear, 'lecCredit':lecCredit}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#lecList').empty();
		    	  var str = '';
		    	  if(result.length == 0){
		    		  str += '<tr>';
		    		  str += '<td colspan="9">조건에 맞는 과목이 없습니다.</td>';
		    		  str += '</tr>';
		    	  }
		    	  else{
		    		  $(result).each(function(index, element){
		    			  var str2 = '';
		    			  
		    			  $(element.lecTimeList).each(function(index1, element1){
		    				  if(element1.lecWeek == 2) {
		                          str2+= '월';                         
		                       }
		                       else if(element1.lecWeek == 3) {
		                    	   str2+= '화';                         
		                       }
		                       else if(element1.lecWeek == 4)   {
		                    	   str2+= '수';                         
		                       }
		                       else if(element1.lecWeek == 5)   {
		                    	   str2+= '목';                         
		                       }
		                       else if(element1.lecWeek == 6)   {
		                    	   str2+= '금';                         
		                       }   
		    				  str2 += `${element1.ttSeq }교시`;
		    				  str2 += `<span style="color: blue;" class="facCode">(${element1.facCode })</span>`;
		    				  str2 += "<br>"
		    			  });
			    		  str += `<tr>`;
			    		  str += `<td>${element.lecTtCode }</td>`;
			    		  str += `<td>${element.semCode }</td>`;
			    		  str += `<td>${element.lectureName }</td>`;
			    		  str += `<td>${element.profName }</td>`;
			    		  str += `<td>${element.lecCredit }</td>`;
			    		  str += `<td>${element.recYear }학년</td>`;
			    		  str += `<td>${element.stuMaxNum }</td>`;
			    		  str += `<td>${element.stuAppNum }</td>`;
			    		  str += '<td>';
			    		  str += str2;
		    	    	  str += '</td>';
		    	    	  str += `<td><i class="icon-plus" id="cartBtn"></i></td>`
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
	//강의검색
	searchTTList = function(lecTtCode){
		$.ajax({
		      url: 'selectLecTT.do', //요청경로
		      type: 'post',
		      data: {'lecTtCode':lecTtCode}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#lecList').empty();
		    	  var str = '';
		    	  if(result.length == 0){
		    		  str += '<tr>';
		    		  str += '<td colspan="9">조건에 맞는 과목이 없습니다.</td>';
		    		  str += '</tr>';
		    	  }
		    	  else{
		    		  $(result).each(function(index, element){
		    			  var str2 = '';
		    			  
		    			  $(element.lecTimeList).each(function(index1, element1){
		    				  if(element1.lecWeek == 2) {
		                          str2+= '월';                         
		                       }
		                       else if(element1.lecWeek == 3) {
		                    	   str2+= '화';                         
		                       }
		                       else if(element1.lecWeek == 4)   {
		                    	   str2+= '수';                         
		                       }
		                       else if(element1.lecWeek == 5)   {
		                    	   str2+= '목';                         
		                       }
		                       else if(element1.lecWeek == 6)   {
		                    	   str2+= '금';                         
		                       }   
		    				  str2 += `${element1.ttSeq }교시`;
		    				  str2 += `<span style="color: blue;" class="facCode">(${element1.facCode })</span>`;
		    				  str2 += "<br>"
		    			  });
			    		  str += `<tr>`;
			    		  str += `<td>${element.lecTtCode }</td>`;
			    		  str += `<td>${element.semCode }</td>`;
			    		  str += `<td>${element.lectureName }</td>`;
			    		  str += `<td>${element.profName }</td>`;
			    		  str += `<td>${element.lecCredit }</td>`;
			    		  str += `<td>${element.recYear }학년</td>`;
			    		  str += `<td>${element.stuMaxNum }</td>`;
			    		  str += `<td>${element.stuAppNum }</td>`;
			    		  str += '<td>';
			    		  str  += str2;
		    	    	  str += '</td>';
		    	    	  str += `<td><i class="icon-plus" id="cartBtn"></i></td>`
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