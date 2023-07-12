package com.tptp.controller;

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


@Controller
public class MapController {
	private final MapService mapService;
	
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
	public String main(Model model) throws Exception{
		System.out.println("MapContoller main()");
		model.addAttribute("discription","당신이 클릭한 장소의 반경 10km 이내의 모든 관광지를 표시합니다. 가고 싶은 곳을 골라보세요");
		
		List<Tptp> tptpList = mapService.getTptpList();
		model.addAttribute("tptpList", tptpList);
		
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
	@RequestMapping(value = "/mapLatLng", method = { RequestMethod.GET })
	public String getMap(Model model,
			@RequestParam("lat") String lat,
			@RequestParam("lng") String lng){
		System.out.println("MapContoller getMap");
		
		double selectLat = Double.parseDouble(lat);
		double selectLng = Double.parseDouble(lng);
		
		System.out.println(selectLat + " " + selectLng);
		return "/app/map";
	}
}
