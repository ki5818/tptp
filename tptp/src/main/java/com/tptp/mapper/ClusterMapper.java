package com.tptp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tptp.dto.ClusterL;
import com.tptp.dto.ClusterM;
import com.tptp.dto.ClusterS;


@Mapper
public interface ClusterMapper {
	// # average_dist_large
	public ClusterL getAverageDistLarge() throws Exception;
	
	public ClusterM getAverageDistMedium() throws Exception;
	
	public ClusterS getAverageDistSmall() throws Exception;
	
	public List<ClusterL> getClusterLarge() throws Exception;
	
	public List<ClusterM> getClusterMedium(ArrayList<String> cluster_l_list) throws Exception;
	
	public List<ClusterS> getClusterSmall(ArrayList<String> cluster_m_list) throws Exception;
	
	
}
