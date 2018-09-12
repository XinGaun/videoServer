package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.CartTabService;
/**
 * 购物车API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/CartTab")
@ResponseBody
@Controller
public class CartTabController {
	@Autowired
	private CartTabService cartTabService;//调用购物车Service层接口
	/**
	 * 添加购物车信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addCartTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addCartTab(@RequestBody String data) {
		return cartTabService.addCartTab(data);
	}
	/**
	 * 查询购物车信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCartTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCartTab(@RequestBody String data) {
		return cartTabService.queryCartTab(data);
	}
	/**
	 * 更新购物车信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateCartTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateCartTab(@RequestBody String data) {
		return cartTabService.updateCartTab(data);
	}
	/**
	 * 删除购物车信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteCartTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteCartTab(@RequestBody String data) {
		return cartTabService.deleteCartTab(data);
	}
}
