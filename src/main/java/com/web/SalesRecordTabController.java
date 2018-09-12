package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.SalesRecordTabService;

/**
 * 商品销售记录API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/SalesRecord")
@ResponseBody
@Controller
public class SalesRecordTabController {
	@Autowired
	private SalesRecordTabService recordTabService;//调用商品销售记录Service层接口
	/**
	 * 添加商品销售记录
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addSalesRecordTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addSalesRecordTab(@RequestBody String data) {
		return recordTabService.addSalesRecordTab(data);
	}
	/**
	 * 添加商品销售记录
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/querySalesRecordTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String querySalesRecordTab(@RequestBody String data) {
		return recordTabService.querySalesRecordTab(data);
	}
	/**
	 * 更新商品销售记录
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateSalesRecordTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateSalesRecordTab(@RequestBody String data) {
		return recordTabService.updateSalesRecordTab(data);
	}
	/**
	 * 更新商品销售记录
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteSalesRecordTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteSalesRecordTab(@RequestBody String data) {
		return recordTabService.deleteSalesRecordTab(data);
	}
}
