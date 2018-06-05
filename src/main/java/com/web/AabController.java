package com.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.AabService;

@Controller
@RequestMapping("/Aab")
public class AabController {
	@Autowired
	private AabService aabService;
//	,method= {RequestMethod.POST,RequestMethod.GET}	
	@RequestMapping(value="/selectAab",produces="application/json;charset=utf-8")
	@ResponseBody
	public String selectAab(){
		return aabService.queryAab();
	}
}
