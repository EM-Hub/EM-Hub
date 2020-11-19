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
table{
	border: 1px solid #bfbfbf;
	width: 850px;
	height: 180px;
	text-align: center;
}
tr, td{
	height: 40px;
	border: 1px solid #bfbfbf;
	border-collapse: collapse;
}
i:hover{
	cursor: pointer;
}
.title2{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
	border: none;
}
</style>
</head>
<body>
<div align="center" style="width: 100%;">
<table>
	<thead>
	<tr>
		<td class="title2">No.</td>
		<td class="title2">강의명</td>
		<td class="title2">담당교수</td>
		<td class="title2">개설학과</td>
		<td class="title2"></td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${lectureList }" var="lecture">
	<tr>
 		<td class ="lecCode">${lecture.lecCode }</td>
		<td>${lecture.lectureName }</td>
		<td>${lecture.profName }</td>
		<td>${lecture.depName }</td> 
		<td>
			<i class = "icon-trash deleteBtn" ></i>
		</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/deleteLecture.js?ver=8"></script>
</body>
</html>