<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/commonTable.css?ver=12"/>
<style type="text/css">
table{
	width: 600px;
}
table td{
	height: 50px;
}
i:hover {
	cursor: pointer;
}
input, select{
	margin-right: 10px;
}
</style>
</head>
<body>
<div align="center">
<div>
	<h2 style="margin: 30px; font-weight: bold;  margin-right: 520px">● 정보 확인</h2>
	<table id="t1">
		<tr>
			<td class="title">강의코드</td>
			<td id="lecCode">${lecture.lecCode }</td>
			<td class="title">개설학과</td>
			<td>${lecture.depName }</td>
		</tr>
		<tr>
			<td class="title">강의명</td>
			<td colspan="3" id="lecName">${lecture.lectureName }</td>
		</tr>
		<tr>
			<td class="title">담당교수</td>
			<td>${lecture.profName }(${lecture.profNum })</td>
			<td class="title">담당조교</td>
			<td>${lecture.asstName }(${lecture.asstNum })</td>
		</tr>
		<tr>
			<td class="title">학점</td>
			<td>${lecture.lecCredit }</td>
			<td class="title">권장학년</td>
			<td>${lecture.recYear }</td>
		</tr>
		<tr>
			<td class="title">강의계획서</td>			
			<td colspan="3">${lecture.attachment }<input type="button" value="미리보기" style="margin-left: 20px" id="viewerBtn" data-attachment = "${lecture.attachment }"></td>
		</tr>
	
	</table>
</div>
<div>
	<h2 style="margin: 30px; font-weight: bold; margin-top: 80px; margin-right: 450px">● 세부 정보 입력</h2>
	<table style="width: 600px">
		<tr>
			<td class="title">학기</td>
			<td>
			<select name="sem1" id ="sem1">
				<option value = "2016">2016</option>
				<option value = "2017">2017</option>
				<option value = "2018">2018</option>
				<option value = "2019">2019</option>
				<option value = "2020">2020</option>
			</select>년도
			<select name="sem2" id ="sem2">
				<option value = "1">1</option>
				<option value = "2">2</option>
			</select>학기
			</td>
			<td class="title">정원</td>
			<td><input type="number" id="stuMaxNum" name="stuMaxNum" value="1" min="1" max="300" style="width: 20%;">명</td>
		</tr>
	</table>
	<div style="height: 10px"></div>
	<table id="timeTable">
		<colgroup>
			<col width="45%">
			<col width="45%">
			<col width="10%">
		</colgroup>
		<tr style="font-weight: bold;" id="addTime">
			<td class="title" >강의 일시</td>
			<td class="title"style="border-left: 0px">강의실</td>
			<td style="background-color: #191970;"><i class="icon-plus" id="plusBtn" style="color: white;"></i><td>
		</tr>
	</table>
	<div style="margin: 20px">
	<input type="button" value="개설하기" id="openLecDo">
	<input type="button" value="뒤로가기" onclick="history.back()">
	</div>
</div>


</div>
<script src="resources/js/openLec2.js?ver=6"></script>
</body>
</html>