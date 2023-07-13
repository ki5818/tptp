package com.tptp.controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	private static final Integer POSTS_PER_PAGE = 10;
	private static final Integer PAGES_PER_BLOCK = 50;
	
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
	public String map() throws Exception{
		System.out.println("MapContoller map()");
		
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
	@RequestMapping(value = "/mapcheck", method = RequestMethod.GET )
	public List<Tptp> checkCategory(Model model,
								@RequestParam(value="checkedList[]") ArrayList<String> checkedList,
								@RequestParam(value = "page",  defaultValue = "1") Integer page) throws Exception {

		List<Tptp> viewList = mapService.getViewList(checkedList);
		System.out.println("MapContoller checkCategory()");		
        // 페이지네이션
        try {
            Paginator paginator = new Paginator(PAGES_PER_BLOCK, POSTS_PER_PAGE, viewList.size());
            Map<String, Object> pageInfo = paginator.getFixedBlock(page);
            model.addAttribute("pageInfo", pageInfo);
            System.out.println(pageInfo);
            viewList.get(0).setPageInfo(pageInfo);
        }
        catch(IllegalStateException e) {
            model.addAttribute("pageInfo", null);
            System.err.println(e);
        }
        
        System.out.println(viewList.get(0).toString());
		
		return viewList;
	}
	
	
	
	
}
