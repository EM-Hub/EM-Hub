<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 공통css -->
<link rel="stylesheet" type="text/css" href="resources/css/common2.css?ver=100"/>
<!-- Jquey를 사용을 위한 태그 -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- 아이콘 -->
<link rel="stylesheet" href="resources/icon/fontello-embedded1.css">
<!--Validate  -->
<script src="resources/js/jquery.validate.js"></script>
<!-- top/down -->
<script src="resources/js/move2.js"></script>
<script type="text/javascript">
//   validate에 정규식 사용하게 설정   
   $.validator.addMethod('regx', function(value, element, regexpr){
         return regexpr.test(value);
});
</script>
<style type="text/css">
#body{
   min-height:60%
}
#foot{
   height:150px;
   width: 100%;
   overflow-x: hidden;
}
html, body {
   width: 100%;
   height: 100%;
   margin: 0;
   padding: 0;
}
@font-face{
   font-family: 'NotoSans';
   src: url("resources/font/NotoSansKR-Medium.otf");
}
#upBtn, #downBtn{
   cursor: pointer;
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
   <div style="height: 00px; width: 0px; z-index: 100">
      <tiles:insertAttribute name="modal"/>
   </div>
<!-- 상단 -->
<div style="height: 170px; width: 100%; z-index: 3; position: relative;">
   <!-- top -->
   <div style="height: 50px; width: 100%;">
      <tiles:insertAttribute name="topMenu"/>
   </div>
   <!-- DropMenu -->
   <div style="height: 120px; width: 100%;">
      <tiles:insertAttribute name="dropMenu"/>
   </div>
</div>
<!-- 상단 배경이미지 -->
<div style="height: 410px; width: 100%; top:0px; position: absolute; z-index: 1;">
   <tiles:insertAttribute name="back"/>
</div>
<!-- 메인 -->
<div style="height: auto; width:75%; top: 250px; padding-left:15%; position: relative; z-index: 2; background: white;">
   <div style="height: 160px; width: 100%;">
      <tiles:insertAttribute name="bodyTitle"/>
   </div>
   <div style="height: auto; width: 100%:">
      <tiles:insertAttribute name="body"/>
   </div>
</div>
<!-- 사이드 -->
<div style="height: 760px; width: 25%; top: 330px; right: 0px; position: absolute; z-index: 2;">
   <tiles:insertAttribute name="sideMenu"/>
</div>

<div id="body">
</div>
<div style="height: 100px; background:rgba(14,14,114,0.9); color: white;"></div>
<div id="foot" style="background: #f4f4f4;">
<div style="position: relative; left: 300px; top: 50px; font-weight: bold;" >
   <p >학교명: KH대학교｜대표자: 권은지｜E-mail: jee14@ulsanit.com｜Tel: 052-257-7600｜Fax: 052-257-7822｜Tel: 052-257-7600｜446-77 울산광역시 남구 삼산로35번길 19 (신정동)</p>
   <p>copyright © KH대학교. All Rights Reserved.</p>
</div>
</div>
</body>
</html>