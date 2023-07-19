package com.tptp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tptp.dto.Cluster;
import com.tptp.dto.ClusterL;
import com.tptp.dto.ClusterM;
import com.tptp.dto.Tptp;
import com.tptp.mapper.ClusterMapper;
import com.tptp.mapper.TptpMapper;

import com.tptp.util.Distance;

@Service
public class MapServiceImpl implements MapService {

	@Autowired
	private TptpMapper tptpMapper;
	private ClusterMapper clusterMapper;

	@Autowired
	public MapServiceImpl(TptpMapper tptpMapper, ClusterMapper clusterMapper) {
		this.tptpMapper = tptpMapper;
		this.clusterMapper = clusterMapper;
	}

	@Override
	public List<Tptp> getTptpList() throws Exception {
		List<Tptp> tptpList = tptpMapper.getTptpList();
		return tptpList;
	}

	@Override
	public List<Tptp> getViewList(ArrayList<String> checkedList, Integer currentNum) throws Exception {

		Map<String, String> category = new HashMap<String, String>();
		Map<String, Integer> currentNumber = new HashMap<String, Integer>();

		for (String element : checkedList) {
			if (element.equals("CT1")) {
				category.put("ct1", element);
			} else if (element.equals("CT2")) {
				category.put("ct2", element);
			} else if (element.equals("CT3")) {
				category.put("ct3", element);
			} else if (element.equals("CT4")) {
				category.put("ct4", element);
			}
		}
		int num = (currentNum - 1) * 10;
		currentNumber.put("num", num);

		List<Tptp> viewList = tptpMapper.getListOffset(category, currentNumber);
		System.out.println(viewList);

		return viewList;
	}

	@Override
	public List<Tptp> getRegionList(String region, String category) throws Exception {
		String categoryId = "";
		List<Tptp> regionAndCategoryList;

		if (category.equals("")) {
			regionAndCategoryList = tptpMapper.getRegionList(region);
			return regionAndCategoryList;
		}

		if (category.equals("자연경관")) {
			categoryId = "CT1";
		} else if (category.equals("문화재")) {
			categoryId = "CT2";
		} else if (category.equals("테마공원")) {
			categoryId = "CT3";
		} else if (category.equals("관광지")) {
			categoryId = "CT4";
		}

		regionAndCategoryList = tptpMapper.getRegionAndCategoryList(region, categoryId);

		return regionAndCategoryList;
	}

	@Override
	public void getClusterList() throws Exception {
		double distL = clusterMapper.getAverageDistLarge().getAvg();
		double distM = clusterMapper.getAverageDistMedium().getAvg();
		double distS = clusterMapper.getAverageDistSmall().getAvg();
		
		  double ratio_l = distL / distS;
		  double ratio_m = distM / distS;
		  
		  // 현재위치 혹은 클릭위치 받아옴
		  double geoLat = 37.59698674; 
		  double geoLng = 126.9539447;
		  int criterion = 30; // 범위 km
		  
		  List<ClusterL> rowL = clusterMapper.getClusterLarge();
		
		  ArrayList<String> cluster_l_list = new ArrayList<>();
		  
		  double lat;
		  double lng;
		  double dist;
		  double distance;
		  
		  for(int i = 0; i < rowL.size(); i++) {
			  lat = rowL.get(i).getLatCenter();
			  lng = rowL.get(i).getLngCenter();
			  dist = rowL.get(i).getDist();
			  distance = Distance.distanceInKilometerByHaversine(lat, lng, geoLat, geoLng);
			  if(Math.abs(distance - dist) < criterion * ratio_l) {
				  cluster_l_list.add((String)rowL.get(i).getClusterLId()); 
			  }
		  }
		  System.out.println(cluster_l_list);
		  System.out.println(cluster_l_list.size());
		  
		  
		  System.out.println(cluster_l_list);
		  
		  List<ClusterM> rowM = clusterMapper.getClusterMedium(cluster_l_list);
		  
		  ArrayList<String> cluster_m_list = new ArrayList<>();
		  
		  for(int i = 0; i < rowM.size(); i++) {
			  lat = rowM.get(i).getLatCenter();
			  lng = rowM.get(i).getLngCenter();
			  dist = rowM.get(i).getDist();
			  distance = Distance.distanceInKilometerByHaversine(lat, lng, geoLat, geoLng);
			  if(Math.abs(distance - dist) < criterion * ratio_m) {
				  cluster_m_list.add((String)rowM.get(i).getClusterMId());
			  }
		  }
		  
		  System.out.println(cluster_m_list);
		  
		  List<ClusterM> rowS = clusterMapper.getClusterMedium(cluster_m_list);
		  
		  System.out.println(rowS);
		  
		  ArrayList<String> cluster_s_list = new ArrayList<>();
		  
		  for(int i = 0; i < rowS.size(); i++) {
			  lat = rowS.get(i).getLatCenter();
			  lng = rowS.get(i).getLngCenter();
			  dist = rowS.get(i).getDist();
			  distance = Distance.distanceInKilometerByHaversine(lat, lng, geoLat, geoLng);
			  if(Math.abs(distance - dist) < criterion) {
				  cluster_s_list.add((String)rowS.get(i).getClusterMId()); 
			  }
		  }

	}
}