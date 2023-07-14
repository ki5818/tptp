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
		return tptpList;
	}
	
	public List<Tptp> getViewList(ArrayList<String> checkedList) throws Exception {
		List<Tptp> tptpList = tptpMapper.getTptpList();
		List<Tptp> viewList = new ArrayList<Tptp>(tptpList.size());
		System.out.println(checkedList);
		for(Tptp element : tptpList) {
			for(int i = 0; i < checkedList.size(); i++) {
				if(element.getCategoryId().equals(checkedList.get(i))) {
					viewList.add(element);
				}
			}
		}
		System.out.println(viewList.toString());
		return viewList;
	}
}