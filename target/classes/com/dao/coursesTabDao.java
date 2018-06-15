package com.dao;

import java.util.List;

import com.entity.coursesTab;

public interface coursesTabDao {
	public List<coursesTab> getTabList(coursesTab c);
	public List<coursesTab> getTabList();
	public void addCoursesTab(coursesTab c);
	public void delCoursesById(int id);
	public void upCoursesById(coursesTab c);
	public List<coursesTab> getTabListById(int id);
}
