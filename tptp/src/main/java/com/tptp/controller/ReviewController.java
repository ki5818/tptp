package com.tptp.controller;

import java.io.Console;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.tptp.dto.Review;
import com.tptp.dto.Tptp;
import com.tptp.mapper.NewCodeMapper;
import com.tptp.mapper.ReviewMapper;
import com.tptp.util.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	
	/*getPlaceID 받아와서 팝업창에 그 place의 리뷰만 뜨게 하기*/

	@RequestMapping(value = "/reviewPopup", method = RequestMethod.GET )
	public String reviewPopup(Model model,
										@RequestParam("placeId") String placeId) throws Exception{
		System.out.println(placeId);
		List<Review> reviewList = reviewMapper.getPlaceIDReviewList(placeId);
	
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("placeId", placeId);
		return "/app/reviewPopup";

	}	

	/*07-17 게시글 작성창 만들기*/
	/**
	 * 
	 * @param addReview
	 * @return reviewPopup
	 * @throws Exception
	 */
	
	
	@PostMapping("/reviewWrite")
	public String reviewWrite(Review addReview) throws Exception {
		System.out.println("reviewWrite()");
		System.out.println(addReview);
		addReview.setReviewId(newCodeMapper.getCommonNewCode());
		//addReview.getPassword()
		System.out.println(addReview);
		// 비밀번호 암호화 코드 적용
		SHA256 sha256 = new SHA256();
		
		String password = addReview.getPassword();
		String cryptogram = sha256.encrypt(password);
		password = cryptogram;
		addReview.setPassword(password);
		reviewMapper.addReviewList(addReview);
		
		String url = "redirect:/reviewPopup?placeId=" + addReview.getPlaceId();
		return url;
	}
	



	/* 리뷰 삭제 하기 */ 
	@ResponseBody
	@RequestMapping(value = "/reviewDelete", method = RequestMethod.GET )
	public String reviewDelete( 
								@RequestParam("reviewId") String reviewId,
							    @RequestParam("insertPw") String insertPw,
							    @RequestParam("placeId") String placeId) throws Exception {
		System.out.println("reviewDelete()");
		System.out.println(reviewId); 
		System.out.println(insertPw);
		
		SHA256 sha256 = new SHA256();
        
        //비밀번호
        String password = insertPw;
        //SHA256으로 암호화된 비밀번호
        String cryptogram = sha256.encrypt(password);
        
        System.out.println(cryptogram);
        String reviewPassword = reviewMapper.getPassword(reviewId).getPassword();
        System.out.println(reviewPassword);
        //비밀번호 일치 여부
        System.out.println(cryptogram.equals(reviewPassword));
        
        String message;
        
        if(cryptogram.equals(reviewPassword)) {
        	reviewMapper.delReviewList(reviewId);
        	message = "true";
        }
        else {
        	message = "false";

        }
    	return message;
	}
	
	
	/* 게시글 수정하기 위한 준비 -> 비밀번호 체크 */
	@ResponseBody /*responseBody는 redirect를 못쓴다. ajax도 비동기라 그거도 responsebody로*/
	@RequestMapping(value = "/review/checkPassword" , method = RequestMethod.GET)
	public String checkPassword( @RequestParam("reviewId") String reviewId,
								@RequestParam("insertPw") String insertPw ,
								@RequestParam("placeId") String placeId) throws Exception {
		/*비밀번호 암호화 된 걸 풀어서 확인해야함*/
		SHA256 sha256 = new SHA256();
		
		//비밀번호
        String password = insertPw;
        //SHA256으로 암호화된 비밀번호
        String cryptogram = sha256.encrypt(password);
        
        System.out.println(cryptogram);
        String reviewPassword = reviewMapper.getPassword(reviewId).getPassword();
        System.out.println(reviewPassword);
        //비밀번호 일치 여부
        System.out.println(cryptogram.equals(reviewPassword));
        
        String message="";
        
        if(cryptogram.equals(reviewPassword)) {
        	message = "true";
        }
        else {
        	message = "false";

        }
		return message;
	}
	
	/*게시판 수정하기 */
	@GetMapping("/reviewModify")
	public String reviewModify( Model model, HttpServletResponse response,
								@RequestParam("reviewId") String reviewId,
								@RequestParam("insertPw") String insertPw) throws Exception {
		System.out.println("/reviewModify");
		System.out.println(reviewId + " " + insertPw);
	
		// 수정 화면에 수정 전 내용 보내주기
		List<Review> reviewList= reviewMapper.getReviewListParamReviewId(reviewId);
		model.addAttribute("reviewList", reviewList);
		
		//비밀번호 체크
		/*비밀번호 암호화 된 걸 풀어서 확인해야함*/
		SHA256 sha256 = new SHA256();
		
		//비밀번호
        String password = insertPw;
        //SHA256으로 암호화된 비밀번호
        String cryptogram = sha256.encrypt(password);
        
        System.out.println(cryptogram);
        String reviewPassword = reviewMapper.getPassword(reviewId).getPassword();
        System.out.println(reviewPassword);
        //비밀번호 일치 여부
        System.out.println(cryptogram.equals(reviewPassword));

        if(cryptogram.equals(reviewPassword)) {
        	return "/app/modReview";
        }
        else {
        	Alert.alertMiss(response);
        	String url = "/reviewPopup?placeId=" + reviewList.get(0).getPlaceId();
    		return url;

        }

	}
	
	
	
	@PostMapping("/reviewModifyController")
	public String reviewModifyController(HttpServletRequest request) throws Exception {
		System.out.println("reviewModifyController()");
		request.setCharacterEncoding("UTF-8");
		String reviewId = request.getParameter("reviewId");
		String placeId = request.getParameter("placeId");
		String contents = request.getParameter("contents");
		System.out.println(reviewId);
		System.out.println(placeId);
		System.out.println(contents);
		
		reviewMapper.modReviewList(contents, reviewId);
		
		String url = "redirect:/reviewPopup?placeId=" + placeId;
		//System.out.println(modReview);
		return url;
	}
	
	/*
	@GetMapping("/reviewDelete/getPassword")
	@ResponseBody
	private Review getPassword(@RequestParam("reviewId") String reviewId, @RequestParam("password") String password, Model model) throws Exception{	
		Review delReview = new Review();
		delReview.setReviewId(reviewId);
		Review 
		BoardDto result = boardservice.getContentByidx(boardDto);
		return result;	
	}
 	*/
	

}
