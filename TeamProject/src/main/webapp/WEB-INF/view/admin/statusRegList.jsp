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
tr{
	border-bottom: 1px solid #F5F5F5;
	height: 25px;
}
#listTable .title2{
	background: #191970;
	color: white;
	font-weight: bold;
	height: 30px;
}
input[type="button"]{
	width: 3em;
	height: 2em;
}
</style>
</head>
<body>
<div style="width: 100%; height:auto; padding: 15px;" align="center">
<table id="listTable">
		<colgroup>
			<col width="5%">
			<col width="5%">
			<col width="15%">
			<col width="15%">
			<col width="10%">
			<col width="10%">
			<col width="15%">
			<col width="15%">
			<col width="10%">
		</colgroup>
		<tr>
			<td class="title2"><input type="checkbox" id="checkAll"></td>
			<td class="title2">No</td>
			<td class="title2">학번</td>
			<td class="title2">이름</td>
			<td class="title2">기존학적</td>
			<td class="title2">변경신청</td>
			<td class="title2">신청일</td>
			<td class="title2">승인일</td>
			<td class="title2">승인상태</td>
		</tr>
		<c:forEach items="${statusRegList }" var="sr">
			<tr>
				<td><input type="checkbox" class="check" value="${sr.regNum }"></td>
				<td>${sr.regNum }</td>
				<td>${sr.stuNum }</td>
				<td>${sr.stuName }</td>
				<td>
					<input type="hidden" value="${sr.fromStatus }">
					<c:if test="${sr.fromStatus eq 1 }">재학</c:if>
					<c:if test="${sr.fromStatus eq 2 }">휴학</c:if>
					<c:if test="${sr.fromStatus eq 3 }">졸업</c:if>
					<c:if test="${sr.fromStatus eq 4 }">제적</c:if>
					<c:if test="${sr.fromStatus eq 5 }">재입학</c:if>
					<c:if test="${sr.fromStatus eq 6 }">자퇴</c:if>
					<c:if test="${sr.fromStatus eq 7 }">복학</c:if>
				</td>
				<td>
					<input type="hidden" value="${sr.toStatus }">
					<c:if test="${sr.toStatus eq 1 }">재학</c:if>
					<c:if test="${sr.toStatus eq 2 }">휴학</c:if>
					<c:if test="${sr.toStatus eq 3 }">졸업</c:if>
					<c:if test="${sr.toStatus eq 4 }">제적</c:if>
					<c:if test="${sr.toStatus eq 5 }">재입학</c:if>
					<c:if test="${sr.toStatus eq 6 }">자퇴</c:if>
					<c:if test="${sr.toStatus eq 7 }">복학</c:if>
				</td>
				<td>${sr.applicationDate }</td>
				<c:if test="${empty sr.approvalDate }"><td> - </td></c:if>
				<c:if test="${not empty sr.approvalDate }"><td>${sr.approvalDate }</td></c:if>
				<c:if test="${sr.isComfirm eq 'N'}"><td style="color: red" class="isComfirm">승인대기중</td></c:if>
				<c:if test="${sr.isComfirm eq 'Y'}"><td style="color: blue" class="isComfirm">승인완료</td></c:if>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<input type="button" value="승인" id="updateStatus">
</div>
<script src="resources/js/statusRegList.js?ver=101"></script>
</body>
</html>