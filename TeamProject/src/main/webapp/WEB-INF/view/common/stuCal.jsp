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
<link href='resources/css/main.css?ver=3' rel='stylesheet' />
<script src='resources/js/main.js'></script>
<script src='resources/js/ko.js'></script>
<style type="text/css">
body {
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}
/* .fc .fc-col-header-cell-cushion {
  padding: 2px 4px;
} */
#calendar{
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
</style>
</head>
<body>
<div style="height: 50px;"></div>
<div style="display: flex;">
<div style="flex: 1">
	<div id='calendar'></div>
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
	
<div style="height: 100px;"></div>
</body>
</html>