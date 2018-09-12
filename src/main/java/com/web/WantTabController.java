package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.WantTabService;

/**
 * 缺货登记PAI
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Want")
@ResponseBody
@Controller
public class WantTabController {
	@Autowired
	private WantTabService wantTabService;//调用缺货登记Service层接口
	/**
	 * 添加缺货登记信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addWantTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addWantTab(@RequestBody String data) {
		return wantTabService.addWantTab(data);
	}
	/**
	 * 查询缺货登记信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryWantTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryWantTab(@RequestBody String data) {
		return wantTabService.queryWantTab(data);
	}
	/**
	 * 更新缺货登记信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateWantTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateWantTab(@RequestBody String data) {
		return wantTabService.updateWantTab(data);
	}
	/**
	 * 删除缺货登记信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteWantTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteWantTab(@RequestBody String data) {
		return wantTabService.deleteWantTab(data);
	}
	/**
	 * 将缺货登记生成采购需求
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/generatePurchase",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String generatePurchase(@RequestBody String data) {
		return wantTabService.generatePurchase(data);
	}
}
