<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<style type="text/css">
table {
	border: 1px solid black;
	font-weight: bold;
	text-align: center;
	width: 800px;
	
}

tr td {
	border: 1px solid #bfbfbf;
	border-collapse: collapse;
}

.title{
	background: #F5F5F5;
	border-left: 3px solid #191970;
	font-size: 15px;
	font-weight: bold;
	color: #191970;	
	height: 50px;
	text-align: center;
}
pre{
	width: 100%;
	height: 95%;
	background: none;
	outline: none;
	border: none;
}

.boardContent::-webkit-scrollbar {
   width: 15px;
}
.boardContent::-webkit-scrollbar-thumb {
  	background-color: #191970;
  	border: 2px solid transparent;
   	border-radius: 15px;
}
.boardContent::-webkit-scrollbar-track {
  background: #f4f4f4;
  border-radius: 15px;
}
 #gradeE {
 position: relative;
 left: 270px;
 bottom: 100px;
 }
 #gradeY {
  position: relative;
 left: 270px;
 bottom: 100px;
 }
</style>
</head>
<body>
<div align="center" style="width: 100%; height: auto; padding-top: 30px;">
<input type="hidden" value="${requestDetail.requestNum}" id="requestNum"> 
<table>
	<colgroup>
		<col width="10%">
		<col width="23%">
		<col width="10%">
		<col width="23%">
		<col width="10%">
		<col width="*">
	</colgroup>
	<tr>
		<td class="title">학번</td>
		<td>${requestDetail.stuNum}</td>
		<td class="title">학과</td>
		<td>${requestDetail.depName}</td>
		<td class="title">학년</td>
		<td >${requestDetail.stuYear}</td>
	</tr>
	<tr>
		<td class="title">제목</td>
		<td colspan="3">${requestDetail.requestTitle}</td>
		<td class="title">작성자</td>
		<td>${requestDetail.requestName}</td>
	</tr>
	<tr height="300px" style="overflow: scroll;">
		<td class="title">내용</td>
		<td colspan="5"><pre class="boardContent">${requestDetail.requestContent }</pre></td>
	</tr>
</table>
<div style="height: 50px;"></div>
<div>
	<input type="button" value="목록" onclick="history.back();">
	<c:if test="${sessionScope.loginInfo.memGrade eq 'E'}">
	<c:choose>
		<c:when test="${sessionScope.loginInfo.memGrade eq 'E' && requestDetail.requestStatus eq 'N'}">
			<input type="button" value="수리 및 승인확인" id="gradeE" style="width: 150px;">
		</c:when>
		<c:otherwise>
			<input type="button" value="승인완료"  style="width: 120px;" id="gradeY">
		</c:otherwise>
	</c:choose>
	</c:if>
</div>
</div>
<script src="resources/js/repairRequest.js?ver=855"></script>
</body>
</html>