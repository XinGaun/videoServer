package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.DiscussTabService;

/**
 * 评论表API
 * @author vip
 *
 */
@RequestMapping("/hangrano2o/Discuss")
@ResponseBody
@Controller
public class DiscussTabController {
	@Autowired
	private DiscussTabService discussTabService;//调用评论表Serive层接口
	/**
	 * 添加评论信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addDiscussTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addDiscussTab(@RequestBody String data) {
		return discussTabService.addDiscussTab(data);
	}
	/**
	 * 查询评论信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryDiscussTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryDiscussTab(@RequestBody String data) {
		return discussTabService.queryDiscussTab(data);
	}
	/**
	 * 更新评论信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/updateDiscussTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String updateDiscussTab(@RequestBody String data) {
		return discussTabService.updateDiscussTab(data);
	}
	/**
	 * 删除评论信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/deleteDiscussTab",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String deleteDiscussTab(@RequestBody String data) {
		return discussTabService.deleteDiscussTab(data);
	}
}
