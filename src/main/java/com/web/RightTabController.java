package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.RightTabService;
/**
 * 权限API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Right")
@ResponseBody
@Controller
public class RightTabController {
	@Autowired
	private RightTabService rightTabService;
	/**
	 * 添加权限
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addRightTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addRightTab(@RequestBody String data) {
		return rightTabService.addRightTab(data);
	}
	/**
	 * 查询权限
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryRightTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryRightTab(@RequestBody String data) {
		return rightTabService.queryRightTab(data);
	}
	/**
	 * 更新权限
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateRightTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateRightTab(@RequestBody String data) {
		return rightTabService.updateRightTab(data);
	}
	/**
	 * 删除权限
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteRightTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteRightTab(@RequestBody String data) {
		return rightTabService.deleteRightTab(data);
	}
}
