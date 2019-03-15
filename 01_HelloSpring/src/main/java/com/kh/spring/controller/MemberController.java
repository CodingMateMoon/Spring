package com.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.model.vo.Member;
import com.kh.spring.service.MemberService;

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
	
}
