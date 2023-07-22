package com.tptp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tptp.dto.Tptp;

@Service
public interface MainService {
		// 1. 지역별 관광지 개수
		public List<Tptp> getRegionCount() throws Exception;

		// 2. 지역별 카테고리별 관광지 개수
		public List<Tptp> getRegionCategoryCount() throws Exception;
		
		// 3. 카테고리별 관광지 개수
		public List<Tptp> getCategoryCount() throws Exception;
		
		// 2번 차트 정렬
		public List<Tptp> sortChart2(String cName) throws Exception;
			
}
