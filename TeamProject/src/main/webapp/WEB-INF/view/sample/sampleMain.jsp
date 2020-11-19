<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN</title>
<style>
@font-face{
	font-family: 'NotoSans';
	src: url("resources/font/NotoSansKR-Medium.otf");
}
html, body{
	height: 100%;
	width: 100%;
	margin: 0;
	padding: 0;
	font-family: 'NotoSans' !important;
	overflow: hidden;
}
#bottom-menu {
	height: 100px;
	width: 100%;
	left: 0;
	bottom: 0;
	position: absolute;
	background: rgba(0, 0, 0, 0.8);
	color: white;
	text-align: center;
}
/*사진 전체크기로  */
#mainImage {
	background-image: url("resources/images/mainImage2.jpg");
	background-size: cover;
}
input[type="text"],
input[type="password"]{
	width: 250px;
	height: 60px;
	outline: none;
	border: none;
	border-bottom: 4px solid white;
	background: none;
	color: white;
}
input::placeholder{
	color: #D8D8D8;
}
input[type="button"]{
	height: 150px;
	width: 150px;
	transition: .4s;
	font-size: 30px;
	font-weight: bold;
	color: #626161;
	border-radius: 10px;
	border: none;
	outline: none;
	box-shadow: none;
	cursor: pointer;
}
input[type="button"]:hover{
	background: none;
	border:none;
	color: white;
	box-shadow: 0 0 20px 0 white;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- 아이콘 -->
<link rel="stylesheet" href="resources/icon/fontello-embedded.css?ver=1">
<!-- 화면전환 -->
<script src="resources/js/move.js"></script>
</head>
<body>
<div style="width: 100%; height: 100%;">
	<!-- 로고 -->
	<img src="resources/images/KH_logo.png" width="200px" height="200px" style="top: 100px; right: 700px; position: absolute; z-index: 5;">
	<div style="width: 70%; height: 100%; display: inline-block;" id="mainImage">
		
	</div>
	<div style="width: 30%; height: 100%; display: inline-block; background: #191970; float: right;">
		<!-- 로그인 박스 -->
		<div style="width: 100%; height: 450px;">
			<div align="left" style="height: 200px; line-height: 200px; color: white; padding-top: 30px; padding-left: 50px;">
				<span style="font-size: 58px;">Login</span>
			</div>
			<div style="color: white; height: 200px;">
				<div align="left" style=" width: 60%; height: 100%; display: inline-block;">
					<div style="padding-left: 50px; height: 100%;">
						<input type="text"  id="memId" placeholder="아이디 혹은 학번" ><br><br>
						<input type="password" id="memPassword" placeholder="비밀번호">
					</div>
				</div>
				<div style="width: 40%; height: 100%; display: inline-block; float: right;">
					<div style="padding-top: 10px;">
						<input type="button" id ="loginBtn" value="로그인">
					</div>
				</div>
			</div>
		</div>
		<!-- 안내문구 -->
		<div style="padding-left: 50px; padding-top: 50px; color: white;">
			<h2>참고사항</h2>
<pre>
·학생 아이디는 학번입니다.

·비밀번호 분실 시 각 과 행정실에서 초기화
</pre>
		</div>
	</div>
</div>
<div id="bottom-menu">
	<p>학교명: KH대학교｜대표자: 권은지｜E-mail: jee14@ulsanit.com｜Tel: 052-257-7600｜Fax: 052-257-7822｜Tel: 052-257-7600｜446-77 울산광역시 남구 삼산로35번길 19 (신정동)</p>
	<p>copyright © KH대학교. All Rights Reserved.</p>
</div>
<script src="resources/js/loginPage.js?ver=4"></script>
</body>
</html>