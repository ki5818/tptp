package com.tptp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.tptp.dto.Tptp;

@Mapper
public interface TptpMapper {
	// 0. 관광지 데이터 전체 리스트 조회 -> MapService
	public List<Tptp> getTptpList() throws Exception;
	
	// 1. 지역별 관광지 개수
	public List<Tptp> getRegionCount() throws Exception;
	
	// 2. 카테고리별 관광지 개수
	public List<Tptp> getCategoryCount() throws Exception;
	
	// 3. 지역별 카테고리별 관광지 개수
	public List<Tptp> getRegionCategoryCount() throws Exception;
	
	// 3-1.  tptpRegionCategoryCountNat
	public List<Tptp> getRegionCategoryCountNat() throws Exception;
	
	// 3-2. tptpRegionCategoryCountCul
	public List<Tptp> getRegionCategoryCountCul() throws Exception;
	
	// 3-3. tptpRegionCategoryCountThem
	public List<Tptp> getRegionCategoryCountThem() throws Exception;
		
	// 3-4. tptpRegionCategoryCountTour
	public List<Tptp> getRegionCategoryCountTour() throws Exception;
	
	// 4. 카테고리별 디테일별 관광지 개수
	public List<Tptp> getCategoryDetailCount() throws Exception;
	
}
