<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수리신청페이지</title>
<style type="text/css">
table {
width: 80%;
text-align: center;
border-bottom: 2px solid gray;
font-weight: bold;

}
td{
	height: 35px;
}
thead {
border-top : 3px solid #191970;
color: black;
border-bottom: 1px solid black;
}
.title{
height: 40px;
	background: #191970;
	color: white;
	font-weight: bold;
}
</style>
</head>
<body>
<input type="hidden" id="mainNum" value=${menuSideDetailVO.mainNum }>
<input type="hidden" id="sideNum" value=${menuSideDetailVO.sideNum }>
<input type="hidden" id="sideDetailNum" value=${menuSideDetailVO.sideDetailNum }>
<div style="width: 100%;" align="center">
	<table>
		<colgroup>
			<col width="10%">
			<col width="40%">
			<col width="10%">
			<col width="15%">
			<col width="15%">
			<col width="10%">
		</colgroup>
		<thead>
			<tr>
				<td class="title">번호</td>
				<td class="title">제목</td>
				<td class="title">작성자</td>
				<td class="title">신청일</td>
				<td class="title">처리상태</td>
				<td class="title">조회</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${repairList }" var="repair">
			<tr>
				<td class="requestNum" >${repair.requestNum }</td>
				<td class="titleDetail"><a href="requestDetail.do?requestNum=${repair.requestNum }&mainNum=${menuSideDetailVO.mainNum }&sideNum=${menuSideDetailVO.sideNum }
				&sideDetailNum=${menuSideDetailVO.sideDetailNum }">${repair.requestTitle }</a></td>
				<td>${repair.requestName }</td>
				<td>${repair.requestCreate }</td>
				<c:if test="${repair.requestStatus eq 'N' }">
					<td background="skyblue">처리대기중</td>
				</c:if>
				<c:if test="${repair.requestStatus eq 'Y' }">
					<td style="color: blue">처리완료</td>
				</c:if>
				<td>${repair.requestReadCnt }</td>
			</tr>
		</c:forEach>
		</tbody>	
	</table>
</div>
	<input type="hidden" value="${side.mainNum }" name="mainNum">
	<input type="hidden" value="${side.sideNum }" name="sideNum">
	<input type="hidden" value="${side.sideDetailNum }" name="sideDetailNum">
<script>
//이전 버튼 이벤트
function fn_prev(page, range, rangeSize, mainNum, sideNum, sideDetailNum) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		var url = "repairRequest.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&mainNum=" + mainNum;
		url = url + "&sideNum=" + sideNum;
		url = url + "&sideDetailNum=" + sideDetailNum;
		location.href = url;
	}

  //페이지 번호 클릭
	function fn_pagination(page, range, rangeSize, mainNum, sideNum, sideDetailNum) {
		var url = "repairRequest.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&rangeSize=" + rangeSize;
		url = url + "&mainNum=" + mainNum;
		url = url + "&sideNum=" + sideNum;
		url = url + "&sideDetailNum=" + sideDetailNum;
		location.href = url;	
	}

	//다음 버튼 이벤트
	function fn_next(page, range, rangeSize, mainNum, sideNum, sideDetailNum) {
		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;
		var url = "repairRequest.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&mainNum=" + mainNum;
		url = url + "&sideNum=" + sideNum;
		url = url + "&sideDetailNum=" + sideDetailNum;
		location.href = url;
	}
</script>
	<!-- pagination{s} -->
	<div id="paginationBox" style="width: 100%;" align="center">
		<ul class="pagination">
			<c:if test="${repairRequestVO.prev}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${repairRequestVO.page}', '${repairRequestVO.range}', '${repairRequestVO.rangeSize}, '${side.mainNum }', '${side.sideNum }', '${side.sideDetailNum }'')">Previous</a></li>
			</c:if>
			<c:forEach begin="${repairRequestVO.startPage}" end="${repairRequestVO.endPage}" var="idx">
				<li class="page-item <c:out value="${repairRequestVO.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${repairRequestVO.range}', '${repairRequestVO.rangeSize}', '${side.mainNum }', '${side.sideNum }', '${side.sideDetailNum }')"> ${idx} </a></li>
			</c:forEach>

			<c:if test="${repairRequestVO.next}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${repairRequestVO.page}', '${repairRequestVO.range}', '${repairRequestVO.rangeSize}, '${side.mainNum }', '${side.sideNum }', '${side.sideDetailNum }'')" >Next</a></li>
			</c:if>
		</ul>
	</div>
	<!-- pagination{e} -->
<div style="width: 100%; margin-top: 30px;" align="center">
	<input type="button" value="글쓰기" onclick="location.href='repairRequestForm2.do?mainNum=11&sideNum=35';">
</div>
</body>
</html>