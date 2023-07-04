package com.tptp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AboutController {

	@GetMapping("/about")
	public String main(Model model) {
		System.out.println("AboutContoller");
		
		return "/app/about";
	}

}
