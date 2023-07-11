package com.tptp.service;

import java.util.ArrayList;
import java.util.List;

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
		List<Tptp> listCT1 = new ArrayList<>();
		System.out.println(tptpList);
		
		for(int i = 0; i< tptpList.size(); i++) {
			if(tptpList.get(i).getCategoryId().equals("CT1")) {
				System.out.println(tptpList.get(i).getCategoryId());
				listCT1.add(tptpList.get(i));
			}
			
		}
		System.out.println(listCT1);
		
		return tptpList;
	}
	

}
