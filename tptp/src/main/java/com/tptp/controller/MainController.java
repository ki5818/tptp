package com.tptp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tptp.dto.Tptp;
import com.tptp.service.MainService;


@Controller
public class MainController {
	
	private MainService mainService;
	
	@Autowired
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	/**
	 * @brief home 화면
	 * @param model 
	 * @return index.html
	 * @throws Exception 
	 */
	
	@GetMapping("/")
	public String main(Model model) throws Exception {
		System.out.println("MainContoller");
		model.addAttribute("discription","대한민국 전국의 관광지를 소개해드립니다. 장소별, 지역별 차트를 확인 할 수 있습니다!");

		//1
		List<Tptp> regionCount = mainService.getRegionCount();
		model.addAttribute("regionCount", regionCount);
		System.out.println(regionCount);
		
		//2
		List<Tptp> categoryCount = mainService.getCategoryCount();
		model.addAttribute("categoryCount", categoryCount);
		System.out.println(categoryCount);
		
		//3
		List<Tptp> regionCategoryCount = mainService.getRegionCategoryCount();
		model.addAttribute("regionCategoryCount", regionCategoryCount);
		System.out.println(regionCategoryCount);		
		
		//3-1
		List<Tptp> regionCategoryCountNat = mainService.getRegionCategoryCountNat();
		model.addAttribute("regionCategoryCountNat", regionCategoryCountNat);
		System.out.println(regionCategoryCountNat);
		
		//3-2. tptpRegionCategoryCountCul
		List<Tptp> regionCategoryCountCul = mainService.getRegionCategoryCountCul();
		model.addAttribute("regionCategoryCountCul", regionCategoryCountCul);
		System.out.println(regionCategoryCountCul);
		
		//3-1
		List<Tptp> regionCategoryCountThem = mainService.getRegionCategoryCountThem();
		model.addAttribute("regionCategoryCountThem", regionCategoryCountThem);
		System.out.println(regionCategoryCountThem);
		
		//3-1
		List<Tptp> regionCategoryCountTour = mainService.getRegionCategoryCountTour();
		model.addAttribute("regionCategoryCountTour", regionCategoryCountTour);
		System.out.println(regionCategoryCountTour);
		
		//4
		List<Tptp> categoryDetailCount = mainService.getCategoryDetailCount();
		model.addAttribute("categoryDetailCount", categoryDetailCount);
		System.out.println(categoryDetailCount);
		
		return "index";
	}
	
}   