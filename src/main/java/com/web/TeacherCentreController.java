package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.TeacherCentreService;

@Controller
@RequestMapping("/front/TeacherCentre")
@ResponseBody
public class TeacherCentreController {
	@Autowired
	private TeacherCentreService teacherCentreService;
	/**
	 * 通过ID查询教师详情信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryTeacherCentre",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryTeacherCentre(@RequestBody String data) {
		return teacherCentreService.queryTeacherCentre(data);
	}
	/**
	 * 查询教师教学视频信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryTeacherCentreVideo",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryTeacherCentreVideo(@RequestBody String data) {
		return teacherCentreService.queryTeacherCentreVideo(data);
	}
}
