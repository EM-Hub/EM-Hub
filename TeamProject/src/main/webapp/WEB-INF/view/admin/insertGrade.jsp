<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.searchDiv{
	width: 100%;
	height: 80px;
}
select{
	width: 100%;
	height: 100%;
	border: 1px solid #bfbfbf;
	padding-left:20%;
}
.searchDiv table{
	text-align: center;
	width: 500px;
	height: 30px;
}
.title{
	border-left: 3px solid #191970;
	background: #F5F5F5;
	font-weight: bold;
}
#studentList{
	width: 100%;
	height: auto;
	margin-top: 50px;
}
#studentList table{
	width: 500px;
	text-align: center;
}
#studentList td{
	border-bottom: 1px solid #bfbfbf;
	height: 40px;
}
#studentList select{
	width: 100%;
	height: 100%;
	border: 1px solid #bfbfbf;
	padding-left: 40%;
	border: none;
}
.insertBtn{
	width: 80%;
	height: 80%;
}
.title2{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
}
</style>
</head>
<body>
<!-- 학생목록 -->
<div align="center" class="searchDiv">
	<span style="color: red;">※과목을 선택하세요</span><br><br>
	<table>
		<colgroup>
			<col width="15%">
			<col width="*">
			<col width="20%">
		</colgroup>
		<tr>
			<td class="title"><i class="icon-search"></i></td>
			<td>
				<select id="lecSel">
					<c:forEach items="${lecList }" var="lec">
						<option value="${lec.lecTtCode }" class="ttCode">(${lec.lecTtCode})&nbsp;${lec.lectureName }</option>
					</c:forEach>
				</select>
			</td>
			<td><input type="button" value="조회" id="search"></td>
		</tr>
	</table>
</div>
<!-- 점수입력div -->
<div id="studentList" align="center">
	
</div>
<script src="resources/js/insertGrade.js?ver=21"></script>
</body>
</html>