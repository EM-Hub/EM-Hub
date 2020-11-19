/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	
	//수업당 학생 리스트
	$(document).on('click', '#search', function() {
		var lecCode = $('#lecSel').val();
		$.ajax({
		      url: 'lecStudentList.do', //요청경로
		      type: 'post',
		      data: {'lecCode':lecCode}, //요청경로로 던질 파라메터. '파레메터명':파라메터
		      success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
		    	  $('#studentList').empty();
					var str = '';
					str += `<table>`;
					str += `<colgroup>
							<col width="40%">
							<col width="35%">
							<col width="25%">
							</colgroup>`
					str += `<tr>`;
					str += `<td class="title2">학번</td>`;
					str += `<td class="title2">이름</td>`;
					str += `<td class="title2">성적</td>`;
					str += `</tr>`;
					if(result == '' || result == null){
						str += `<tr>
								<td colspan="4">해당 과목을 수강하는 학생이 없습니다.</td>
								</tr>`
						str += `</table>`;
					}
					else{
						$(result).each(function(index, element){
							str += '<tr>';
							str += `<td class="stuNum">${element.stuNum}</td>`;
							str += `<td>${element.stuName}</td>`;
							str += '<td>';
							str += '<select class="gradeNum">';
							str += element.gradeNum == 10 ? '<option value="10" selected>N</option>' : '<option value="10">N</option>';
							str += element.gradeNum == 1 ? '<option value="1" selected>A+</option>' : '<option value="1">A+</option>';
							str += element.gradeNum == 2 ? '<option value="2" selected>A</option>' : '<option value="2">A</option>';
							str += element.gradeNum == 3 ? '<option value="3" selected>B+</option>' : '<option value="3">B+</option>';
							str += element.gradeNum == 4 ? '<option value="4" selected>B</option>' : '<option value="4">B</option>';
							str += element.gradeNum == 5 ? '<option value="5" selected>C+</option>' : '<option value="5">C+</option>';
							str += element.gradeNum == 6 ? '<option value="6" selected>C</option>' : '<option value="6">C</option>';
							str += element.gradeNum == 7 ? '<option value="7" selected>D+</option>' : '<option value="7">D+</option>';
							str += element.gradeNum == 8 ? '<option value="8" selected>D</option>' : '<option value="8">D</option>';
							str += element.gradeNum == 9 ? '<option value="9" selected>F</option>' : '<option value="9">F</option>';
							str += '</select>';	
							str += '</td>';	
							str += '</tr>';
					});
						str += `</table>`;
						str += `<br><br>`;
						str += `<input type="button" value="성적등록" class="insertGrade">`;
					}
					$('#studentList').append(str);
		      },
		      error: function(){ //ajax통신 실패 시 실행부분
		    	  alert('오류');
		      }
		});
	});
	//성적등록
	$(document).on('click', '.insertGrade', function() {
		var stuNum = [];
		$('.stuNum').each(function(index, element){
			stuNum[index] = $(this).text();
		});
		var gradeNum = [];
		$('.gradeNum').each(function(index, element){
			gradeNum[index] = $(this).val();
		});
		
		var code = $('.ttCode:selected').text();
		var lecTtCode = code.substring(code.lastIndexOf("(")+1, code.lastIndexOf(")"));
		
		location.href = 'updateGrade.do?stuNum='+stuNum+'&gradeNum='+gradeNum+'&lecTtCode='+lecTtCode;
		alert('성적이 등록되었습니다.');
	});
});

/* 함수선언 영역*/
(function($){
	//aaa라는 함수선언
	//aaa = function(){
	
	//};
})(jQuery);