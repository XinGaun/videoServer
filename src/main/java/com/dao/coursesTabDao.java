package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.coursesTab;

public interface coursesTabDao {
	public List<coursesTab> getTabList(coursesTab c);
	public List<coursesTab> searchTabList(@Param(value="teacher_id") String teacher_id,@Param(value="video_form_id") String courses_video_form_id,@Param(value="courses_name") String courses_name,@Param(value="courses_pricemoney") String courses_pricemoney,@Param(value="courses_grade") String courses_grade);
	public List<coursesTab> getTabList();
	public void addCoursesTab(coursesTab c);
	public void delCoursesById(int id);
	public void upCoursesById(coursesTab c);
	public List<coursesTab> getTabListById(int id);
}
