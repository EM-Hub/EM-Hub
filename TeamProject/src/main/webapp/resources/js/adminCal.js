/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	adminCalendar();
	
	$(document).on('click', '.fc-next-button', function() {
		var calcal22 = $('.fc-toolbar-title').text();
		var calYear22 = calcal22.substring(0,4);
		var calMonth22 = '';
		if(calcal22.length == 9){
			calMonth22 = calcal22.substring(6,8);
		}
		else if(calcal22.length == 8){
			calMonth22 = 0+ calcal22.substring(6,7);
		}
		
		var calTYM22 = calYear22+calMonth22;
		$('#ymSpan').text(calYear22 + '.' +calMonth22);
		//Ajax 시작
	      $.ajax({
	            url: 'selectMonth.do', //요청경로
	            type: 'post',
	            async: false,
	            data: {'calStartDate' :calTYM22}, //요청경로로 던질 파라메터. '파레메터명':파라메터
	            success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
	            
	                $('#moveMonth').empty();
	                var str = '';
	                $(result).each(function(index, element){
	                    /*str += `<tr>`;
	                    str += `<td>${element.calTitle }</td>`
	                    str += `<td>${element.calStartDate }</td>`
	                    str += `<td>${element.calEndDate }</td>`
	                    str += `</tr>`;*/
	                   str += `<tr style="border-top: 1px solid #656565; border-bottom: 1px solid #656565;">
	                	<td align="left" class="dateTd">${element.calStartDate }`; 
	                	   if (element.calEndDate != null){
	                		   str += `~ ${element.calEndDate }`;
	                	   }
	                	str += `</td>`;
	        			str += `<td class="scheduleTd">${element.calTitle }</td>`
	                	str += `</tr>`;
	                 });
	            	
	                $('#moveMonth').append(str);
	            },
	            error: function(){ //ajax통신 실패 시 실행부분
	               alert('ajax 통신 오류');
	            }
	      });
		
	});
	
	$(document).on('click', '.fc-prev-button', function() {
		var calcal22 = $('.fc-toolbar-title').text();
		var calYear22 = calcal22.substring(0,4);
		var calMonth22 = '';
		if(calcal22.length == 9){
			calMonth22 = calcal22.substring(6,8);
		}
		else if(calcal22.length == 8){
			calMonth22 = 0+ calcal22.substring(6,7);
		}
		
		var calTYM22 = calYear22+calMonth22;
		$('#ymSpan').text(calYear22 + '.' +calMonth22);
		//Ajax 시작
	      $.ajax({
	            url: 'selectMonth.do', //요청경로
	            type: 'post',
	            async: false,
	            data: {'calStartDate' :calTYM22}, //요청경로로 던질 파라메터. '파레메터명':파라메터
	            success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
	            
	                $('#moveMonth').empty();
	                var str = '';
	                $(result).each(function(index, element){
	                	str += `<tr style="border-top: 1px solid #656565; border-bottom: 1px solid #656565;">
		                	<td align="left" class="dateTd">${element.calStartDate }`; 
	                	   if (element.calEndDate != null){
	                		   str += `~ ${element.calEndDate }`;
	                	   }
	                	str += `</td>`;
	        			str += `<td class="scheduleTd">${element.calTitle }</td>`
	                	str += `</tr>`;
	                   
	                 });
	            	
	                $('#moveMonth').append(str);
	            },
	            error: function(){ //ajax통신 실패 시 실행부분
	               alert('ajax 통신 오류');
	            }
	      });
	});
  
  
});

/* 함수선언 영역*/
(function($){
	//화면 로딩 시 캘린더 초기화
	adminCalendar = function(){
		$.ajax({
		      url: 'adminAjax.do', //요청경로
		      type: 'post',
		      data: {}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.

		    	  var str = '';
		    	  if(result == ''){
		    		  str = '[]';
		    	  }
		    	  else{
		    		  
		    	  str = '[';
		    	  $(result).each(function(index, element){
		    		  str += '{"id":"' + element.calId + '", "title":"' + element.calTitle + '", "start":"' + element.calStartDate + '", "end":"' + element.calEndDate + '" , "color":"' + element.calColor + '" },';
		    	  });
		    	  str = str.substr(0, str.length-1);
		    	  str += ']';
		    	  
		    	  }
		    	  var calendarObj = JSON.parse(str);
		    	  
		    	  var calendarEl = document.getElementById('calendar');

			  		var calendar = new FullCalendar.Calendar(calendarEl, {
			  			googleCalendarApiKey: 'AIzaSyDUbC679dvw8Tqsb_6hZoK2UWykkvPGmKo',
			  			headerToolbar : {
			  				left : 'prev,next',
			  				center : 'title',
			  				right : 'today'
			  			},
			  			locale : 'ko',
			  			dayMaxEvents: true, // allow "more" link when too many events
			  			eventSources: [
			  			    {
			  			          googleCalendarId: 'ltm0jrlsamv8mlhrg0bpcgu6ps@group.calendar.google.com',
			  			          className: '공휴일',
			  			          color: 'red', 
			  			          //textColor: 'black' 
			  			    }
			  			],
			  			events:calendarObj
			  			,
			  			eventClick: function(event) {
			  				
			  		        if (confirm('일정을 지우시겠습니까?')) {
			  		        	
			  		        	deleteCal(event.event.id); //삭제
			  		        	
			  		        	
			  		        	event.event.remove();
			  		        }
			  		    },
			  		});
			  		calendar.render();
			  		var calcal33 = $('.fc-toolbar-title').text();
				  	var calYear33 = calcal33.substring(0,4);
				  	var calMonth33 = calcal33.substring(6,8);
				  	$('#ymSpan').text(calYear33 + '.' +calMonth33);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
		});
	};//end initCalendar
	
	deleteCal = function(id){
		$.ajax({
		      url: 'deleteAjax.do', //요청경로
		      type: 'post',
		      data: {'calId':id}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  alert('삭제 성공!');
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
		});
	};
	
})(jQuery);
