package com.tptp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tptp.dto.Review;
import com.tptp.dto.Tptp;
import com.tptp.mapper.NewCodeMapper;
import com.tptp.mapper.ReviewMapper;

@Controller
public class ReviewController {
	private final ReviewMapper reviewMapper;
	private final NewCodeMapper newCodeMapper;
	
	@Autowired
	public ReviewController(ReviewMapper reviewMapper, NewCodeMapper newCodeMapper) {
		this.reviewMapper = reviewMapper;
		this.newCodeMapper = newCodeMapper;
	}
	

	@GetMapping("/review")
	public String review(Model model) throws Exception{
		List<Review> reviewList = reviewMapper.getReviewList();
	
		System.out.println(reviewList);
		model.addAttribute("reviewList", reviewList);
		return "/app/review";

	}
	
	/*07-17 게시글 작성창 만들기*/
	
	@PostMapping("/reviewWrite")
	public String reviewWrite(Review addReview) throws Exception {
		System.out.println("reviewWrite()");
		System.out.println(addReview);
		addReview.setReviewId(newCodeMapper.getCommonNewCode());
		
		System.out.println(addReview);
		reviewMapper.addReviewList(addReview);
		String url = "redirect:/reviewPopup?placeId=" + addReview.getPlaceId();
		return url;
	}
	
	/*getPlaceID 받아오기*/
	
	@RequestMapping(value = "/reviewPopup", method = RequestMethod.GET )
	public String reviewPopup(Model model,
										@RequestParam("placeId") String placeId) throws Exception{
		System.out.println(placeId);
		List<Review> reviewList = reviewMapper.getPlaceIDReviewList(placeId);
	
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("placeId", placeId);
		return "/app/reviewPopup";

	}
	
	/* 리뷰 삭제 하기  */
	@RequestMapping(value = "/reviewDelete", method = RequestMethod.GET )
	public String reviewDelete( @RequestParam("reviewId") String reviewId,
								@RequestParam("insertPw") String insertPw) throws Exception {
		System.out.println("reviewDelete()");
		System.out.println(reviewId);
		//reviewMapper.delReviewList(reviewId);
		//String url = "redirect:/reviewpopup?placeId=" + delReview.getPlaceId();
		return null;
		
		/*삭제를 할 때 삭제가 되고 다시 팝업창이 떠야?하는데 이렇게 하는게
		 맞는 지... placeId를 받아오지 못하는 것 같다. */
	}
	

}
