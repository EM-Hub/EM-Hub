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
.listTable::-webkit-scrollbar {
   width: 10px;
}
.listTable::-webkit-scrollbar-thumb {
  background-color: #191970;
  border-radius: 10px;
  border: 2px solid transparent;
}
.listTable::-webkit-scrollbar-track {
  border-radius: 10px;
  box-shadow: inset 0px 0px 5px white;
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
						<option value="0">전체</option>
						<c:forEach items="${collegeList }" var="college">
							<option value="${college.collegeNum }">${college.collegeName }</option>
						</c:forEach>
					</select>
				</td>
				<td class="title">학 년</td>
				<td>
					<select id="yearSel">
						<option value="0">전체</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</td>
				<td rowspan="2" style="border: none;"><input type="button" value="조회" id="selectBtn"></td>
			</tr>
			<tr style="height: 40px;">
				<td class="title">전 공</td>
				<td class="depTd">
					<select id="depSel">
						<option value="0">전체</option>
						<c:forEach items="${depList }" var="dep">
							<option value="${dep.depNo }">${dep.depName }</option>
						</c:forEach>
					</select>
				</td>
				<td class="title">학 적</td>
				<td>
					<select id="statusSel">
						<option value="0">전 체</option>
						<c:forEach items="${statusList }" var="status">
							<option value="${status.statusNum }">${status.memStatus }</option>
						</c:forEach>
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
				<td colspan="3"><input type="text" placeholder="학번 또는 이름을 검색하세요." id="searchInput"></td>
				<td style="border: none;"><input type="button" value="검색" id="searchBtn"></td>
			</tr>
		</table>
	</div>
	<div style="width: 95%;" align="center"><p style="color: red">*학생의 이름을 클릭하면 학생의 상세정보 페이지로 이동합니다.</p></div>
	<div style="height: 600px; width: 95%; overflow-y: scroll; border-bottom: 2px solid #191970;" align="center" class="listTable">
		<table>
			<colgroup>
				<col width="15%">
				<col width="10%">
				<col width="15%">
				<col width="20%">
				<col width="25%">
				<col width="15%">
			</colgroup>
			<tr>
				<td class="title2">학번</td>
				<td class="title2">학년</td>
				<td class="title2">이름</td>
				<td class="title2">대학</td>
				<td class="title2">전공</td>
				<td class="title2">학적상태</td>
			</tr>
			<tbody id="stuList">
			<c:forEach items="${studentList }" var="stu">
				<tr>
					<td>${stu.stuNum }</td>
					<td>${stu.stuYear }</td>
					<td><a href="studentInfo.do?stuNum=${stu.stuNum }&mainNum=8&sideNum=21">${stu.stuName }</a></td>
					<td>${stu.collegeName }</td>
					<td>${stu.depName }</td>
					<td>${stu.memStatus }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript" src="resources/js/studentList.js?ver=17"></script>
</body>
</html>