package com.kh.spring.common.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

// 소켓핸들러 객체는 두개의 상속 객체를 가질 수 있음
/*
   1. TextWebSocketHandler : 문자만 전송 채팅전용, 알람 기타 문자들만 사용하는 경우
   2. BinaryWebSocketHandler : 문자도 되고 파일까지 받을 수 있음
 * */

public class SocketHandler extends TextWebSocketHandler {
	private Logger logger = LoggerFactory.getLogger(SocketHandler.class);
	// 리스트 대신 해쉬맵으로 처리해서 동일한 IP 동일한 채팅에 접속하는 것 막음
	private List<WebSocketSession> list = new ArrayList();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("session id : " + session.getId());
		list.add(session);
//		super.afterConnectionEstablished(session);
	}
	// WebSocketSession session 은 보낸사람, session.send를 해야 그 session한테 보내는것
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		// DEBUG com.kh.spring.common.socket.SocketHandler.handleTextMessage(SocketHandler.java:28) - message : TextMessage payload=[하이], byteCount=6, last=true]
		// message : TextMessage payload=[{"nickname":"의조","msg":"ㅁㅁ"}]
		logger.debug("message : " + message);
		String msg = message.getPayload();
		logger.debug(msg);
		// 메시지 파싱 처리 - {"nickname":"의조","msg":"ㅁㅁ"}
		/*
		 JSON 형식으로 온 것 다른 형식으로 바꿈
		 JSON으로 넘어온 문자열 HashMap으로 키 밸류 형식으로 바꿈
		 잭슨이 지원하는 ObjectMapper 원하는 클래스 형식으로 바꿈
		 * */
		Map<String, String> map = new HashMap();
		ObjectMapper mapper = new ObjectMapper();
		try {
			map = mapper.readValue(msg, HashMap.class);
		} catch (IOException e) {
			
		}
		logger.debug("메세지 변환 후 : " + map);
		// session.sendMessage : session에 메세지를 보내는 메소드
		// 전달된 메소드는 페이지의 onmessage함수를 호출!
		// JSON.stringify -> 자바스크립트 객체 string으로 {"nickname":"킴","msg":"ㄱㄱ"}
		/*
		 원하는 대상한테만 보낼 수 있음
		 object안에 .찍고 접근
		 * */
		for (WebSocketSession s : list) {
			// 나한테는 안보냄
//			if (s == session) {continue;}
			/*if (map.containsKey("whisper")) {
				if (map.get("whisper").equals(list))
			}*/
			s.sendMessage(message);
		}
//		session.sendMessage(message);
//		super.handleTextMessage(session, message);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("close : " + session.getId());
		list.remove(session);
//		super.afterConnectionClosed(session, status);
	}

	
}
