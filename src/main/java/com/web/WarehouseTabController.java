package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.WarehouseTabService;
/**
 * 仓库API
 * @author vip
 *
 */
@Controller
@ResponseBody
@RequestMapping("/hangrano2o/Warehouse")
public class WarehouseTabController {
	@Autowired
	private  WarehouseTabService warehouseTabService;//调用仓库Service层接口
	/**
	 * 添加仓库信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addWarehouseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String addWarehouseTab(@RequestBody String data) {
		return warehouseTabService.addWarehouseTab(data);
	}
	/**
	 * 查询仓库信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryWarehouseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String queryWarehouseTab(@RequestBody String data) {
		return warehouseTabService.queryWarehouseTab(data);
	}
	/**
	 * 更新仓库信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateWarehouseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String updateWarehouseTab(@RequestBody String data) {
		return warehouseTabService.updateWarehouseTab(data);
	}
	/**
	 * 删除仓库信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteWarehouseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String deleteWarehouseTab(@RequestBody String data) {
		return warehouseTabService.deleteWarehouseTab(data);
	}
}
