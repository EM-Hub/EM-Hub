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
<form action="leaveOfAbsence.do" method="post" id="leaveOfAbsence">
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
	<table id="table2">
		<colgroup>
			<col width="15%">
			<col width="35%">
			<col width="15%">
			<col width="35%">
		</colgroup>
		<tr>
			<td class="title">휴학구분</td>
			<td>
				<input type="radio" value="2" name="toStatus" checked>일반휴학&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" value="2" name="toStatus">군휴학
			</td>
			<td class="title">일반휴학수</td>
			<td>1 학기</td>
		</tr>
	</table>
	<br><br>
	<div style="width: 100%; height: auto; padding: 15px; padding-left: 25px; margin-top: 30px;" align="left">
		<span style="font-size: 24px; font-family:'NotoSans' !important; font-weight: bold;">휴학신청 유의사항</span>
	</div>
<div style="width: 85%; height: auto; color: red;" align="left">
<pre style="border: none; color: red; line-height: 3">
1. 일반휴학은 신청서를 작성하고, 신청완료(접수 절차) 절차를 거쳐야 접수가 완료된다. 출력은 하지 않는다.
   단 의학과 소속학생일 경우 휴학신청(신청서 작성)을 하고, 
   필히 해당학부(과)에서 면담 및 허가를 득하여야 해당 학부(과)에서 접수처리를 해주며, 
   학부(과)에서 접수처리를 해야 접수가 완료된다.
2. 휴학기간이 만료된자의 휴학연장 신청 절차도 1항과 동일하며,
   군입대 휴학자가 복학하지 아니하고 일반휴학으로 휴학연장을 하고자 할 경우는 
   구비서류 업로드 후 저장 신청완료(접수절차)를 거쳐야 접수가 완료됩니다. 출력은 하지 않는다.
3. 휴학은 재적기간 중 총 6개 학기까지 가능하며, 휴학기간은 1회에 2개학기를 초과할 수 없다.
4. 신입생은 입학 후 첫학기에 휴학할 수 없다.
5. 징계처분 중인 경우와 3/4선이 경과된 후에는 휴학할 수 없다.
6. 일반휴학 중 군입영자는 군입대휴학으로 변경하여야 한다. 미조치시 일반휴학 기간 만료 후 제적 처분된다.
7. 학기개시 후 4주선 이후에 휴학할 경우 등록금은 전액 소멸되므로 복학시 등록금 전액을 납부하여야 한다.
8. 휴학취소는 당해학기 휴학신청 후 5일 이내 (학기개시 후 4주선 이내에 한함)에 하여야 한다.
9. 기숙사는 휴학시 일주일 이내에 퇴사하여야 하며, 퇴사 시 퇴사원서는 UWINS를 통해 제출해야 환불이 가능하다
	</pre>
</div>
<br><br>
<div style="width: 100%; height: 100px;">
	<input type="button" value="휴학신청" style="width: 5em;" id="LoaBtn">
</div>
</form>
</div>
<script src="resources/js/leaveOfAbsence.js?ver=4"></script>
</body>
</html>