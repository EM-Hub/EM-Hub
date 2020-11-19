<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  #empList::-webkit-scrollbar {
    width: 10px;
  }
  #empList::-webkit-scrollbar-thumb {
    background-color: #191970;
    border-radius: 10px;
    background-clip: padding-box;
    border: 2px solid transparent;
  }
  #empList::-webkit-scrollbar-track {
    background-color: #e9f2f9;
    border-radius: 10px;
    box-shadow: inset 0px 0px 5px white;
  }
#empList table{
	width: 570px;
}
#empList td{
	height: 40px;
}
.title{
	border-left: 3px solid #191970;
	background: #F5F5F5;
	font-weight: bold;
	text-align: center;
}
.infoTd{
	padding-left: 20px;
}
textarea {
	resize: none;
	width: 90%;
	height: 80%;
}
</style>
</head>
<body>
<!-- 학생 제적 모달  -->
<div class="modal fade" id ="expelModal" style="z-index: 10000;" >
    <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" style="font-weight: bold;">학생 제적</h4>
      </div>
      <div class="modal-body">
      	<table style="width: 500px; height: 350px">
      		<tr>
      			<td class="title">학번</td>
      			<td id ="modalmemIdE" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">이름</td>
      			<td id ="modalstuNameE" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">학년</td>
      			<td id ="modalstuGradeE" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">대학</td>
      			<td id ="modalstuColE" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">전공</td>
      			<td id ="modalstuDepE" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">이메일</td>
      			<td id ="modaluserEmailE" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">사유</td>
      			<td><textarea placeholder="제적 사유를 입력해주세요.." id="expelReason" cols="40" rows="3"></textarea></td>
      		</tr>
      	</table>
      	<input type="checkbox" checked id="check4ExpEmail">학생에게 안내 메일을 전송하시겠습니까?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id = "modalExpelBtn" data-dismiss="modal">확인</button>
        <button type="button" class="btn btn-primary" id = "closeBtn" data-dismiss="modal">취소</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!-- 학사경고 모달  -->
<div class="modal fade" id ="probationModal" style="z-index: 10000;" >
    <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" style="font-weight: bold;">학사경고</h4>
      </div>
      <div class="modal-body" align="center">
      	<table style="width: 550px; height: 350px;">
      		<colgroup>
      			<col width="20%">
      			<col width="80%">
      		</colgroup>
      		<tr>
      			<td class="title">학번</td>
      			<td id ="modalmemIdP" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">이름</td>
      			<td id ="modalstuNameP" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">학년</td>
      			<td id ="modalstuGradeP" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">대학</td>
      			<td id ="modalstuColP" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">전공</td>
      			<td id ="modalstuDepP" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">이메일</td>
      			<td id ="modaluserEmailP" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">경고 학기</td>
      			<td><select style="width: 80px"id ="modalsemCode1P">
      				<option value = "2016">2016</option>
      				<option value = "2017">2017</option>
      				<option value = "2018">2018</option>
      				<option value = "2019">2019</option>
      				<option value = "2020">2020</option>
				</select>년도&nbsp;&nbsp;&nbsp;&nbsp;
				<select style="width: 40px" id ="modalsemCode2P">
					<option value = "1">1</option>
					<option value = "2">2</option>
      			</select>학기</td>
      		</tr>
      		<tr>
      			<td class="title">사유</td>
      			<td><select id ="modalprobReasonP"  style="width: 150px">
      				<option value = "이수학점 미달">이수학점 미달</option>
      				<option value = "평균평점 미달">평균평점 미달</option>
      				<option value = "학칙위반">학칙위반</option>
      				<option value = "부정행위">부정행위</option>
      				<option value = "수강신청 미시행">수강신청 미시행</option>
      				<option value = "등록금 미납">등록금 미납</option>
      			</select></td>
      		</tr>
      	</table><br>
      	<input type="checkbox" checked id="check4proEmail">학생에게 안내 메일을 전송하시겠습니까?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id = "modalProbationBtn" data-dismiss="modal">확인</button>
        <button type="button" class="btn btn-primary" id = "closeBtn" data-dismiss="modal">취소</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<!-- 시설 이용 신청 철회시키기 모달  -->
<div class="modal fade" id ="cancelFacUseModal" style="z-index: 10000;" >
    <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" style="font-weight: bold;">시설예약철회</h4>
      </div>
      <div class="modal-body">
      	<table style="width: 550px; height: 400px; text-align: left">
      		<colgroup>
      			<col width="30%">
      			<col width="70%">
      		</colgroup>
      		<tr>
      			<td class="title">신청번호</td>
      			<td id ="modalFacUseCode" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">시설명</td>
      			<td id ="modalfacName" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">신청날짜</td>
      			<td id ="modalfacUseDay" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">신청시간</td>
      			<td id ="modalUseTime" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">신청자<br>(학번/교직원번호)</td>
      			<td id ="modalmemId" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">이메일</td>
      			<td id ="modaluserEmail" class="infoTd"></td>
      		</tr>
      		<tr>
      			<td class="title">취소사유</td>
      			<td class="infoTd"><textarea placeholder="취소사유를 입력해주세요.." id="cancelReason" cols="20" rows="3"></textarea></td>
      		</tr>
      	</table><br>
      	<input type="checkbox" checked id="check4email">신청자에게 안내 메일을 전송하시겠습니까?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id = "modalCancelFacUseBtn" data-dismiss="modal">확인</button>
        <button type="button" class="btn btn-primary" id = "closeBtn" data-dismiss="modal">취소</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->



<!-- 강의계획서 미리보기 모달  -->
<div class="modal fade" id ="showAttchModal" style="z-index: 10000;" >
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      </div>
      <div class="modal-body"style="width: 100%;">
	    <iframe style="width: 100%; height: 700px;" src="/upload/${lecture.attachment }" id="attachmentSrc">
		</iframe>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id = "closeBtn" data-dismiss="modal">닫기</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!-- 인물검색모달 -->
<div class="modal fade" id ="selectEmpModal" style="height: auto;">
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
        <div id="empList" style="overflow:auto; height: 400px;" align="center">
        	<table class="table-hover" id="modalEmpTable" style="height: auto;">
	        	<colgroup>
	        	<col width="10%">
	        	<col width="25%">
	        	<col width="20%">
	        	<col width="25%">
	        	<col width="20%">
	        	</colgroup>
        		<thead>
        		<tr align="center">
	        		<th style="text-align: center;"></th>
	        		<th style="text-align: center;">교직원번호</th>
	        		<th style="text-align: center;">이름</th>
	        		<th style="text-align: center;">소속</th>
	        		<th style="text-align: center;">직급</th>
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

</body>
</html>