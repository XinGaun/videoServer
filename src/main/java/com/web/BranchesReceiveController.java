package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.BranchesReceiveService;

/**
 * 接收总实例推送信息API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/BranchesReceive")
@Controller
@ResponseBody
public class BranchesReceiveController {
	@Autowired
	private BranchesReceiveService branchesReceiveService;
	
	/**
	 * 添加商品信息
	 * @return
	 */
	@RequestMapping(value="/addPushCommodity",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPushCommodity(@RequestBody String data) {
		return branchesReceiveService.addPushCommodity(data);
	}
	/**
	 * 更新商品信息
	 * @return
	 */
	@RequestMapping(value="/updatePushCommodity",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePushCommodity(@RequestBody String data) {
		return branchesReceiveService.updatePushCommodity(data);
	}
	/**
	 * 删除商品信息
	 * @return
	 */
	@RequestMapping(value="/deletePushCommodity",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deletePushCommodity(@RequestBody String data) {
		return branchesReceiveService.deletePushCommodity(data);
	}
	/**
	 * 添加品类信息
	 * @return
	 */
	@RequestMapping(value="/addPushCategory",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPushCategory(@RequestBody String data) {
		return branchesReceiveService.addPushCategory(data);
	}	
	/**
	 * 更新品类信息
	 * @return
	 */
	@RequestMapping(value="/updatePushCategory",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePushCategory(@RequestBody String data) {
		return branchesReceiveService.updatePushCategory(data);
	}
	/**
	 * 添加商品规格信息
	 * @return
	 */
	@RequestMapping(value="/addPushSpecifications",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPushSpecifications(@RequestBody String data) {
		return branchesReceiveService.addPushSpecifications(data);
	}
	/**
	 * 更新商品规格信息
	 * @return
	 */
	@RequestMapping(value="/updatePushSpecifications",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePushSpecifications(@RequestBody String data) {
		return branchesReceiveService.updatePushSpecifications(data);
	}
	/**
	 * 添加总实例推送的供应商信息
	 * @return
	 */
	@RequestMapping(value="/addPushSupplier",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPushSupplier(@RequestBody String data) {
		return branchesReceiveService.addPushSupplier(data);
	}
	/**
	 * 更新总实例推送的供应商信息
	 * @return
	 */
	@RequestMapping(value="/updatePushSupplier",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePushSupplier(@RequestBody String data) {
		return branchesReceiveService.updatePushSupplier(data);
	}
	/**
	 * 添加总实例推送的品牌信息
	 * @return
	 */
	@RequestMapping(value="/addPushBrand",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPushBrand(@RequestBody String data) {
		return branchesReceiveService.addPushBrand(data);
	}
	/**
	 * 更新总实例推送的品牌信息
	 * @return
	 */
	@RequestMapping(value="/updatePushBrand",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePushBrand(@RequestBody String data) {
		return branchesReceiveService.updatePushBrand(data);
	}

}
