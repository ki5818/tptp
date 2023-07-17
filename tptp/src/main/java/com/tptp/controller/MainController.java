package com.tptp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tptp.dto.Review;
import com.tptp.dto.Tptp;
import com.tptp.mapper.ReviewMapper;
import com.tptp.service.MainService;


@Controller
public class MainController {
	
	private MainService mainService;
	private ReviewMapper reviewMapper;
	
	@Autowired
	public MainController(MainService mainService, ReviewMapper reviewMapper) {
		this.mainService = mainService;
		this.reviewMapper = reviewMapper;
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
		
		List<Review> reviewList = reviewMapper.getReviewList();
		
		System.out.println(reviewList);
		model.addAttribute("reviewList", reviewList);

		// 1. 지역별 관광지 개수
		List<Tptp> regionCount = mainService.getRegionCount();
		model.addAttribute("regionCount", regionCount);
		System.out.println(regionCount);
		
		// 2. 지역별 카테고리별 관광지 개수
		List<Tptp> regionCategoryCount = mainService.getRegionCategoryCount();
		model.addAttribute("regionCategoryCount", regionCategoryCount);
		System.out.println(regionCategoryCount);		
		
		// 2-1.  tptpRegionCategoryCountNat
		List<Tptp> regionCategoryCountNat = mainService.getRegionCategoryCountNat();
		model.addAttribute("regionCategoryCountNat", regionCategoryCountNat);
		
		
		// 2-2. tptpRegionCategoryCountCul
		List<Tptp> regionCategoryCountCul = mainService.getRegionCategoryCountCul();
		model.addAttribute("regionCategoryCountCul", regionCategoryCountCul);
		
		
		// 2-3. tptpRegionCategoryCountThem
		List<Tptp> regionCategoryCountThem = mainService.getRegionCategoryCountThem();
		model.addAttribute("regionCategoryCountThem", regionCategoryCountThem);
		
		
		// 2-4. tptpRegionCategoryCountTour
		List<Tptp> regionCategoryCountTour = mainService.getRegionCategoryCountTour();
		model.addAttribute("regionCategoryCountTour", regionCategoryCountTour);
		
		// 3. 카테고리별 관광지 개수
		List<Tptp> categoryCount = mainService.getCategoryCount();
		model.addAttribute("categoryCount", categoryCount);
		System.out.println(categoryCount);
		
		return "index";
	}
	
}   