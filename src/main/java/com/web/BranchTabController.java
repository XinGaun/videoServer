package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.BranchTabService;

/**
 * 分公司API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Branch")
@Controller
@ResponseBody
public class BranchTabController {
	@Autowired
	private BranchTabService branchTabService;//调用分公司Service层接口
	/**
	 * 添加分公司信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addBranchTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addBranchTab(@RequestBody String data) {
		return branchTabService.addBranchTab(data);
	}
	/**
	 * 添加分公司信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryBranchTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryBranchTab(@RequestBody String data) {
		return branchTabService.queryBranchTab(data);
	}
	/**
	 * 添加分公司信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateBranchTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateBranchTab(@RequestBody String data) {
		return branchTabService.updateBranchTab(data);
	}
	/**
	 * 删除分公司信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteBranchTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteBranchTab(@RequestBody String data) {
		return branchTabService.deleteBranchTab(data);
	}
}
