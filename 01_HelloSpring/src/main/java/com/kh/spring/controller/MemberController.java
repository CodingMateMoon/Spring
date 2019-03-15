package com.kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.model.vo.Member;
import com.kh.spring.service.MemberService;

//@SessionAttributes(value= {"loginMember"})
@Controller
public class MemberController {

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
		System.out.println(rawPw);
		String enPw = bcEncoder.encode(rawPw);
		System.out.println(enPw);
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
		System.out.println(m);
		Member result = service.selectOne(m);
		String msg= "";
		String loc="/";
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
}
