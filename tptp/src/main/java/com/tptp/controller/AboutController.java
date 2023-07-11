package com.tptp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

	@GetMapping("/aboutUs")
	public String main(Model model) {
		System.out.println("AboutContoller");
		model.addAttribute("discription","이 프로젝트를 만든 사람들");
		return "/app/about";
	}

}
