package com.tptp.controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tptp.dto.Tptp;
import com.tptp.service.MapService;


@Controller
public class MapController {
	private final MapService mapService;
	private static final Integer POSTS_PER_PAGE = 10; // 한 페이지당 보여줄 리스트의 수
	private static final Integer PAGES_PER_BLOCK = 10;// 하단에 보여줄 페이징의 개수 ex) 10 이면 아래에 1~ 10까지 보이고 다음페이지는 다음을 눌러야 넘어감
	
	@Autowired
	public MapController(MapService mapService) {
		this.mapService = mapService;
	}
	
	/**
	 * @brief map init 화면
	 * @param model
	 * @return map.html
	 * @throws Exception 
	 */
	@GetMapping("/map")
	public String map(Model model) throws Exception{
		System.out.println("MapContoller map()");
		model.addAttribute("POSTS_PER_PAGE", POSTS_PER_PAGE); // 한 페이지당 보여줄 리스트의 수
		model.addAttribute("PAGE_PER_BLOCK", PAGES_PER_BLOCK); // 하단에 보여줄 페이징의 개수
		return "/app/map";
	}
	
	/**
	 * @brief 사용자가에게 보여줄 리스트
	 * @param model
	 * @param checkId
	 * @param cheked
	 * @return map.html
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/mapCheck", method = RequestMethod.GET )
	public List<Tptp> checkCategory(Model model,
								@RequestParam(value="checkedList[]") ArrayList<String> checkedList,
								@RequestParam(value="currentNum", defaultValue = "1") Integer currentNum,
								@RequestParam(value="geoLat") String geoLat,
								@RequestParam(value="geoLng") String geoLng ) throws Exception {
		System.out.println("MapController checkCategory()");
		
		double selectLat = Double.parseDouble(geoLat), selectLng = Double.parseDouble(geoLng);
		List<Tptp> viewList = null;
		ArrayList<String> clusterArray = null;
		try {
			clusterArray = mapService.getClusterList(selectLat, selectLng); // 클러스터링 적용
		} catch(NullPointerException e) { 
			return viewList;
		}
		if(clusterArray == null) return viewList; //clusterArray가 비어있는 경우
		
		Map<String, Double> location = new HashMap<String, Double>();
		location.put("lat", selectLat); location.put("lng", selectLng);
		viewList = mapService.getViewList(checkedList, currentNum, clusterArray, location);
		return viewList;
	}
	
	@RequestMapping(value = "/mapPopup", method = RequestMethod.GET )
	public String chart2(Model model,
								@RequestParam(value="region", defaultValue = "" ) String region,
								@RequestParam(value="category", defaultValue = "" ) String category
								) throws Exception {
		
		System.out.println("MainContoller chart()");
		
		List<Tptp> regionCategoryList = mapService.getRegionAndCategoryList(region, category);
		model.addAttribute("region", region);
		model.addAttribute("category", category);
		model.addAttribute("regionCategoryList", regionCategoryList);
		
		System.out.println(region);
		System.out.println(category);

		
		return "/app/mapPopup.html";
	}
	
	
}