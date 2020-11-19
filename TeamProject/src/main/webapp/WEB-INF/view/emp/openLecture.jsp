<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.selectTable{
	width: 350px;
	text-align: center;
}
.selectTable td{
	border: 1px solid #bfbfbf;
	height: 3em;
}
.selectTable .title{
	border-left: 3px solid #191970;
	background: #F5F5F5;
	font-weight: bold;
	color: #526ca2;
}
.listTable{
	width: 700px;
	text-align: center;
}
.listTable td{
	border-bottom: 1px solid #f1f1f1;
}
.listTable tr:nth-child(even){
	background: #f2f2f2;
}
.listTable tr:hover{
	background: #B5D0FB;
}
.title2{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
}
select{
	width: 95%;
	height: 95%;
	border: none;
}
input[type="text"]{
	width: 95%;
	height: 95%;
	border: none;
}
#searchBtn:hover{
	background: #191970;
	color: white;
}
.lecRadio:hover{
	cursor: pointer;
}
</style>
</head>
<body>
<input type="hidden" value="${memberDepInfo.depNo }" id="memberDepNo">
<input type="hidden"id="mainNum" value=${menuSideDetailVO.mainNum }>
<input type="hidden"  id="sideNum" value=${menuSideDetailVO.sideNum }>
<div style="width: 100%;" align="center">
	<div>
		<table class="selectTable">
			<colgroup>
				<col width="20%">
				<col width="40%">
				<col width="40%">
			</colgroup>
			<tr>
				<td class="title">대학/전공</td>
				<td><select name="collegeNum" id="colSelect">
						<option value="0">전체</option>
						<c:forEach items="${colList }" var="college">
							<option value="${college.collegeNum}">
								${college.collegeName }</option>
						</c:forEach>
				</select></td>
				<td><select id="depSelect" name="depNo">
						<option>-</option>
				</select></td>
			</tr>
		</table>
	</div>
	<div style="margin-top: 10px;">
		<table class="selectTable">
			<colgroup>
				<col width="20%">
				<col width="60%">
				<col width="20%">
			</colgroup>
			<tr>
				<td class="title">검색</td>
				<td><input type="text" id="searchBox" placeholder="강의명"></td>
				<td id="searchBtn"><i class="icon-search"></i></td>
			</tr>
		</table>
	</div>
	<div style="margin-top: 30px;">
		<table class="listTable">
				<tr>
					<td class="title2"></td>
					<td class="title2">No.</td>
					<td class="title2">강의명</td>
					<td class="title2">개설학과</td>
					<td class="title2">담당교수</td>
					<td class="title2">담당조교</td>
					<td class="title2">학점</td>
					<td class="title2">권장학년</td>
				</tr>
			<tbody id="tBody">
				<c:forEach items="${lectureList}" var="lecture">
					<tr>
						<td><input type="radio" name="lecRadioBtn" class="lecRadio"></td>
						<td class="lecCode">${lecture.lecCode }</td>
						<td>${lecture.lectureName }</td>
						<td>${lecture.depName }</td>
						<td>${lecture.profName }</td>
						<td>${lecture.asstName }</td>
						<td>${lecture.lecCredit }</td>
						<td>${lecture.recYear }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table><br>
		<input type="button" value="개설하기" id="openLecBtn">
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/openLecture.js?ver=458"></script>
</body>
</html>