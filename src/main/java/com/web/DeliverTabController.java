package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.DeliverTabService;

/**
 * 配送单表PAI
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Deliver")
@ResponseBody
@Controller
public class DeliverTabController {
	@Autowired
	private DeliverTabService deliverTabService;//调用配送单Service层接口
	/**
	 * 添加配送单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addDeliverTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addDeliverTab(@RequestBody String data) {
		return deliverTabService.addDeliverTab(data);
	}
	/**
	 * 查询配送单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryDeliverTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryDeliverTab(@RequestBody String data) {
		return deliverTabService.queryDeliverTab(data);
	}
	/**
	 * 更新配送单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateDeliverTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateDeliverTab(@RequestBody String data) {
		return deliverTabService.updateDeliverTab(data);
	}
	/**
	 * 签收配送单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateSignDeliverTabAll",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateSignDeliverTabAll(@RequestBody String data) {
		return deliverTabService.updateSignDeliverTabAll(data);
	}
	/**
	 * 删除配送单信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteDeliverTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteDeliverTab(@RequestBody String data) {
		return deliverTabService.deleteDeliverTab(data);
	}
}
