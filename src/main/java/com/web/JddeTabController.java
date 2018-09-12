package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.service.JddeTabService;
/**
 * 配送单位API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Jdde")
@ResponseBody
@Controller
public class JddeTabController {
	@Autowired
	private JddeTabService jddeTabService;//调用配送单位Service层接口
	/**
	 * 添加配送单位
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addJddeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addJddeTab(@RequestBody String data) {
		return jddeTabService.addJddeTab(data);
	}
	/**
	 * 查询配送单位
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryJddeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryJddeTab(@RequestBody String data) {
		return jddeTabService.queryJddeTab(data);
	}
	/**
	 * 更新配送单位
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateJddeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateJddeTab(@RequestBody String data) {
		return jddeTabService.updateJddeTab(data);
	}
	/**
	 * 删除配送单位
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteJddeTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteJddeTab(@RequestBody String data) {
		return jddeTabService.deleteJddeTab(data);
	}
}
