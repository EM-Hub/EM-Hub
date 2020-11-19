<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/commonTable.css?ver=12"/>
<style type="text/css">
#totalTable{
	width: 600px
}
#totalTable tr{
	height: 40px
}

#semGradeTable{
	width: 800px;
	text-align: center;
}
#semGradeTable td{
	border-bottom: 1px solid #F5F5F5;
	height: 40px;
}
#semGradeTable .title2{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
}
#semGradeTable tr:hover{
	background: #B5D0FB;
}
#semGradeTable tr, td{
	border: none;
}
#semGradeTableDiv::-webkit-scrollbar {
   width: 10px;
}
#semGradeTableDiv::-webkit-scrollbar-thumb {
  background-color: #191970;
  border-radius: 10px;
  border: 2px solid transparent;
}
#semGradeTableDiv::-webkit-scrollbar-track {
  border-radius: 10px;
  box-shadow: inset 0px 0px 5px white;
}


#gradeDetailTable{
	width: 800px;
	text-align: center;
}
#gradeDetailTable td{
	border-bottom: 1px solid #F5F5F5;
	height: 40px;
}
#gradeDetailTable .title2{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
}
#gradeDetailTable tr, td{
	border: none;
}
</style>
</head>
<body>
<div align="center">
	<table id="totalTable">
		<colgroup>
			<col width="30%">
			<col width="20%">
			<col width="30%">
			<col width="20%">
		</colgroup>
		<tr>
			<td class="title">총취득학점</td>
			<td>${totalGrade.semTotalCredit }</td>
			<td class="title">총평점평균</td>
			<td>${totalGrade.semAvgGrade }</td>
		</tr>
	</table>
	<div style="height: 40px"></div>
	<div id="semGradeTableDiv" style="overflow: scroll; width: 1000px; height: 200px; padding: 10px; margin-bottom: 50px">
	<table id="semGradeTable">
		<colgroup>
			<col width="20%">
			<col width="20%">
			<col width="20%">
			<col width="20%">
			<col width="20%">
		</colgroup>
		<tr>
			<td class="title2">년도</td>
			<td class="title2">학기</td>
			<td class="title2">신청학점</td>
			<td class="title2">취득학점</td>
			<td class="title2">평점평균</td>
		</tr>
		<c:forEach items="${semGradeList }" var="semGrade">
			<tr class="semGradeTr">
				<td>${semGrade.semCode.toString().substring(0, 4) }</td>
				<td>${semGrade.semCode.toString().substring(5, 6) }</td>
				<td>${semGrade.semTotalCredit }</td>
				<td>${semGrade.acqiredCredit }</td>
				<td>${semGrade.semAvgGrade }</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div style="height: 40px"></div>
	<div id = "gradeDetailTable">
		
	</div>
</div>

<script src="resources/js/stuGrade.js?ver=1"></script>
</body>
</html>