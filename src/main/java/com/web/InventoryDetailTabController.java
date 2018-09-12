package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.InventoryDetailTabService;
/**
 * 库存明细表API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/InventoryDetail")
@ResponseBody
@Controller
public class InventoryDetailTabController {
	@Autowired
	private InventoryDetailTabService detailTabService;//调用库存明细表API
	/**
	 * 添加库存明细表信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addInventoryDetailTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addInventoryDetailTab(@RequestBody String data) {
		return detailTabService.addInventoryDetailTab(data);
	}
	/**
	 * 查询库存明细表信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryInventoryDetailTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryInventoryDetailTab(@RequestBody String data) {
		return detailTabService.queryInventoryDetailTab(data);
	}
	/**
	 * 更新库存明细表信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateInventoryDetailTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateInventoryDetailTab(@RequestBody String data) {
		return detailTabService.updateInventoryDetailTab(data);
	}
	/**
	 * 更新库存明细表信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteInventoryDetailTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteInventoryDetailTab(@RequestBody String data) {
		return detailTabService.deleteInventoryDetailTab(data);
	}
	/**
	 * 根据商品ID查询库存明细表信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryDeliIdInventoryDetailTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryDeliIdInventoryDetailTab(@RequestBody String data) {
		return detailTabService.queryDeliIdInventoryDetailTab(data);
	}
	/**
	 * 入库
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/purchaseAccess",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String purchaseAccess(@RequestBody String data) {
		return detailTabService.purchaseAccess(data);
	}
}
