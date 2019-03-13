package com.kh.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.service.DomoService;

// Spring이 관리할 수 있도록 @로 표기
@Controller
public class DomoController {
	
	// 알아서 집어넣어줄 클래스
	@Autowired
	/*@Qualifier("choice")*/
	private DomoService service;
	
	@RequestMapping("/domo/domo.do")
	public String domo() {
		return "domo/domo";
	}
}
