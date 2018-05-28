package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.OrderTabService;

@Controller
@RequestMapping("order")
@ResponseBody
public class OrderController {
	@Autowired
	private OrderTabService orderTabService;//调用订单Service层接口
	
	@RequestMapping(value="/queryOrderAll",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryOrderTabAll(@RequestBody String data) {
		return orderTabService.queryOrderTabAll(data);
	}
}
