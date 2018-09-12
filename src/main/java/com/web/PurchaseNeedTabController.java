package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.PurchaseNeedTabService;

/**
 * 采购需求API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/PurchaseNeed")
@ResponseBody
@Controller
public class PurchaseNeedTabController {
	@Autowired
	private PurchaseNeedTabService needTabService;//调用采购需求Service层接口
	/**
	 * 添加采购需求
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addPurchaseNeedTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPurchaseNeedTab(@RequestBody String data) {
		return needTabService.addPurchaseNeedTab(data);
	}
	/**
	 * 查询采购需求
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryPurchaseNeedTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryPurchaseNeedTab(@RequestBody String data) {
		return needTabService.queryPurchaseNeedTab(data);
	}
	/**
	 * 更新采购需求
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updatePurchaseNeedTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePurchaseNeedTab(@RequestBody String data) {
		return needTabService.updatePurchaseNeedTab(data);
	}
	/**
	 * 删除采购需求
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deletePurchaseNeedTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deletePurchaseNeedTab(@RequestBody String data) {
		return needTabService.deletePurchaseNeedTab(data);
	}
}
