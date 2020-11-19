 //페이지 로딩 후 실행 
$(document).ready(function(){
	initValidate();
	
	$(document).on('change', '#memPassword2', function() {
	
	});
	//클릭 이벤트
	$(document).on('click', '#changeBtn', function() {
			
	if($('#memPassword1').val() == $('#memPassword2').val()){
		location.href = 'passwordChange.do'			
			alert('비밀번호가 변경되었습니다.');			
		}
	else {
		alert('비밀번호를 확인해주세요.');
	}
	});

});

 /*함수선언 영역*/
(function($){
	//validate 초기화 함수
	initValidate = function(){
		
		//validate(유효성 검사)
		$("#passwordForm").validate({ //form 태그를 검사 
	        //테스트를 위하여 유효성 검사가 완료되어도 submit을 처리하지 않음.
			//데이터 안 넘어가고 확인만 true 다 됬으면 false
			debug : false,

			//입력태그에 foucs가 들어왔을때 유효성을 검사한다 input태그를 클릭 했을 때
	        onfocusin: false, 
	        onkeyup: false,
	        //입력태그에 입력을 하고 다른 태그로 넘어갈 때
	        onfocusout: function(element) { $(element).valid(); }, 
	 
	 
	        //검사할 필드와 검사 항목의 나열
//	        groups:{
//	           socialNum : 'socialNum1 socialNum2',
//	           emergencyPhoneNum : 'emergencyPhoneNum2 emergencyPhoneNum3',
//	           phoneNum : 'phoneNum2 phoneNum3'
//	        },
	          
	        rules : {
	         	//아래의 정규식은 /정규식/i 형태로 작성  
	        	//1) 숫자만 : ^[0-9]*$
	        	//2) 영문자만 : ^[a-zA-Z]*$
	        	//3) 한글만 : ^[가-힣]*$
	        	//4) 영어 & 숫자만 : ^[a-zA-Z0-9]*$
//	        					ex)	/^[a-zA-Z0-9]*$/i
	        	//5) E-Mail : ^[a-zA-Z0-9]+@[a-zA-Z0-9]+$
	        	//6) 휴대폰 : ^01(?:0|1|[6-9]) - (?:\d{3}|\d{4}) - \d{4}$
	        	//7) 일반전화 : ^\d{2,3} - \d{3,4} - \d{4}$
	        	//8) 주민등록번호 : \d{6} \- [1-4]\d{6}
	        
	           // className:{
	          //    required : true             //필수여부 지정
	                //digits : true,               //숫자만 입력 지정
	               // email : true,                //이메일만 입력 지정
	               // url : true,                  //url만 입력 지정
	               // minlength : 4,               //최소길이 지정
	               // maxlength : 8,               //최대길이 지정
	               // equalTo : "대상요소의 id 값" //특정 요소와 입력값이 같은지 여부 검사
	          // }

				memPassword1 : {
					required : true,
					minlength : 4,
					regx:/^[a-zA-Z0-9]*$/i //영어&숫자만
				},

				memPassword2 : {
					required : true,
					minlength : 4,
					regx:/^[a-zA-Z0-9]*$/i, //영어&숫자만
					equalTo : memPassword1
				}

			},
	        // 검사를 충족하지 못할 경우 표시될 메시지의 나열
	        messages : {
	          // className : "과정명을 입력하세요.",
	          // className : {
	          //      required : "필수 입력 항목 입니다.",
	           //     number : "숫자만 입력하세요.",
	          //      minlength : "최소 {0}글자 입니다.",
	           //     maxlength : "최대 {0}글자 입니다.",
	           //     equalTo : "입력이 잘못되었습니다."
	           // },
	           //memberId:'ID를 입력하세요',

				memPassword1 : {
					  required: '비밀번호는 필수항목입니다.',
		               minlength:'비밀번호는 {0}자 이상 입력하세요.',
		               regx:'영어와 숫자만 사용가능합니다.'
				},

				memPassword2 : {
					   required: '비밀번호는 필수항목입니다.',
		               minlength:'비밀번호는 {0}자 이상 입력하세요.',
		               regx:'영어와 숫자만 사용가능합니다.',
		        	   equalTo : '비밀번호 입력값이 다릅니다.'
				}

			},
	        // 유효성 검사 실패 시 메세지의 출력 방식을 설정
	        errorPlacement: function(error, element){
	           error.insertAfter(element);
	           
	        },
	        //유효성 검사 완료(성공) 후 실행할 코드 
	        submitHandler: function(form) {
	        	form.submit();
	        	// $( "#dialog-confirm" ).dialog( "open" );
	        }

		
		});
		
	};
})(jQuery);