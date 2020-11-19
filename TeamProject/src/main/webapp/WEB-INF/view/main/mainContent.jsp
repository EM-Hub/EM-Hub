<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='resources/css/main.css?ver=2' rel='stylesheet' />
<script src='resources/js/main.js'></script>
<script src='resources/js/ko.js'></script>
<script src='resources/js/cal.js?ver=11'></script>
<script src='resources/js/tabMenu.js'></script>
<script src='resources/js/chat.js?ver=15'></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<style type="text/css">
@font-face{
	font-family: 'NotoSans';
	src: url("resources/font/NotoSansKR-Medium.otf");
}
#calendar {
	width : 100%;
	height : 100%;
	font-size: 12px;
	padding: 0;
	border: none;
}
.fc-col-header{
	background: #191970;
}
.fc-day{background: white;}
.fc-daygrid-day-number{color:  black;}
.fc-day > div > a{color: black;}
.fc-day-sat > div > a {color: blue;} /* 토요일 */
.fc-day-sun > div > a {color: red;}
.fc-day-sun > div > div> a{color: red;}
.fc-day-sat > div > div> a{color: blue;}
.fc-day-sun {background: #FBEFEF;}
.fc-day-sat {background: #EFF8FB;}
.fc-toolbar-title{
	font-weight: bold;
	font-family:'NotoSans' !important;
}
.fc .fc-toolbar-title{
	color: black;
}
.iDiv{
	width: 150px;
	height: 100%;
	text-align: center;
	display: inline-block;
	margin-right: 80px;
}
.iDiv > i{
	font-size: 45px;
	color: white;
}
.iDiv > .it{
	font-size: 30px;
	color: yellow;
}
.iDiv > .ii{
	font-size: 24px;
	color: white;
}
.fadeinleft{
	opacity:0;
    margin-left:-300px;    
    max-width:100%;
}
#bottom-menu {
	height: 100px;
	width: 100%;
	left: 0;
	bottom: 0;
	position: absolute;
	background: rgba(0, 0, 0, 1);
	color: white;
	font-size: 18px;
	padding-top:1em;
	text-align: center;
}
/* tabMenu */
.container{
   margin: 0 auto;
   background: white;
}
ul.tabs{
   margin: 0px;
   padding: 0px;
   list-style: none;
}
ul.tabs li{
   background: #646262;
   color: white;
   font-weight:bold;
   display: inline-block;
   padding: 10px 15px;
   cursor: pointer;
   height: 50px;
   line-height: 30px;
}

ul.tabs li.current{
   background: #ededed;
   color: #222;
}

.tab-content{
   background: #eaeaea;
   padding: 15px;
   height: 500px;
   display: none;
}

.tab-content.current{
   display: inherit;
}

.boardContent{
	width: 100%;
	padding: 5px;
	color: black;
}
.boardContentTitle > a {
	color: #13007C;
	text-decoration: none;
	font-weight: bold;
	font-size: 20px;
}

.pOver{
	padding-left: 10px;
	overflow:hidden;
	text-overflow:ellipsis;
	display:-webkit-box;
	-webkit-line-clamp:2; /* 라인수 */
	-webkit-box-orient:vertical;
	word-wrap:break-word;
	line-height:18px;
	height:36px;
}

#messageDiv::-webkit-scrollbar {
   width: 6px;
}
#messageDiv::-webkit-scrollbar-thumb {
  background-color: #191970;
  border-radius: 10px;
  border: 2px solid transparent;
}
#messageDiv::-webkit-scrollbar-track {
  border-radius: 10px;
  box-shadow: inset 0px 0px 5px white;
}
#chatButton{
	transition: .4s;
	
}
#chatButton:hover{
	cursor: pointer;
	transform: scale(1.7);
	animation: motion 0.3s linear 0s infinite alternate; 
	margin-top: 0;
}
@keyframes motion {
	0% {margin-top: 0px;}
	100% {margin-top: 10px;}
}
</style>
</head>
<body>
<div style="height: auto;">
	<div style="width: 100%; height: 200px;">
		<div style="width: 100%; height: 200px; position: absolute; z-index: 1">
			<img src="resources/images/mainPage1/back300.jpg" width="100%" height="100%" style="object-fit: cover;">
		</div>
		<div style="width: 100%; height: 200px; position: absolute; z-index: 2; background: gray; opacity: 0.8;">
			<div style="width: 30%; height:100%; display: inline-block; padding-top: 30px; padding-left: 100px;">
				<h1 style="color: yellow;">KH UNIVERSITY</h1>
				<span style="color: white; font-size: 20px;">Korea No.1 University</span><br>
				<span style="color: white; font-size: 15px;">미래가 있는 대학교</span>
			</div>
			<div style="width: 70%; height:100%; display: inline-block; float: right; padding-top: 20px; padding-left: 100px;">
				<div class="iDiv">
					<i class="icon-commerical-building"></i><br>
					<span class="it">설립연도</span><br>
					<span class="ii">2020</span>
				</div>
				<div class="iDiv">
					<i class="icon-users"></i><br>
					<span class="it">재적생수</span><br>
					<span class="ii">34,200</span>
				</div>
				<div class="iDiv">
					<i class="icon-globe-1"></i><br>
					<span class="it">협력대학</span><br>
					<span class="ii">60개국 509</span>
				</div>
				<div class="iDiv">
					<i class="icon-graduation-cap"></i><br>
					<span class="it">장학금</span><br>
					<span class="ii">826억</span>
				</div>
				<div class="iDiv">
					<i class="icon-chart-bar"></i><br>
					<span class="it">취업률</span><br>
					<span class="ii">91%</span>
				</div>
			</div>
		</div>		
	</div>
	<div style="width: 100%; height: auto; margin-top: 50px;">
		<div style="width: 100%; height: auto; padding-left: 250px; color: #191970;" class="fadeinleft">
			<span style="font-size: 60px; font-weight: bold;">KH UNIVERSITY</span>
		</div>
		<div style="width: 100%; height: 500px; color: white;">
			<div style="width: 100%; height: 500px; padding-left: 250px; z-index: 2; position: absolute; background: #191970; opacity: 0.6;">
			
			</div>
			<div style="width: 100%; height: 500px; padding-left: 250px; z-index: 3; position: absolute; opacity: 1; background: none;" class="fadeinleft">
				<span style="font-size: 60px; font-weight: bold;">COMMUNITY</span><br><br>
				<span style="font-size: 28px;">다양한 정보와 소식을 확인하세요!</span>
			</div>
			<img src="resources/images/comBack.jpg" width="100%" height="100%" style="object-fit: cover; z-index: 1">
		</div>
		<div style="width: 400px; height: 150px; top: 650px; left: 300px; position: absolute; z-index: 3; border-radius: 10px; overflow: hidden;" class="fadeinleft">
			<img src="resources/images/b3.png" width="100%" height="100%">
		</div>
		<div style="width: 400px; height: 150px; top: 800px; left: 300px; position: absolute; z-index: 3; border-radius: 10px; overflow: hidden;" class="fadeinleft">
			<img src="resources/images/b4.png" width="100%" height="100%" style="object-fit: cover;">
		</div>
		<div style="width: 400px; height: 100px; top: 1050px; left: 300px; position: absolute; z-index: 3" class="fadeinleft">
			<div style="width: 100px; height: 100px; display: inline-block;">
				<a href="https://ko-kr.facebook.com/"><img src="resources/images/facebook.png" width="100%" height="100%"></a>
			</div>
			<div align="center" style="width: 100px; height: 100px; display: inline-block; float: right;">
				<a href="https://www.youtube.com/"><img src="resources/images/youtube.png" width="100%" height="100%"></a>
			</div>
			<div style="width: 100px; height: 100px; display: inline-block; float: right;">
				<a href="https://www.instagram.com/"><img src="resources/images/instagram.png" width="100%" height="100%"></a>
			</div>
			<div style="width: 100px; height: 100px; display: inline-block; float: right;">
				<a href="https://twitter.com/?lang=ko">
				<img src="resources/images/twitter.png" width="100%" height="100%"></a>
			</div>
		</div>
		<div
			style="width: 550px; height: 600px; top: 650px; left: 750px; position: absolute; z-index: 3; background: none;"
			class="fadeinleft container">
			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1">학사일정</li>
				<li class="tab-link " data-tab="tab-2">학사공지</li>
				<li class="tab-link" data-tab="tab-3">행사안내</li>
			</ul>
			<div id="tab-1" class="tab-content current">
				<div id="calendar"></div>
			</div>
			<div id="tab-2" class="tab-content">
				<c:forEach items="${board }" var="vo">
					<div style="height: 30px; width:100%;">
						<div class="boardContent">
							<div style="width: 50%; height:30px; display: inline-block;" class="boardContentTitle">
								<a href="boardDetail.do?categoryNum=${vo.categoryNum }&boardNum=${vo.boardNum}&mainNum=4&sideNum=11">${vo.boardTitle }</a>
							</div>
							<div style="width: 50%; height:30px; display: inline-block; float: right;" align="right">
								<span style="color: #949494;">${vo.createDate }</span>
							</div>
						</div>
					</div>
					<c:if test="${vo.rowNum < 3 }">
						<div style="height: 45px; width: 100%;" class="pOver">
							<p>${vo.boardContent }</p>
						</div>
					</c:if>
						<hr style="border: 1px dotted #ccc;">
				</c:forEach>
					<div align="right" style="width: 100%; height: 30px; bottom: 0;">
						<a href="board.do?mainNum=4&sideNum=11&sideDetailNum=24">
							more<i class="icon-plus" style="font-weight: bold; font-size: 20px;"></i>
						</a>
					</div>
			</div>
			<div id="tab-3" class="tab-content">행사</div>
		</div>
		<!-- 채팅 -->
		<div style="width: 400px; height: 600px; top: 650px; right: 150px; position: absolute; z-index: 3;" id="chat">
			<div style="background-color: rgb(255, 209, 4); border-radius: 15px" align="center"> 
				<div style="height: 50px; line-height: 50px; padding-left: 15px;" align="left">
					<span style="font-weight: bold; font-size: 18px;">실시간 채팅</span>
					<i class="icon-down-open close" ></i>
					<!-- <button type="button" onclick="closeSocket();">대회방 나가기</button> --> 
				</div>
				<div style="height: 440px; background: white; border-radius: 10px; width: 380px; overflow: auto;" id="messageDiv">
					<div id="messages">
					</div>
				</div> <!-- Server responses get written here -->
				<div style="height: 10px"></div>
					<div style="background-color: white; height: 60px;border-radius: 10px; width: 380px; padding: 5px">
						<input type="text" id="sender" value="${loginInfo.memId}" style="display: none;"> 
						<input type="text" id="messageinput" style="width: 300px; height: 50px; border: none;"> 
						<button type="button" id="sendBtn" style="background: #191970 ; outline: none;border: none;border-radius: 6px;color: white;	width:50px;height: 40px">전송</button> 
					</div>
				<div style="height: 10px"></div>
				</div> 
		 </div>
		 <div style="width: 400px; height: 600px; top: 650px; right: 150px; position: absolute; z-index: 3; padding-right: 30px;" id="chatIcon" align="right">
		 	<div style="width: 50px; height: auto;" id="chatButton"><i class="icon-chat" style="font-size: 50px; color: yellow"></i></div>
		 </div>
		 
	</div>
</div>
<div style="height: 700px;">

</div>
<div id="bottom-menu">
	<p>학교명: KH대학교｜대표자: 권은지｜E-mail: jee14@ulsanit.com｜Tel: 052-257-7600｜Fax: 052-257-7822｜Tel: 052-257-7600｜446-77 울산광역시 남구 삼산로35번길 19 (신정동)</p>
	<p>copyright © KH대학교. All Rights Reserved.</p>
</div>
</body>
</html>