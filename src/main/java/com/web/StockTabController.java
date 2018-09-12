package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 库存量信息API
 * @author vip
 *
 */

import com.service.StockTabService;
@RequestMapping("/hangrano2o/Stock")
@ResponseBody
@Controller
public class StockTabController {
	@Autowired
	private StockTabService stockTabService;//调用库存量Service层接口
	/**
	 * 添加库存量信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addStockTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addStockTab(@RequestBody String data) {
		return stockTabService.addStockTab(data);
	}
	/**
	 * 查询库存量信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryStockTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryStockTab(@RequestBody String data) {
		return stockTabService.queryStockTab(data);
	}
	/**
	 * 更新库存量信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateStockTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateStockTab(@RequestBody String data) {
		return stockTabService.updateStockTab(data);
	}
}
