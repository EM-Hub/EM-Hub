<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {margin:0; padding:0;}
ul li {list-style:none;}
.clearfix:after{content:'';display:block; clear:both;
}
#header {   
   height:120px;
   width: 100%;
   background:linear-gradient(#191970 120px, rgba(25,25,112,0.7) 50px, rgba(25,25,112,1.0));
   position: absolute;
   z-index: 999;
}
nav {
   width:100%;
   height: 100%;
   margin:0;
}
nav > ul > li { /*상단 메뉴나오는 곳*/
float:left; 
line-height:115px;
margin-left : 100px;
width: 130px;
position: relative;
text-align: center;
}
nav > ul > li ul{  /*상단메뉴 밑에 사이드메뉴  */
width: 130px;
height: 300px;
position: absolute;
top: 120px;
display: none;
text-align: center;
}
.menuA{
	color: white;
	font-size: 20px;
	font-family: 'NotoSans' !important;
	text-decoration: none;
}
.menuA:hover{
	color: #FFCC00;
}
nav > ul > li:hover ul{ 
display: block;
}
nav > ul > li ul li{
white-space:nowrap;
}
.drop{
	color:white;
	width:130px;
	height: 50px;
	line-height: 50px;
	font-weight: bold;
	font-size: 18px;
}
.drop > a{
	color: white;
	text-decoration: none;
}
.drop > a:hover{
	color: #FFCC00;
	text-decoration: none;
}
</style>
</head>
<body>
<div style="background: rgba(14,14,114,0.9); display: inline-block; float: right;" id="header" align="center">
   <a href="mainPage.do"><img src="resources/images/KH_logo2.png" width="200px" height="80px"
    style="display: inline-block; float: left; position: relative; top: 15px; margin-left: 60px;" id="logo"></a>
   <nav>
      <ul class="clearfix">
         <c:forEach items="${mainMenu }" var="main">
            <li class="mainLi" data-mainNum="${main.mainNum }"><a href="${main.menuUrl }?mainNum=${main.mainNum}" class="menuA">${main.mainName}</a>
               <ul class="sideUl">
               </ul>
            </li>
         </c:forEach>
      </ul>
   </nav>
</div>
<script src="resources/js/dropMenu.js?ver=299"></script>
</body>
</html>