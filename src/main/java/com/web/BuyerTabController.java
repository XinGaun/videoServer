package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.BuyerTabService;
/**
 * 买家信息API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/buyer")
@ResponseBody
@Controller
public class BuyerTabController {
	@Autowired
	private BuyerTabService buyerTabService;
	/**
	 * 添加买家信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addBuyerTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addShopTab(@RequestBody String data) {
		return buyerTabService.addBuyerTab(data);
	}
	/**
	 * 查询买家信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryBuyerTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryBuyerTab(@RequestBody String data) {
		return buyerTabService.queryBuyerTab(data);
	}
	/**
	 * 更新买家信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateBuyerTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateBuyerTab(@RequestBody String data) {
		return buyerTabService.updateBuyerTab(data);
	}
	/**
	 * 删除买家信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/daleteBuyerTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String daleteBuyerTab(@RequestBody String data) {
		return buyerTabService.deleteBuyerTab(data);
	}
}
