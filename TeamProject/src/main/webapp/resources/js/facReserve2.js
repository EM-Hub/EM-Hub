/* 페이지 로딩 후 실행 */
$(document).ready(function(){
   
   $('#alertDiv').hide();
   $('#regFormDiv').hide();
   
  
   //클릭 이벤트
   $(document).on('click', '.iconDiv', function() {
      $('.iconDiv').css('background', '#e9f2f9');
      $('.iconDiv').attr('class', 'iconDiv');
      
      $(this).css('background', '#ffd255');
      $(this).attr('class', 'iconDiv aa');
      
      
      var facCode = $(this).children(':first').val();
      var date = $('.day-active').attr('data-fdate');
      
      if(date != null && date != ''){
         selectFacCondition(facCode, date);
      } 
   });
   
   $(document).on('click', '.day', function() {
//      var date = new Date();
//      var year = date.getFullYear(); 
//      var month = new String(date.getMonth()+1); 
//      var day = new String(date.getDate());
//      var today = year + month + day;
      
	   var dateff = $('.today').attr('data-fdate');
      var datevv = $('.day-active').attr('data-fdate');
      var dateArr = datevv.split('.');
      var dateA = dateArr[0] + dateArr[1] + dateArr[2];
      
      var facCode = $('.aa').children(':first').val();
      
      if(datevv < dateff){
         alert('지난 날짜의 예약은 불가능합니다.')
         $('.day-active').attr('class', 'day')
         
         $('#tableDiv').empty();
         $('#alertDiv').hide();
         $('#regFormDiv').hide();
         
      }else{
         if(facCode != null && facCode !=''){
            selectFacCondition(facCode, date);
         }
      }
      
   });
   $(document).on('click', '.possible', function() {
      var ttSeq = $(this).closest('tr').children(':first').attr('data-ttSeq');
      var ttTime = $(this).closest('tr').children(':first').text();
      var facCode = $('.aa').children(':first').val();
      
      var date = $('.day-active').attr('data-fdate');
      
      var useDate = date + '(' +$(this).closest('tr').find('.title').text() + ')';
      $('#facUseDate').val(useDate);
      
      $('#facUseDay').val(date);
      $('#ttSeq').val(ttSeq);
      $('#facCode').val(facCode);
      
      $('#alertDiv').hide();
      $('#regFormDiv').show();
   });
   
});

/* 함수선언 영역*/
(function($){
   selectFacCondition = function(facCode, date){
      //Ajax 시작
      $.ajax({
            url: 'selectFacCondition.do', //요청경로
            type: 'post',
            async: false,
            data: {'facCode': facCode
                  , 'facUseDay': date}, //요청경로로 던질 파라메터. '파레메터명':파라메터
            success: function(result) { // ajax 통신 성공 시 실행부분. result가 결과 데이터를 가진다.
               
               $('#tableDiv').empty();
               var str = '';
               str += '<table id="conTable">';
               $(result).each(function(index, element){
                 
                     var tt = element.isReserved == 'Y' ? '<td style="color:red">예약불가</td>' : '<td style="color:blue" class="possible">예약가능</td>';
                  
                   str += `<tr>`;
                   str +=    `<td class="title" data-ttSeq="${element.ttSeq}">${element.ttStartTime.substring(0, 2)}:${element.ttStartTime.substring(2, 4)} ~ ${element.ttEndTime.substring(0, 2)}:${element.ttEndTime.substring(2, 4)}</td>`;
                   str +=    tt;
                   str += `</tr>`;
                });
               
               
               $('#tableDiv').append(str);
               $('#alertDiv').show();
             $('#regFormDiv').hide();
            },
            error: function(){ //ajax통신 실패 시 실행부분
               alert('ajax 통신 오류');
            }
      });
   };
})(jQuery);