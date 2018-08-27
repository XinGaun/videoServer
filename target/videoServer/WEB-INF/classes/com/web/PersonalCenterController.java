package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.PersonalCenterService;

@Controller
@RequestMapping("/front/PersonalCenter")
@ResponseBody
public class PersonalCenterController {
	@Autowired
	private PersonalCenterService personalCenterService;
	/**
	 * 通过userphone查询收藏课程详情
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryPersonalCenter",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryPersonalCenter(@RequestBody String data) {
		return personalCenterService.queryPersonalCenter(data);
	}
	/**
	 * 删除收藏课程
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteSubscription",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteSubscription(@RequestBody String data) {
		return personalCenterService.deleteSubscription(data);
	}
	/**
	 * 查询推荐好课
	 */
	@RequestMapping(value="/queryRecommend",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryRecommend() {
		return personalCenterService.queryRecommend();
	}
	/**
	 * 通过userphone查询订单详情
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryOrderInformation",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryOrderInformation(@RequestBody String data) {
		return personalCenterService.queryOrderInformation(data);
	}
}
