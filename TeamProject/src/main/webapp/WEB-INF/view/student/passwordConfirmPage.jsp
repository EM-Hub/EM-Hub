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
	font-weight: bold;
	font-size: 15px;
}
tr {
	border-bottom: 1px solid black;
}
input[type="password"]{
	height: 2.5em;
	width: 200px;
}	
.pn{
	font-weight: bold;
}	
	
</style>
</head>
<body>
<input type="hidden" value="${sessionScope.loginInfo.memId }" id="memId"> 
<input type="hidden" id="mainNum" value=${menuSideDetailVO.mainNum }>
<input type="hidden" id="sideNum" value=${menuSideDetailVO.sideNum }>
<input type="hidden" id="sideDetailNum" value=${menuSideDetailVO.sideDetailNum }>
<div style="width: 100%; height:auto; margin-top: 50px; padding-top: 50px;" align="center">
	<div style="width: 100%; height: 35px; font-size: 25px; font-weight: bold;" align="center">
		<i class="icon-key"></i><span style="color: #D54B4B;">비밀번호 확인</span>
	</div>
	<div style="width: 500px; height: 180px; border-top: 3px solid #191970; margin-top: 35px; padding-top:20px; padding-left: 20px; background: #f5f5f5;" align="left">
		<span class="pn">현재 비밀번호를 입력해 주세요</span><br><br>
		<span class="pn">정보를 안전하게 보호하기 위해 비밀번호를 한번 더 입력합니다.</span><br>
		<div style="margin-top: 20px;" align="center">
			<input type="password" id="memPassword" placeholder="비밀번호 입력">
			<input type="button" value="확인" id="passwordBtn">
		</div>
	</div>
</div>
</body>
<script src="resources/js/passwordConfirm.js?ver=315123"></script>
</html>