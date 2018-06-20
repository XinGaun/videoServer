package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.coursesTabDao;
import com.entity.coursesTab;
import com.service.coursesTabService;

@Service
public class coursesTabServiceImpl implements coursesTabService{
	@Autowired
	private coursesTabDao ctDao;
	
	@Override
	public List<coursesTab> getTabList(coursesTab v) {
		return ctDao.getTabList(v);
	}

	@Override
	public void addCoursesTab(coursesTab c) {
		ctDao.addCoursesTab(c);
	}

	@Override
	public List<coursesTab> getTabList() {
		return ctDao.getTabList();
	}

	@Override
	public void delCoursesById(int id) {
		ctDao.delCoursesById(id);
	}

	@Override
	public void upCoursesById(coursesTab c) {
		ctDao.upCoursesById(c);
	}

	@Override
	public List<coursesTab> getTabListById(int id) {
		return ctDao.getTabListById(id);
	}

}
