package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 安装单位API
 * @author vip
 *
 */

import com.service.InstallUnitTabSercice;
@RequestMapping("/hangrano2o/InstallUnit")
@ResponseBody
@Controller
public class InstallUnitTabController {
	@Autowired
	private InstallUnitTabSercice installUnitTabSercice;//调用安装单位Service层接口
	/**
	 * 添加安装单位
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addInstallUnitTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addInstallUnitTab(@RequestBody String data) {
		return installUnitTabSercice.addInstallUnitTab(data);
	}
	/**
	 * 查询安装单位
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryInstallUnitTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryInstallUnitTab(@RequestBody String data) {
		return installUnitTabSercice.queryInstallUnitTab(data);
	}
	/**
	 * 更新安装单位
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateInstallUnitTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateInstallUnitTab(@RequestBody String data) {
		return installUnitTabSercice.updateInstallUnitTab(data);
	}
	/**
	 * 删除安装单位
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteInstallUnitTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteInstallUnitTab(@RequestBody String data) {
		return installUnitTabSercice.deleteInstallUnitTab(data);
	}
}
