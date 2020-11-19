<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#adminInfo{
	border: 1px solid #bfbfbf;
	width: 600px;
	height: 180px;
	text-align: center;
}
#adminInfo tr, td{
	border: 1px solid #bfbfbf;
	border-collapse: collapse;
}
#adminInfo2{
	border: 1px solid #bfbfbf;
	width: 810px;
	text-align: center;
}
#adminInfo2 tr{
	height: 43px;
}
.title{
	background: #F5F5F5;
	border-left: 3px solid #191970;
	font-size: 15px;
	font-weight: bold;
	color: #191970;
}
.inputT{
	text-align: center;
	border: none;
}
input[type='text']:focus{
	outline-color: #788EBC;
}
</style>
</head>
<body>
<div style="width: 900px; height:auto; padding: 15px; margin-left: 100px;" align="center">
	<div style="width: 150px; height: 180px; border: 1px solid #bfbfbf; display: inline-block;"> 
		<img src="resources/images/${myInfo.memPhoto }" width="100%" height="100%">
	</div>
	<div style="width: 600px; height: 180px; display: inline-block; float: right;" align="center">
		
				<table id="adminInfo">
			<colgroup>
				<col width="15%">
				<col width="35%">
				<col width="15%">
				<col width="35%">
			</colgroup>
			<tr>
				<td class="title">이 름</td>
				<td>${empInfo.empName }</td>
				<td class="title">소속대학</td>
				<td>${empInfo.collegeName }</td>
			</tr>
			<tr>
				<td class="title">직원번호</td>
				<td class="empNo">${empInfo.empNo }</td>
				<td class="title">담 당</td>
				<td>${empInfo.depName }</td>
			</tr>
			<tr>
				<td class="title">직 위</td>
				<td>${empInfo.empJob }</td>
				<td class="title"></td>
				<td></td>
			</tr>
			<tr>
				<td class="title">성 별</td>
				<td><input type="radio" name="gender" <c:if test="${empInfo.memGender eq 'M' }">checked</c:if> onclick="return(false);">남&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" <c:if test="${empInfo.memGender eq 'F' }">checked</c:if> onclick="return(false);">여
				</td>
				<td class="title">이메일</td>
				<td><input type="text" value="${empInfo.memEmail }" class="inputT" readonly id="memEmail"></td>
			</tr>
		</table>
	</div>
	<div style="width: 900px; margin-top: 20px; padding-left: 60px;" align="left">
		<table id="adminInfo2">
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="10%">
				<col width="40%">
			</colgroup>
			<tr>
				<td class="title">생년월일</td>
				<td>${empInfo.memBirthday }</td>
				<td class="title"></td>
				<td></td>
			</tr>
			<tr>
				<td class="title">전화번호</td>
				<td><input type="text" value="${empInfo.memTel }" class="inputT" readonly id="memTel"></td>
				<td class="title">휴대폰</td>
				<td><input type="text" value="${empInfo.memPhone }" class="inputT" readonly id="memPhone"></td>
			</tr>
			<tr>
				<td class="title">우편번호</td>
				<td colspan="3"><input type="text" value="${empInfo.memZipCode }" class="inputT" readonly id="memZipCode"></td>
			</tr>
			<tr>
				<td class="title">주 소</td>
				<td colspan="3"><input type="text" value="${empInfo.memAddr }" class="inputT" readonly id="memAddr"></td>
			</tr>
		</table>
		<div align="center" style="margin-top: 30px;">
			<input type="button" value="정보수정" id="update11Btn">
		</div>
	</div>
</div>
<script src="resources/js/updateAdminMyInfo.js?ver=11"></script>
</body>
</html>