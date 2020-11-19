<!-- 수정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.title{
	border-left: 3px solid #526ca2;
	font-size: 15px;
	font-weight: bold;
	color: #526ca2;
}
#updateBtn{
	height: 2em;
	width: 5em;
	border: none;
	background: #788EBC;
	color: white;
}
#updateBtn:hover{
	background: #82C5AF;
	color: white;
}
table{
	border: 1px solid #bfbfbf;
	width: 700px;
	height: 250px;
	text-align: center;
}
tr, td{
	border: 1px solid #bfbfbf;
	border-collapse: collapse;
}
.title{
	border-left: 3px solid #526ca2;
	font-size: 15px;
	font-weight: bold;
	color: #526ca2;
	background: #f5f5f5;
}
.icon-search{
	font-size: 16px;
}
.icon-search:hover{
	cursor: pointer;
	color: orange;
}
input[type="text"]{
	border:none;
}
select{
	height: 2em;
	width: 10em;
}
</style>
</head>
<body>
<input type="hidden" value="교수" id="hiddenEmpJob">
<c:if test="${insertResult eq 1 or insertResult == 1}">
	<script type="text/javascript">
		alert('강의가 성공적으로 등록되었습니다');
	</script>
</c:if>
<form action="insertLec.do" method="post" enctype= "multipart/form-data" id="regForm">
<div>	
	<input type="hidden" name = "mainNum" id="mainNum" value=${menuSideDetailVO.mainNum }>
	<input type="hidden" name = "sideNum"  id="sideNum" value=${menuSideDetailVO.sideNum }>
	<input type="hidden" value="${loginInfo.memId }" name="regEmp">
</div>
<div style="width: 100%; height: 400px; margin-top: 50px;" align="center">
	<div style="width: 900px; height: 400px;" align="center">
		<table>
			<colgroup>
				<col width="15%">
				<col width="35%">
				<col width="15%">
				<col width="35%">
			</colgroup>
			<tr>
				<td class="title">개설강의명</td>
				<td colspan="3"><input type="text" style="width: 95%; height: 95%; border: none;" name="lectureName" class="required" placeholder="강의명을 입력하세요."></td>
			</tr>
			<tr>
				<td class="title">개설학과</td>
				<td colspan="3">
				<select name ="collegeNum" id="colSelect" class="required">
					<c:forEach items="${colList }" var="college">
						<option value="${college.collegeNum}"> ${college.collegeName }</option>
					</c:forEach>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<select id="depSelect" name = "depNo" class="required">
					<option>-</option>
				</select>
				</td>
			</tr>
			<tr>
				<td class="title">담당교수</td>
				<td><input type="text" id="profNum" name="profNum" readonly class="required" placeholder="아이콘을 눌러 조회하세요 ▶" style="width: 80%; height: 95%;">
				<i class="icon-search" data-toggle="modal" data-target="#selectEmpModal" id="profBtn"></i>
				<td class="title">담당조교</td>
				<td><input type="text" id="asstNum" name="asstNum" readonly class="required" placeholder="아이콘을 눌러 조회하세요 ▶" style="width: 80%; height: 95%;">
				<i class="icon-search" data-toggle="modal" data-target="#selectEmpModal" id="asstBtn"></i>
			</tr>
			<tr>
				<td class="title">학점</td>
				<td><input type="number" name="lecCredit" class="required" min="1" value="1"></td>
				<td class="title">권장학년</td>
				<td><input type="number" name="recYear" min="1" value="1"></td>
			</tr>
			<tr>
				<td class="title">강의계획서</td>
				<td colspan="1" style="border-right: none;">
					<input type="file" name="lecFile" accept=".pdf" style="padding-left: 16px; width: 90%;" placeholder="첨부하기">
				</td>
				<td colspan="3" align="left" style="border-left: none;">
					<span style="color: red"><i class="icon-attention-alt"></i>pdf파일만 첨부 가능</span>
				</td>
			</tr>
		</table><br>
		<input type="button" value="등록" id="regFormBtn">
	</div>
</div>
</form>
<!-- 인물 선택 모달 -->
<div class="modal fade" id ="selectEmpModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">임직원 검색</h4>
      </div>
      <div class="modal-body">
           <div class="col-md-5">
	        <input  type="text" class="form-control" id="searchValue" width="50%" placeholder="이름">
	       </div>
	       <div>
	        <button type="button" class="btn btn-primary" id="modalsearchBtn">검색</button>
           </div>
        </div>
        <div id="empList">
        	<table class="table table-hover">
        	<colgroup>
        	<col width="10%">
        	<col width="25%">
        	<col width="20%">
        	<col width="25%">
        	<col width="20%">
        	</colgroup>
        		<thead>
        		<tr>
	        		<th></th>
	        		<th>교직원번호</th>
	        		<th>이름</th>
	        		<th>소속</th>
	        		<th>직급</th>
        		</tr>
        		</thead>
        		<tbody id="modalTbody">
        		</tbody>
			</table>
        </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id = "confirmBtn" data-dismiss="modal">등록</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/insertLecture.js?ver=10"></script>
</body>
</html>