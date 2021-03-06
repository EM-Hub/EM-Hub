/* 페이지 로딩 후 실행 */
flatpickr.localize(flatpickr.l10ns.ko);
flatpickr("dateSelector");

$(document).ready(function(){
//	var fromDate = '';
//	var toDate = '';
//	
	var arr = new Array();
	
	var today = new Date();
	
	$(document).on('click', '#todayBtn', function() {
		arr[0] = today;	
		arr[1] = today;
		myCal.setDate(arr, Array);
	});
	
	var before1Month = new Date();
	before1Month.setMonth(before1Month.getMonth() + 1);
	
	$(document).on('click', '#aMonthBtn', function() {
		arr[0] = before1Month;
		arr[1] = today;
		myCal.clear();
		myCal.setDate(arr, Array);
	});
	
	var before3Month = new Date();
	before3Month.setMonth(before3Month.getMonth() + 3);
	
	$(document).on('click', '#threeMonthBtn', function() {
		arr[0] = before3Month;
		arr[1] = today;
		myCal.clear();
		myCal.setDate(arr, Array);
	});
	
	var before6Month = new Date();
	before6Month.setMonth(before6Month.getMonth() + 6);
	
	$(document).on('click', '#sixMonthBtn', function() {
	
		arr[0] = before6Month;
		arr[1] = today;
		myCal.clear();
		myCal.setDate(arr, Array);
	});
	
	
	var fromD = '';
	var toD = '';
	
	
	const myCal = flatpickr("#dateSelector", {
		dateFormat: "Y-m-d",
		mode: "range", //선택 날짜 ~로 연결하기
		conjunction: '~',
		local: 'ko',
		onChange: function(selectedDates){
			
			fromD = selectedDates[0];
			if(selectedDates[1] == '' || selectedDates[1] == null){
				toD = selectedDates[0];
			}else{
				toD = selectedDates[1];
			}
			
			
		},
	});
	
	
	//selectFacListA();
	$(document).on('click', '#seachBtn', function() {
		var facCodeArr = new Array();
		
		$('.facCheck:checked').each(function(index, element){
			var facCode = $(element).val();
			facCodeArr[index] = facCode;
		});
		
		selectFacListA(fromD, toD, facCodeArr);
	});
	
	


});

/* 함수선언 영역*/
(function($){
	
	//aaa라는 함수선언
	selectFacListA = function(fromD, toD, facCodeArr){
		var fromDate = '';
		var toDate = '';
		

		if(fromD != null && fromD != '' && toD != null &&toD != ''){
			
			var yyyy1 = fromD.getFullYear().toString();
			var mm1 = (fromD.getMonth() + 1).toString();
			var dd1 = fromD.getDate().toString();
			
			var yyyy2 = toD.getFullYear().toString();
			var mm2 = (toD.getMonth() + 1).toString();
			var dd2 = toD.getDate().toString();
			
			fromDate = yyyy1 + (mm1[1] ? mm1 : '0'+mm1[0]) + (dd1[1] ? dd1 : '0'+dd1[0]);
			toDate = yyyy2 + (mm2[1] ? mm2 : '0'+mm2[0]) + (dd2[1] ? dd2 : '0'+dd2[0]);
			
		}
		
		
		
		var aa = '';
		for(var i = 0 ; i < facCodeArr.length ; i++){
				aa += facCodeArr[i] + ',';
		}
		
		//Ajax 시작
		$.ajax({
		      url: 'selectFacListA.do', //요청경로
		      type: 'post',
		      async: false,
		      data: {'fromDate': fromDate
		    	  , 'toDate' : toDate
		    	  , 'facCodeArr': aa
		    	  }, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  
		    	  
		    	  $('#resultBody').empty();
		    	  var str = '';
		    	  $(result).each(function(index, element){
		    		  var tt = element.purpose == null ? '' : element.purpose;
		    		  
		    		  str+= `  <tr> `;                                                                               
					  str+= `	<td>${element.facUseNum }</td> `;                                                      
					  str+= `	<td>${element.facName }</td>   `;                                                      
					  str+= `	<td>${element.facUseDay }</td>   `;                                                    
					  str+= `	<td>${element.ttStartTime.substring(0, 2)} : ${element.ttStartTime.substring(2, 4)} ~`; 
					  str+= `		${element.ttEndTime.substring(0, 2)} : ${element.ttEndTime.substring(2, 4)} `;      
					  str+= `	</td>    `;                                                                           
					  str+= `	<td>${element.memId }</td> `;                                                          
					  str+= `	<td>${element.userEmail }</td>  `;                                                     
					  str+= `	<td>` + tt + `</td>    `;                                                     
					  str+= `</tr>  `;                                                                        
			    	});
		    	  
		    	  $('#resultBody').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분

		      }
		});
	};
})(jQuery);

