package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.InstallTabService;

/**
 * 安装单API
 * @author vip
 *
 */
@Controller
@ResponseBody
@RequestMapping("/hangrano2o/Install")
public class InstallTabController {
	@Autowired
	private InstallTabService installTabService;//调用安装单Service层接口
	/**
	 * 添加安装单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addInstallTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addInstallTab(@RequestBody String data) {
		return installTabService.addInstallTab(data);
	}
	/**
	 * 查询安装单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryInstallTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryInstallTab(@RequestBody String data) {
		return installTabService.queryInstallTab(data);
	}
	/**
	 * 更新安装单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateInstallTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateInstallTab(@RequestBody String data) {
		return installTabService.updateInstallTab(data);
	}
	/**
	 * 更新安装单信息All
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateInstallTabAll",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateInstallTabAll(@RequestBody String data) {
		return installTabService.updateInstallTabAll(data);
	}
	/**
	 * 删除安装单信息
	 * @param datad
	 * @return
	 */
	@RequestMapping(value="/deleteInstallTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteInstallTab(@RequestBody String data) {
		return installTabService.deleteInstallTab(data);
	}
}
