package com.tptp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.junit.validator.PublicClassValidator;

import com.tptp.dto.Review;

@Mapper
public interface ReviewMapper {
	// 0. 리뷰게시판 데이터 전체 리스트 조회 (Read)
	//ReviewMapper.java에서 만들 함수를 선언만 하고 직접 쿼리문은 xml에 입력 맞는지
	public List<Review> getReviewList() throws Exception;
	
	//1. 리뷰게시판 데이터 추가 (Create)
	public List<Review> addReviewList() throws Exception;
	
	//2. 리뷰게시판 데이터 수정 (Update)
	public List<Review> modReviewList() throws Exception;
	
	//3. 리뷰게시판 데이터 삭제 (Delete)
	public List<Review> delReviewList() throws Exception;
}
