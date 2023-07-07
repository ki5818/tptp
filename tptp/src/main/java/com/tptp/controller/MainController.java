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

	/**
	 * @brief home 화면
	 * @param model 
	 * @return index.html
	 */
	
	@GetMapping("/")
	public String main(Model model) {
		System.out.println("MainContoller");
		model.addAttribute("discription","대한민국 전국의 관광지를 소개해드립니다. 장소별, 지역별 차트를 확인 할 수 있습니다!");
		Tptp tptp = new Tptp();
		getTptpList(model, tptp);
		
		return "index";
	}
	
	/**
	 * @brief db로 받아온 tptp 테이블을 리스트에 매핑
	 * 
	 * @param tptp
	 */
	public void getTptpList(Model model, Tptp tptp) {
		//0
		List<Tptp> tptpList = tptpMapper.getTptpList();
		model.addAttribute("tptpList", tptpList);
		System.out.println(tptpList);
		
		//1
		List<Tptp> tptpRegionCount = tptpMapper.getRegionCount();
		model.addAttribute("tptpRegionCount", tptpRegionCount);
		System.out.println(tptpRegionCount);
		
		//2
		List<Tptp> tptpCategoryCount = tptpMapper.getCategoryCount();
		model.addAttribute("tptpCategoryCount", tptpCategoryCount);
		System.out.println(tptpCategoryCount);
		
		//3
		List<Tptp> tptpRegionCategoryCount = tptpMapper.getRegionCategoryCount();
		model.addAttribute("tptpRegionCategoryCount", tptpRegionCategoryCount);
		System.out.println(tptpRegionCategoryCount);		
		
		//3-1
		List<Tptp> tptpRegionCategoryCountNat = tptpMapper.getRegionCategoryCountNat();
		model.addAttribute("tptpRegionCategoryCountNat", tptpRegionCategoryCountNat);
		System.out.println(tptpRegionCategoryCountNat);
		
		//3-2. tptpRegionCategoryCountCul
		List<Tptp> tptpRegionCategoryCountCul = tptpMapper.gettptpRegionCategoryCountCul();
		model.addAttribute("tptpRegionCategoryCountCul", tptpRegionCategoryCountCul);
		System.out.println(tptpRegionCategoryCountCul);
		
		//3-1
		List<Tptp> tptpRegionCategoryCountThem = tptpMapper.getRegionCategoryCountThem();
		model.addAttribute("tptpRegionCategoryCountThem", tptpRegionCategoryCountThem);
		System.out.println(tptpRegionCategoryCountThem);
		
		//3-1
		List<Tptp> tptpRegionCategoryCountTour = tptpMapper.getRegionCategoryCountTour();
		model.addAttribute("tptpRegionCategoryCountTour", tptpRegionCategoryCountTour);
		System.out.println(tptpRegionCategoryCountTour);
		
		//4
		List<Tptp> categoryDetailCount = tptpMapper.getCategoryDetailCount();
		model.addAttribute("categoryDetailCount", categoryDetailCount);
		System.out.println(categoryDetailCount);
	}
	
}   