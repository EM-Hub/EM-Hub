/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	$(document).on('click', '.semGradeTr', function() {
		$('.semGradeTr').css('background', 'white');
		$(this).css('background', '#B5D0FB');
		
		
		var semCode = $(this).children().eq(0).text() + '0' + $(this).children().eq(1).text() ;
		
		selectGradeDetail(semCode);
		

	});
	
});

/* 함수선언 영역*/
(function($){
	selectGradeDetail = function(semCode){
		$.ajax({
		      url: 'selectGradeDetail.do', //요청경로
		      type: 'post',
		      data: {'semCode':semCode}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#gradeDetailTable').empty();
		    	  var str = '';
		    	  str += `<table id="gradeDetailTable">
		    		  		<tr>
		    		  			<td class="title2">과목번호</td>
				    		    <td class="title2">교과목명</td>
				    		    <td class="title2">담당교수</td>
				    		    <td class="title2">학점</td>
				    		    <td class="title2">등급</td>
				    		    <td class="title2">성적인정</td>
				    		    <td class="title2">비고</td>
		    		  		</tr>`;
		    		  
		    	  $(result).each(function(index, element){
		    		  var isApp = element.gradeScore == 0 ? '미인정' : '';
		    		  
		    		  str += `<tr>
				    			    <td>${element.lecTtCode }</td>
				    			  	<td>${element.lectrueName }</td>
				    			  	<td>${element.profName }</td>
				    			  	<td>${element.lecCredit }</td>
				    			    <td>${element.gradeAbc }</td>
				    			    <td>${isApp}</td>
				    			    <td></td>
		    			  	</tr>`;
		    	  });
		    	  
		    	  str += `</table>`;
		    	  
		    	  $('#gradeDetailTable').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
		});
	};
})(jQuery);