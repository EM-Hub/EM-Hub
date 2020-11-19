<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
select{
	border: 2px solid black;
	width: 150px;
	height: 2em;
	padding-left: 3.5em;
}
#stuTTtable{
	border-collapse: collapse;
	width: 100%;
	text-align: center;
}
#stuTTtable tr, td{
	height: 45px;
}
#stuTTtable tr[class="resultTr"]:hover{
	cursor: pointer;
}
.title{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
	border: none;
}
#ttTable{
	width: 800px;
	text-align: center;
}
#ttTable td{
	border-bottom: 1px solid #F5F5F5;
	height: 60px;
}
#ttTable td:nth-child(1){
	border-bottom: 1px solid #191970;
	background: white;
	color: black;
}
#ttTable tr:nth-child(1){
	height: 25px;
	color: black;
	background: white;
	font-weight: bold;
	border: none;
	border-top: 3px solid #191970;
	border-bottom: 3px solid #191970;
}
#myTimetableDiv::-webkit-scrollbar {
   width: 10px;
}
#myTimetableDiv::-webkit-scrollbar-thumb {
  background-color: #191970;
  border-radius: 10px;
  border: 2px solid transparent;
}
#myTimetableDiv::-webkit-scrollbar-track {
  border-radius: 10px;
  box-shadow: inset 0px 0px 5px white;
}

</style>
</head>

<body>
<input type="hidden" id = "memId" value="${loginInfo.memId }"> 
<div id="mainDiv" align="center">
	<div style="padding-bottom: 20px">
		<select id="yearSelector">
			<option value ="2015">2015</option>
			<option value ="2016">2016</option>
			<option value ="2017">2017</option>
			<option value ="2018">2018</option>
			<option value ="2019">2019</option>
			<option  value ="2020" selected>2020</option>
		</select>
		<select id="semSelector">
			<option  value ="1">1학기</option>
			<option  value ="2" selected>2학기</option>
		</select>
	</div>
	<div id="myTimetableDiv" style="overflow: scroll; width: 800px; height: 200px; padding: 10px; margin-bottom: 50px">
	
	
	</div>
	<div>
		<table id ="ttTable">
			<colgroup>
				<col width="*">
				<col width="17%">
				<col width="17%">
				<col width="17%">
				<col width="17%">
				<col width="17%">
			</colgroup>
			<tr>
				<td></td>
				<td>월</td>
				<td>화</td>
				<td>수</td>
				<td>목</td>
				<td>금</td>
			</tr>
			<c:forEach items="${ttSeq }" var="tt">
				<tr class="${tt.ttSeq }tr">
					<td>${tt.ttSeq }교시<br>(${tt.ttStartTime.substring(0, 2)}:${tt.ttStartTime.substring(2, 4)} ~ ${tt.ttEndTime.substring(0, 2)}:${tt.ttEndTime.substring(2, 4)})</td>
					<td class="2 resultTd"></td>
					<td class="3 resultTd"></td>
					<td class="4 resultTd"></td>
					<td class="5 resultTd"></td>
					<td class="6 resultTd"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<script src="resources/js/stuTimetable.js?ver=100006"></script>
</body>
</html>