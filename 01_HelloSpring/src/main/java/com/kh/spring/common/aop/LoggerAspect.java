package com.kh.spring.common.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.kh.spring.model.vo.Member;

@Component
@Aspect
public class LoggerAspect {

	private Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Pointcut("execution(* com.kh.spring..Memo*.*(..))")
	public void myPointcut() {}
	
	@Around("myPointcut()")
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
		// proceed 가지고 잇는 정보를 받음, proceed 하기 전에 먼저 잡음, proceed 기점 전처리 후처리 수행
		Object obj = joinPoint.proceed();
		logger.warn("[after]" + componentType + type + "." + method + "()");
		return obj;
	}
	
	@Pointcut("execution(* com.kh.spring..MemberDao.*(..))")
	public void beforePoint() {
		
	}
	
	@Before("beforePoint()")
	public void beforeLogger(JoinPoint joinPoint) throws Exception {
		
		/*HttpSession session = (HttpSession) RequestContextHolder.currentRequestAttributes().resolveReference(RequestAttributes.REFERENCE_SESSION);
		HttpRequest request = (HttpRequest) RequestContextHolder.currentRequestAttributes().resolveReference(RequestAttributes.REFERENCE_REQUEST);*/
		/*
		 
		 * */
		Signature sig = joinPoint.getSignature();
		Object[] objs = joinPoint.getArgs();
		for (Object o : objs) {
			logger.warn("매개변수 : " + o);
			Member m = null;
			if (o instanceof Member) {
				m = (Member) o;
			}
			/*if (m!=null && !"admin".equals(m.getUserId())) {
//				throw new Exception();
				System.out.println("----admin------");
				System.out.println(m);
			}*/
		}
		
		logger.warn("before : " + sig.getDeclaringType());
	}
	
	@After("execution(* com.kh.spring..Member*.*(..))")
	public void afterLogger(JoinPoint joinPoint) {
		logger.warn("After : 한방에!");
	}
}
