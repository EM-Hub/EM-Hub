<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/commonTable.css?ver=145"/>
<link rel="stylesheet" type="text/css" href="resources/css/facReserve.css?ver=145"/>
<style type="text/css">
.iconDiv{
 	width:130px; 
 	height:130px; 
 	display: inline-block; 
 	background-color: #e9f2f9; 
 	padding: 20px; 
 	border-radius: 20px;
 	margin: 3px;
}
.iconDiv:hover{
	background-color: #ffd255;
	cursor: pointer;
}
img{
 	padding: 5px;
}
.typoDiv{
	padding-top: 10px;
	font-size: 16px; 
	font-weight: bold;
	font-family:'NotoSans' !important;
}


#cal-table{
	border-color: transparent;
}

#cal-table tr,td{
	border-color: transparent;
	padding: 10px;
}

#conTable{
	
}

#conTable tr, td{
	height: 50px;
}

.possible:hover{
	cursor: pointer;
	text-decoration: underline;
}


</style>
</head>
<body>
<c:if test="${insertResult eq 1 or insertResult == 1}">
	<script type="text/javascript">
		alert('시설 예약이 완료되었습니다.');
	</script>
</c:if>
<div class="container" align="center">
  <div class="my-calendar clearfix">
    <div class="clicked-date">
      <div class="cal-day"></div>
      <div class="cal-date"></div>
    </div>
    <div class="calendar-box">
      <div class="ctr-box clearfix">
        <button type="button" title="prev" class="btn-cal prev">
        </button>
        <span class="cal-month"></span>
        <span class="cal-year"></span>
        <button type="button" title="next" class="btn-cal next">
        </button>
      </div>
      <table class="cal-table" id="cal-table">
        <thead>
          <tr>
            <th>S</th>
            <th>M</th>
            <th>T</th>
            <th>W</th>
            <th>T</th>
            <th>F</th>
            <th>S</th>
          </tr>
        </thead>
        <tbody class="cal-body"></tbody>
      </table>
    </div>
  </div>
  <!-- // .my-calendar -->
  <div class="iconDiv">
  		<input type="hidden" value="OUT1">
	  <img src="resources/images/football.png" width="60px">
	  <div class="typoDiv">운 동 장</div>
  </div>
  <div class="iconDiv">
  		<input type="hidden" value="OUT2">
	  <img src="resources/images/sportwoman.png" width="60px">
	  <div class="typoDiv">실내체육관</div>
  </div>
  <div class="iconDiv">
  		<input type="hidden" value="OUT3">
	  <img src="resources/images/meeting.png" width="60px">
	  <div class="typoDiv">회 의 실</div>
  </div>
  <div class="iconDiv">
  		<input type="hidden" value="OUT4">
	  <img src="resources/images/conference.png" width="60px">
	  <div class="typoDiv">대 강 당</div>
  </div>
  <div class="iconDiv">
  		<input type="hidden" value="OUT5">
	  <img src="resources/images/mutiRoom.png" width="60px">
	  <div class="typoDiv">멀티미디어실</div>
  </div>
  <div style="height: 50px"></div>
	  <div id="conditionDiv" style="width: 100%;">
	  	<div id="tableDiv" style="display: inline-block; width: 300px;  margin-right: 50px" align="left"></div>
	  	<div id= "alertDiv" style="display : inline-block;width: 300px; vertical-align: top;" align="right" >
	  	<h5 style="color: red">[사용시간을 먼저 선택해주세요.]</h5>
	  	</div>
	  	<div id= "regFormDiv" style="display : inline-block;width: 300px; vertical-align: top;" align="right" >
	  	<form action="insertFacUse.do?mainNum=5&sideNum=13&sideDetailNum=29" method="post">
	  		<input type="hidden" id="ttSeq" name="ttSeq">
	  		<input type="hidden" id="facUseDay" name="facUseDay">
	  		<input type="hidden" id="facCode" name="facCode">
	  		<table style="margin: 0">
	  			<colgroup>
	  				<col width="30%">
	  				<col width="70%">
	  			</colgroup>
	  			<tr>
	  				<td class="title">신청자</td>
	  				<td><input type="text" value = "${memName}(${loginInfo.memId })" readonly></td>
	  			</tr>
	  			<tr>
	  				<td class="title">이메일</td>
	  				<td><input type="text" name = "userEmail" value = "${loginInfo.memEmail}" readonly></td>
	  			</tr>
	  			<tr>
	  				<td class="title">사용일시</td>
	  				<td>
	  					<input type="text"  name="facUseDate" id="facUseDate" style="border: none" value = "2015.20.64 33:00~33:33">
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="title">사용목적</td>
	  				<td><textarea cols="22" rows="3" name="purpose"></textarea></td>
	  			</tr>
	  		</table>
	  		<input type="submit" value="신청하기">
	  	</form>
	  	</div>
	  </div>
</div>
<script src="resources/js/facReserve.js?ver=64"></script>
<script src="resources/js/facReserve2.js?ver=66"></script>
</body>
</html>