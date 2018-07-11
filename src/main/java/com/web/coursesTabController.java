package com.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	public List<coursesTab> getTabListBy(String teacher_id,String courses_video_form_id,String courses_name,String courses_pricemoney,String courses_grade){
		System.out.println("courses");
		
		String cteacherId = null;
		String cVideo_form_id = null;
		String cCourses_grade = null;
		String cCourses_pricemoney = null;
		String cCourses_name = null;
		System.out.println(teacher_id);
		System.out.println(courses_video_form_id);
		System.out.println(courses_name);
		System.out.println(courses_pricemoney);
		System.out.println(courses_grade);
		System.out.println("courses 2");
		coursesTab c=new coursesTab();
		if(teacher_id!=null) {
			cteacherId = teacher_id;
			c.setTeacher_id(Integer.parseInt(cteacherId));
		}
		if(courses_video_form_id!=null) {
			cVideo_form_id = courses_video_form_id;
			c.setVideo_form_id(Integer.parseInt(cVideo_form_id));
		}
		if(courses_name!=null) {
			cCourses_name = courses_name;
			c.setCourses_name(cCourses_name);
		}else {
			System.out.println("3"+courses_name);
		}
			
		if(courses_pricemoney!=null) {
			cCourses_pricemoney = courses_pricemoney;
			c.setCourses_pricemoney(cCourses_pricemoney);
		}else {
			System.out.println("4"+courses_pricemoney);
		}			
		if(courses_grade!=null) {
			cCourses_grade = courses_grade;
			c.setCourses_grade(Integer.parseInt(cCourses_grade));
		}else {
			System.out.println("5"+courses_grade);
		}
		
	   
		return ctService.getTabList(c);
	}
	@RequestMapping(value="/searchTabListBy.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<coursesTab> searchTabListBy(String teacher_id,String courses_video_form_id,String courses_name,String courses_pricemoney,String courses_grade){	
		return ctService.searchTabList( teacher_id, courses_video_form_id, courses_name, courses_pricemoney, courses_grade);
	}
	@RequestMapping(value="/addCoursesTab.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void addCoursesTab(HttpServletRequest request,String courses_name,int courses_video_form_id,String courses_introduce,String courses_pricemoney,String courses_video,MultipartFile image,String courses_qz) throws Exception{
		TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
		int teacher_id = Integer.parseInt(teacher.getTeacher_id());
		System.out.println(image.getOriginalFilename());
		ctService.addCoursesTab(courses_name,courses_video_form_id,courses_introduce,courses_pricemoney,courses_video, image,teacher_id,Integer.parseInt(courses_qz));
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
	public void upCoursesById(int courses_id,String courses_name,String courses_introduce,String courses_pricemoney,String courses_video,String courses_img_url/*,int video_qz*/){
		coursesTab c=new coursesTab();
		c.setCourses_name(courses_name);
		c.setCourses_introduce(courses_introduce);
		c.setCourses_video(courses_video);
		c.setCourses_img_url(courses_img_url);
		c.setCourses_pricemoney(courses_pricemoney);
		c.setCourses_id(courses_id);
		//c.setCourses_qz(courses_qz);
		ctService.upCoursesById(c);
	}
	@RequestMapping(value="/updateCoursesById.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updateCoursesById(int id){
		ctService.updateCoursesById(id);
	}
}
