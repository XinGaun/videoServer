package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.RoleTabService;
/**
 * 角色API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Role")
@ResponseBody
@Controller
public class RoleTabCpntroller {
	@Autowired
	private RoleTabService roleTabService;
	/**
	 * 添加角色
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addRoleTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addRoleTab(@RequestBody String data) {
		return roleTabService.addRoleTab(data);
	}
	/**
	 * 查询角色
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryRoleTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryRoleTab(@RequestBody String data) {
		return roleTabService.queryRoleTab(data);
	}
	/**
	 * 修改角色
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateRoleTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateRoleTab(@RequestBody String data) {
		return roleTabService.updateRoleTab(data);
	}
	/**
	 * 删除角色
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteRoleTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteRoleTab(@RequestBody String data) {
		return roleTabService.deleteRoleTab(data);
	}
}
