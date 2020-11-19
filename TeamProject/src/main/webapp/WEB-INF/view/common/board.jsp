<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/board.js?ver=111111"></script>
<style type="text/css">
#board{
	width: 1000px;
	text-align: center;
}
#board td{
	border-bottom: 1px solid #F5F5F5;
	height: 50px;
}
.title2{
	background: #F5F5F5;
	border-left: 3px solid #191970;
	font-size: 15px;
	font-weight: bold;
	color: #191970;	
	height: 40px;
	text-align: center;
}
.title3{
	height: 50px;
	background: #191970;
	color: white;
	font-weight: bold;
}
#board tr:nth-child(even){
	background: #f2f2f2;
}
#board tr:hover{
	background: #B5D0FB;
}
#board tr, td{
	border: none;
}
input[type=text] {
	border: none;
	height: 100%;
	width: 100%;
}
input[type=checkbox] {
	margin: 5px
}
select{
	width: 100%;
	height: 100%;
	border: none;
	padding-left: 50px;
	align-content: center;
}
</style>
</head>
<body>
<input type="hidden" value="${category }" id="boardCategory">
<div style="height: 30px;"></div>
<div align="center" style="width: 100%;">
	<form action="board.do" method="post">
	<table border="1" style="width: 800px;">
		<colgroup>
			<col width="15%">
			<col width="20%">
			<col width="15%">
			<col width="40%">
			<col width="10%">
		</colgroup>
		<tr>
			<td class="title2">검색조건</td>
			<td align="center">
				<select name="searchKeyword">
					<option value="BOARD_TITLE">제목</option>
					<option value="BOARD_WRITER">작성자</option>
				</select>
			</td>
			<td class="title2">검색내용</td>
			<td align="center"><input type="text" style="width: 98%" name="searchValue" placeholder="검색어를 입력하세요."></td>
			<td align="center">
				<input type="submit" value="검색" style="z-index: 1; display: block;">
			</td>
		</tr>
	</table>
	<input type="hidden" value="${side.mainNum }" name="mainNum" id="m1">
	<input type="hidden" value="${side.sideNum }" name="sideNum" id="s1">
	<input type="hidden" value="${side.sideDetailNum }" name="sideDetailNum" id="d1">
	<input type="hidden" value="${category }" name="categoryNum" id="boardCategory">
	</form>
</div>
<!-- 자유게시판 -->

<c:if test="${category == 1 }">
<div align="center">
<div style="height: 50px;"></div>
<table id="board">
	<colgroup>
		<col width="30%">
		<col width="20%">
		<col width="30%">
		<col width="20%">
	</colgroup>

	<tr>
		<td class="title3">제목</td>
		<td class="title3">작성자</td>
		<td class="title3">날짜</td>
		<td class="title3">조회수</td>
	</tr>
	<c:forEach items="${board }" var="vo">
	<tr>
		<!-- 댓글갯수 입력 -->
		<td><a href="boardDetail.do?categoryNum=${category }&boardNum=${vo.boardNum}&mainNum=${side.mainNum}&sideNum=${side.sideNum}&sideDetailNum=${side.sideDetailNum}">${vo.boardTitle }<c:if test="${vo.commentCnt != 0 }"> <span style="color: red"> (${vo.commentCnt})</span></c:if></a></td>
		<td>${vo.boardWriter }</td>
		<td>${vo.createDate }</td>
		<td>${vo.readCnt }</td>
	</tr>
	</c:forEach>
</table>
<br>
<input type="button" value="글쓰기" id="board1">
</div>
</c:if>

<!-- 건의게시판 -->
<c:if test="${category == 2 	}">
<div align="center">
<div style="height: 50px;">${count }</div>
<table id="board">
	<tr>
		<td class="title3">제목</td>
		<td class="title3">작성자</td>
		<td class="title3">날짜</td>
		<td class="title3">조회수</td>
	</tr>
	<c:forEach items="${board }" var="vo">
	<tr>
		<td><a href="boardDetail.do?categoryNum=${category }&boardNum=${vo.boardNum}&mainNum=${side.mainNum}&sideNum=${side.sideNum}&sideDetailNum=${side.sideDetailNum}"><c:if test="${vo.boardGroup != 0}"><span>[답글]</span></c:if>${vo.boardTitle }</a></td>
		<td>${vo.boardWriter }</td>
		<td>${vo.createDate }</td>
		<td>${vo.readCnt }</td>
	</tr>
	</c:forEach>
</table>
<br>
<input type="button" class="btn btn-success" id="board2" value="글쓰기">
</div>
</c:if>

<!-- 공지게시판 -->

<c:if test="${category == 3 }">
<div align="center">
<div style="height: 50px;"></div>
<table id="board">
	<tr>
		<td class="title3">글번호</td>
		<td class="title3">제목</td>
		<td class="title3">작성자</td>
		<td class="title3">날짜</td>
		<td class="title3">조회수</td>
	</tr>
	<c:forEach items="${board }" var="vo">
	<tr>
		<td>${vo.boardNum }</td>
		<td><a href="boardDetail.do?categoryNum=${category }&boardNum=${vo.boardNum}&mainNum=${side.mainNum}&sideNum=${side.sideNum}&sideDetailNum=${side.sideDetailNum}"">${vo.boardTitle }</a></td>
		<td>${vo.boardWriter }</td>
		<td>${vo.createDate }</td>
		<td>${vo.readCnt }</td>
	</tr>
	</c:forEach>
</table>
<br>
<c:if test="${memGrade eq 'E' }">
	<input type="button" class="btn btn-success" id="board3" value="글쓰기">
</c:if>

</div>
</c:if>

<!-- 전체게시판 -->
<c:if test="${category == 4 }">
<div align="center">
<div style="height: 50px;"></div>
<table id="board">
	<tr>
		<td class="title3">게시판</td>
		<td class="title3">제목</td>
		<td class="title3">작성자</td>
		<td class="title3">날짜</td>
		<td class="title3">조회수</td>
	</tr>
	<c:forEach items="${board }" var="vo">
	<tr>
		<c:if test="${vo.categoryNum == 1 }">
		<td>자유게시판</td>
		</c:if>
		<c:if test="${vo.categoryNum == 2 }">
		<td>건의게시판</td>
		</c:if>
		<c:if test="${vo.categoryNum == 3 }">
		<td><span style="color: red;">공지게시판</span></td>
		</c:if>
		<td><a href="boardDetail.do?categoryNum=${category }&boardNum=${vo.boardNum}&mainNum=${side.mainNum}&sideNum=${side.sideNum}&sideDetailNum=${side.sideDetailNum}""><c:if test="${vo.boardGroup != 0}"><span>[답글]</span></c:if>${vo.boardTitle }<c:if test="${vo.commentCnt != 0 }"> <span style="color: red"> (${vo.commentCnt})</span></c:if></a></td>
		<td>${vo.boardWriter }</td>
		<td>${vo.createDate }</td>
		<td>${vo.readCnt }</td>
	</tr>
	</c:forEach>
</table>
</div>
</c:if>

<script>
//이전 버튼 이벤트
function fn_prev(page, range, rangeSize, category, mainNum, sideNum, sideDetailNum) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		var url = "board.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&categoryNum=" + category;
		url = url + "&mainNum=" + mainNum;
		url = url + "&sideNum=" + sideNum;
		url = url + "&sideDetailNum=" + sideDetailNum;
		location.href = url;
	}

  //페이지 번호 클릭
	function fn_pagination(page, range, rangeSize, category, mainNum, sideNum, sideDetailNum) {
		var url = "board.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&rangeSize=" + rangeSize;
		url = url + "&categoryNum=" + category;
		url = url + "&mainNum=" + mainNum;
		url = url + "&sideNum=" + sideNum;
		url = url + "&sideDetailNum=" + sideDetailNum;
		location.href = url;	
	}

	//다음 버튼 이벤트
	function fn_next(page, range, rangeSize, category, mainNum, sideNum, sideDetailNum) {
		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;
		var url = "board.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&categoryNum=" + category;
		url = url + "&mainNum=" + mainNum;
		url = url + "&sideNum=" + sideNum;
		url = url + "&sideDetailNum=" + sideDetailNum;
		location.href = url;
	}

</script>
	<!-- pagination{s} -->
	<div id="paginationBox" align="center" style="margin-top: 30px;">
		<ul class="pagination">
			<c:if test="${boardVO.prev}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${boardVO.page}', '${boardVO.range}', '${boardVO.rangeSize}, '${category}', '${side.mainNum }', '${side.sideNum }', '${side.sideDetailNum }'')">Previous</a></li>
			</c:if>
			<c:forEach begin="${boardVO.startPage}" end="${boardVO.endPage}" var="idx">
				<li class="page-item <c:out value="${boardVO.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${boardVO.range}', '${boardVO.rangeSize}', '${category}', '${side.mainNum }', '${side.sideNum }', '${side.sideDetailNum }')"> ${idx} </a></li>
			</c:forEach>

			<c:if test="${boardVO.next}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${boardVO.page}', '${boardVO.range}', '${boardVO.rangeSize}, '${category}', '${side.mainNum }', '${side.sideNum }', '${side.sideDetailNum }'')" >Next</a></li>
			</c:if>
		</ul>
	</div>
	<!-- pagination{e} -->

</body>
</html>