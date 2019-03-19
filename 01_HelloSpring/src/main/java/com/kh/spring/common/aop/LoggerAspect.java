package com.kh.spring.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAspect {

	private Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	public Object loggerAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Signature sig = joinPoint.getSignature();
		String type = sig.getDeclaringTypeName(); // 클래스 이름
		String method = sig.getName(); // 메소드 이름, 넘어가는 String 시점의 메소드
		
		String componentType = "";
		if (type.indexOf("Controller") > -1) {
			componentType = "Controller \t: ";
		} else if(type.indexOf("Service") > -1){
			componentType = "Service \t: ";
		} else if(type.indexOf("Dao") > -1){
			componentType = "Dao \t: ";
		}
		logger.warn("[before]" + componentType + type + "." + method + "()");
		// proceed 가지고 잇는 정보를 받음, proceed 하기 전에 먼저 잡음
		return joinPoint.proceed();
	}
}
