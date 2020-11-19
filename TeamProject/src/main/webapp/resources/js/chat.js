/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	$('#chatIcon').hide();
	//채팅창 닫기
	$(".close").click(function() {
		$('#chat').hide(500);
		$('#chatIcon').show(300);
	});
	
	$("#chatIcon").click(function() {
		$('#chatIcon').hide(500);
		$('#chat').show(300);
	});
	
	//엔터를 치면
	$("#messageinput").keypress(function (e) {
        if (e.which == 13){
        	send();
        	$('#messageinput').val('');
        }
    });
	
	//전송 버튼 누르면..
	$("#sendBtn").click(function() {
		send();
		$('#messageinput').val('');
	});
	
//	//대화내용 지우기 버튼 누르면
//	$("#deleteContent").click(function() {
//		clearText();
//		$('#messageinput').val('');
//	});
	
	
	
var ws; 
var messages = document.getElementById("messages"); 

openSocket();









// 이 밑으로는 함수선언
function openSocket(){ 
	if(ws !== undefined && ws.readyState !== WebSocket.CLOSED ){
		writeResponse("이미 대화에 참여중입니다."); 
		return; 
	} //웹소켓 객체 만드는 코드 
	ws = new WebSocket("ws://localhost:8081/biz/echo.do"); 
	
	ws.onopen = function(event){ 
		if(event.data === undefined){ 
			return; 
		} 
		writeResponse(event.data); 
	}; 
	
	ws.onmessage = function(event){ 
		console.log('writeResponse'); 
		console.log(event.data);
		writeResponse(event.data); 
	}; 
	
	ws.onclose = function(event){ 
		writeResponse("채팅이 종료되었습니다."); 
		} 
} 
	
function send(){ 
		if(document.getElementById("messageinput").value != null && document.getElementById("messageinput").value != ''){
			
			var text = document.getElementById("sender").value+","+document.getElementById("messageinput").value; 
			ws.send(text); 
			text = ""; 
		}
	} 

function closeSocket(){
	ws.close(); 
	} 

function writeResponse(text){ 
	messages.innerHTML += "<br/>" +text; 
	} 

function clearText(){ 
	console.log(messages.parentNode); 
	messages.parentNode.removeChild(messages) 
	} 




	
	
});
