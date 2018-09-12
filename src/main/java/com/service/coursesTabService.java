package com.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.entity.coursesTab;

public interface coursesTabService {
	public List<coursesTab> getTabList(coursesTab c);
	public List<coursesTab> searchTabList(String teacher_id,String video_form_id, String courses_name,String courses_pricemoney,String courses_grade);
	public List<coursesTab> getTabList();
	public void addCoursesTab(coursesTab c);

	public void addCoursesTab(String courses_name,int video_form_id,String courses_introduce,String courses_pricemoney,String courses_video,MultipartFile image,int teacher_id,int courses_qz,String coures_price) throws Exception ;

	public void delCoursesById(int id);
	public void upCoursesById(int id,String courses_name,int video_form_id,String courses_introduce,String courses_pricemoney,String courses_video,MultipartFile image,int courses_qz,String coures_price) throws Exception;
	public List<coursesTab> getTabListById(int id);
	public void updateCoursesById(int id);
}
