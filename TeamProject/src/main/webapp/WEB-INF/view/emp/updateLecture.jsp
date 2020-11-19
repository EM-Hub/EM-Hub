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
}
.title2{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
	border: none;
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
	width: 850px; 
	text-align: center;
}
tr, td{
	border: 1px solid #bfbfbf;
	border-collapse: collapse;
	height: 40px;
}
.title{
	border-left: 3px solid #526ca2;
	font-size: 15px;
	font-weight: bold;
	color: #526ca2;
}
i:hover{
	cursor: pointer;
}
</style>
</head>
<body>
<c:if test="${updateResult eq 1 or updateResult == 1}">
	<script type="text/javascript">
		alert('강의가 성공적으로 수정되었습니다');
	</script>
</c:if>
<div align="center" style="width: 100%;">
<table>
	<tr>
		<td class="title2">No.</td>
		<td class="title2">강의명</td>
		<td class="title2">담당교수</td>
		<td class="title2">개설학과</td>
		<td class="title2"></td>
	</tr>
	<tbody>
	<c:forEach items="${lectureList }" var="lecture">
	<tr>
 		<td class ="lecCode">${lecture.lecCode }</td>
		<td>${lecture.lectureName }</td>
		<td>${lecture.profName }</td>
		<td>${lecture.depName }</td> 
		<td><i class="icon-cog aa"></i></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
<script src="resources/js/updateLecture.js?ver=33"></script>
</body>
</html>














