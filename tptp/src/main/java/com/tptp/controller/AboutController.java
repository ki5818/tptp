package com.tptp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

	@GetMapping("/aboutUs")
	public String about(Model model) {
		System.out.println("AboutContoller");
		model.addAttribute("discription","이 프로젝트를 만든 사람들");
		return "/app/about";
	}

}
