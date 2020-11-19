<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 공통css -->
<link rel="stylesheet" type="text/css" href="resources/css/common.css?ver=9"/>
<!-- Jquey를 사용을 위한 태그 -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- 화면전환 -->
<script src="resources/js/move.js?ver=22"></script>
<!-- 아이콘 -->
<link rel="stylesheet" href="resources/icon/fontello-embedded1.css">
<!-- 배경 슬라이드 -->
<link rel="stylesheet" href="resources/css/slide.css?ver=14">
<script src="resources/js/slide.js?ver=16"></script>
<style type="text/css">
html, body{
 	margin: 0 auto;
 	padding: 0;
	width: 100%;
 	height: auto;
 	overflow-x: hidden;
}
@font-face{
	font-family: 'NotoSans';
	src: url("resources/font/NotoSansKR-Medium.otf");
}
body::-webkit-scrollbar {
   width: 15px;
}
body::-webkit-scrollbar-thumb {
  background-color: #191970;
  border: 2px solid transparent;
}
body::-webkit-scrollbar-track {
  background: black;
}
#upBtn, #downBtn{
   cursor: pointer;
}
</style>
</head>
<body>
<div id="pageUp"></div>
   <div style="width:50px; height:50px; position:fixed; right: 0px; bottom: 50px; z-index: 3; background: #191970" align="center" id="upBtn">
      <i class="icon-up-big" style="font-size: 30px; color: white;"></i>
   </div>
   <div style="width:50px; height:50px; position:fixed; right: 0; bottom: 0; z-index: 3; background: #191970" align="center" id="downBtn">
      <i class="icon-down-big" style="font-size: 30px; color: white;"></i>
   </div>
<div style="background: #191970; width: 100%; z-index: 8; position: absolute; top:0px; line-height: 300px; padding-top: 300px;" align="center" id="mainE">
	<img src="resources/images/logo2.png" width="800px" height="300px">
</div>
<div style="background: white; width: 100%; z-index: 9; position: absolute; top:0px; line-height: 300px; padding-top: 300px;" align="center" id="mainF">
</div>
<!-- <div style="background: #0B0B61; width: 100%; height:30%; z-index: 8; position: absolute; top:0px;" id="main1">
</div>
<div style="background: #0B0B61; width: 100%; height: 30%; z-index: 8; position: absolute; top:30%;" id="main2">
</div>
<div style="background: #0B0B61; width: 100%; height:30%; z-index: 8; position: absolute; top:60%;" id="main3">
</div>
<div style="background: #0B0B61; width: 100%; height:30%; z-index: 8; position: absolute; top:90%;" id="main4">
</div>  -->
<!-- 상단 -->
<div style="height: 170px; width: 100%; z-index: 3; position: absolute;">
	<!-- top -->
	<div style="height: 50px; width: 100%;">
		<tiles:insertAttribute name="topMenu"/>
	</div>
	<!-- DropMenu -->
	<div style="height: 120px; width: 100%;">
		<tiles:insertAttribute name="dropMenu"/>
	</div>
</div>
<!-- body 메인컨텐츠 -->
<!-- back이미지 -->
<div style="height: 900px; width: 100%; top: 0; position: absolute; z-index: 1" class="section">
	<input type="radio" name="slide" id="slide0" checked>
	<input type="radio" name="slide" id="slide1">
	<input type="radio" name="slide" id="slide2">
	<div class="slideWrap" style="height: 900px; width: 100%;">
		<ul class="slideList">
			<li>
				<a>
					<label for="slide2" class="left"><i class="icon-left-open" style="font-size: 50px; color: white;"></i></label>
						<img src="resources/images/mainPage1/mainPage4.jpg" style="object-fit: cover; width: 100%; height: 100%;">
					<label for="slide1" class="right"><i class="icon-right-open" style="font-size: 50px; color: white;"></i></label>
				</a>
			</li>
			<li>
				<a>
					<label for="slide0" class="left"><i class="icon-left-open" style="font-size: 50px; color: white;"></i></label>
						<img src="resources/images/mainPage2/back5.jpg" style="object-fit: cover; width: 100%; height: 100%;">
					<label for="slide2" class="right"><i class="icon-right-open" style="font-size: 50px; color: white;"></i></label>
				</a>
			</li>
			<li>
				<a>
					<label for="slide1" class="left"><i class="icon-left-open" style="font-size: 50px; color: white;"></i></label>
						<img src="resources/images/co2.png" style="top: 170px; position: absolute; width: 100%; height: 630px;">
					<label for="slide0" class="right"><i class="icon-right-open" style="font-size: 50px; color: white;"></i></label>
				</a>
			</li>
		</ul>
	</div>
</div>
	<!-- mainContent -->
<div style="height: auto; width: 100%; top:780px; position: absolute; z-index: 2">
	<div style="height: auto; width: 100%;">
		<tiles:insertAttribute name="body"/>
	</div>
</div>
</body>
</html>