package com.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> guanxin
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.entity.PaySaPi;
<<<<<<< HEAD
=======
import com.service.OrderTabService;
import com.util.Outputsystem;
>>>>>>> guanxin
import com.util.PayUtil;

@Controller
@RequestMapping("pays")
public class PaysApiController {
<<<<<<< HEAD
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
=======
	@Autowired
	private OrderTabService orderTabService;//调用订单Service层接口
	
	
	@RequestMapping(value="/pay",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String pay(HttpServletRequest request, float price, int istype,int user_id,@RequestParam(value="combo_id",required=false) Integer combo_id,@RequestParam(value="video_id",required=false) Integer video_id,@RequestParam(value="discounts_id",required=false) Integer discounts_id) throws UnsupportedEncodingException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> remoteMap = new HashMap<String, Object>();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		hashMap.put("user_id",user_id);
		hashMap.put("combo_id", combo_id);
		hashMap.put("video_id", video_id);
		hashMap.put("discounts_id", discounts_id);
		hashMap.put("order_due", price);
		hashMap.put("order_status", "未付款");
		String result = orderTabService.addOrderTab(hashMap);
		Outputsystem.sysTemOut("addOrderTab result: "+result);
		Outputsystem.sysTemOut(price+"");
		
		remoteMap.put("price", price);
		remoteMap.put("istype", istype);
		remoteMap.put("orderid", hashMap.get("order_id"));
		//remoteMap.put("orderid", PayUtil.getOrderIdByUUId());
		remoteMap.put("orderuid", user_id);
>>>>>>> guanxin
		//remoteMap.put("goodsname", "测试");
		resultMap.put("data", PayUtil.payOrder(remoteMap));
		return  JSON.toJSONString(resultMap);
	}
	
	@RequestMapping("/notifyPay")
	public void notifyPay(HttpServletRequest request, HttpServletResponse response, PaySaPi paySaPi) throws UnsupportedEncodingException {
<<<<<<< HEAD
		// 保证密钥一致性
		if (PayUtil.checkPayKey(paySaPi)) {
			System.out.println("price:"+paySaPi.getPrice());
			System.out.println("spi_id: "+paySaPi.getPaysapi_id());
=======
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("order_id",paySaPi.getOrderid());
		// 保证密钥一致性
		if (PayUtil.checkPayKey(paySaPi)) {
			Outputsystem.sysTemOut("price:"+paySaPi.getPrice());
			Outputsystem.sysTemOut("spi_id: "+paySaPi.getPaysapi_id());
			if(paySaPi.getPrice()==paySaPi.getRealprice()) {
				hashMap.put("order_pricemoney", paySaPi.getRealprice());
				hashMap.put("order_status","已付款");
				String result = orderTabService.updateOrderTab(hashMap);
				Outputsystem.sysTemOut("/notifyPay result: "+result);
			}
>>>>>>> guanxin
			response.setStatus(200);
			// TODO 做自己想做的
		} else {
			// TODO 该怎么做就怎么做
<<<<<<< HEAD
			System.out.println("秘钥不一致");
=======
			Outputsystem.sysTemOut("秘钥不一致");
			hashMap.put("order_pricemoney",paySaPi.getRealprice());
			hashMap.put("order_status","付款失败");
			orderTabService.updateOrderTab(hashMap);
>>>>>>> guanxin
			response.setStatus(400);
		}
	}
	
	@RequestMapping("/returnPay")
	public ModelAndView returnPay(HttpServletRequest request, HttpServletResponse response, String orderid) {
		boolean isTrue = false;
		ModelAndView view = null;
		// 根据订单号查找相应的记录:根据结果跳转到不同的页面
<<<<<<< HEAD
=======
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("order_id", orderid);
		int flog = orderTabService.queryOrderTab(hashMap);
		if(flog!=1) {
			isTrue = true;
		}
>>>>>>> guanxin
		if (isTrue) {
			view = new ModelAndView("error");
		} else {
			view = new ModelAndView("success");
		}
		return view;
	}
}
