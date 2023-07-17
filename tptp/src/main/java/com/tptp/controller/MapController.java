package com.tptp.controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.tptp.util.Paginator;


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
		model.addAttribute("POSTS_PER_PAGE", POSTS_PER_PAGE);
		model.addAttribute("PAGE_PER_BLOCK", PAGES_PER_BLOCK);
		
		return "/app/map";
	}
	
	/**
	 * @brief 사용자가 클릭한 위치를 GET으로 받아와서 처리후 map view에 보냅니다.
	 * @param model
	 * @param lat
	 * @param lng
	 * @return map.html
	 */
	@ResponseBody
	@RequestMapping(value = "/maplocation", method = { RequestMethod.GET })
	public String getMap(Model model,
							@RequestParam("lat") String lat,
							@RequestParam("lng") String lng) {
		System.out.println("MapContoller getMap()");
		
		double selectLat = Double.parseDouble(lat);
		double selectLng = Double.parseDouble(lng);
		
		System.out.println(selectLat + " " + selectLng);
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
								@RequestParam(value="currentNum", defaultValue = "1") Integer currentNum) throws Exception {

		List<Tptp> viewList = mapService.getViewList(checkedList, currentNum);
		
		System.out.println("MapContoller checkCategory()");
        

		return viewList;
	}
	
}
