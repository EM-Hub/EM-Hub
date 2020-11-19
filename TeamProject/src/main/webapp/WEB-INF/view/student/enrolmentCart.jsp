<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.selectTable table{
	width: 650px;
	text-align: center;
}
.selectTable table td{
	border: 1px solid #bfbfbf;
}
select{
	width: 100%;
	height: 100%;
	border: none;
	text-align-last: center;
	outline: none;
}
input[type="text"]{
	width: 100%;
	height: 100%;
	border: none;
	outline: none;
}
.selectTable .title{
	border-left: 3px solid #191970;
	background: #F5F5F5;
	font-weight: bold;
}
.listTable table{
	width: 1000px;
	text-align: center;
}
.listTable table td{
	border-bottom: 1px solid #F5F5F5;
	height: 60px;
}
.listTable .title2{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
}
.cartInfoDiv .title{
	border-left: 3px solid #191970;
	background: #F5F5F5;
	font-weight: bold;
}
.listTable tr:nth-child(even){
	background: #f2f2f2;
}
.listTable tr:hover{
	background: #B5D0FB;
}
.title2 tr, td{
	border: none;
}
i{
	cursor: pointer;
}
.cartInfoDiv table{
	width: 350px;
	border: 1px solid #bfbfbf;
	text-align: center;
}
.cartInfoDiv td{
	height: 30px;
}
.facCode{
	cursor: pointer;
}
.listTable::-webkit-scrollbar {
   width: 10px;
}
.listTable::-webkit-scrollbar-thumb {
  background-color: #191970;
  border-radius: 10px;
  border: 2px solid transparent;
}
.listTable::-webkit-scrollbar-track {
  border-radius: 10px;
  box-shadow: inset 0px 0px 5px white;
}
</style>
</head>
<body>
<input type="hidden"id="mainNum" value=${menuSideDetailVO.mainNum }>
<input type="hidden"  id="sideNum" value=${menuSideDetailVO.sideNum }>
<input type="hidden" id="sideDetailNum" value=${menuSideDetailVO.sideDetailNum }>
<input type="hidden" value="${sessionScope.loginInfo.memId }" id="stuNum">
<div style="height: auto; width: 100%;" align="center">
	<div style="height: 200px; width: 100%;" align="center" class="selectTable">
		<table>
			<colgroup>
				<col width="10%">
				<col width="30%">
				<col width="10%">
				<col width="30%">
				<col width="20%">
			</colgroup>
			<tr style="height: 40px;">
				<td class="title">대 학</td>
				<td>
					<select id="colSel">
						<option value="0">전 체</option>
						<c:forEach items="${collegeList }" var="col">
							<option value="${col.collegeNum }">${col.collegeName }</option>
						</c:forEach>
					</select>
				</td>
				<td class="title">권장학년</td>
				<td>
					<select id="yearSel">
						<option value="0">전 체</option>
						<option value="1">1학년</option>
						<option value="2">2학년</option>
						<option value="3">3학년</option>
					</select>
				</td>
				<td rowspan="2" style="border: none;"><input type="button" value="조회" id="selectBtn"></td>
			</tr>
			<tr style="height: 40px;">
				<td class="title">전 공</td>
				<td class="depTd">
					<select id="depSel">
						<option value="0">전 체</option>
						<c:forEach items="${depList }" var="dep">
							<option value="${dep.depNo }">${dep.depName }</option>
						</c:forEach>
					</select>
				</td>
				<td class="title">학 점</td>
				<td>
					<select id="lecCredit">
						<option value="0">전 체</option>
						<option value="1">1학점</option>
						<option value="2">2학점</option>
						<option value="3">3학점</option>
					</select>
				</td>
			</tr>
		</table>
		<br>
		<table>
			<colgroup>
				<col width="10%">
				<col width="30%">
				<col width="10%">
				<col width="30%">
				<col width="20%">
			</colgroup>
			<tr style="height: 50px;">
				<td class="title">검 색</td>
				<td colspan="3"><input type="text" placeholder="과목코드 또는 강의명을 검색하세요." class="searchInput"></td>
				<td style="border: none;"><input type="button" value="검색" id="searchBtn"></td>
			</tr>
		</table>
	</div>
	<div id="mapDiv" style="width: 80%; height: 300px;">
		<img src="resources/images/map.png" width="80%" height="300px" style="z-index: 1;">
		<i class="icon-commerical-building" id="fA" style="font-size: 40px; z-index: 3; top: 370px; left: 500px; position: absolute;"></i>
		<i class="icon-commerical-building" id="fB" style="font-size: 40px; z-index: 3; top: 520px; left: 650px; position: absolute;"></i>
		<i class="icon-commerical-building" id="fC" style="font-size: 40px; z-index: 3; top: 570px; right: 550px; position: absolute;"></i>
		<i class="icon-commerical-building" id="fD" style="font-size: 40px; z-index: 3; top: 370px; right: 500px; position: absolute;"></i>
		<i class="icon-commerical-building" id="fE" style="font-size: 40px; z-index: 3; top: 370px; right: 300px; position: absolute;"></i>
		<i class="icon-commerical-building" id="fF" style="font-size: 40px; z-index: 3; top: 570px; right: 350px; position: absolute;"></i>
		<input type="button" value="닫기" id="closeBtn">
	</div>
	<div style="width: 95%" align="center"><p style="color: blue">*건물코드를 클릭하면 해당건물의 상세위치가 나타납니다.</p></div>
	<div style="height: 450px; width: 95%; overflow-y: scroll; margin-top: 20px;" align="center" class="listTable">
		<table>
			<colgroup>
				<col width="10%">
				<col width="5%">
				<col width="25%">
				<col width="10%">
				<col width="5%">
				<col width="10%">
				<col width="5%">
				<col width="10%">
				<col width="15%">
				<col width="5%">
			</colgroup>
			<tr>
				<td class="title2">코드</td>
				<td class="title2">학기</td>
				<td class="title2">강의명</td>
				<td class="title2">담당교수</td>
				<td class="title2">학점</td>
				<td class="title2">권장학년</td>
				<td class="title2">정원</td>
				<td class="title2">현재인원</td>
				<td class="title2">시간(강의실)</td>
				<td class="title2"><i class="icon-plus"></i></td>
			</tr>
			<tbody id="lecList">
			<c:forEach items="${lecTTList}" var="lec">
				<tr>
					<td>${lec.lecTtCode }</td>
					<td>${lec.semCode }</td>
					<td>${lec.lectureName }</td>
					<td>${lec.profName }</td>
					<td>${lec.lecCredit }</td>
					<td>${lec.recYear }학년</td>
					<td>${lec.stuMaxNum }</td>
					<td>${lec.stuAppNum }</td>
					<td class="timeTd">		    				 
		    			<c:forEach items="${lec.lecTimeList }" var="time">
		    				<c:if test="${time.lecWeek == 2 }">
		    					월
		    				</c:if>
		    				<c:if test="${time.lecWeek == 3 }">
		    					화
		    				</c:if>
		    				<c:if test="${time.lecWeek == 4 }">
		    					수
		    				</c:if>
		    				<c:if test="${time.lecWeek == 5 }">
		    					목
		    				</c:if>
		    				<c:if test="${time.lecWeek == 6 }">
		    					금
		    				</c:if>
		    			${time.ttSeq }교시
		    			<span style="color: blue;" class="facCode">(${time.facCode })</span>
		    			<br>
		    			</c:forEach>	   
		    		</td>
		    		<td><i class="icon-plus" id="cartBtn"></i></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<br>
	</div>
	<div style="width: 95%; height: auto; padding-top: 30px;" align="center" class="listTable">
		<i class="icon-folder" style="font-size: 30px;"></i>&nbsp;&nbsp;&nbsp;<span style="font-size: 30px; font-weight: bold;">과목바구니</span>
		<br><br>
		<table>
			<colgroup>
				<col width="10%">
				<col width="5%">
				<col width="20%">
				<col width="10%">
				<col width="5%">
				<col width="10%">
				<col width="15%">
				<col width="5%">
			</colgroup>
			<tr>
				<td class="title2">코드</td>
				<td class="title2">학기</td>
				<td class="title2">강의명</td>
				<td class="title2">담당교수</td>
				<td class="title2">학점</td>
				<td class="title2">권장학년</td>
				<td class="title2">시간(강의실)</td>
				<td class="title2"><i class="icon-minus"></i></td>
			</tr>
			<c:forEach items="${cartList }" var="cart">
				<tr>
					<td class="lecTtCode">${cart.lecTtCode }</td>
					<td>${cart.semCode }</td>
					<td>${cart.lectureName }</td>
					<td>${cart.profName }</td>
					<td class="credit">${cart.lecCredit }</td>
					<td>${cart.recYear }</td>
					<td class="cartTime">
						<c:forEach items="${cart.lecTimeList }" var="time">
		    				<c:if test="${time.lecWeek == 2 }">
		    					월
		    				</c:if>
		    				<c:if test="${time.lecWeek == 3 }">
		    					화
		    				</c:if>
		    				<c:if test="${time.lecWeek == 4 }">
		    					수
		    				</c:if>
		    				<c:if test="${time.lecWeek == 5 }">
		    					목
		    				</c:if>
		    				<c:if test="${time.lecWeek == 6 }">
		    					금
		    				</c:if>
		    			${time.ttSeq }교시
		    			(${time.facCode })
		    			<br>
		    			</c:forEach>
					</td>
					<td><i class="icon-minus" id="delCart"></i></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div style="width: 100%; height: auto; margin-top: 20px;" class="cartInfoDiv" align="center">
		<table>
			<colgroup>
				<col width="30%">
				<col width="30%">
				<col width="*">
			</colgroup>
			<tr>
				<td class="title">총 학점</td>
				<td><span id="sum" style="color: red;"></span></td>
				<td align="left"><span style="color: blue; font-size: 13px;">학기당 수강 할 수 있는</span><br><span style="color: blue; font-size: 13px;">최대학점은 20점입니다.</span></td>
			</tr>
		</table>
	</div>
	<br><br><br><br><br><br><br>
</div>
<script src="resources/js/enrolmentCart.js?ver=68"></script>
</body>
</html>