package com.tptp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tptp.dto.Tptp;

@Service
public interface MainService {
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
