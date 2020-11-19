<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
hr{
	border: 2px solid #82C5AF;
}
#table1{
	width: 1000px;
	height: 180px;
	text-align: center;
	border: 1px solid #bfbfbf;
}
tr, td{
	border: 1px solid #bfbfbf;
}
#table2{
	width: 1000px;
	height: 45px;
	text-align: center;
}
.title{
	background: #F5F5F5;
	border-left: 3px solid #526ca2;
	color: #526ca2;
	font-size: 15px;
	font-weight: bold;
}
input[type="text"]{
	border: none;
	widows: 100%;
	text-align: center;
	outline: none;
}
</style>
</head>
<body>
<div style="width: 100%; height:auto; padding: 15px;" align="center">
<form action="returningToSchool.do" method="post" id="Rts">
	<table id="table1">
		<colgroup>
			<col width="10%">
			<col width="10%">
			<col width="20%">
			<col width="10%">
			<col width="20%">
			<col width="10%">
			<col width="20%">
		<tr>
			<td rowspan="3"><img src="resources/images/${myInfo.memPhoto }" width="150px" height="179px"></td>
			<td class="title">이 름</td>
			<td>${myInfo.stuName }</td>
			<td class="title">학 번</td>
			<td><input type="text" value="${myInfo.stuNum }" name="stuNum" readonly id="stuNum"></td>
			<td class="title">학 년</td>
			<td>${myInfo.stuYear }</td>
		</tr>
		<tr>
			<td class="title">대 학</td>
			<td >${myInfo.collegeName }</td>
			<td class="title">전 공</td>
			<td>${myInfo.depName }</td>
			<td class="title">부전공</td>
			<c:choose>
				<c:when test="${myInfo.depName2 eq null || myInfo.depName2 eq '0'}">
					<td></td>
				</c:when>
				<c:otherwise>
					<td>${myInfo.depName2 }</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td class="title">생일</td>
			<td>${myInfo.memBirthday }</td>
			<td class="title">학적상태</td>
			<td><input type="text" value="${myInfo.memStatus }" readonly>
				<input type="hidden" value="${myInfo.statusNum }" name="fromStatus" id="fromStatus">
			</td>
			<td class="title"></td>
			<td></td>
		</tr>
	</table>
	<input type="hidden" value="1" name="toStatus">
	<br><br>
	<input type="button" value="복학신청" style="width: 5em; height: 2em;" id="RtsBtn">
</form>
</div>
<script src="resources/js/returningToSchool.js?ver=4"></script>
</body>
</html>