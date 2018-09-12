package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.FinancialTabService;

/**
 * 财务记录API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Financial")
@ResponseBody
@Controller
public class FinancialTabController {
	@Autowired
	private FinancialTabService financialTabService;//调用财务记录Service层接口
	/**
	 * 添加财务记录
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addFinancialTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addFinancialTab(@RequestBody String data) {
		return financialTabService.addFinancialTab(data);
	}
	/**
	 * 查询财务记录
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryFinancialTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryFinancialTab(@RequestBody String data) {
		return financialTabService.queryFinancialTab(data);
	}
	/**
	 * 更新财务记录
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateFinancialTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateFinancialTab(@RequestBody String data) {
		return financialTabService.updateFinancialTab(data);
	}
	/**
	 * 删除财务记录
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteFinancialTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteFinancialTab(@RequestBody String data) {
		return financialTabService.deleteFinancialTab(data);
	}
}
