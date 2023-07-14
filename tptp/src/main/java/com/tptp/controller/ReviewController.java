package com.tptp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tptp.dto.Review;
import com.tptp.dto.Tptp;
import com.tptp.mapper.ReviewMapper;

@Controller
public class ReviewController {
	private final ReviewMapper reviewMapper;
	
	@Autowired
	public ReviewController(ReviewMapper reviewMapper) {
		this.reviewMapper = reviewMapper;
	}
	

	@GetMapping("/review")
	public String review(Model model) throws Exception{
		List<Review> reviewList = reviewMapper.getReviewList();
	
		System.out.println(reviewList);
		model.addAttribute("reviewList", reviewList);
		return "/app/review";

	}

}
