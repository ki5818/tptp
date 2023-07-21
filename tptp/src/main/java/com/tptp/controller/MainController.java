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
import com.tptp.mapper.TptpMapper;
import com.tptp.service.MainService;


@Controller
public class MainController {
	
	private MainService mainService;
	private ReviewMapper reviewMapper;
	private TptpMapper tptpMapper;
	
	@Autowired
	public MainController(MainService mainService, ReviewMapper reviewMapper, TptpMapper tptpMapper) {
		this.mainService = mainService;
		this.reviewMapper = reviewMapper;
		this.tptpMapper = tptpMapper;
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
		
		List<Tptp> makeBoxPlot = tptpMapper.makeBoxPlot();
		
		ArrayList<Integer> ct1 = new ArrayList<>();
		ArrayList<Integer> ct2 = new ArrayList<>();
		ArrayList<Integer> ct3 = new ArrayList<>();
		ArrayList<Integer> ct4 = new ArrayList<>();
		System.out.println(makeBoxPlot);
		
		model.addAttribute("makeBoxPlot", makeBoxPlot);
		for(int i=0; i< makeBoxPlot.size(); i++) {
			ct1.add(makeBoxPlot.get(i).getCT1());
			ct2.add(makeBoxPlot.get(i).getCT2());
			ct3.add(makeBoxPlot.get(i).getCT3());
			ct4.add(makeBoxPlot.get(i).getCT4());
		}
		model.addAttribute("ct1", ct1);
		model.addAttribute("ct2", ct2);
		model.addAttribute("ct3", ct3);
		model.addAttribute("ct4", ct4);
		
		List<Tptp> detailCount = tptpMapper.getDetailCount();
		
		ArrayList<String> ct1Detail = new ArrayList<>();
		ArrayList<Integer> ct1DetailCount = new ArrayList<>();
		ArrayList<String> ct2Detail = new ArrayList<>();
		ArrayList<Integer> ct2DetailCount = new ArrayList<>();
		ArrayList<String> ct3Detail = new ArrayList<>();
		ArrayList<Integer> ct3DetailCount = new ArrayList<>();
		ArrayList<String> ct4Detail = new ArrayList<>();
		ArrayList<Integer> ct4DetailCount = new ArrayList<>();
		
		for(int i=0; i<detailCount.size(); i++) {
			switch (detailCount.get(i).getCategoryId()) {
				case "CT1": 
					ct1Detail.add(detailCount.get(i).getDetail());
					ct1DetailCount.add(detailCount.get(i).getCount());
					break;
				case "CT2": 
					ct2Detail.add(detailCount.get(i).getDetail());
					ct2DetailCount.add(detailCount.get(i).getCount());
					break;
				case "CT3": 
					ct3Detail.add(detailCount.get(i).getDetail());
					ct3DetailCount.add(detailCount.get(i).getCount());
					break;
				case "CT4": 
					ct4Detail.add(detailCount.get(i).getDetail());
					ct4DetailCount.add(detailCount.get(i).getCount());
					break;
			}
		}
		
		model.addAttribute("ct1Detail", ct1Detail);
		model.addAttribute("ct1DetailCount", ct1DetailCount);
		model.addAttribute("ct2Detail", ct2Detail);
		model.addAttribute("ct2DetailCount", ct2DetailCount);
		model.addAttribute("ct3Detail", ct3Detail);
		model.addAttribute("ct3DetailCount", ct3DetailCount);
		model.addAttribute("ct4Detail", ct4Detail);
		model.addAttribute("ct4DetailCount", ct4DetailCount);
		System.out.println(ct1DetailCount);
		
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