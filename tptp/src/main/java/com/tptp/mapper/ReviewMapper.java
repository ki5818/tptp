package com.tptp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.tptp.dto.Review;

@Mapper
public interface ReviewMapper {
	// 0. 리뷰게시판 데이터 전체 리스트 조회
	public List<Review> getReviewList() throws Exception;
}
