package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ComeWarehouseTabService;

@RequestMapping("/hangrano2o/ComeWarehouse")
@ResponseBody
@Controller
public class ComeWarehouseTabController {
	@Autowired
	private ComeWarehouseTabService comeWarehouseTabService;//调用出库单Service层信息
	/**
	 * 添加出库单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addComeWarehouseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addComeWarehouseTab(@RequestBody String data) {
		return comeWarehouseTabService.addComeWarehouseTab(data);
	}
	/**
	 * 查询出库单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryComeWarehouseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryComeWarehouseTab(@RequestBody String data) {
		return comeWarehouseTabService.queryComeWarehouseTab(data);
	}
	/**
	 * 更新出库单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateComeWarehouseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateComeWarehouseTab(@RequestBody String data) {
		return comeWarehouseTabService.updateComeWarehouseTab(data);
	}
	/**
	 * 删除出库单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteComeWarehouseTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteComeWarehouseTab(@RequestBody String data) {
		return comeWarehouseTabService.deleteComeWarehouseTab(data);
	}
	/**
	 * 出库
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/departLibrary",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String departLibrary(@RequestBody String data) {
		return comeWarehouseTabService.departLibrary(data);
	}
	
}
