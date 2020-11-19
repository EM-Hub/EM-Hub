<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전과신청</title>
<style type="text/css">
#table1{
	width: 1000px;
	height: 150px;
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

 .table3 {
 	width: 1000px;
 	text-align: center;
 	border: 1px solid #bfbfbf;
 }
 .table3 td{
 	height: 50px;
 }
 
 .title2{
 	background: #F5F5F5;
	border-left: 3px solid #526ca2;
	color: #526ca2;
	font-size: 15px;
	font-weight: bold;
 
 }
 .ttt11{
 	width: 1000px;
 	height: 60px;
 	text-align: center;
 	border: none;
 }
 textarea{
 	width: 95%;
 	height: 90%;
 	outline: none;
 	border: none;
 	resize: none;
 	padding: 5px;
 }
 #title td{
 	font-weight: bold;
 	background: #191970;
 	color: white;
 	border: none;
 }
</style>
</head>
<body>
<div align="left" style="width: 100%; padding-left: 70px;">
<h3 style="font-weight: bold">학생정보</h3>
</div>
<form action="insertMajor.do" method="post" id="mBtn">
<input type="hidden" value="${myInfo.collegeNum }" name="fromCollegeNum" id="myCollege">
<input type="hidden" value="${myInfo.depNo }" name="fromDepNo" id="myDep">
<div style="width: 100%; height:auto; padding: 15px;" align="center">
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
			<td class="title">성 별</td>
			<c:choose>
				<c:when test="${myInfo.memGender eq 'F' }">
					<td>여</td>
				</c:when>			
				<c:otherwise>
					<td>남</td>
				</c:otherwise>
			</c:choose>
			<td class="title">생 일</td>
			<td>${myInfo.memBirthday }</td>	
			<td class="title">학적상태</td>
			<td><input type="text" value="${myInfo.memStatus }" readonly>
				<input type="hidden" value="${myInfo.statusNum }">
			</td>
			<td></td>
		</tr>
	</table>
</div>
<div align="left" style="width: 100%; padding-left: 70px;">
	<h3 style="font-weight: bold;">전과 신청 사항</h3>
</div>
<div style="width: 100%; height:auto; padding: 15px;" align="center">
		<table class="table3">
			<colgroup>
				<col width="20%">
				<col width="30%">
				<col width="20%">
				<col width="30%">
			</colgroup>
			<tr>
				<td class="title">현재대학</td>
				<td>${myInfo.collegeName }</td>
				<td class="title">현재학과</td>
				<td>${myInfo.depName }</td>
			</tr>
			<tr>
				<td class="title">변경대학</td>
				<td><select id="collegeC" name="majorCollegeNum"><option value="0" >전체</option>
				<c:forEach items="${collegeList }" var="college">
					<option value="${college.collegeNum }">${college.collegeName }</option>
				</c:forEach>
				</select>
				<td class="title">변경학부</td>
				<td colspan="3">
				<select id="depC" name="majorDepno" ><option value="0">전체</option>
				<c:forEach items="${depList }" var="dep">
					<option value="${dep.depNo }">${dep.depName }</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="title">전과사유</td>
				<td colspan="4"><textarea name="majorContent" placeholder="사유를 입력하세요."></textarea></td>
			</tr>
	</table>
</div>
<div align="left" style="width: 100%; padding-left: 70px;">
	<h3 style="font-weight: bold;">전과 신청 내역</h3>
</div>
<div style="width: 100%; height:auto; padding: 15px;" align="center" id="">
	<table class="table3">
		<colgroup>
			<col width="5%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="5%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="*">
		</colgroup>
		<tr id="title">
			<td>No</td>
			<td>소속대학</td>
			<td>소속학과</td>
			<td>학번</td>
			<td>이름</td>
			<td>학년</td>
			<td>학적상태</td>
			<td>변경대학</td>
			<td>변경학과</td>
			<td>신청상태</td>
			<td>신청일</td>
		</tr>
	</table >
	<div id="majorList">
	
	</div>
</div>
	<div style="width: 100%; height: auto;" align="center">
	<div style="width: 100%; padding-left: 70px; margin-top: 30px;" align="left">
		<h3 style="font-weight: bold;">전과신청 안내</h3>
	</div>
	<div style="width: 85%; height: auto; color: red;" align="left">
	<pre style="border: none; color: red; line-height: 3">
1.진로지도 이수 신청 시 본인을 확인할 수 있는 학생증 또는 주민등록증을 제출하지 않을 경우 신청불가
2.전과한 이후라도 신청자격 미달 또는 부정이 확인될 경우 전과 취소
전과가 허가된 학기에는 장학금이 지급되지 않으며, 이미 지급된 장학금은 반환해야 한다.
3.전과된 이후에는 전과한 학과의 기준으로 영역별 이수학점을 새로이 취득해야 한다. 기존 학과에서 취득한 학점은
 모두 자유선택으로 인정되므로 주의해야 한다.
4.전과 직후에도 휴학은 가능하며 반드시 등록금을 정산한 후에 신청할 수 있다.
5.해외학점교류 학생 중 전과 전 성적이 확정되지 않은 학생은 본인이 직접 교무처 별도 확인 필요
	</pre>
	<br>
	</div>
	</div>
	<br>
	<div align="center" style="font-weight: bold;">
	<input type="checkbox" class="yBtn"><span class="sBtn">동의함</span>
	<input type="button" id="yBtn1" value="신청하기">	
	</div>
	<br>
	</form>
</body>
<script src="resources/js/majorApplication.js?ver=1"></script>
</html>