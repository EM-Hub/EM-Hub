<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고장수리신청페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/23.0.0/classic/ckeditor.js?ver=2"></script>
<style type="text/css">
table {
width: 1000px;
height: 650px;
border: 1px solid black;
text-align: center;
font-weight: bold;
}
tr, td{
	border: 1px solid #f5f5f5;
}
.title{
	background: #F5F5F5;
   border-left: 3px solid #191970;
   font-size: 15px;
   font-weight: bold;
   color: #191970;
}
.ck ck-editor{
	max-width: 500px;
	overflow: scroll;
}
.ck-editor__editable{
	min-height: 500px;
	max-height: 500px;
	overflow: scroll;
}
input[type="text"]{
	width: 100%;
	height: 100%;
	border: none;
	outline: none;
	text-align: center;
}
</style>
</head>
<body>
<form action="insertRepairRequest.do" method="post" id="repairForm">
<div style="width: 100%;" align="center">
<table>
	<colgroup>
		<col width="10%">
		<col width="23%">
		<col width="10%">
		<col width="23%">
		<col width="10%">
		<col width="*">
	</colgroup>
	<tr height="10%">
		<td class="title">제목</td>
		<td colspan="3"><input type="text" name="requestTitle" id="repairTitle" ></td>
		<td class="title">작성자</td>
		<td ><input type="text" value="${myInfo.stuName }" name="requestName" readonly></td>
	</tr>
	<tr height="10%">
		<td class="title">전공</td>
		<td ><input type="text" value="${myInfo.depName }" name="depName" readonly></td>
		<td class="title">학번</td>
		<td><input type="text" value="${myInfo.stuNum }" name="stuNum" readonly></td>
		<td class="title">학년</td>
		<td><input type="text" value="${myInfo.stuYear }" name="stuYear" readonly></td>
	</tr>
	<tr height="*">
		<td class="title">내용</td>
		<td colspan="5" ><textarea name="requestContent" id="editor"></textarea>
			
			<script>
		    ClassicEditor
		        .create( document.querySelector( '#editor' ) )
		        .catch( error => {
		            console.error( error );
		        } );
			</script></td>
	</tr>
	
</table>
<div style="height: 30px;">
</div>
<div align="center">
	<input type="button" value="글 등록" id="repairBtn">
</div>
</div>
</form>
<div style="height: auto; margin-top: 20px;"></div>
<div>※ 주의사항
   - 학생생활관내 시설물 고장을 발견할 경우 신청자 소속 호관, 호실을 정확히 기재하여 "시설물 수리 및
      보수"를 신청하여야 한다.
   - 신고 된 시설물 고장은 학생생활관 행정팀에서 확인 후 최대한 신속하게 처리하도록 한다.
   - 시설물 수리 및 보수 신청내용은 30자 내외로 간단하게 입력하여야 한다.
   - 신청한 시설물 수리 및 보수된 사항은 "진행, 외주, 완료" 등으로 진행상태를 확인할 수 있습니다.
   - 기타 문의사항은 학생생활관 행정팀으로 문의(☎053-600-4731~2)</div>
</body>
<script src="resources/js/repairRequest.js?ver=1555"></script>
</html>