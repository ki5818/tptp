package com.tptp.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewCodeMapper {
	// 코드 생성 모듈 
	public String getCommonNewCode(String tableName, String columName);
}