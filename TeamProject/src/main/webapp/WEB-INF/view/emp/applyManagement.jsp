<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>신청관리페이지</title>
<style type="text/css">
	 .table3 {
 	width: 1000px;
 	height: 60px;
 	text-align: center;
 	border: 1px solid #bfbfbf;
 }
 
  #title td{
 	font-weight: bold;
 	background: #191970;
 	color: white;
 	border: none;
 }
 
 tr td{
 border: 1px solid #bfbfbf;
 }
 

#myInfo{
	border: 1px solid #bfbfbf;
	width: 600px;
	height: 180px;
	text-align: center;
	position: relative;
	
}
#myInfo tr, td{
	border: 1px solid #bfbfbf;
	border-collapse: collapse;
}
#myInfo2{
	border: 1px solid #bfbfbf;
	width: 810px;
	text-align: center;
	position: relative;
	left: 30px;
}
#myInfo2 tr{
	height: 43px;
}
.title{
	background: #F5F5F5;
	border-left: 3px solid #191970;
	font-size: 15px;
	font-weight: bold;
	color: #191970;
}
.inputT{
	text-align: center;
	border: none;
}
input[type='text']:focus{
	outline-color: #788EBC;
}
 #pImg {
  position: relative;
  left: 100px;
 }
 
</style>
</head>
<body>
<input type="hidden"  class="mStatus">

<h2 style="font-weight: bold;" align="center">전과 신청 목록</h2>
<div style="width: 100%; height:auto; padding: 15px;" align="center" id="">
	<table class="table3">
		<colgroup>
			<col width="5%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="5%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="*">
		</colgroup>
		<tr id="title">
			<td>No</td>
			<td>소속대학</td>
			<td>소속학과</td>
			<td>학번</td>
			<td>이름</td>
			<td>학년</td>
			<td>학적상태</td>
			<td>변경대학</td>
			<td>변경학과</td>
			<td>신청상태</td>
			<td>신청일</td>
		</tr>
		<c:forEach items="${majorList }" var="major"  varStatus="status">
		<c:if test="${major.applyType == 1}">
		<tr>
			<td>${status.count }</td>
			<td>${major.collegeName}</td>
			<td>${major.depName}</td>
			<td class="studentId" >${major.stuNum}</td>
			<td>${major.stuName}</td>
			<td>${major.stuYear}</td>
			<td>${major.memStatus}</td>
			<td>${major.collegeName2}</td>
			<td>${major.depName2}</td>
			<c:choose>
				<c:when test="${major.majorStatus eq 'N'}">
				<td class="statusBtn"><input type="button" value="처리대기중" class="empBtn" data-stuNum="${major.stuNum }" data-applyType="${major.applyType }" data-majorCollegeNum="${major.majorCollegeNum }" data-majorDepno="${major.majorDepno }"
				data-majorStatus="${major.majorStatus }"></td>
				</c:when>
				<c:otherwise>
				<td class="statusBtn"><input type="button" value="승인완료" class="empBtn" data-stuNum="${major.stuNum }" data-majorStatus="${major.majorStatus }"></td>
				</c:otherwise>
			</c:choose>
			<td>${major.majorCreateDate}</td>
		</tr>
		</c:if>
		</c:forEach>	
	</table>
</div><br><br><br><br>
<h2 style="font-weight: bold;" align="center">복수전공 신청 목록</h2>
<div style="width: 100%; height:auto; padding: 15px;" align="center" id="">
	<table class="table3">
		<colgroup>
			<col width="5%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="5%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="10%">
			<col width="*">
		</colgroup>
		<tr id="title">
			<td>No</td>
			<td>소속대학</td>
			<td>소속학과</td>
			<td>학번</td>
			<td>이름</td>
			<td>학년</td>
			<td>학적상태</td>
			<td>복수전공대학</td>
			<td>복수전공학과</td>
			<td>신청상태</td>
			<td>신청일</td>
		</tr>
		<c:forEach items="${majorList }" var="major"  varStatus="status">
		<c:if test="${major.applyType == 2}">
		<tr>
			<td>${status.count }</td>
			<td>${major.collegeName}</td>
			<td>${major.depName}</td>
			<td class="studentId" data-stuNum="${major.stuNum}">${major.stuNum}</td>
			<td>${major.stuName}</td>
			<td>${major.stuYear}</td>
			<td>${major.memStatus}</td>
			<td>${major.collegeName21}</td>
			<td>${major.depName21}</td>
			<c:choose>
				<c:when test="${major.majorStatus eq 'N'}">
				<td class="statusBtn"><input type="button" value="처리대기중" class="empBtn" data-stuNum="${major.stuNum }"data-applyType="${major.applyType }" data-majorCollegeNum="${major.dmajorCollegeNum }" 
				data-majorDepno="${major.dmajorDepno }" data-majorStatus="${major.majorStatus }" >	</td>		
				</c:when>
				<c:otherwise>
				<td class="statusBtn"><input type="button" value="승인완료" class="empBtn" data-stuNum="${major.stuNum }" data-majorStatus="${major.majorStatus }"></td>		
				</c:otherwise>
			</c:choose>
			<td>${major.majorCreateDate}</td>
		</tr>
		</c:if>
		</c:forEach>	
	</table>
</div>

<!-- ///////////////////// 전과신청목록 모달 ///////////////////////// -->

<div class="modal fade bs-example-modal-lg" id="studentInfo"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" style="position: relative; top: 200px; right: 180px;" >
    <div class="modal-content" >
      <div style="width: 900px; height:auto; padding: 15px; position: relative; right: 50px; " align="center">
	<div  id="pImg"  style="width: 150px; height: 180px; border: 1px solid #bfbfbf; display: inline-block;" > 
		<img src="resources/images/${myInfo.memPhoto }" width="100%" height="100%" >
	</div>
	<div style="width: 600px; height: 180px; display: inline-block; float: right;" align="center">	
		<table id="myInfo">
			<colgroup>
				<col width="15%">
				<col width="35%">
				<col width="15%">
				<col width="35%">
			</colgroup>
			<tr>
				<td class="title">이 름</td>
				<td>${myInfo.stuName }</td>
				<td class="title">대 학</td>
				<td>${myInfo.collegeName }</td>
			</tr>
			<tr>
				<td class="title">학 번</td>
				<td class="stuNum">${myInfo.stuNum }</td>
				<td class="title">전 공</td>
				<td>${myInfo.depName }</td>
			</tr>
			<tr>
				<td class="title">학 년</td>
				<td>${myInfo.stuYear }학년</td>
				<td class="title">부전공</td>
				<c:choose>
					<c:when test="${myInfo.depNo2 eq null || myInfo.depNo2 eq '0'}">
						<td>-</td>
					</c:when>
					<c:otherwise>
						<td>${myInfo.depName2 }</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td class="title">성 별</td>
				<td><input type="radio" name="gender" checked="<c:if test="${myInfo.memGender eq M }">checked</c:if>" onclick="return(false);">남&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" checked="<c:if test="${myInfo.memGender eq F }">checked</c:if>" onclick="return(false);">여
				</td>
				<td class="title">이메일</td>
				<td><input type="text" value="${myInfo.memEmail }" class="inputT" readonly id="memEmail"></td>
			</tr>
		</table>
	</div>
	<div style="width: 900px; margin-top: 20px; padding-left: 60px;" align="left">
		<table id="myInfo2">
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="10%">
				<col width="40%">
			</colgroup>
			<tr>
				<td class="title">생년월일</td>
				<td>${myInfo.memBirthday }</td>
				<td class="title">학적상태</td>
				<td>${myInfo.memStatus }</td>
			</tr>
			<tr>
				<td class="title">전화번호</td>
				<td><input type="text" value="${myInfo.memTel }" class="inputT" readonly id="memTel"></td>
				<td class="title">휴대폰</td>
				<td><input type="text" value="${myInfo.memPhone }" class="inputT" readonly id="memPhone"></td>
			</tr>
			<tr>
				<td class="title">우편번호</td>
				<td colspan="3"><input type="text" value="${myInfo.memZipCode }" class="inputT" readonly id="memZipCode"></td>
			</tr>
			<tr>
				<td class="title">주 소</td>
				<td colspan="3"><input type="text" value="${myInfo.memAddr }" class="inputT" readonly id="memAddr"></td>
			</tr>
		</table>
	</div>
</div>
		<div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
       	 <button type="button" class="btn btn-primary" id="confirmBtn">ㅁㄴㅇㄴㅇㄴㄴ</button>
      </div>
    </div>
  </div>
</div>
<script src="resources/js/applyManagement.js?ver=155"></script>

</body>
</html>