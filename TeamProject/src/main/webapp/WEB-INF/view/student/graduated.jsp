<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#gmyInfo{
	border: 1px solid #bfbfbf;
	width: 1000px;
	height: 180px;
	text-align: center;
}
#gmyInfo tr, td{
	border: 1px solid #bfbfbf;
	border-collapse: collapse;
}
#gmyInfo2{
	border: 1px solid #bfbfbf;
	width: 1000px;
	text-align: center;
}
#gmyInfo2 tr{
	height: 43px;
}
.title{
	background: #F5F5F5;
	border-left: 3px solid #191970;
	font-size: 15px;
	font-weight: bold;
	color: #191970;
}
.title2{
	background: #191970;
	color: white;
	font-weight: bold;
	height: 40px;
	border: none;
}
.inputT{
	text-align: center;
	border: none;
}
input[type='text']:focus{
	outline-color: #788EBC;
}
</style>
</head>
<body>
<div style="width: 100%; height:auto; " align="center">
	<div style="width: 100%; height: 200px;" align="center">	
		<table id="gmyInfo">
			<colgroup>
				<col width="10%">
				<col width="25%">
				<col width="10%">
				<col width="25%">
				<col width="10%">
				<col width="20%">
			</colgroup>
			<tr>
				<td class="title">학 번</td>
				<td class="stuNum">${myInfo.stuNum }</td>
				<td class="title">이 름</td>
				<td>${myInfo.stuName }</td>
				<td class="title">학 년</td>
				<td>${myInfo.stuYear }학년</td>
			</tr>
			<tr>
				<td class="title">대 학</td>
				<td>${myInfo.collegeName }</td>
				<td class="title">전 공</td>
				<td>${myInfo.depName }</td>
				<td class="title">부전공</td>
				<td>${myInfo.depName2 }</td>
			</tr>
			<tr>
				<td class="title">성 별</td>
				<td><input type="radio" name="gender" <c:if test="${myInfo.memGender eq 'M' }">checked</c:if> onclick="return(false);">남&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="gender" <c:if test="${myInfo.memGender eq 'F' }">checked</c:if> onclick="return(false);">여
				</td>
				<td class="title">학적상태</td>
				<td>${myInfo.memStatus }</td>
				<td class="title">졸업대상</td>
				<td>해당없음.</td>
			</tr>
		</table>
	</div>
	<div align="left" style="width: 100%; padding-left: 7%; margin-top: 50px;">
		<h3 style="font-weight: bold;">졸업사정 조회</h3>
	</div>
	<div style="width: 100%; margin-top: 10px;" align="center">
		<table id="gmyInfo2">
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="*">
			</colgroup>
			<tr>
				<td class="title2" style="border-left: 3px solid #191970;">비고</td>
				<td class="title2">기준학점</td>
				<td class="title2">취득학점</td>
				<td class="title2">이수구분</td>
				<td class="title2">기준평균</td>
				<td class="title2">취득평균</td>
				<td class="title2">특이사항</td>
			</tr>
			<tr>
				<td class="title">졸업학점</td>
				<td>130</td>
			<c:if test="${grade1 eq '[]'}">
				<td class="graduatedScore">-</td>
			</c:if>
			<c:if test="${grade1 ne null}">
				<c:forEach items="${grade1 }" var="gr2" varStatus="status">
				<td class="graduatedScore">${gr2.lecCredit }</td>
				</c:forEach>
			</c:if>
				<td>N/Y</td>
				<td>2.00</td>
				<td>2.00</td>
				<td>-</td>
			</tr>
			<c:choose>
				<c:when test="${grade1 eq '[]' }">
				<td class="title">전공학점</td>
				<td>68</td>
				<td>-</td>
				<td>N</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				</c:when>
				<c:otherwise>
			<c:forEach items="${grade1 }" var="gr2">
			<tr>
				<td class="title">전공학점</td>
				<td>68</td>
				<td class="graduatedScore">${gr2.lecCredit }</td>
				<td>N</td>
				<td>${gr2.gradeScore }</td>
				<td>${gr2.gradeScore }</td>
				<td>-</td>
			</tr>
			</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td class="title">학점취소신청</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
			</tr>
			<tr>
				<td class="title">특별학점신청</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
			</tr>
			<tr>
				<td class="title">재이수</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
			</tr>
			<tr>
				<td class="title">사회봉사</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
			</tr>			
		</table><br>
<pre id="graduatedPre" style="width: 1000px; text-align: left;">
	(1) 대학별 최저 졸업이수학점 이상의 학점을 취득한 자
	(2) 기초필수(또는 교양필수) 및 기초택필(또는 교양택필),
	 전공학점(전공핵심(필수) 및 전공핵심, 전공심화  이수기준 충족)과목을 모두 이수한 자
	(3) 대학별 핵심교양 최소이수학점 이상의 학점을 취득한 자
	(4) 대학별 사회봉사 및 산학협력교육영역 이수학점 이상의 학점을 취득한 자(2013학번 신·편입생부터 적용)
	(5) 전학년 평균평점이 1.75 이상인 자
	(6) 졸업논문심사 또는 졸업시험에합격한 자(공학대학, 약학대학, 디자인대학, 예체능대학만 해당),
	 국제문화대학 문화인류학과(2016.8월 졸업자부터적용)
	(7) 영어전용강좌 2강좌 이상 이수 한 자 (2007학번부터 / 일부 학과 제외)
	(8) 공학인증, 건축학인증, 경영학인증, 소프트웨어특성화과정을 만족하는 자(해당자의 경우)
	(9) PBL 강좌 의무 이수한 자 (2017학번부터)
	(10) 외국인 유학생의 경우 한국어 능력 졸업인증제 통과한 자 (2014학번부터)
	<span class="guideRed">! 전공학점 평균은 이수과목에 따라 상이함 확인바람.</span>
</pre>
	</div>
	<div style="width: 100%; padding-left: 7%; margin-top: 50px;" align="left">
		<h3 style="font-weight: bold;">졸업사정 상세조회</h3>
	</div>
	<div style="width: 100%; height:auto; margin-top: 10px;" align="center" >
		<table id="gmyInfo2">
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="*">
			</colgroup>
			<tr>
				<td class="title2">이수학기</td>
				<td class="title2">과목번호</td>
				<td class="title2">교과목명</td>
				<td class="title2">학점</td>
				<td class="title2">성적</td>
				<td class="title2">이수구분</td>
				<td class="title2">비고</td>
			</tr>
			<c:forEach items="${grade }" var="grade">
			<tr>
				<td>${grade.semCode }</td>
				<td>${grade.lecCode }</td>
				<td>${grade.lectureName }</td>
				<td>${grade.lecCredit }</td>
				<td>${grade.gradeScore}</td>
				<td>Y</td>
				<td>${grade.gradeAbc }</td>
			</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<c:choose>
				<c:when test="${grade1 eq '[]' }">
					<tr>
						<td class="title" colspan="3">이수 총학점</td>
						<td>-</td>
						<td class="title" colspan="2">이수 과목평균</td>
						<td>-</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${grade1 }" var="gr1">
						<tr>
							<td class="title" colspan="3">이수 총학점</td>
							<td>${gr1.lecCredit }</td>
							<td class="title" colspan="2">이수 과목평균</td>
							<td>${gr1.gradeScore}</td>
						</tr>
					</c:forEach>	
				</c:otherwise>
			</c:choose>
		</table>
		<br>
<pre style="width: 1000px; text-align: left;">
	<span class="guideRed">(1) 예외사항</span>
	(2) 취득학점부족.
	(3) 졸업필수과목이수 상태. 	
	(4) 전공과목이수 상태.
	(5) 졸업조건 미 충족시 <span class="guideRed">'졸업유보자'</span>로 분류.	
</pre>
	</div>
</div>
</body>
</html>