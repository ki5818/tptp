package com.tptp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tptp.dto.Tptp;
import com.tptp.mapper.TptpMapper;

@Service
public class MapServiceImpl implements MapService {
	
	@Autowired
	private TptpMapper tptpMapper;
	
	@Override
	public List<Tptp> getTptpList() throws Exception {
		List<Tptp> tptpList = tptpMapper.getTptpList();
		return tptpList;
	}
	
	@Override
	public List<Tptp> getViewList(ArrayList<String> checkedList, Integer currentNum) throws Exception {
		
		Map<String, String> category = new HashMap<String, String>();
		Map<String, Integer> currentNumber = new HashMap<String, Integer>();
		
		for(String element : checkedList) {			
			if(element.equals("CT1")) {
				category.put("ct1", element);
			}
			else if(element.equals("CT2")) {
				category.put("ct2", element);
			}
			else if(element.equals("CT3")) {
				category.put("ct3", element);
			}
			else if(element.equals("CT4")) {
				category.put("ct4", element);
			}
		}
		int num = (currentNum-1) * 10;
		currentNumber.put("num", num);
		
		List<Tptp> viewList = tptpMapper.getListOffset(category, currentNumber);
		System.out.println(viewList);

		return viewList;
	}
	
	@Override
	public List<Tptp> getRegionList(String region, String category) throws Exception {
		String categoryId="";
		List <Tptp> regionAndCategoryList;
		
		if(category.equals("")) {
			regionAndCategoryList = tptpMapper.getRegionList(region);
			return regionAndCategoryList;
		}
		
		if(category.equals("자연경관")) {
			categoryId = "CT1";
		}
		else if(category.equals("문화재")) {
			categoryId = "CT2";
		}
		else if(category.equals("테마공원")) {
			categoryId = "CT3";
		}
		else if(category.equals("관광지")) {
			categoryId = "CT4";
		}

		regionAndCategoryList = tptpMapper.getRegionAndCategoryList(region, categoryId);
		
		return regionAndCategoryList;
	}
}