<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
<form action="dropOut.do" method="post" id="dropOut">
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
	<br><br>
	<div style="width: 100%; height: auto; padding: 15px; padding-left: 25px; margin-top: 30px;" align="left">
		<span style="font-size: 24px; font-family:'NotoSans' !important; font-weight: bold;">자퇴신청 유의사항</span>
	</div>
	<div style="width: 85%; height: auto; color: red;" align="left">
	<pre style="border: none; color: red; line-height: 3">
1. 자진퇴학을 원하는 학생은 자진퇴학을 신청한 후 7일이내 신청서를 출력하여 학부(과)장, 학생복지팀(장학수혜확인), 
   도서관(도서대출확인)을 경유하여 학사관리팀에 제출하여야 처리가 완료된다.
   (대학원은 각 대학원교학행정실로 제출)
2. 등록금 반환은 학사운영규정에 명시된 등록금 반환규정에 의거하여 반환된다.
3. 등록금 반환 신청사항 기재시 예금주는 보호자 또는 본인 명의로 기재하여야 한다.
4. 기숙사는 자진퇴학 시 일주일 이내에 퇴사하여야 하며, 퇴사 시 퇴사원서는 UWINS를 통해 제출해야 환불이 가능하다.
	</pre>
	<br><br>
	</div>
		<input type="checkbox" class="checkB" value="6" name="toStatus">&nbsp;&nbsp;동의함
		<br><br>
		<input type="button" value="자퇴신청" style="width: 5em;" id="DropBtn">
		<br><br>
</form>
</div>
<script src="resources/js/dropOut.js?ver=3"></script>
</body>
</html>