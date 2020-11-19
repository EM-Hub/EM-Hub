<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
i{
	cursor: pointer;
}
</style>
</head>
<body>
<div style="width: 100%; height: auto;" align="center">
	<table>
		<colgroup>
			<col width="15%">
			<col width="5%">
			<col width="30%">
			<col width="10%">
			<col width="5%">
			<col width="10%">
			<col width="20%">
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
		<c:if test="${empty stuTTList }">
			<tr>
				<td colspan="8">수강신청한 과목이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty stuTTList }">
			<c:forEach items="${stuTTList }" var="tt">
			<tr>
				<td>${tt.lecTtCode }</td>
				<td>${tt.semCode }</td>
				<td>${tt.lectureName }</td>
				<td>${tt.profName }</td>
				<td class="credit">${tt.lecCredit }</td>
				<td>${tt.recYear }</td>
				<td class="cartTime">
					<c:forEach items="${tt.lecTimeList }" var="time">
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
				<td><i class="icon-minus" id="deleteTT"></i></td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
</div>
<script src="resources/js/delStuTT.js?ver=3"></script>
</body>
</html>