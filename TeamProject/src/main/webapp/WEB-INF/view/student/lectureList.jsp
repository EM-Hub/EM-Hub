<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.selectTable table{
	width: 650px;
	text-align: center;
}
.selectTable table td{
	border: 1px solid #bfbfbf;
}
.listTable table{
	width: 1000px;
	text-align: center;
}
.listTable table td{
	border-bottom: 1px solid #F5F5F5;
	height: 30px;
}
select{
	width: 100%;
	height: 100%;
	border: none;
	text-align-last: center;
	outline: none;
}
input[type="text"]{
	width: 100%;
	height: 100%;
	border: none;
	outline: none;
}
.selectTable .title{
	border-left: 3px solid #191970;
	background: #F5F5F5;
	font-weight: bold;
}
.listTable .title2{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
}
.listTable tr:nth-child(even){
	background: #f2f2f2;
}
.listTable tr:hover{
	background: #B5D0FB;
}
.title2 tr, td{
	border: none;
}
.attachment{
	color: blue;
	cursor: pointer;
}
</style>
</head>
<body>
<div style="height: auto; width: 100%;">
	<div style="height: 200px; width: 100%;" align="center" class="selectTable">
		<table>
			<colgroup>
				<col width="10%">
				<col width="30%">
				<col width="10%">
				<col width="30%">
				<col width="20%">
			</colgroup>
			<tr style="height: 40px;">
				<td class="title">대 학</td>
				<td>
					<select id="colSel">
						<option value="0">전 체</option>
						<c:forEach items="${collegeList }" var="col">
							<option value="${col.collegeNum }">${col.collegeName }</option>
						</c:forEach>
					</select>
				</td>
				<td class="title">권장학년</td>
				<td>
					<select id="yearSel">
						<option value="0">전 체</option>
						<option value="1">1학년</option>
						<option value="2">2학년</option>
						<option value="3">3학년</option>
					</select>
				</td>
				<td rowspan="2" style="border: none;"><input type="button" value="조회" id="selectBtn"></td>
			</tr>
			<tr style="height: 40px;">
				<td class="title">전 공</td>
				<td class="depTd">
					<select id="depSel">
						<option value="0">전 체</option>
						<c:forEach items="${depList }" var="dep">
							<option value="${dep.depNo }">${dep.depName }</option>
						</c:forEach>
					</select>
				</td>
				<td class="title">학 점</td>
				<td>
					<select id="lecCredit">
						<option value="0">전 체</option>
						<option value="1">1학점</option>
						<option value="2">2학점</option>
						<option value="3">3학점</option>
					</select>
				</td>
			</tr>
		</table>
		<br>
		<table>
			<colgroup>
				<col width="10%">
				<col width="30%">
				<col width="10%">
				<col width="30%">
				<col width="20%">
			</colgroup>
			<tr style="height: 50px;">
				<td class="title">검 색</td>
				<td colspan="3"><input type="text" placeholder="과목코드 또는 강의명을 검색하세요." class="searchInput"></td>
				<td style="border: none;"><input type="button" value="검색" id="searchBtn"></td>
			</tr>
		</table>
	</div>
	<div style="height: 600px; width: 100%;" align="center" class="listTable">
	<span style="color: blue; font-size: 14px;">※강의명을 클릭하면 강의계획서를 열람할 수 있습니다.</span>
	<br><br>
		<table>
			<colgroup>
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="20%">
				<col width="15%">
				<col width="15%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<tr>
				<td class="title2">과목코드</td>
				<td class="title2">대학</td>
				<td class="title2">학과</td>
				<td class="title2">강의명</td>
				<td class="title2">담당교수</td>
				<td class="title2">담당조교</td>
				<td class="title2">권장학년</td>
				<td class="title2">학점</td>
			</tr>
			<tbody id="lecList">
			<c:forEach items="${LectureList }" var="lec">
				<tr>
					<td>${lec.lecCode }</td>
					<td>${lec.collegeName }</td>
					<td>${lec.depName }</td>
					<td><span class="attachment" data-attachment="${lec.attachment }">${lec.lectureName }</span></td>
					<td>${lec.profName }</td>
					<td>${lec.asstName }</td>
					<td>${lec.recYear }</td>
					<td>${lec.lecCredit }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript" src="resources/js/lectureList.js?ver=5"></script>
</body>
</html>