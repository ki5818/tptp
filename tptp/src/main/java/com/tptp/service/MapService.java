package com.tptp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tptp.dto.Tptp;


@Service
public interface MapService {
	// tptp 테이블의 전체 조회
	public List<Tptp> getTptpList() throws Exception;
	
	// map 화면에서 사용자에게 보여줄 리스트
	public List<Tptp> getViewList(ArrayList<String> chekedList) throws Exception;
	
}
