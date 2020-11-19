/* 페이지 로딩 후 실행 */
$(document).ready(function(){

	
	var mainNum = $('#mainNum').val();
	var sideNum = $('#sideNum').val();
	var sideDetailNum = $('#sideDetailNum').val();
	
	
	
	clickMenuTitle(mainNum,sideNum,sideDetailNum);

	
	
});
/* 함수선언 영역*/
(function($){
	
	clickMenuTitle = function(mainNum,sideNum,sideDetailNum) {
		//Ajax 시작
		$.ajax({
			url: 'clickMenuTitle.do', //요청경로
			type: 'post',
			async: false,
			data: {'mainNum' : mainNum , 'sideNum' :sideNum , 'sideDetailNum':sideDetailNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				$('.bodyTitle').empty(str);
				
				var str = '';
				
				
					str += `<div class="bodyTitle" style="height: 160px; width: 50%; display:inline-block; padding-left: 25px; line-height: 160px; font-family:'NotoSans' !important;">`;
				$(result).each(function(index, element){
					if(index == 0) {
						if(element.sideDetailName != null)	{
							str +=`<span style="font-size: 36px; font-weight: bold;">${element.sideDetailName }</span>`;									
							str +=	`</div>`;
							str +=		`<div style="width: 50%; height: 160px; display: inline-block; float: right; padding-right: 10%; font-size: 16px;" align="right">`;				
							str +=		`<span>${element.mainName }</span>&nbsp;<span>></span>&nbsp;<span>${element.sideName }</span>&nbsp;<span>></span>&nbsp;<span>${element.sideDetailName }</span>`;			
							str +=	`</div>`;
						}					
						else if(element.sideDetailName == null)	{
							str +=`<span style="font-size: 36px; font-weight: bold;">${element.sideName }</span>`;
							str +=	`</div>`;
							str +=		`<div style="width: 50%; height: 160px; display: inline-block; float: right; padding-right: 10%; font-size: 16px;" align="right">`;				
							str +=		`<span>${element.mainName }</span>&nbsp;<span>></span>&nbsp;<span>${element.sideName }</span>&nbsp;<span>`;			
							str +=	`</div>`;
						}

					}
				});		
				
				$('.bodyTitle').append(str);
			},
			error: function(){ //ajax통신 실패 시 실행부분
				alert("오류ㅠㅜ11!");
			}
		});
	};
	
/*	
	
	clickMenuTitle2 = function(mainNum,sideNum) {
		//Ajax 시작
		$.ajax({
			url: 'clickMenuTitle2.do', //요청경로
			type: 'post',
			async: false,
			data: {'mainNum' : mainNum,'sideNum':sideNum}, //요청경로로 던질 파라메터. '파레메터명':파라메터
			success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
				$('.bodyTitle').empty(str);
				
				var str = '';

					str += `<div class="bodyTitle" style="height: 160px; width: 50%; display:inline-block; padding-left: 25px; line-height: 160px; font-family:'NotoSans' !important;">`;
				$(result).each(function(index, element){
					if(index == 0) {
					if(element.sideDetailNum == null && element.sideDetailName != null){
						str +=`<span style="font-size: 36px; font-weight: bold;">${element.sideDetailName }</span>`;
					}
					else {
						str +=`<span style="font-size: 36px; font-weight: bold;">${element.sideName }</span>`;
					}											
						
					str +=	`</div>`;
					str +=		`<div style="width: 50%; height: 160px; display: inline-block; float: right; padding-right: 10%; font-size: 16px;" align="right">`;				
					str +=		`<span>${element.mainName }</span>&nbsp;<span>></span>&nbsp;<span>${element.sideName }</span>&nbsp;<span>></span>&nbsp;<span>${element.sideDetailName }</span>`;			
					str +=	`</div>`;
					}
				});		
				
				$('.bodyTitle').append(str);
			},
			error: function(){ //ajax통신 실패 시 실행부분
				alert("오류ㅠㅜ11!");
			}
		});
	};
	
	*/

})(jQuery);