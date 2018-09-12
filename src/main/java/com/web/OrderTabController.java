package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.OrderTabService;

/**
 * 订单信息API
 * @author vip
 *
 */
@Controller
@ResponseBody
@RequestMapping("/hangrano2o/Order")
public class OrderTabController {
	@Autowired
	private OrderTabService orderTabService;//调用订单Service层接口
	/**
	 * 添加订单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addOrderTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addOrderTab(@RequestBody String data) {
		return orderTabService.addOrderTab(data);
	}
	/**
	 * 查询订单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryOrderTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryOrderTab(@RequestBody String data) {
		return orderTabService.queryOrderTab(data);
	}
	/**
	 * 更新订单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateOrderTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateOrderTab(@RequestBody String data) {
		return orderTabService.updateOrderTab(data);
	}
	/**
	 * 删除订单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteOrderTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteOrderTab(@RequestBody String data) {
		return orderTabService.deleteOrderTab(data);
	}
	/**
	 * 添加后台购物订单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addOrderBack",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addOrderBack(@RequestBody String data) {
		return orderTabService.addOrderBack(data);
	}
	/**
	 * 删除未结算订单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteOrderBack",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteOrderBack(@RequestBody String data) {
		return orderTabService.deleteOrderBack(data);
	}
	/**
	 * 商城前端查询用户个人订单详情
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryBuyerOrder",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryBuyerOrder(@RequestBody String data) {
		return orderTabService.queryBuyerOrder(data);
	}
	/**
	 * 商城前端查询用户个人订单ID订单详情
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryBuyerOrderDetails",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryBuyerOrderDetails(@RequestBody String data) {
		return orderTabService.queryBuyerOrderDetails(data);
	}
}
