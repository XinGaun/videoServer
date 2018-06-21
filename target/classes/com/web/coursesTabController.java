package com.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.TeacherDomain;
import com.entity.coursesTab;
import com.service.coursesTabService;

@Controller
@RequestMapping("/coursesTab")
public class coursesTabController {
	@Autowired
	private coursesTabService ctService;
	
	@RequestMapping(value="/getTabList.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<coursesTab> getTabList(){
		
		return ctService.getTabList();
	}
	@RequestMapping(value="/getTabListBy.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<coursesTab> getTabListBy(int teacher_id,String courses_name,String courses_pricemoney,int courses_grade){
		coursesTab c=new coursesTab();
		c.setCourses_name(courses_name);
		c.setCourses_pricemoney(courses_pricemoney);
		c.setCourses_grade(courses_grade);
		c.setTeacher_id(teacher_id);
		return ctService.getTabList(c);
	}
	@RequestMapping(value="/addCoursesTab.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void addCoursesTab(HttpServletRequest request,String courses_name,String courses_introduce,String courses_pricemoney,String courses_video,String courses_img_url){
		TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
		int teacher_id = Integer.parseInt(teacher.getTeacher_id());
		coursesTab c=new coursesTab();
		c.setCourses_name(courses_name);
		c.setCourses_introduce(courses_introduce);
		c.setCourses_video(courses_video);
		c.setCourses_img_url(courses_img_url);
		c.setTeacher_id(teacher_id);
		c.setCourses_pricemoney(courses_pricemoney);
		ctService.addCoursesTab(c);
	}
	@RequestMapping(value="/delCoursesById.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void delCoursesById(int id){
		ctService.delCoursesById(id);
	}
	
	@RequestMapping(value="/getTabListById.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<coursesTab> getTabListById(int id){
		return ctService.getTabListById(id);
	}
	
	@RequestMapping(value="/upCoursesById.do", method={RequestMethod.POST,RequestMethod.GET})
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
