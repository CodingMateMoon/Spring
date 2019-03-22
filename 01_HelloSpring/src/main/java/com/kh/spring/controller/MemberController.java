package com.kh.spring.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.model.vo.Member;
import com.kh.spring.service.MemberService;

//@SessionAttributes(value= {"loginMember"})
@Controller
public class MemberController {
	// log4j를 이용한 방식
	// private Logger logger = Logger.getLogger(MemberController.class);
	// slf4j 이용
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bcEncoder;
	
	@RequestMapping("/member/memberEnroll.do")
	public String memberEnroll() {
		return "member/memberEnroll";
	}
	
	@RequestMapping("/memberEnrollEnd.do")
	public String memberEnrollEnd(Member m, Model model) {
		String rawPw = m.getPassword();
		logger.debug(rawPw);
//		System.out.println(rawPw);
		String enPw = bcEncoder.encode(rawPw);
//		System.out.println(enPw);
		logger.debug(enPw);
		m.setPassword(enPw);
		
		int result = service.insertMember(m);
		String msg="";
		String loc="/";
		if (result > 0) {	
			msg = "회원가입 완료";
		} else {
			msg = "회원가입 실패";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		return "common/msg";
	}
	
	@RequestMapping("/member/memberlogin.do")
	public String memberLogin(Member m, Model model, HttpSession session) {
//		System.out.println(m);
		logger.debug("memberLogin() : " + m);
		logger.debug("" + session);
		Member result = service.selectOne(m);
		String msg= "";
		String loc="/";
		try {
			throw new RuntimeException("일부러 발생");
		} catch(RuntimeException e) {
			logger.error("로그인 에러 : " + e.getMessage() + " : " + e.getStackTrace());
		}
		String enPw = bcEncoder.encode(m.getPassword());
		if (result != null) {
//			if (enPw.equals(result.getPassword())) {
			if (bcEncoder.matches(m.getPassword(), result.getPassword())) {
				msg ="로그인 성공";
				session.setAttribute("loginMember", result);
//				model.addAttribute("loginMember",result);
			} else {
				msg="패스워드가 일치하지 않습니다.";
			}
		} else {
			msg = "아이디가 존재하지 않습니다.";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		return "common/msg";
	}
	
	@RequestMapping("/member/logOut.do")
	public String logOut(SessionStatus session, HttpSession session1) {
		// session이 Complete시 끝남. isComplete: 세션 끝났는지?
		/*if (!session.isComplete())
		 session.setComplete();*/
		session1.invalidate();
		// 그냥 주소값 줄 경우 F5 눌렀을 때 계속 그대로
		return "redirect:/";
	}
	
	@RequestMapping("/member/memberUpdate.do")
	public String updateMember(String userId, Model model) {
		System.out.println(userId);
		Member m = new Member();
		m.setUserId(userId);
		Member result = service.selectOne(m);
		model.addAttribute("m", result);
		return "member/memberUpdate";
	}
	
	@RequestMapping("/member/update.do")
	public ModelAndView update(Member m) {
		
//		System.out.println(m);
		logger.debug("" + m);
		Member result = service.selectOne(m);
//		System.out.println(result);
		logger.debug("" + result);
		// 데이터와 뷰 정보 하나의 객체에 담아서 보낼 수 있음
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/updateForm");
		mv.addObject("m", result);
		return mv;
	}
	
	@RequestMapping("member/updateEnd.do")
	public ModelAndView updateEnd(Member m) {
		int result = service.update(m);
		String msg="";
		String loc="/member/update.do?userId=" + m.getUserId();
		if (result > 0) {
			msg = "수정완료";
		} else {
			msg = "수정실패";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/msg");
		mv.addObject("msg", msg);
		return mv;
	}
	
	/*@RequestMapping("/member/checkId.do")
	public String selectId(String userId) {
		Member m = new Member();
		m.setUserId(userId);
		Member result = service.selectOne(m);
		System.out.println(result);
		logger.debug("" + result);
		return result.getUserId();
	}*/
	/*@RequestMapping("/member/checkId.do")
	public void checkId(String userId, HttpServletResponse res) throws IOException{
		Member m = new Member();
		m.setUserId(userId);
		Member result = service.selectOne(m);
		boolean isOk = result != null ? false : true;
		res.getWriter().println(isOk);
	}*/
	@RequestMapping("/member/checkId.do")
	public ModelAndView checkId(String userId) throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView();
		Member m = new Member();
		m.setUserId(userId);
		Member result = service.selectOne(m);
		boolean isOk = result != null ? false : true;
		mv.addObject("isOk", isOk);
		mv.addObject("msg", URLEncoder.encode("고마워요~ 감동", "UTF-8"));
		mv.addObject("su", 19);
		mv.setViewName("jsonView");
		return mv;
	}
}
