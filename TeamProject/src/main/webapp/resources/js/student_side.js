/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	var mainNum = $('#mainNum').val();
	var sideDetailNum = $('#sideDetailNum').val();
	
	selectSideMenu1(mainNum);
	selectMainMenuSide(mainNum);
	
	if($('#sideNum').val() == 0){
		var aa = $('#aaaaa').children().first();
		
		var selector = $(aa).next();
		var sideNum = $(aa).children(':first').val();
		
		selectMenuDetail1(mainNum, sideNum, selector);
		
		$(aa).children(':last').children().attr('class', 'remove');
		$(aa).children(':last').children().attr('class', 'icon-minus aa');
		$(aa).css('background', '#191970');
		$(aa).css('color', 'white');
		
		
	}else{
		 $('.sideNum').each(function(index, element){
	  		 if( $(element).val() == $('#sideNum').val()){
	  			 var selector = $(element).parent().next();
	  			 var sideNum = $(element).val();
	  			 
	  			 selectMenuDetail1(mainNum, sideNum, selector);
	  			 
	  			$(element).parent().children(':last').children().attr('class', 'remove');
	  			$(element).parent().children(':last').children().attr('class', 'icon-minus aa');
	  			$(element).parent().css('background', '#191970');
	  			$(element).parent().css('color', 'white');
	  		 }
	  			 
		 });	  
	}

	
	$(document).on('click', '.dropdownlink', function() {
		var selector = $(this).next();
		var sideNum = $(this).children(':first').val();
		
		selectMenuDetail1(mainNum, sideNum, selector);
		
		if($(this).children(':last').children().attr('class') == 'icon-minus aa'){
			$(this).children(':last').children().attr('class', 'remove');
			$(this).children(':last').children().attr('class', 'icon-plus aa');
			$(this).css('background', 'white');
			$(this).css('color', '#191970');
			$('.submenuItems').empty();
		}
		else if($(this).children(':last').children().attr('class') == 'icon-plus aa'){
			$('.aa').attr('class', 'icon-plus aa');
			$('.dropdownlink').css('background', 'white');
			$('.dropdownlink').css('color', '#191970');
			$(this).children(':last').children().attr('class', 'remove');
			$(this).children(':last').children().attr('class', 'icon-minus aa');
			$(this).css('background', '#191970');
			$(this).css('color', 'white');
		}
	});
	
	
});

/* 함수선언 영역*/
(function($){
	selectSideMenu1 = function(mainNum){
		//Ajax 시작
		$.ajax({
		      url: 'selectSideMenu.do', //요청경로
		      type: 'post',
		      async: false,
		      data: {'mainNum': mainNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  
		    	  
		    	  $('#aaaaa').empty();
		    	  
		    	  var str = '';
		    	  $(result).each(function(index, element){
		  		  str += ` <div class="dropdownlink" style="border-bottom: 1px solid #f2f2f2;">`;
		  		  str += ` <input type="hidden" value="${element.sideNum}" class="sideNum">`;
		  		  str += ` <div style="width: 70%; display: inline-block; padding-left: 20px; font-family:'NotoSans' !important;" 
		  			  		onclick="location.href='${element.menuUrl }?mainNum=${element.mainNum}&sideNum=${element.sideNum}'">`;
		  		  str += ` 		<span>${element.sideName }</span>`;
		  		  str += ` 	</div>`;
		  		  str += ` 	<div style="width: 30%; display: inline-block; float: right;" align="right">`;
		  		  str += ` 		<i class="icon-plus aa" ></i>`;
		  		  str += ` 	</div>`;
		  		  str += ` </div>`;
		  		  str += ` <ul class="submenuItems">`;
		  		  str += ` </ul>`;
		  		  
			    	});
		    	  
		    	  $('#aaaaa').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		      }
		});
	};
	selectMenuDetail1 = function(mainNum, sideNum, selector){
		//Ajax 시작
		$.ajax({
			url: 'selectMenuDetail1.do', //요청경로
			type: 'post',
			async: false,
			data: {'mainNum': mainNum
				, 'sideNum' : sideNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				
				$('.submenuItems').empty(str);
				var str = '';
				 
				$(result).each(function(index, element){
					str += `<a href=${element.menuUrl }?mainNum=${element.mainNum}&sideNum=${element.sideNum}&sideDetailNum=${element.sideDetailNum}><li  style="color: black; display: inline-block; font-family:'NotoSans' !important; font-size: 15px; padding-left:20px;">
							${element.sideDetailName }</li></a><br><br>`;

				});
				
	
				$(selector).append(str);
			},
			error: function(){ //ajax통신 실패 시 실행부분
			}
		});
	};
	
	selectMainMenuSide = function(mainNum){
		//Ajax 시작
		$.ajax({
			url: 'selectMainMenuSide.do', //요청경로
			type: 'post',
			async: false,
			data: {'mainNum': mainNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				
				$('#sideName').empty(str);
				
				var str = '';
				 
				$(result).each(function(index, element){
					str += `<div id="sideName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${element.mainName}</div>`;
				});

				$('#sideName').append(str);
			},
			error: function(){ //ajax통신 실패 시 실행부분
			}
		});
	};
	
})(jQuery);