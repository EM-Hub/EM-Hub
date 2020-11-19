<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	text-align: left;
	width: 350px;
}
tr {
}
 
label.error {
	color: red;
	font-size: 12px;
	display: inline-block;
	float: right;
	position: absolute;
}
.pn{
	font-weight: bold;
}
input[type="password"]{
	height: 2.5em;
	width: 100%;
}
</style>
</head>
<body>
<form action="passwordChange.do" method="post" id="passwordForm">
<input type="hidden" value="${sessionScope.loginInfo.memId }" id="memId"> 

<div style="width: 100%; height:auto; margin-top: 50px; padding-top: 50px;" align="center">
	<div style="width: 100%; height: 35px; font-size: 25px; font-weight: bold;" align="center">
		<i class="icon-key"></i><span style="color: #D54B4B;">비밀번호 변경</span>
	</div>
	<div style="width: 750px; height: 250px; border-top: 3px solid #191970; margin-top: 25px; padding-top:20px; padding-left: 20px; background: #f5f5f5;" align="left">
		<span class="pn">새로운 비밀번호를 입력해 주세요</span><br><br>
			<div align="center" style="margin-top: 20px;">
			<table>
				<colgroup>
					<col width="30%">
					<col width="70%">
				</colgroup>
				<tr>
					<td class="pn">비밀번호</td>
					<td><input type="password" id="memPassword1" name="memPassword1"></td>
				</tr>
			</table><br>
			<table>
				<colgroup>
					<col width="30%">
					<col width="70%">
				</colgroup>
				<tr>
					<td class="pn">비밀번호확인</td>
					<td><input type="password" id="memPassword2" name="memPassword2"></td>
				</tr>
			</table>
				<br>	
				<input type="submit" value="확인" id="changeBtn">	
			</div>
	</div>
</div>
</form>
</body>
<script src="resources/js/passwordChange.js?ver=19"></script>
</html>