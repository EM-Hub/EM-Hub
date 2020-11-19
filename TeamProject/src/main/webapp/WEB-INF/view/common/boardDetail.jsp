	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl 사용을 위한 taglib -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Jquey 기능을 가능하게 하는 SCRIPT -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- <img src="resources/images/spongebob.png" width="100px;"> -->
<script src="resources/js/boardDetail.js?ver=15"></script>
<!-- bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- bootstrap 기능을 가능하세 하는 SCRIPT -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
#boardTable {
	border: 1px solid #bfbfbf;
	width: 900px;
	height: 600px;
	word-break:break-all;
}
#myInfo tr, td{
	border: 1px solid #bfbfbf;
	border-collapse: collapse;
	padding: 5px;
}
.title {
	background: #F5F5F5;
	border-left: 3px solid #191970;
	font-size: 15px;
	font-weight: bold;
	color: #191970;	
	text-align: center;
}
.bb{
	padding-left: 20px;
}
/* .bb > input{
	width: 98%;
} */
a{
	cursor: pointer;
	text-decoration: none;
}
.commentContent{
	width: auto;
	height: auto;
}
#reTable table{
	border: none;
}
#reTable td{
	border: none;
}
p{
	width: 100%;
}
</style>

</head>
<body>
<div align="center" class="top">
	<div style="height: 40px;"></div>
	<div style="width: 900px">
		<table id="boardTable">
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="10%">
				<col width="40%">
			</colgroup>
			<tr height="15%">
				<td class="title">제 목</td>
				<td class="bb">${detail.boardTitle }</td>
				<td class="title">작성자</td>
				<td class="bb">${detail.boardWriter }</td>
			</tr>
			<tr height="85%">
				<td class="title">내 용</td>
				<td colspan="3">${detail.boardContent }</td>
			</tr>
		</table>
	</div>
		<br><br>
</div>
<div style="height: 10px;" align="center">
<hr style="border: 2px solid #191970; width: 80%;">
</div>
<!-- 카테고리 1번일때 댓글 리스트 띄우기 + 댓글작성자가 같으면 수정 및 삭제 가능 -->
<c:if test="${detail.categoryNum == 1}">
<div align="left" style="width: 100%; padding-left: 10%;">
	<p style="font-size: 20px; font-weight: bold;">댓글</p>
	<div align="center">
		<ul>
			<!-- 리스트띄움 -->
			<c:forEach items="${commentList }" var="vo">
			<li>
				<input type="hidden" value="${vo.commentNum }" class="commentNum">

				<div><span style="font-weight: bold;">${vo.commentWriter }</span><br>
					 <input type="text" value="${vo.commentContent }" readonly="readonly" style="border: none;" class="commentContent"> 
				</div>
				<div>
					<span style="color: #979797;">(${vo.commentCreateDate })</span>
				</div>
				<div>
				<!-- 댓글작성자 == 로그인사람 일치하면 or 등급이 E일때 -->
				<c:if test="${vo.commentWriter eq memName || memGrade eq 'E'}">
					<a class="upBtn">수정</a> 
					<a class="commentDelBTN">삭제</a>
				</c:if>
				<hr style="border: 1px solid #f4f4f4; width: 80%;">
				</div>
			</li>
			</c:forEach>
		</ul>
	</div>
	<div style="margin-top: 20px;">
		<form action="insertComment.do" method="post">
		<div id="reTable" style="width: 900px">
			<table>
				<tr>
					<td style="font-weight: bold;">작성자 : </td>
					<td>${memName }<input type="hidden" name="commentWriter" value="${memName }"></td>
					<td></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">내용 : </td>
					<td><input type="text" name="commentContent" style="width: 450px; height: 50px; border: 1px solid gray;"></td>
					<td><input type="submit" value="댓글달기" class="btn btn-success"></td>
				</tr>
			</table>
		</div>
			<input type="hidden" name="boardNum" value="${detail.boardNum }" id="btnD1">
			<input type="hidden" name="categoryNum" value="${detail.categoryNum }" id="btnD2">
			<input type="hidden" value="${side.mainNum }" name="mainNum">
			<input type="hidden" value="${side.sideNum }" name="sideNum">
			<input type="hidden" value="${side.sideDetailNum }" name="sideDetailNum">
			<div style="height: 10px;"></div>
		</form>
	</div>
</div>
</c:if>
<input type="hidden" value="${side.mainNum }" name="mainNum" id="m2">
<input type="hidden" value="${side.sideNum }" name="sideNum" id="s2">
<input type="hidden" value="${side.sideDetailNum }" name="sideDetailNum" id="d2">
<input type="hidden" name="boardNum" value="${detail.boardNum }" id="btnD1">
<input type="hidden" name="categoryNum" value="${detail.categoryNum }" id="btnD2">
<div style="height: 30px;"></div>
<div align="center">

<c:if test="${detail.boardWriter eq memName || memGrade eq 'E'}">
<input type="button" class="btn btn-success" id="updateBtn" value="글수정">
<input type="button" class="btn btn-success" id="deleteBtn" value="글삭제">
</c:if>
<c:if test="${detail.categoryNum == 2 }">
	<c:if test="${memGrade eq 'E'}">
		<input type="button" class="btn btn-success" id="cBtn" value="답글">
	</c:if>
</c:if>
</div>
</body>
</html>