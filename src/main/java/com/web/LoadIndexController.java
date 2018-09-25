package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.LoadIndexService;

@Controller
@RequestMapping("/front/LoadIndex")
@ResponseBody
public class LoadIndexController {
	@Autowired
	private LoadIndexService indexService;
	/**
	 * 查询课程分类
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCourseType",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCourseType(@RequestBody String data) {
		return indexService.queryCourseType(data);
	}
	/**
	 * 查询初始化推荐课程分类
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryRecommendCourseList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryRecommendCourseList(@RequestBody String data) {
		return indexService.queryRecommendCourseList(data);
	}
	/**
	 * 用户查询已购课程信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryUseridCourseList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryUseridCourseList(@RequestBody String data) {
		return indexService.queryUseridCourseList(data);
	}
}
