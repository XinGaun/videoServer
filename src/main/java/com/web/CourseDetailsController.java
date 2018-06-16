package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
