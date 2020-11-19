<!-- 수정 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.title{
	border-left: 3px solid #526ca2;
	font-size: 15px;
	font-weight: bold;
	color: #526ca2;
	background: #f5f5f5;
}
#updateBtn{
	height: 2em;
	width: 5em;
	border: none;
	background: #788EBC;
	color: white;
}
#updateBtn:hover{
	background: #82C5AF;
	color: white;
}
table{
	border: 1px solid #bfbfbf;
	width: 700px;
	height: 250px;
	text-align: center;
}
tr, td{
	border: 1px solid #bfbfbf;
	border-collapse: collapse;
}
.title{
	border-left: 3px solid #526ca2;
	font-size: 15px;
	font-weight: bold;
	color: #526ca2;
}
.icon-search{
	font-size: 16px;
}
.icon-search:hover{
	cursor: pointer;
	color: orange;
}
select{
	height: 2em;
    width: 10em;
}
input[type="text"]{
	border:none;
}
</style>
</head>
<body>
<input type="hidden" value="교수" id="hiddenEmpJob">
<input type="hidden" value="${lectureInfo.depNo }" id="aaaaa">
<div style="width: 100%; height: 400px;" align="center">
	<div style="width: 900px; height: 400px; margin-top: 50px" align="center">
	<form action="updateLectureInfo.do" method="post" enctype= "multipart/form-data">
	<input type="hidden" name="lecCode" value=${lectureInfo.lecCode }>
	<input type="hidden" value="${side.mainNum }" name="mainNum" >
	<input type="hidden" value="${side.sideNum }" name="sideNum" >
		<table>
			<colgroup>
				<col width="15%">
				<col width="35%">
				<col width="15%">
				<col width="35%">
			</colgroup>
			<tr>
				<td class="title">개설강의명</td>
				<td colspan="3"><input type="text" style="width: 95%" name="lectureName" value="${lectureInfo.lectureName }"></td>
			</tr>
			<tr>
				<td class="title">개설학과</td>
				<td colspan="3">
				<select name ="collegeNum" id="colSelect" class="required">
					<c:forEach items="${colList }" var="college">
						<option value="${college.collegeNum}"> ${college.collegeName }</option>
					</c:forEach>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<select id="depSelect" name = "depNo" class="required">
					<option>-</option>
				</select>
				</td>
			</tr>
			<tr>
				<td class="title">담당교수</td>
				<td><input type="text" id="profNum" name="profNum" value="${lectureInfo.profNum }" readonly><i class="icon-search" data-toggle="modal" data-target="#selectEmpModal" id="profBtn"></i></td>
				<td class="title">담당조교</td>
				<td><input type="text" id="asstNum" name="asstNum" value="${lectureInfo.asstNum }" readonly><i class="icon-search" data-toggle="modal" data-target="#selectEmpModal" id="asstBtn"></i></td>
			</tr>
			<tr>
				<td class="title">학점</td>
				<td><input type="number" name="lecCredit" value="${lectureInfo.lecCredit }" min="1"></td>
				<td class="title">권장학년</td>
				<td><input type="number" name="recYear" value="${lectureInfo.recYear }" min="1"></td>
			</tr>
			<tr>
				<td class="title">강의계획서<br>(수정)</td>
				<td colspan="1" style="border-right: none;">
					<input type="file" name="lecFile" accept=".pdf" style="padding-left: 16px; width: 90%;" placeholder="첨부하기">
				</td>
				<td colspan="3" align="left" style="border-left: none;">
					<span style="color: red"><i class="icon-attention-alt"></i>pdf파일만 첨부 가능</span>
				</td>
			</tr>
		</table>
		<br><br>
		<div align="center" style="width: 100%;">
			<input type="submit" value="수정" >
			<input type="button" value="뒤로가기" onclick="location.href='updateLecPage.do?mainNum=9&sideNum=28'" >
		</div>
	</form>
	</div>
</div>





<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/updateLecPage.js?ver=8"></script>
</body>
</html>














