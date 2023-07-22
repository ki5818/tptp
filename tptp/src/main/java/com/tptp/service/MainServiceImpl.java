package com.tptp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tptp.dto.Tptp;
import com.tptp.mapper.TptpMapper;

@Service
public class MainServiceImpl implements MainService {
	
	private TptpMapper tptpMapper;
	
	@Autowired
	public MainServiceImpl(TptpMapper tptpMapper) {
		this.tptpMapper = tptpMapper;
	}

	@Override
	// 1. 지역별 관광지 개수
	public List<Tptp> getRegionCount() throws Exception {
		return tptpMapper.getRegionCount();
	}

	@Override
	// 2. 지역별 카테고리별 관광지 개수
	public List<Tptp> getRegionCategoryCount() throws Exception {
		return tptpMapper.getRegionCategoryCount();
	}

	@Override
	// 3. 카테고리별 관광지 개수
	public List<Tptp> getCategoryCount() throws Exception {
		return tptpMapper.getCategoryCount();
	}

	
	@Override
	// 2번 차트 정렬
	public List<Tptp> sortChart2(String cName) throws Exception {
		
		List<Tptp> sortChart2 = tptpMapper.sortChart2(cName);
		
		System.out.println(sortChart2);
		
		return sortChart2;
	}

}
