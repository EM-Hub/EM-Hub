/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	var thisSemCode = $('#yearSelector').val() + '0' + $('#semSelector').val();
	var memId = $('#memId').val();
	selectMyTimetable(memId, thisSemCode);
	//수강신청
	$(document).on('change', '#yearSelector, #semSelector', function() {
		var semCode = $('#yearSelector').val() + '0' + $('#semSelector').val();

		selectMyTimetable(memId, semCode);
	});
	
	$(document).on('click', '#stuTTtable tr[class="resultTr"]', function() {
		$('#stuTTtable tr').css('border', 'none');
		$('#stuTTtable tr').css('background', 'white');
		$(this).css('background', '#f2f2f2');
		
		var stuTtCode = $(this).children(':first').text() + 'ttCode';
		$('.exist').css('background', 'white');
		$('.'+stuTtCode).css('background', '#e9f2f9');
	});
	
	//colorTd();
});

/* 함수선언 영역*/
(function($){
	 selectMyTimetable = function(memId, semCode){
		 $('.exist').each(function(index, element){
			 var dayOweek = $(this).attr('class');
			 $(this).empty();
			 $(this).attr('class', dayOweek);
			 $(this).css('background', 'white');
		 });
		 var stuNumArr = [];
	      //Ajax 시작
	      $.ajax({
	            url: 'selectMyTimetable.do', //요청경로
	            type: 'post',
	            async: false,
	            data: {'memId': memId
	                  , 'semCode': semCode}, //요청경로로 던질 파라메터. '파레메터명':파라메터
	            success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
	            	$('#myTimetableDiv').empty();
	              
	               var str = '';
	               str += '<table id="stuTTtable">';
	               str += '<colgroup>';
	               str += '<col width="10%">';
	               str += '<col width="30%">';
	               str += '<col width="10%">';
	               str += '<col width="20%">';
	               str += '<col width="*">';
	               str += '</colgroup>';
	               
	               str += `<tr>`;
	               str += `<td class="title">No.</td>`;
	               str += `<td class="title">강의명</td>`;
	               str += `<td class="title">학점</td>`;
	               str += `<td class="title">담당교수</td>`;
	               str += `<td class="title">시간표</td>`;
	               str += `</tr>`;
	               
	               
	               
	               $(result).each(function(index, element){
	            	   
	            	   var str2 = '';
	            	   var dayOweek = '';
	            	   var timeSeq = '';
	            	   var info = '';
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
		            		   str2 += ` (${element1.facCode })`;
		            		   str2 += "<br>";
		            		   
		            		   timeSeq = element1.ttSeq+'tr';
		            		   dayOweek = element1.lecWeek;
		            		   
		            		   
		            		   
		            		   
		            		   info = element.lectureName + '<br>'+ element.profName +'<br>'+ element1.facCode;
		            		   $('.'+timeSeq).find('.' + dayOweek).append(info);
		            		   $('.'+timeSeq).find('.' + dayOweek).attr('class', dayOweek + ' exist ' + element.stuTtCode+'ttCode');
		            	   });
	            	   str += `<tr class="resultTr">`;
	            	   str += `<td>${element.stuTtCode}</td>`;
	            	   str += `<td>${element.lectureName}</td>`;
	            	   str += `<td>${element.lecCredit}</td>`;
	            	   str += `<td>${element.profName}</td>`;
	            	   str += '<td>';
		    		  str += str2;
	    	    	  str += '</td>';
	            	   str += `</tr>`;

	            	   stuNumArr[index] = element.stuTtCode;
	                });
	               
	               str += '</table>';
	               $('#myTimetableDiv').append(str);
	               
	               colorTd(stuNumArr);

	            },
	            error: function(){ //ajax통신 실패 시 실행부분
	               alert('ajax 통신 오류');
	            }
	      });
	   };
	   
   colorTd = function(stuNumArr){
	   var letters = ['#EFCCCC', '#E1F7CB', '#FCFCD4', '#FF7238', '#CCF3F7', '#EAD9FA', '#FADDB5', '#E8EAEA', '#D5C6FA', '#B59F9A', '#EFF708']; 
	   var aa = stuNumArr.length;

	   for(var i = 0 ; i < aa ; i++){
		   
		   $('.' + stuNumArr[i] + 'ttCode').css('background', letters[i]);
	   }
   };
})(jQuery);