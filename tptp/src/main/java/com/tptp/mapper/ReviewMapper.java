package com.tptp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.junit.validator.PublicClassValidator;

import com.tptp.dto.Review;

@Mapper
public interface ReviewMapper { //인터페이스이다!!! 
	// 0. 리뷰게시판 데이터 전체 리스트 조회 (Read)
	//ReviewMapper.java에서 만들 함수를 선언만 하고 직접 쿼리문은 xml에 입력 맞는지
	public List<Review> getReviewList() throws Exception;
	
	//1. 리뷰게시판 데이터 추가 (Create)
	public void addReviewList(Review addReview) throws Exception;
	
	//2. 리뷰게시판 데이터 수정 (Update)
	public void modReviewList(String reviewId) throws Exception;
	
	//3. 리뷰게시판 데이터 삭제 (Delete)
	public void delReviewList(Review delReview) throws Exception; 
	//review dto를 가져오는 게 맞는지 아니면 reviewId를 가져오는 게 맞는지 
	
	//4. 리뷰게시판 중 특정 place_id로 리뷰 목록 조회 (Read)
	public List<Review> getPlaceIDReviewList(String placeId) throws Exception; 

	//5. 리뷰게시판에서 장소를 삽입해 {place}의 리뷰입니다. 라고 select문으로 장소를 구하는 쿼리문
	public List<Review> getPlaceList() throws Exception;
}
