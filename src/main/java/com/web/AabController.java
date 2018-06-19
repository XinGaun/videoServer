package com.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.AabService;

@Controller
@RequestMapping("/Aab")
public class AabController {
	@Autowired
	private AabService aabService;
	
	@RequestMapping(value="/selectAab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String selectAab(){
		return aabService.queryAab();
	}
}
