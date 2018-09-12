package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.StaffLogTabService;

/**
 * 员工日志信息API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/StaffLog")
@ResponseBody
@Controller
public class StaffLogTabController {
	@Autowired
	private StaffLogTabService logTabService;//调用员工日志信息Service层接口
	/**
	 * 添加员工日志信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addStaffLogTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addStaffLogTab(@RequestBody String data) {
		return logTabService.addStaffLogTab(data);
	}
	/**
	 * 查询员工日志信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryStaffLogTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryStaffLogTab(@RequestBody String data) {
		return logTabService.queryStaffLogTab(data);
	}
	/**
	 * 更新员工日志信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateStaffLogTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateStaffLogTab(@RequestBody String data) {
		return logTabService.updateStaffLogTab(data);
	}
	/**
	 * 删除员工日志信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteStaffLogTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteStaffLogTab(@RequestBody String data) {
		return logTabService.deleteStaffLogTab(data);
	}
}
