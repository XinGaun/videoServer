package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ShopTabService;
/**
 * 门店信息API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Shop")
@Controller
public class ShopTabController {
	@Autowired
	private ShopTabService ShopTabService;
	/**
	 * 添加门店信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addShopTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String addShopTab(@RequestBody String data) {
		return ShopTabService.addShopTab(data);
	}
	/**
	 * 查询门店信息
	 * @return
	 */
	@RequestMapping(value="/queryShopTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String queryShopTab(@RequestBody String data) {
		return ShopTabService.queryShopTab(data);
	}
	/**
	 * 更新门店信息
	 * @return
	 */
	@RequestMapping(value="/updateShopTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String updateShopTab(@RequestBody String data) {
		return ShopTabService.updateShopTab(data);
	}
	/**
	 * 删除门店信息
	 * @return
	 */
	@RequestMapping(value="/deleteShopTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String deleteShopTab(@RequestBody String data) {
		return ShopTabService.deleteShopTab(data);
	}
}
