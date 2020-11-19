<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl 사용을 위한 taglib -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <img src="resources/images/spongebob.png" width="100px;"> -->
<!--<script src="resources/js/sample.js"></script>-->
<!-- bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- Jquey 기능을 가능하게 하는 SCRIPT -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- bootstrap 기능을 가능하세 하는 SCRIPT -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/23.0.0/classic/ckeditor.js?ver=2"></script>
<style type="text/css">
	table {
		border: 1px solid black;
		width: 900px;
		border-collapse: collapse;
		height: auto;
	}

	tr, td {
		border: 1px solid black;
		border-collapse: collapse;
		padding: 6px;
	}

	.aa {
		background: #eeeeee;
		text-align: center;
	}
	
	.bb > input{
		width: 98%;
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
</style>

</head>
<body>
	<div align="center">
		<div style="height: 40px;"></div>
		<h1>게시글 작성 화면</h1>
		<div style="height: 40px;"></div>

		<form action="reply.do" method="post">
			<table>
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tr>
					<td class="aa">제목</td>
					<td class="bb"><input type="text" name="boardTitle" placeholder="제목작성" required></td>
					<td class="aa">작성자</td>
					<td class="bb">${memName }<input type="hidden" name="boardWriter" value="${memName }"></td>
				</tr>
				<tr height="500px;">
					<td class="aa">내용</td>
					<td colspan="3"><textarea name="boardContent" id="editor"></textarea>
						<script>
		    ClassicEditor
		        .create( document.querySelector( '#editor' ) )
		        .catch( error => {
		            console.error( error );
		        } );
			</script></td>
				</tr>
			</table>
			<input type="hidden" name="categoryNum" value="${categoryNum }">
			<input type="hidden" name="boardGroup" value="${boardNum }">
			<input type="hidden" value="${side.mainNum }" name="mainNum">
			<input type="hidden" value="${side.sideNum }" name="sideNum">
			<input type="hidden" value="${side.sideDetailNum }" name="sideDetailNum">

			<div style="height: 40px;"></div>
			<input type="submit" value="글작성" class="btn btn-success">

		</form>

	</div>
</body>
</html>