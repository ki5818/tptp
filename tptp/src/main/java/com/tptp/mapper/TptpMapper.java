package com.tptp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.tptp.dto.Tptp;

@Mapper
public interface TptpMapper {
	// 0. 관광지 데이터 전체 리스트 조회
	public List<Tptp> getTptpList();
	
	// 1. 지역별 관광지 개수
	public List<Tptp> getRegionCount();
	
	// 2. 카테고리별 관광지 개수
	public List<Tptp> getCategoryCount();
	
	// 3. 지역별 카테고리별 관광지 개수
	public List<Tptp> getRegionCategoryCount();
	
	// 3-1.  tptpRegionCategoryCountNat
	public List<Tptp> getRegionCategoryCountNat();
	
	// 3-2. tptpRegionCategoryCountCul
	public List<Tptp> gettptpRegionCategoryCountCul();
	
	// 3-3. tptpRegionCategoryCountThem
	public List<Tptp> getRegionCategoryCountThem();
		
	// 3-4. tptpRegionCategoryCountTour
	public List<Tptp> getRegionCategoryCountTour();
	
	
	// 4. 카테고리별 디테일별 관광지 개수
	public List<Tptp> getCategoryDetailCount();
	
}
