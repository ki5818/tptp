package com.tptp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tptp.dto.Review;

@Service
public interface ReviewService {
	//review 테이블의 전체 조회
	public List<Review> getReviewList () throws Exception;
}
