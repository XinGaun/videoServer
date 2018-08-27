package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.TeacherCentreDao;
import com.service.TeacherCentreService;
import com.util.Count;
import com.util.Page;

@Service
@SuppressWarnings("unchecked")
public class TeacherCentreServiceImpl implements TeacherCentreService {
	@Autowired
	private TeacherCentreDao teacherCentreDao;
	/**
	 * 查询教师详情
	 */
	@Override
	public String queryTeacherCentre(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> arrayList = teacherCentreDao.queryTeacherCentre(map);
		return JSON.toJSONString(arrayList);
	}
	/**
	 * 查询教师教学视频信息
	 */
	@Override
	public String queryTeacherCentreVideo(String data) {
		HashMap<String,Object> hashmap = JSON.parseObject(data,HashMap.class);
		hashmap= Page.page(hashmap);
		ArrayList<HashMap<String,Object>> list = teacherCentreDao.queryTeacherCentreVideo(hashmap);
		int count = teacherCentreDao.queryTeacherCentreVideoAllCount(hashmap);
		System.out.println(count);
		return JSON.toJSONString(Count.counts(list, count, hashmap,200,"queryTeacherCentreVideoAllCount success"));
	}
}
