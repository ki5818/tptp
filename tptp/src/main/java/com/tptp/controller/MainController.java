package com.tptp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String index(Model model) throws Exception {
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
		
		
		// 3. 카테고리별 관광지 개수
		List<Tptp> categoryCount = mainService.getCategoryCount();
		model.addAttribute("categoryCount", categoryCount);
		System.out.println(categoryCount);
		
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/changeLegend", method = RequestMethod.GET )
	public List<Tptp> clickLegend(Model model,
								@RequestParam(value="removedCategory[]") ArrayList<String> removedCategory) throws Exception {
		
		System.out.println("MapContoller changeLegend()");
        
		List<Tptp> regionCategoryCount = mainService.getRegionCategoryCount();

		return regionCategoryCount;
	}
	
	
	
}   