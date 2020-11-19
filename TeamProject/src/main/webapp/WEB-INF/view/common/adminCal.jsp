<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src='resources/js/adminCal.js?ver=20'></script>
<link href='resources/css/main.css?ver=7' rel='stylesheet' />
<script src='resources/js/main.js?ver=9'></script>
<script src='resources/js/ko.js'></script>
<style type="text/css">
body {
	padding: 0;
}
/* .fc .fc-col-header-cell-cushion {
  padding: 2px 4px;
} */
#calendar {
	max-width: 700px;
	font-family:'NotoSans' !important;
	font-size: 12px;
	flex: 1;
}
#scheduleList{
	width: 450px;
	font-family:'NotoSans' !important;
}
#scheduleList td{
	height: 50px;
}
.title3{
	font-size: 30px;
}
.dateTd{
	font-weight: bold;
	font-size: 20px;
	
}
.scheduleTd{
	color: #191970;
	font-size: 15px;
}
.fc-button-primary{
	    background-color: red;
}
</style>
</head>
<body>
<div style="height: 50px;"></div>
<div style="display: flex; width: 100%;">
<div style="flex: 1" align="center">
	<div id='calendar'></div>
	<br><br>
	<input type="button" data-toggle="modal" data-target="#addModal" value="일정입력">
</div>
<div style="flex: 1;" align="center">
	<table id="scheduleList">
		<colgroup>
			<col width="30%">
			<col width="70%">
		</colgroup>
		<tr height="70px">
			<td colspan="2" class="title3" align="center"><span id="ymSpan"></span></td>
		</tr>
	<tbody id="moveMonth">
	<c:forEach items="${list1 }" var="vo">
		<tr style="border-top: 1px solid #656565; border-bottom: 1px solid #656565;">
			<td align="left" class="dateTd">${vo.calStartDate } <c:if test="${not empty vo.calEndDate }">~ ${vo.calEndDate }</c:if></td>
			<td class="scheduleTd">${vo.calTitle }</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</div>
<!-- 일정 입력 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">일정 추가</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
            </button>
         </div>
         <form action="calendar.do" method="post">
         <div class="modal-body">
               <div class="form-group">
                  <label for="">일정명</label>
                  <input type="text" class="form-control" name="calTitle" placeholder="일정을 적으시오.">
               </div>
               <div class="form-group">
                  <label for="">색상</label>
                  <input type="color" class="form-control" name="calColor" placeholder="색상 지정">
               </div>
               <div class="form-group">
                  <label for="">시작일</label>
                  <input type="date" class="form-control" name="calStartDate" placeholder="시작일">
               </div>
               <div class="form-group">
                  <label for="">종료일</label>
                  <input type="date" class="form-control" name="calEndDate" placeholder="종료일">
               </div>
               	<input type="hidden" value="${side.mainNum }" name="mainNum">
				<input type="hidden" value="${side.sideNum }" name="sideNum">
				<input type="hidden" value="${side.sideDetailNum }" name="sideDetailNum">
         </div>
      	<div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
            <button type="submit" class="btn btn-primary">저장</button>
        </div>
        </form>
        
      </div>
   </div>
</div>
<br><br>
<div align="center">

</div>
</body>
</html>