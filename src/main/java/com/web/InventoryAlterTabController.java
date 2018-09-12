package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.InventoryAlterTabService;

/**
 * 库存变更PAI
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/InventoryAlter")
@ResponseBody
@Controller
public class InventoryAlterTabController {
	@Autowired
	private InventoryAlterTabService inventoryAlterTabService;//调用库存变更Service层接口
	/**
	 * 添加库存变更信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addInventoryAlterTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addInventoryAlterTab(@RequestBody String data) {
		return inventoryAlterTabService.addInventoryAlterTab(data);
	}
	/**
	 * 查询库存变更信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryInventoryAlterTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryInventoryAlterTab(@RequestBody String data) {
		return inventoryAlterTabService.queryInventoryAlterTab(data);
	}
	/**
	 * 更新库存变更信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateInventoryAlterTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateInventoryAlterTab(@RequestBody String data) {
		return inventoryAlterTabService.updateInventoryAlterTab(data);
	}
	/**
	 * 删除库存变更信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteInventoryAlterTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteInventoryAlterTab(@RequestBody String data) {
		return inventoryAlterTabService.deleteInventoryAlterTab(data);
	}
}
