<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅창 구현</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<input type="text" id="msg"/>
	<input type="button" id="btn" value="전송"/>
	<div id="container"></div>
	
	<script>
		var socket;
		var nickname = prompt("닉네임을 입력하세요");
		$(function(){
			socket = new WebSocket("ws://" + document.location.host +"/spring/chatting"); 
			/* socket = new WebSocket("ws:192.168.20.20:9090/spring/chatting");  */
			/* 
				웹소켓 객체안의 메소드를 구현하면됨
				onopen, onmessage, onclose, onerror 속성~ 이벤트 받아들임
				구현함수를 해당 속성에 대입하면됨!
				소켓 메세지를 서버로 전송할 때 사용하는 send()가 있음
			*/
				// 소켓세션이 연결되면 실행되는 함수
				socket.onopen = function(e){
					console.log(e);
				}
			
				socket.onmessage= function(e) {
					console.log(e);
					$("#container").append("<p>" + e.data + "</p>");
				}
				/* socket.onmessage= message;
				
				function message(e) {
					console.log(e);
				} */
				
				socket.onclose = function(e) {
					console.log(e);
				}
				
				$("#btn").click(function(){
					// whisper : 선택한 사람한테만 보냄
					var msg = {"nickname" : nickname, "msg" : $("#msg").val()};
					// 자바스크립트 객체를 스트링형식으로 바꿈
					socket.send(JSON.stringify(msg));
					$("#msg").val("");
				});
		});
		
		$("#msg").keyup(function(){
			if (event.key == "Enter") {
				$("#btn").trigger("click");
			}
		})
		
	</script>
</body>
</html>