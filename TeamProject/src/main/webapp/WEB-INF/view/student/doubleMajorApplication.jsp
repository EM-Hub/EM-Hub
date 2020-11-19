<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>복수전공</title>
<style type="text/css">
#table1{
   width: 1000px;
   height: 150px;
   text-align: center;
   border: 1px solid #bfbfbf;
}
tr, td{
   border: 1px solid #bfbfbf;
}
#table2{
   width: 1000px;
   height: 45px;
   text-align: center;
}
.title{
   background: #F5F5F5;
   border-left: 3px solid #526ca2;
   color: #526ca2;
   font-size: 15px;
   font-weight: bold;
}
input[type="text"]{
   border: none;
   widows: 100%;
   text-align: center;
   outline: none;
}

.table3 {
    width: 1000px;
    text-align: center;
    border: 1px solid #bfbfbf;
 }
 .table3 td{
    height: 50px;
 }
 
 .title2{
    background: #F5F5F5;
   border-left: 3px solid #526ca2;
   color: #526ca2;
   font-size: 15px;
   font-weight: bold;
 
 }
 .ttt11{
    width: 1000px;
    height: 60px;
    text-align: center;
    border: none;
 }
 #title td{
    font-weight: bold;
    background: #191970;
    color: white;
    border: none;
 }
  textarea{
    width: 95%;
    height: 90%;
    outline: none;
    border: none;
    resize: none;
    padding: 5px;
 }
</style>
</head>
<body>
<div align="left" style="width: 100%; padding-left: 70px;">
<h3 style="font-weight: bold">학생정보</h3>
</div>

<form action="insertDoubleMajor.do" method="post" id="dBtn">
<input type="hidden" value="${myInfo.collegeNum }" name="fromCollegeNum" id="myCollege">
<input type="hidden" value="${myInfo.depNo }" name="fromDepNo" id="myDep">

<div style="width: 100%; height:auto; padding: 15px;" align="center">
   <table id="table1">
      <colgroup>
         <col width="10%">
         <col width="10%">
         <col width="20%">
         <col width="10%">
         <col width="20%">
         <col width="10%">
         <col width="20%">
      <tr>
         <td rowspan="3"><img src="resources/images/${myInfo.memPhoto }" width="150px" height="179px"></td>
         <td class="title">이 름</td>
         <td>${myInfo.stuName }</td>
         <td class="title">학 번</td>
         <td><input type="text" value="${myInfo.stuNum }" name="stuNum" readonly id="stuNum"></td>
         <td class="title">학 년</td>
         <td>${myInfo.stuYear }</td>
      </tr>
      <tr>
         <td class="title">대 학</td>
         <td >${myInfo.collegeName }</td>
         <td class="title">전 공</td>
         <td>${myInfo.depName }</td>
         <td class="title">부전공</td>
         <c:choose>
            <c:when test="${myInfo.depName2 eq null || myInfo.depName2 eq '0'}">
               <td></td>
            </c:when>
            <c:otherwise>
               <td>${myInfo.depName2 }</td>
            </c:otherwise>
         </c:choose>
      </tr>
      <tr>
         <td class="title">성별</td>
         <c:choose>
            <c:when test="${myInfo.memGender eq 'F' }">
               <td>여</td>
            </c:when>         
            <c:otherwise>
               <td>남</td>
            </c:otherwise>
         </c:choose>
         <td class="title">생일</td>
         <td>${myInfo.memBirthday }</td>   
         <td class="title">학적상태</td>
         <td><input type="text" value="${myInfo.memStatus }" readonly>
            <input type="hidden" value="${myInfo.statusNum }">
         </td>
         <td></td>
      </tr>
   </table>
</div>
<div align="left" style="width: 100%; padding-left: 70px;">
   <h3 style="font-weight: bold;">복수전공 신청 사항</h3>
</div>
<div style="width: 100%; height:auto; padding: 15px;" align="center">
      <table class="table3">
         <colgroup>
            <col width="20%">
            <col width="30%">
            <col width="20%">
            <col width="30%">
         </colgroup>
         <tr>
            <td class="title">현재대학</td>
            <td>${myInfo.collegeName }</td>
            <td class="title">현재학과</td>
            <td>${myInfo.depName }</td>
         </tr>
         <tr>
            <td class="title">복수전공대학</td>
            <td><select id="collegeD" name="dmajorCollegeNum"><option value="0" >전체</option>
            <c:forEach items="${collegeList }" var="college">
               <option value="${college.collegeNum }">${college.collegeName }</option>
            </c:forEach>
            </select>
            <td class="title">복수전공학부</td>
            <td colspan="3">
            <select id="depD" name="dmajorDepno" ><option value="0">전체</option>
            <c:forEach items="${depList }" var="dep">
               <option value="${dep.depNo }">${dep.depName }</option>
            </c:forEach>
            </select></td>
         </tr>
         <tr>
            <td class="title">복수전공사유</td>
            <td colspan="4"><textarea name="majorContent" placeholder="사유를 입력하세요."></textarea></td>
         </tr>
   </table>
</div>
<div align="left" style="width: 100%; padding-left: 70px;">
   <h3 style="font-weight: bold;">복수전공 신청 내역</h3>
</div>
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
   </table >
   <div id="dmajorList">
   
   </div>
</div>
   <div style="width: 100%; height: auto;" align="center">
   <div style="width: 100%; padding-left: 70px; margin-top: 30px;" align="left">
      <h3 style="font-weight: bold;">복수전공 신청 유의사항</h3>
   </div>
      <div style="width: 85%; height: auto; color: red;" align="left">
   <pre style="border: none; color: red; line-height: 3">
•복수전공 이수자는 신설학과(부)의 졸업생이 배출이 되어야 학위수여가 가능합니다.
•편입생으로 본교에서 이수하지 않은 과목(편입시 학점인정 받은 과목 포함)은 복수전공 과목으로 인정을 받을 수 없습니다.
•부/복수전공을 합쳐 3개까지 신청 및 이수가 가능합니다. 미래학부를 이수하는 경우는 이수 전공트랙 개수에 상관없이 전공 1개로 인정합니다.
•졸업시까지 복수전공학점을 이수 하지 못한 경우 복수전공 취소 후 졸업을 하거나,복수전공 관련 학점을 모두 이수 후 졸업을 하실 수 있습니다
•복수전공 신청/승인 시 다음학기 반드시 등록하여야 합니다. (휴학신청 불가 및 졸업대상자 제외)
•복수전공 신청/취소 시 과목별 이수구분 변경에 대한 확인 및 변경을 진행해야 합니다. 복수전공이 신청/취소가 완료되면 승인 안내가 됩니다.
   </pre>
   <br>
   </div>
   </div>
   <br>
   <div align="center" style="font-weight: bold;">
   <input type="checkbox" class="yBtn"><span class="sBtn">동의함</span>
   <input type="button" id="yBtn1" value="신청하기">   
   </div>
   <div style="height: 50px;"></div>
   <br>
   </form>
</body>
<script src="resources/js/doubleMajorApplication.js?ver=115"></script>
</html>