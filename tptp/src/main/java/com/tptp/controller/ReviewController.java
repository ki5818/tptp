package com.tptp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tptp.dto.Review;
import com.tptp.mapper.ReviewMapper;

@Controller
public class ReviewController {
	private final ReviewMapper reviewMapper;
	
	@Autowired
	public ReviewController(ReviewMapper reviewMapper) {
		this.reviewMapper = reviewMapper;
	}
	

	@GetMapping("/board")
	public String board(Model model) throws Exception{
		System.out.println("ReviewController board()");
		
		List<Review> reviewList = reviewMapper.getReviewList();
		
		System.out.println(reviewList);
		model.addAttribute("reviewList", reviewList);
		
		return null;
	}

}
