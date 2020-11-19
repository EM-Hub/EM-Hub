<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${openLecResult == 0 }">
	<script type="text/javascript">
		alert('등록 실패 \n 관련 부서에 문의하세요');
	</script>
</c:if>
<c:if test="${openLecResult >= 1 }">
	<script type="text/javascript">
		alert('강의가 성공적으로 개설되었습니다.');
	</script>
</c:if>
<script type="text/javascript">
	location.href='openLecPage.do?mainNum=' + 9 + '&sideNum=' + 27;
</script>
</body>
</html>