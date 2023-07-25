package com.tptp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tptp.dto.Tptp;


@Service
public interface MapService {
	// tptp 테이블의 전체 조회
	public List<Tptp> getTptpList() throws Exception;
	
	// map 화면에서 사용자에게 보여줄 리스트
	public List<Tptp> getViewList(ArrayList<String> chekedList, Integer currentNum, ArrayList<String> clusterArray, Map<String, Double> location) throws Exception;
	
	// 지역명 기준으로 관광지 리스트
	public List<Tptp> getRegionAndCategoryList(String region, String category) throws Exception;
	
	// 클러스터링
	public ArrayList<String> getClusterList(double geoLat, double geoLng) throws Exception;
}
