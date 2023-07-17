package com.tptp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.tptp.dto.Tptp;

@Mapper
public interface TptpMapper {
	// 0. 관광지 데이터 전체 리스트 조회 -> MapService
	public List<Tptp> getTptpList() throws Exception;
	
	// 1. 지역별 관광지 개수
	public List<Tptp> getRegionCount() throws Exception;
	
	// 2. 지역별 카테고리별 관광지 개수
	public List<Tptp> getRegionCategoryCount() throws Exception;
	
	// 2-1.  tptpRegionCategoryCountNat
	public List<Tptp> getRegionCategoryCountNat() throws Exception;
	
	// 2-2. tptpRegionCategoryCountCul
	public List<Tptp> getRegionCategoryCountCul() throws Exception;
	
	// 2-3. tptpRegionCategoryCountThem
	public List<Tptp> getRegionCategoryCountThem() throws Exception;
		
	// 2-4. tptpRegionCategoryCountTour
	public List<Tptp> getRegionCategoryCountTour() throws Exception;
	
	// 3. 카테고리별 관광지 개수
	public List<Tptp> getCategoryCount() throws Exception;
	
	// paging 처리를 위한 mapper
	public List<Tptp> getListOffset(Map<String, String> category , Map<String, Integer> currentNumber) throws Exception;
	
	// 4. 지역명 기준으로 관광지 리스트
	public List<Tptp> getRegionList(String region) throws Exception;
	
}
