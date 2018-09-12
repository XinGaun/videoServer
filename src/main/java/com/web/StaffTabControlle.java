package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.StaffTabService;

/**
 * 员工信息API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Staff")
@ResponseBody
@Controller
public class StaffTabControlle {
	@Autowired
	private StaffTabService staffTabService;//调用员工信息Service层接口
	/**
	 * 添加员工信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addStaffTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addStaffTab(@RequestBody String data) {
		return staffTabService.addStaffTab(data);
	}
	/**
	 * 查询员工信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryStaffTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryStaffTab(@RequestBody String data) {
		return staffTabService.queryStaffTab(data);
	}
	/**
	 * 更新员工信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateStaffTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateStaffTab(@RequestBody String data) {
		return staffTabService.updateStaffTab(data);
	}
	/**
	 * 删除员工信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteStaffTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteStaffTab(@RequestBody String data) {
		return staffTabService.deleteStaffTab(data);
	}
	/**
	 * 验证登录员工信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/loginStaff",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String loginStaff(@RequestBody String data) {
		return staffTabService.loginStaff(data);
	}
}
