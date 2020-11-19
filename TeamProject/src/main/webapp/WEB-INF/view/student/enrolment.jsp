<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
table{
	width: 1000px;
	text-align: center;
}
td{
	border-bottom: 1px solid #F5F5F5;
}
.title2{
	height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
}
</style>
</head>
<body>
<div style="width: 100%; height: auto;" align="center">
	<table>
		<colgroup>
			<col width="15%">
			<col width="5%">
			<col width="35%">
			<col width="10%">
			<col width="5%">
			<col width="10%">
			<col width="20%">
		</colgroup>
		<tr>
			<td class="title2">코드</td>
			<td class="title2">학기</td>
			<td class="title2">강의명</td>
			<td class="title2">담당교수</td>
			<td class="title2">학점</td>
			<td class="title2">권장학년</td>
			<td class="title2">시간(강의실)</td>
		</tr>
		<c:if test="${empty cartList }">
			<tr>
				<td colspan="7">수강바구니에 담은 과목이 없습니다.</td>
			</tr>
		</c:if>
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
			</tr>
		</c:forEach>
	</table>
	<br>
	<c:if test="${not empty cartList }">
		<input type="button" value="수강신청" id="enrolmentBtn">
	</c:if>
</div>
<script src="resources/js/enrolment.js?ver=9"></script>
</body>
</html>