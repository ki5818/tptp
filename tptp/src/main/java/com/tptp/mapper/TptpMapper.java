package com.tptp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.tptp.dto.Tptp;

@Mapper
public interface TptpMapper {
	// 관광지 데이터 조회
	public List<Tptp> getTptpList();
}
