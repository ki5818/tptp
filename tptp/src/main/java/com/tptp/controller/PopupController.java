package com.tptp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PopupController {

	@GetMapping("/information")
	public String inforPopup(Model model) throws Exception {
		
		System.out.println("PopupController inforPopup()");       

		return "app/inforPopup";
	}

}
