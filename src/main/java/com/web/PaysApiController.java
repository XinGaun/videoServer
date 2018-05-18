package com.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.entity.PaySaPi;
import com.util.PayUtil;

@Controller
@RequestMapping("pays")
public class PaysApiController {
	@RequestMapping(value="/pay",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String pay(HttpServletRequest request, float price, int istype) throws UnsupportedEncodingException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> remoteMap = new HashMap<String, Object>();
		System.out.println(price);
		remoteMap.put("price", price);
		remoteMap.put("istype", istype);
		remoteMap.put("orderid", PayUtil.getOrderIdByUUId());
		remoteMap.put("orderuid", "911");
		//remoteMap.put("goodsname", "测试");
		resultMap.put("data", PayUtil.payOrder(remoteMap));
		return  JSON.toJSONString(resultMap);
	}
	
	@RequestMapping("/notifyPay")
	public void notifyPay(HttpServletRequest request, HttpServletResponse response, PaySaPi paySaPi) throws UnsupportedEncodingException {
		// 保证密钥一致性
		if (PayUtil.checkPayKey(paySaPi)) {
			System.out.println("price:"+paySaPi.getPrice());
			System.out.println("spi_id: "+paySaPi.getPaysapi_id());
			response.setStatus(200);
			// TODO 做自己想做的
		} else {
			// TODO 该怎么做就怎么做
			System.out.println("秘钥不一致");
			response.setStatus(400);
		}
	}
	
	@RequestMapping("/returnPay")
	public ModelAndView returnPay(HttpServletRequest request, HttpServletResponse response, String orderid) {
		boolean isTrue = false;
		ModelAndView view = null;
		// 根据订单号查找相应的记录:根据结果跳转到不同的页面
		if (isTrue) {
			view = new ModelAndView("error");
		} else {
			view = new ModelAndView("success");
		}
		return view;
	}
}
