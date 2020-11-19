<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.tm{
	width: 5em;
	height: 100%;
	line-height: 50px;
	text-align: center;
	font-weight: bold;
	font-size: 16px;
	display: inline-block;
	cursor: pointer;
	margin-right: 20px;
	
}
.tm:hover, .tm:hover a{
	color: #FFCC00;
}
.tm a{
	text-decoration: none;
	color: white;
}
.tm > img{
	width: 80%;
	height: 100%;
}
</style>
</head>
<body>
<div align="right" style="width: 100%; height: 100%; background: rgba(14,14,114,0.9); border-bottom: 1px solid #495057; color: white; padding-right: 20%;">
	<div class="tm">
		<a href="mainPage.do"><i class="icon-home"></i>Home</a>
	</div>
	<div class="tm logout">
		<span>Logout</span>
	</div>
</div>
<script type="text/javascript" src="resources/js/topMenu.js?ver=1"></script>
</body>
</html>