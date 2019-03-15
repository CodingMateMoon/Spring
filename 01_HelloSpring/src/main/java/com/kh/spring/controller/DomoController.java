package com.kh.spring.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.model.vo.Dev;
import com.kh.spring.service.DomoService;

// Spring이 관리할 수 있도록 @로 표기
@Controller
public class DomoController {
	
	// 해당 클래스 변수에 자동으로 객체 생성해서 넣어줌, 의존성 주입
	@Autowired
	/*@Qualifier("choice")*/
	private DomoService service;
	
	// 요청 연결, root context뒤에 일치하는 url에 연결, @WebServlet(url)과 유사
	// Controller 역할 : 요청에 맞는 view화면 보내줌
	@RequestMapping("/domo/domo.do")
	public String domo() {
		service.print();
		return "domo/domo";
	}
	
	@RequestMapping("/domo/domo1.do")
	public String domo1(HttpServletRequest re) {
		
		String devName = re.getParameter("devName");
		int devAge = Integer.parseInt(re.getParameter("devAge"));
		String devEmail = re.getParameter("devEmail");
		String devGender = re.getParameter("devGender");
		String[] devLang = re.getParameterValues("devLang");
		System.out.println(devName + devAge + devEmail + devGender + devLang);
		Dev dev = new Dev(devName, devAge, devEmail, devGender, devLang);
		re.setAttribute("dev", dev);
		return "domo/domoResult";
	}
	
	@RequestMapping("/domo/domo2.do")
	// jsp input 태그의 name에 맞게 mapping
	public String domo2(
			@RequestParam(value="Name") String devName, 
			// required default - true (무조건 값 넣어야함) , false(값 없어도됨) / defaultValue="100" 값이 없을 경우 해당값 넣어줌 
			@RequestParam(value="devAge", defaultValue="100") int devAge, String devEmail, String devGender, String[] devLang, HttpServletRequest re) {
		
		re.setAttribute("dev", new Dev(devName, devAge, devEmail, devGender, devLang));
		return "domo/domoResult";
	}
	// 커맨드로 받기
	@RequestMapping("/domo/domo3.do")
	// 파라미터값이 있으면 객체 생성후 setter로 값 설정
	public String domo3(Dev dev, Model model) {
		model.addAttribute("dev", dev);
		return "domo/domoResult";
	}
	
	@RequestMapping("/domo/insert.do")
	public String insert(Dev dev) {
		
		int result = service.insert(dev);
		// 새로고침했을 때 계속 insert 되는 것 막음, view를 연결해주는 서블릿 주소 적기
//		return "/domo/domo";
		
		return "redirect:/";
	}
	
	
	@RequestMapping("/domo/select.do")
	public String select(int devAge, HttpServletRequest re) {
		Dev dev = service.select(devAge);
		re.setAttribute("dev", dev);
		return "domo/domoResult";
	}
	
	@RequestMapping("/domo/selectList.do")
	public String selectList(Model model) {
		List<Dev> list = service.selectList();
		System.out.println(list);
		model.addAttribute("list",list);
		return "domo/domoList";
	}
	/*public String selectList(HttpServletRequest re) {
		List<Dev> list = service.selectList();
		re.setAttribute("list", list);
		return "domo/domoselectList";
	}*/

}
