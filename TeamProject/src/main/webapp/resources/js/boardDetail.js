/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	var sideDetailNum22 = $('#d2').val();
	var mainNum22 = $('#m2').val();
	var sideNum22 = $('#s2').val();
	
	$(document).on('click', '#deleteBtn', function() {
		var boardNum = $('#btnD1').val();
		var categoryNum = $('#btnD2').val();
		
		alert('글 삭제 성공!');
		location.href = "delete.do?categoryNum="+ categoryNum+"&boardNum="+boardNum+"&mainNum="+mainNum22+"&sideNum="+sideNum22+"&sideDetailNum="+sideDetailNum22;
		
	});
	
	$(document).on('click', '#updateBtn', function() {
		var boardNum = $('#btnD1').val();
		var categoryNum = $('#btnD2').val();
		
		location.href = "updateForm.do?categoryNum="+ categoryNum+"&boardNum="+boardNum+"&mainNum="+mainNum22+"&sideNum="+sideNum22+"&sideDetailNum="+sideDetailNum22;
		
	});
	
	$(document).on('click', '#cBtn', function() {
		var boardNum = $('#btnD1').val();
		var categoryNum = $('#btnD2').val();
		
		location.href = "replyForm.do?categoryNum="+ categoryNum+"&boardNum="+boardNum+"&mainNum="+mainNum22+"&sideNum="+sideNum22+"&sideDetailNum="+sideDetailNum22;
		
	});
	
	$(".commentDelBTN").click(function(){
		var boardNum = $('#btnD1').val();
		var categoryNum = $('#btnD2').val();
		var commentNum11 = $(this).parent().parent().children(':first').val();
		alert('댓글삭제성공!');
		
		location.href = "deleteComment.do?categoryNum="+ categoryNum+"&boardNum="+boardNum+"&mainNum="+mainNum22+"&sideNum="+sideNum22+"&sideDetailNum="+sideDetailNum22+"&commentNum="+commentNum11;
	});
	
	//수정버튼 클릭
	$(document).on('click', '.upBtn', function() {
		$(this).parent().prev().children().removeAttr("readonly");
		$(this).text("확인");
		$(this).attr("class", "updateCmt");
	});
	//댓글 수정
	$(document).on('click', '.updateCmt', function() {
		var commentNum55 = $(this).parent().parent().children(':first').val();
		var commentContent11 = $(this).parent().prev().children().val();
		
		$.ajax({
		      url: 'commentUpdate.do', //요청경로
		      type: 'post',
		      async: false,
		      data: {'commentNum': commentNum55, 'commentContent': commentContent11}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  alert("수정되었습니다.");
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert("!!!!!!!!!!!!!!!!!!");
		      }
		});
		$(this).parent().prev().children().attr("readonly", true);
		$(this).removeAttr("class");
		$(this).attr("class", "upBtn");
		$(this).text('수정');
	});
	
	
	
	
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	//aaa = function(){
	
	//};
})(jQuery);