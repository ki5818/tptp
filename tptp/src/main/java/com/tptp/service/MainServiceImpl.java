package com.tptp.service;

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
	// 2. 카테고리별 관광지 개수
	public List<Tptp> getCategoryCount() throws Exception {
		return tptpMapper.getCategoryCount();
	}

	@Override
	// 3. 지역별 카테고리별 관광지 개수
	public List<Tptp> getRegionCategoryCount() throws Exception {
		return tptpMapper.getRegionCategoryCount();
	}

	@Override
	public List<Tptp> getRegionCategoryCountNat() throws Exception {
		return tptpMapper.getRegionCategoryCountNat();
	}

	@Override
	public List<Tptp> getRegionCategoryCountCul() throws Exception {
		return tptpMapper.getRegionCategoryCountCul();
	}

	@Override
	public List<Tptp> getRegionCategoryCountThem() throws Exception {
		return tptpMapper.getRegionCategoryCountThem();
	}

	@Override
	public List<Tptp> getRegionCategoryCountTour() throws Exception {
		return tptpMapper.getRegionCategoryCountTour();
	}

	@Override
	// 4. 카테고리별 디테일별 관광지 개수
	public List<Tptp> getCategoryDetailCount() throws Exception {
		return tptpMapper.getCategoryDetailCount();
	}

}
