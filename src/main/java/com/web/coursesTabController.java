package com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.coursesTab;
import com.service.coursesTabService;

@Controller
@RequestMapping("/coursesTab")
public class coursesTabController {
	@Autowired
	private coursesTabService ctService;
	
	@RequestMapping(value="/getTabList.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getTabList(){
	
		return JSON.toJSONString(ctService.getTabList());
	}
	@RequestMapping(value="/getTabListBy.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getTabListBy(String courses_name,String courses_pricemoney,int courses_grade){
		coursesTab c=new coursesTab();
		c.setCourses_name(courses_name);
		c.setCourses_pricemoney(courses_pricemoney);
		c.setCourses_grade(courses_grade);
		return JSON.toJSONString(ctService.getTabList(c));
	}
	@RequestMapping(value="/addCoursesTab.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void addCoursesTab(String courses_name,String courses_introduce,String courses_pricemoney,String courses_video,String courses_img_url){
		coursesTab c=new coursesTab();
		c.setCourses_name(courses_name);
		c.setCourses_introduce(courses_introduce);
		c.setCourses_video(courses_video);
		c.setCourses_img_url(courses_img_url);
		c.setCourses_pricemoney(courses_pricemoney);
		ctService.addCoursesTab(c);
	}
	@RequestMapping(value="/delCoursesById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void delCoursesById(int id){
		ctService.delCoursesById(id);
	}
	
	@RequestMapping(value="/getTabListById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getTabListById(int id){
		return JSON.toJSONString(ctService.getTabListById(id));
	}
	
	@RequestMapping(value="/upCoursesById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void upCoursesById(int courses_id,String courses_name,String courses_introduce,String courses_pricemoney,String courses_video,String courses_img_url){
		coursesTab c=new coursesTab();
		c.setCourses_name(courses_name);
		c.setCourses_introduce(courses_introduce);
		c.setCourses_video(courses_video);
		c.setCourses_img_url(courses_img_url);
		c.setCourses_pricemoney(courses_pricemoney);
		c.setCourses_id(courses_id);
		ctService.upCoursesById(c);
	}
}
