package com.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.ExampleTab;
import com.service.ExampleTabService;

/**
 * 公司实例管理
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Example")
@ResponseBody
@Controller
public class ExampleTabController {
	@Autowired
	private ExampleTabService exampleTabService;
	/**
	 * 添加公司实例信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addExampleTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addExampleTab(@RequestBody ExampleTab exampleTab) {
		return exampleTabService.addExampleTab(exampleTab);
	}
	/**
	 * 添加公司实例信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryExampleTab",produces="application/json;charset=utf-8",method=RequestMethod.GET)
	public String queryExampleTab() {
		return exampleTabService.queryExampleTab();
	}
	/**
	 * 更新公司实例信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateExampleTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateExampleTab(@RequestBody ExampleTab exampleTab) {
		return exampleTabService.updateExampleTab(exampleTab);
	}
	/**
	 * 删除公司实例信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteExampleTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteExampleTab(@RequestBody ArrayList<Integer> list) {
		return exampleTabService.deleteExampleTab(list);
	}
}
