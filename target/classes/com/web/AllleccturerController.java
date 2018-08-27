package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.AlllecturerService;

@Controller
@RequestMapping("/front/Alllecturer")
@ResponseBody
public class AllleccturerController {
	@Autowired
	private AlllecturerService alllecturerService;
	/**
	 * index查询教师信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryTeacherInformation",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryBoutiqueVideo(@RequestBody String data) {
		return alllecturerService.queryTeacherInformation(data);
	}
}
