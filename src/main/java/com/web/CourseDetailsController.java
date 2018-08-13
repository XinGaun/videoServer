package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.service.CourseDetailsService;

@Controller
@RequestMapping("/front/CourseDetails")
@ResponseBody
public class CourseDetailsController {
	@Autowired
	private CourseDetailsService courseDetailsService;
	/**
	 * 通过ID查询课程详情信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCourseDetails",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCourseDetails(@RequestBody String data) {
		return courseDetailsService.queryCourseDetails(data);
	}
	/**
	 * 通过ID查询视频信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryVideoDetails",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryVideoDetails(@RequestBody String data) {
		return courseDetailsService.queryVideoDetails(data);
	}
	/**
	 * 查询推荐课程信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryqueryRecommendCourse",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryqueryRecommendCourse() {
		return courseDetailsService.queryqueryRecommendCourse();
	}
	/**
	 * 查询学员评论
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryStudentComments",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryStudentComments(@RequestBody String data) {
		return courseDetailsService.queryStudentComments(data);
	}
	/**
	 * 插入到收藏表
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/addCollection",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String addCollection(@RequestBody String data) {
		return courseDetailsService.addCollection(data);
	}
	/**
	 * 测试数据
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/loginss",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String loginss(@RequestBody String data) {
		return JSON.toJSONString(data);
	}
}
