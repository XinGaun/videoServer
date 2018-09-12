package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.SalesIncentiveService;

@RequestMapping("/hangrano2o/SalesIncentive")
@ResponseBody
@Controller
public class SalesIncentiveController {
	@Autowired
	private SalesIncentiveService incentiveService;
	/**
	 * 添加销售团队类型
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addSalesteamTypeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addSalesteamTypeTab(@RequestBody String data) {
		return incentiveService.addSalesteamTypeTab(data);
	}
	/**
	 * 查询销售团队类型
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/querySalesteamTypeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String querySalesteamTypeTab(@RequestBody String data) {
		return incentiveService.querySalesteamTypeTab(data);
	}
	/**
	 * 修改销售团队类型
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateSalesteamTypeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateSalesteamTypeTab(@RequestBody String data) {
		return incentiveService.updateSalesteamTypeTab(data);
	}
	/**
	 * 删除销售团队类型
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteSalesteamTypeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteSalesteamTypeTab(@RequestBody String data) {
		return incentiveService.deleteSalesteamTypeTab(data);
	}
	/**
	 * 添加销售团队
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addSalesteamTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addSalesteamTab(@RequestBody String data) {
		return incentiveService.addSalesteamTab(data);
	}
	/**
	 * 查询销售团队
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/querySalesteamTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String querySalesteamTab(@RequestBody String data) {
		return incentiveService.querySalesteamTab(data);
	}
	/**
	 * 更新销售团队
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateSalesteamTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateSalesteamTab(@RequestBody String data) {
		return incentiveService.updateSalesteamTab(data);
	}
	/**
	 * 删除销售团队
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteSalesteamTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteSalesteamTab(@RequestBody String data) {
		return incentiveService.deleteSalesteamTab(data);
	}
	/**
	 * 添加销售团队员工
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addSalesteamStaffMiddleTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addSalesteamStaffMiddleTab(@RequestBody String data) {
		return incentiveService.addSalesteamStaffMiddleTab(data);
	}
	/**
	 * 删除销售团队员工
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteSalesteamStaffMiddleTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteSalesteamStaffMiddleTab(@RequestBody String data) {
		return incentiveService.deleteSalesteamStaffMiddleTab(data);
	}
	/**
	 * 查询销售团队员工
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/querySalesteamStaffMiddleTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String querySalesteamStaffMiddleTab(@RequestBody String data) {
		return incentiveService.querySalesteamStaffMiddleTab(data);
	}
	/**
	 * 添加品类提成配置信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addCommissionsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addCommissionsTab(@RequestBody String data) {
		return incentiveService.addCommissionsTab(data);
	}
	/**
	 * 查询品类提成配置信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCommissionsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCommissionsTab(@RequestBody String data) {
		return incentiveService.queryCommissionsTab(data);
	}
	/**
	 * 更新品类提成配置信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateCommissionsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateCommissionsTab(@RequestBody String data) {
		return incentiveService.updateCommissionsTab(data);
	}
	/**
	 * 删除品类提成配置信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteCommissionsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteCommissionsTab(@RequestBody String data) {
		return incentiveService.deleteCommissionsTab(data);
	}
	/**
	 * 添加考核额度信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addAssessTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addAssessTab(@RequestBody String data) {
		return incentiveService.addAssessTab(data);
	}
	/**
	 * 查询考核额度信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryAssessTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryAssessTab(@RequestBody String data) {
		return incentiveService.queryAssessTab(data);
	}
	/**
	 * 修改考核额度信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateAssessTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateAssessTab(@RequestBody String data) {
		return incentiveService.updateAssessTab(data);
	}
	/**
	 * 删除考核额度信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteAssessTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteAssessTab(@RequestBody String data) {
		return incentiveService.deleteAssessTab(data);
	}
}
