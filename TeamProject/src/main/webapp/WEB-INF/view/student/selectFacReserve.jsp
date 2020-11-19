<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/commonTable.css?ver=12"/>
<style type="text/css">
body{
	font-size: 15px;
}
#searchTable{
	width: 800px;
	height: 100px;
	border: 1px solid black;
	vertical-align: middle;
	padding: 10px;
}

#searchTable tr{
	height: 50px
}

input[type=text] {
	margin: 5px;
	height: 30px;
}

input[type=checkbox] {
	margin: 5px
}

input[type=button]{
	width:4.8em;
	height: 1.8em;
	margin: 5px;
}
#resultTable{
	width: 1000px;
	text-align: center;
}
#resultTable td{
	border-bottom: 1px solid #F5F5F5;
	height: 60px;
}
#resultTable .title2{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
}
#resultTable tr:nth-child(even){
	background: #f2f2f2;
}
#resultTable tr:hover{
	background: #B5D0FB;
}
#resultTable tr, td{
	border: none;
}
</style>
</head>
<body>
<div id = "mainDiv" align="center">
	<table id="searchTable">
		<colgroup>
			<col width="18%">
			<col width="*%">
		</colgroup>
		<tr>
			<td class="title" align="center">기간별 조회</td>
			<td>
				<i class="icon-calendar-1" id="calIcon" style="font-size: 20px"></i>
				<input type="text" class="dateSelector" id="dateSelector" placeholder="검색 범위를 설정하세요...">
				<input type="button" value="오늘" id="todayBtn">
				<input type="button" value="1개월" id="aMonthBtn">
				<input type="button" value="3개월" id="threeMonthBtn">
				<input type="button" value="6개월" id="sixMonthBtn">
			</td>
		</tr>
		<tr>
			<td class="title" align="center">시설별조회</td>
			<td>
				<input type="checkbox" class = "facCheck" value="OUT1" >운동장
				<input type="checkbox" class = "facCheck" value="OUT2">실내체육관
				<input type="checkbox" class = "facCheck" value="OUT3">회의실
				<input type="checkbox" class = "facCheck" value="OUT4">대강당
				<input type="checkbox" class = "facCheck" value="OUT5">멀티미디어실
			</td>
		</tr>
	</table>
		<input type="button" id="seachBtn" value="검색하기" style="padding-right: 5px;margin-top:10px; width: 5.1em; height: 2.5em">

	<div style="height: 50px"></div>
	<div id="div4select">
		<table id="resultTable">
			<tr>
				<td class="title2">No.</td>
				<td class="title2">시설명</td>
				<td class="title2">이용일자</td>
				<td class="title2">시간</td>
				<td class="title2">신청자(학번/교직원번호)</td>
				<td class="title2">연락처</td>
				<td class="title2">이용목적</td>
			</tr>
			<tbody id="resultBody">
			<c:forEach items="${useList }" var="facUse">
				<tr>
					 <td>${facUse.facUseNum }</td>
					<td>${facUse.facName }</td>
					<td>${facUse.facUseDay }</td>
					<td >${facUse.ttStartTime.substring(0, 2)} : ${facUse.ttStartTime.substring(2, 4)} ~ ${facUse.ttEndTime.substring(0, 2)} : ${facUse.ttEndTime.substring(2, 4)}</td>
					<td>${facUse.memId }</td>
					<td>${facUse.userEmail }</td>
					<td>${facUse.purpose }</td>
				</tr>
			
			</c:forEach>
			</tbody>
		
		</table>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://npmcdn.com/flatpickr/dist/flatpickr.min.js"></script>
<script src="https://npmcdn.com/flatpickr/dist/l10n/ko.js"></script>
<script src="resources/js/selectFacReserve.js?ver=46"></script>
</body>
</html>