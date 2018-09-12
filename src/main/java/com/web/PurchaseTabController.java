package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.PurchaseTabService;
/**
 * 采购单API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Purchase")
@ResponseBody
@Controller
public class PurchaseTabController {
	@Autowired
	private PurchaseTabService purchaseTabService;
	/**
	 * 添加采购单
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addPurchaseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPurchaseTab(@RequestBody String data) {
		return purchaseTabService.addPurchaseTab(data);
	}
	/**
	 * 查询采购单
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryPurchaseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryPurchaseTab(@RequestBody String data) {
		return purchaseTabService.queryPurchaseTab(data);
	}
	/**
	 * 更新采购单
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updatePurchaseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePurchaseTab(@RequestBody String data) {
		return purchaseTabService.updatePurchaseTab(data);
	}
	/**
	 * 删除采购单
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deletePurchaseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deletePurchaseTab(@RequestBody String data) {
		return purchaseTabService.deletePurchaseTab(data);
	}
}
