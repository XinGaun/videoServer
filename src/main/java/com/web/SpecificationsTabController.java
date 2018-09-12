package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 商品规格API
 * @author vip
 *
 */

import com.service.SpecificationsTabService;
/**
 * 厂商规格API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Specifications")
@Controller
@ResponseBody
public class SpecificationsTabController {
	@Autowired
	private SpecificationsTabService specificationsTabService;//调用商品规格Service层接口
	/**
	 * 添加商品规格
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addSpecificationsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addSpecificationsTab(@RequestBody String data) {
		return specificationsTabService.addSpecificationsTab(data);
	}
	/**
	 * 查询商品规格
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/querySpecificationsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String querySpecificationsTab(@RequestBody String data) {
		return specificationsTabService.querySpecificationsTab(data);
	}
	/**
	 * 更新商品规格
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateSpecificationsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateSpecificationsTab(@RequestBody String data) {
		return specificationsTabService.updateSpecificationsTab(data);
	}
	/**
	 * 删除商品规格
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteSpecificationsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteSpecificationsTab(@RequestBody String data) {
		return specificationsTabService.deleteSpecificationsTab(data);
	}
	/**
	 * 总实例添加商品规格
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addPushSpecificationsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addPushSpecificationsTab(@RequestBody String data) {
		return specificationsTabService.addPushSpecificationsTab(data);
	}
	/**
	 * 总实例修改商品规格
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updatePushSpecificationsTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updatePushSpecificationsTab(@RequestBody String data) {
		return specificationsTabService.updatePushSpecificationsTab(data);
	}
}
