package com.tptp.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tptp.dto.Tptp;
import com.tptp.mapper.TptpMapper;



@Controller
public class MainController {
	
	private final TptpMapper tptpMapper;
	
	public MainController(TptpMapper tptpMapper) {
		this.tptpMapper = tptpMapper;
	}

	@GetMapping("/")
	public String main(Model model) {
		getTptpList();
		return "index";
	}
	
	public void getTptpList() {
		List<Tptp> tptpList = tptpMapper.getTptpList();
		// 현재는 10개만 가져오게 함
		System.out.println(tptpList);
	}
}   