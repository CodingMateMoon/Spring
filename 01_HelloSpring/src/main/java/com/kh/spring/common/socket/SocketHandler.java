package com.kh.spring.common.socket;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// 소켓핸들러 객체는 두개의 상속 객체를 가질 수 있음
/*
   1. TextWebSocketHandler : 문자만 전송 채팅전용, 알람 기타 문자들만 사용하는 경우
   2. BinaryWebSocketHandler : 문자도 되고 파일까지 받을 수 있음
 * */

public class SocketHandler extends TextWebSocketHandler {
	private Logger logger = LoggerFactory.getLogger(SocketHandler.class);
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
		logger.debug("message : " + message);
		String msg = message.getPayload();
		// session.sendMessage : session에 메세지를 보내는 메소드
		// 전달된 메소드는 페이지의 onmessage함수를 호출!
		for (WebSocketSession s : list) {
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
