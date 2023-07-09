package com.tptp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tptp.dto.Tptp;


@Service
public interface MapService {
	public List<Tptp> getTptpList() throws Exception;
}
