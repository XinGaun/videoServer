package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.OpinionService;


@Controller
@RequestMapping("opinion")
@ResponseBody
public class OpinionController {
	@Autowired
	private OpinionService opinionService;
	
	@RequestMapping(value="/queryOpinionAll",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryOpinionAll(@RequestBody String data) {
		
		return opinionService.queryOpinionAll(data);
		
	}
	
	/**
	 * 删除订单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteopinionTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteOrderTab(@RequestBody String data) {
		return opinionService.deleteOpinionTab(data);
	}
}
