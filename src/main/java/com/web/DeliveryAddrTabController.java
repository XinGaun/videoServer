package com.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.service.DeliveryAddrTabService;
import com.util.HttpReq;
/**
 * 配置地址API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/DeliveryAddr")
@ResponseBody
@Controller
public class DeliveryAddrTabController {
	@Autowired
	private DeliveryAddrTabService addrTabService;//调用配置地址Service层接口
	/**
	 * 添加配置地址
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addDeliveryAddrTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addDeliveryAddrTab(@RequestBody String data) {
		return addrTabService.addDeliveryAddrTab(data);
	}
	/**
	 * 查询配置地址
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryDeliveryAddrTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryDeliveryAddrTab(@RequestBody String data) {
		return addrTabService.queryDeliveryAddrTab(data);
	}
	/**
	 * 更新配置地址
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateDeliveryAddrTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateDeliveryAddrTab(@RequestBody String data) {
		return addrTabService.updateDeliveryAddrTab(data);
	}
	/**
	 * 删除配置地址
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteDeliveryAddrTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteDeliveryAddrTab(@RequestBody String data) {
		return addrTabService.deleteDeliveryAddrTab(data);
	}
	/**
	 * 同步配置地址
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/synchronizationAddr",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String synchronizationAddr(@RequestBody String data) {
		return addrTabService.synchronizationAddr(data);
	}
	/**
	 * 添加买家配置地址
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addBuyersaddress",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addBuyersaddress(@RequestBody String data) {
		return addrTabService.addBuyersaddress(data);
	}
	/**
	 * 转发查询换管单位API
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/userinfoByAddr",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String userinfoByAddr(@RequestBody String data) {
		@SuppressWarnings("unchecked")
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		String result = HttpReq.httpRequestsfrom("http://test.cloud-scale.cn/TransferSystem/query/userinfoByAddr","POST", map);
		return result;
	}
}
