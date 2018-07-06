package com.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.entity.coursesTab;

public interface coursesTabService {
	public List<coursesTab> getTabList(coursesTab c);
	public List<coursesTab> getTabList();
	public void addCoursesTab(coursesTab c);
	public void addCoursesTab(String courses_name,int video_form_id,String courses_introduce,String courses_pricemoney,String courses_video,MultipartFile image,int teacher_id) throws Exception ;
	public void delCoursesById(int id);
	public void upCoursesById(coursesTab c);
	public List<coursesTab> getTabListById(int id);
}
