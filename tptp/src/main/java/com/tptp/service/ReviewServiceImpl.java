package com.tptp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tptp.dto.Review;
import com.tptp.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	
	@Override
	public List<Review> getReviewList() throws Exception{
		List<Review> reviewList = reviewMapper.getReviewList();
		return reviewList;
		
	}

}

